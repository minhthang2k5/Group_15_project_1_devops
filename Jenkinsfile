@com.cloudbees.groovy.cps.NonCPS
def getAffectedPaths() {
    def paths = []
    for (changeSet in currentBuild.changeSets) {
        for (entry in changeSet.items) {
            for (file in entry.affectedFiles) {
                paths.add(file.path) // Lưu vào mảng String đơn giản
            }
        }
    }
    return paths
}

@com.cloudbees.groovy.cps.NonCPS
def extractUniqueFolders(List paths) {
    def folders = [] as Set
    for (path in paths) {
        if (path.contains('/')) {
            folders.add(path.split('/')[0])
        }
    }
    return folders.toList()
}

def getChangedServices() {
    def changedServices = [] as Set

    def gitDiffOutput = ''
    try {
        // Phát hiện tag (release)
        def gitTag = ''
        if (env.TAG_NAME) {
            gitTag = env.TAG_NAME
        } else {
            try {
                gitTag = sh(script: 'git describe --tags --exact-match 2>/dev/null || echo ""', returnStdout: true).trim()
            } catch (e) {}
        }
        def isRelease = gitTag && gitTag.startsWith('v')

        // Trên nhánh main hoặc khi build tag: so sánh với commit trước đó (HEAD~1)
        // Trên nhánh dev: so sánh với origin/main
        if (isRelease || env.BRANCH_NAME == 'main' || env.GIT_BRANCH == 'main' || env.GIT_BRANCH == 'origin/main') {
            echo "Đang ở nhánh main hoặc build tag (${gitTag ?: 'main'}). So sánh với commit trước đó (HEAD~1)..."
            gitDiffOutput = sh(
                script: 'git diff --name-only HEAD~1',
                returnStdout: true
            ).trim()
        } else {
            sh(script: 'git fetch --no-tags --prune --depth=1 origin +refs/heads/main:refs/remotes/origin/main', returnStdout: false)
            gitDiffOutput = sh(
                script: 'git diff --name-only origin/main...HEAD',
                returnStdout: true
            ).trim()
        }
    } catch (e) {
        echo "git diff failed, falling back to changeSets: ${e.message}"
    }

    def paths = []
    if (gitDiffOutput) {
        paths = gitDiffOutput.split('\n').toList()
    } else {
        paths = getAffectedPaths()
    }

    def uniqueFolders = extractUniqueFolders(paths)
    for (folder in uniqueFolders) {
        if (fileExists("${folder}/pom.xml")) {
            changedServices.add(folder)
        }
    }

    return changedServices
}


pipeline {
    agent any
    
    tools {
        maven 'Maven3' 
        jdk 'Java21'   
    }

    // Ép Java21
    environment {
        PATH_TO_JAVA = tool name: 'Java21', type: 'jdk'
        JAVA_HOME = "${PATH_TO_JAVA}"
        PATH = "${PATH_TO_JAVA}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                // Lấy code từ GitHub về
                checkout scm
            }
        }

        stage('Security Scan: Gitleaks') {
            steps {
                script {
                    echo '=> Bắt đầu tải và chạy Gitleaks...'
                    sh '''
                                        set -e
                                        GITLEAKS_URL="https://github.com/gitleaks/gitleaks/releases/download/v8.18.2/gitleaks_8.18.2_linux_x64.tar.gz"

                                        if command -v gitleaks >/dev/null 2>&1; then
                                            echo "Sử dụng gitleaks có sẵn trên agent"
                                            gitleaks detect --source . -v --redact --config gitleaks.toml --no-git --report-path=gitleaks-report.json
                                            exit 0
                                        fi

                                        if command -v wget >/dev/null 2>&1; then
                                            wget -qO- "$GITLEAKS_URL" | tar xvz
                                        elif command -v curl >/dev/null 2>&1; then
                                            curl -sSL "$GITLEAKS_URL" | tar xvz
                                        else
                                            echo "ERROR: Agent không có wget/curl để tải Gitleaks." >&2
                                            exit 2
                                        fi

                                        chmod +x gitleaks
                                        ./gitleaks detect --source . -v --redact --config gitleaks.toml --no-git --report-path=gitleaks-report.json
                    '''
                }
            }
            post {
                always {
                    archiveArtifacts artifacts: 'gitleaks-report.json', allowEmptyArchive: true
                }
            }
        }

        stage('Test & Coverage') {
            steps {
                echo 'Đang kiểm tra phiên bản Java...'
                sh 'java -version'
                
                script {
                    def services = getChangedServices().toList().sort()
                    
                    if (services.isEmpty()) {
                        echo 'Không phát hiện service thay đổi. Bỏ qua Test & Coverage theo phạm vi service.'
                    } else {
                        def serviceSelector = services.join(',')
                        echo "Đang chạy Unit Test và tạo report Coverage cho CÁC SERVICE BỊ THAY ĐỔI: ${services}"
                        sh "mvn clean test jacoco:report -pl ${serviceSelector} -am '-Dsurefire.excludes=**/*IT.java,**/*IT\$*.java,**/ProductCdcConsumerTest.java,**/ProductVectorRepositoryTest.java,**/VectorQueryTest.java'"
                    }
                }
            }

            // Di chuyển logic upload sang Phase Test theo yêu cầu của bài
            post {
                always {
                    echo 'Upload Test Result và TestCoverage cho Phase Test...'
                    junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
                    script {
                        def services = getChangedServices().toList().sort()
                        if (services.isEmpty()) {
                            echo 'Không phát hiện service thay đổi. Bỏ qua publish JaCoCo.'
                        } else {
                            def execPatterns = services.collect { "${it}/target/jacoco.exec" }.join(',')
                            def classPatterns = services.collect { "${it}/target/classes" }.join(',')
                            def sourcePatterns = services.collect { "${it}/src/main/java" }.join(',')

                            jacoco execPattern: execPatterns,
                                   classPattern: classPatterns,
                                   sourcePattern: sourcePatterns
                        }
                    }
                }
            }
        }

        stage('SonarQube Analysis') {
    steps {
        script {
            echo '=> Bắt đầu phân tích mã nguồn với SonarQube...'
            // Lấy danh sách service thay đổi để tối ưu hóa việc quét cho Monorepo 
            def services = getChangedServices().toList().sort()

            if (services.isEmpty()) {
                echo 'Không phát hiện service thay đổi. Bỏ qua phân tích SonarQube.'
            } else {
                withSonarQubeEnv('SonarQube') {
                    def serviceSelector = services.join(',')
                    echo "Phân tích SonarQube cho CÁC SERVICE BỊ THAY ĐỔI: ${services}"
                    // Sử dụng flag -pl để chỉ định quét các service cụ thể [cite: 28]
                    sh """
                    mvn -B -DskipTests -pl ${serviceSelector} -am sonar:sonar \
                      -Dsonar.projectKey=minhthang2k5_Group_15_project_1_devops \
                      -Dsonar.organization=minhthang2k5 \
                      -Dsonar.projectName="YAS Microservices"
                    """
                }
            }
        }
    }
}

        stage('Security Scan: Snyk SCA') {
            steps {
                withCredentials([string(credentialsId: 'snyk-token', variable: 'SNYK_TOKEN')]) {
                    script {
                        echo '=> Bắt đầu tải và phân tích bảo mật thư viện với Snyk...'
                        sh '''
                        set -e
                        mkdir -p reports/snyk

                        if command -v snyk >/dev/null 2>&1; then
                          cp "$(command -v snyk)" ./snyk
                        elif command -v curl >/dev/null 2>&1; then
                          curl -sSL -o ./snyk https://github.com/snyk/snyk/releases/latest/download/snyk-linux
                        elif command -v wget >/dev/null 2>&1; then
                          wget -qO ./snyk https://github.com/snyk/snyk/releases/latest/download/snyk-linux
                        else
                          echo "ERROR: Agent không có snyk/curl/wget để chạy Snyk." >&2
                          exit 2
                        fi

                        chmod +x ./snyk
                        ./snyk --version
                        '''

                        def services = getChangedServices().toList().sort()

                        if (services.isEmpty()) {
                            echo 'Không phát hiện service thay đổi. Quét Snyk cho TOÀN BỘ dự án.'
                            sh './snyk test --all-projects --json-file-output=reports/snyk/snyk-all-projects.json || true'
                        } else {
                            echo "Quét Snyk cho CÁC SERVICE BỊ THAY ĐỔI: ${services}"
                            for (String svc : services) {
                                if (fileExists("${svc}/pom.xml")) {
                                    sh "./snyk test --file=${svc}/pom.xml  --json-file-output=reports/snyk/snyk-${svc}.json || true"
                                }
                            }
                        }
                    }
                }
            }
            post {
                always {
                    archiveArtifacts artifacts: 'reports/snyk/*.json', allowEmptyArchive: true
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    def services = getChangedServices().toList().sort()
                    services.remove("payment-paypal")
                    
                    // Phát hiện nhánh/tag để tự động build toàn bộ nếu cần thiết
                    def gitTag = ''
                    if (env.TAG_NAME) {
                        gitTag = env.TAG_NAME
                    } else {
                        try {
                            gitTag = sh(script: 'git describe --tags --exact-match 2>/dev/null || echo ""', returnStdout: true).trim()
                        } catch (e) {}
                    }
                    def isRelease = gitTag && gitTag.startsWith('v')
                    def isMainBranch = (env.BRANCH_NAME == 'main' || env.GIT_BRANCH == 'main' || env.GIT_BRANCH == 'origin/main')
                    
                    // HARDCODE: Tạm thời bổ sung các service còn thiếu để build 1 lần
                    def missingServices = ["location", "payment", "promotion", "rating", "recommendation", "webhook"]
                    for (svc in missingServices) {
                        if (!services.contains(svc)) {
                            services.add(svc)
                        }
                    }
                    
                    // Nếu không có thay đổi thật sự trên main/release, build toàn bộ repo để tránh lỗi thiếu file jar khi docker build
                    if (services.isEmpty() || (services.size() == missingServices.size() && (isMainBranch || isRelease))) {
                        echo '⚠️ Đang đóng gói TOÀN BỘ ứng dụng (Bỏ qua test vì đã chạy ở stage trước)...'
                        sh 'mvn package -DskipTests -DskipCompile=false'
                    } else {
                        def serviceSelector = services.join(',')
                        echo "Đang đóng gói CÁC SERVICE BỊ THAY ĐỔI + BỔ SUNG: ${services}"
                        sh "mvn package -pl ${serviceSelector} -am -DskipTests -DskipCompile=false"
                    }
                }
            }
        }

        stage('Build & Push Docker Image') {
            steps {
                script {
                    echo '=> Bắt đầu Build và Push Docker Image lên Docker Hub...'
                    
                    // Lấy 7 ký tự đầu của commit ID
                    def commitHash = env.GIT_COMMIT ? env.GIT_COMMIT.take(7) : 'latest'
                    
                    // Xác định danh sách service cần build và tag tương ứng
                    def servicesToBuild = []
                    def imageTag = ''
                    
                    // Phát hiện tag (release)
                    def gitTag = ''
                    if (env.TAG_NAME) {
                        gitTag = env.TAG_NAME
                    } else {
                        try {
                            gitTag = sh(script: 'git describe --tags --exact-match 2>/dev/null || echo ""', returnStdout: true).trim()
                        } catch (e) {}
                    }
                    def isRelease = gitTag && gitTag.startsWith('v')
                    
                    // Nhất quán với getChangedServices(): kiểm tra cả BRANCH_NAME và GIT_BRANCH
                    def isMainBranch = (env.BRANCH_NAME == 'main' || env.GIT_BRANCH == 'main' || env.GIT_BRANCH == 'origin/main')
                    
                    if (isRelease) {
                        servicesToBuild = getChangedServices().toList().sort()
                        imageTag = gitTag
                        echo "Phát hiện tag release: ${imageTag}. Build cho Staging. Dịch vụ: ${servicesToBuild}"
                    } else if (isMainBranch) {
                        // Nhánh main: chỉ build CÁC SERVICE THAY ĐỔI, tag = commitHash (7 ký tự)
                        servicesToBuild = getChangedServices().toList().sort()
                        imageTag = commitHash
                        echo "Phát hiện nhánh 'main'. Chỉ build CÁC SERVICE THAY ĐỔI: ${servicesToBuild} | Tag: ${imageTag}"
                    } else {
                        // Yêu cầu #3: User branch → chỉ build services thay đổi so với main
                        // Tag = <commitHash> (commit ID cuối cùng của branch đó)
                        servicesToBuild = getChangedServices().toList().sort()
                        imageTag = commitHash
                        
                        // Lấy tên nhánh để log
                        def rawBranch = env.BRANCH_NAME ?: env.GIT_BRANCH ?: 'dev'
                        echo "Phát hiện user branch '${rawBranch}'. Chỉ build CÁC SERVICE THAY ĐỔI: ${servicesToBuild} | Tag: ${imageTag}"
                    }

                    // Loại bỏ các module phụ trợ không chạy container
                    servicesToBuild.remove("payment-paypal")
                    
                    // TỰ ĐỘNG FALLBACK: Nếu danh sách trống trên main hoặc release tag (do shallow clone / build thủ công)
                    // Jenkins sẽ tự động điền toàn bộ 18 services để đồng bộ đầy đủ cấu hình.
                    if (servicesToBuild.isEmpty() && (isMainBranch || isRelease)) {
                        servicesToBuild = ["location", "payment", "promotion", "rating", "recommendation", "webhook", "product", "cart", "order", "customer", "inventory", "media", "search", "storefront-bff", "backoffice-bff", "storefront-ui", "backoffice-ui", "sampledata"]
                        echo "⚠️ Danh sách thay đổi trống. Tự động chuyển sang build/push TOÀN BỘ service: ${servicesToBuild}"
                    }

                    if (servicesToBuild.isEmpty()) {
                        echo "⏭️  Không có service nào thay đổi → Bỏ qua Build & Push Docker Image."
                    } else {
                        // Nhúng ID của Credentials Docker Hub
                        withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials-id', passwordVariable: 'DOCKER_PASS', usernameVariable: 'DOCKER_USER')]) {
                            
                            // Đăng nhập Docker Hub
                            sh '''
                                echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                            '''
                            
                            for (String svc : servicesToBuild) {
                                echo "Đang Build và Push image cho service: ${svc} | Tag: ${imageTag}"
                                
                                def imageName = "${env.DOCKER_USER}/${svc}:${imageTag}"
                                
                                // Bỏ qua nếu thư mục service không tồn tại (tránh lỗi pipeline)
                                if (fileExists("./${svc}")) {
                                    sh "docker build -t ${imageName} ./${svc}"
                                    sh "docker push ${imageName}"
                                    echo "✅ Đã push thành công: ${imageName}"
                                    
                                    // Nếu là main branch (nhưng không phải tag release), đẩy thêm tag 'latest' cho CD Job của dev dùng
                                    if (isMainBranch && !isRelease) {
                                        def latestImageName = "${env.DOCKER_USER}/${svc}:latest"
                                        sh "docker tag ${imageName} ${latestImageName}"
                                        sh "docker push ${latestImageName}"
                                        echo "✅ Đã push tag latest thành công: ${latestImageName}"
                                    }
                                } else {
                                    echo "CẢNH BÁO: Không tìm thấy thư mục ./${svc}. Bỏ qua..."
                                }
                            }
                        }
                    }
                }
            }
        }

        stage('Update GitOps Repo') {
            steps {
                script {
                    def servicesToBuild = getChangedServices().toList().sort()
                    def commitHash = env.GIT_COMMIT ? env.GIT_COMMIT.take(7) : 'latest'
                    
                    def gitTag = ''
                    if (env.TAG_NAME) {
                        gitTag = env.TAG_NAME
                    } else {
                        try {
                            gitTag = sh(script: 'git describe --tags --exact-match 2>/dev/null || echo ""', returnStdout: true).trim()
                        } catch (e) {}
                    }
                    def isRelease = gitTag && gitTag.startsWith('v')
                    def isMainBranch = (env.BRANCH_NAME == 'main' || env.GIT_BRANCH == 'main' || env.GIT_BRANCH == 'origin/main')
                    def imageTag = isRelease ? gitTag : commitHash
                    
                    // Loại bỏ các module phụ trợ không chạy container
                    servicesToBuild.remove("payment-paypal")
                    
                    // TỰ ĐỘNG FALLBACK: Điền toàn bộ 18 services nếu danh sách trống trên main hoặc release tag
                    if (servicesToBuild.isEmpty() && (isMainBranch || isRelease)) {
                        servicesToBuild = ["location", "payment", "promotion", "rating", "recommendation", "webhook", "product", "cart", "order", "customer", "inventory", "media", "search", "storefront-bff", "backoffice-bff", "storefront-ui", "backoffice-ui", "sampledata"]
                        echo "⚠️ Danh sách thay đổi trống. Tự động chuyển sang cập nhật GitOps TOÀN BỘ service."
                    }
                    
                    // Chỉ chạy GitOps cho nhánh main hoặc Release Tag
                    if (!isMainBranch && !isRelease) {
                        echo "⏭️ Đây là user branch. Chỉ push Docker Image để CD Job sử dụng. Bỏ qua cập nhật GitOps."
                    } else if (servicesToBuild.isEmpty()) {
                        echo "⏭️ Không có service nào thay đổi -> Bỏ qua Update GitOps Repo."
                    } else {
                        def envName = isRelease ? 'staging' : 'dev'
                        
                        echo "=> Bắt đầu Clone và Update GitOps Repo cho: ${servicesToBuild} | Môi trường: ${envName} | Tag: ${imageTag}"
                        
                        // Sử dụng Credentials ID 'github-credentials-id' lưu Token/Username Password để Git Push
                        withCredentials([usernamePassword(credentialsId: 'github-credentials-id', passwordVariable: 'GIT_PASS', usernameVariable: 'GIT_USER')]) {
                            sh """
                                git config --global user.email "lenhatthanh1004@gmail.com"
                                git config --global user.name "23120357"
                                
                                rm -rf yas-gitops
                                git clone https://${GIT_USER}:${GIT_PASS}@github.com/23120357/yas-gitops.git
                            """
                            
                            for (String svc : servicesToBuild) {
                                sh """
                                    cd yas-gitops
                                    FILE_PATH="environments/${envName}/services/${svc}.yaml"
                                    
                                    # Xác định KEY (ui hoặc backend)
                                    if grep -q "^ui:" "charts/${svc}/values.yaml"; then
                                        KEY="ui"
                                    else
                                        KEY="backend"
                                    fi
                                    
                                    # Đảm bảo thư mục tồn tại
                                    mkdir -p environments/${envName}/services
                                    
                                    # Cập nhật tag thông minh bảo toàn cấu hình cũ
                                    if [ -f "\${FILE_PATH}" ] && grep -q "tag:" "\${FILE_PATH}"; then
                                        sed -i 's/tag: .*/tag: "'${imageTag}'"/g' "\${FILE_PATH}"
                                    else
                                        cat <<EOF > "\${FILE_PATH}"
# Service specific overrides
\${KEY}:
  image:
    tag: "${imageTag}"
EOF
                                    fi
                                    
                                    git add "\${FILE_PATH}"
                                """
                            }
                            
                            sh """
                                cd yas-gitops
                                if ! git diff --cached --quiet; then
                                    git commit -m "Auto-update image tag to ${imageTag} for ${servicesToBuild} [skip ci]"
                                    git push origin main
                                else
                                    echo "Không có thay đổi để commit."
                                fi
                            """
                        }
                    }
                }
            }
        }
    }
}
