nhatthanh@yas-vm:~/Group_15_project_1_devops$ kubectl logs -n dev storefront-bff-6b4d8bf675-sxl7w --previous --tail=200

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v4.0.2)

2026-06-25T15:06:01.843Z application=storefront-bff traceId= spanId= level=INFO 1 --- [storefront-bff] [           main] c.y.s.StorefrontBffApplication           : Starting StorefrontBffApplication v1.0-SNAPSHOT using Java 25.0.2 with PID 1 (/app.jar started by root in /)
2026-06-25T15:06:01.857Z application=storefront-bff traceId= spanId= level=INFO 1 --- [storefront-bff] [           main] c.y.s.StorefrontBffApplication           : The following 1 profile is active: "dev"
2026-06-25T15:06:11.130Z application=storefront-bff traceId= spanId= level=INFO 1 --- [storefront-bff] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode
2026-06-25T15:06:11.141Z application=storefront-bff traceId= spanId= level=INFO 1 --- [storefront-bff] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data Redis repositories in DEFAULT mode.
2026-06-25T15:06:11.342Z application=storefront-bff traceId= spanId= level=INFO 1 --- [storefront-bff] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 87 ms. Found 0 Redis repository interfaces.
2026-06-25T15:06:13.298Z application=storefront-bff traceId= spanId= level=INFO 1 --- [storefront-bff] [           main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=4f214d62-ce60-32eb-a7da-fcecabd3c996
2026-06-25T15:06:16.087Z application=storefront-bff traceId= spanId= level=WARN 1 --- [storefront-bff] [           main] onfigReactiveWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'securityConfig' defined in URL [jar:nested:/app.jar/!BOOT-INF/classes/!/com/yas/storefrontbff/config/SecurityConfig.class]: Unsatisfied dependency expressed through constructor parameter 0: Error creating bean with name 'reactiveClientRegistrationRepository' defined in class path resource [org/springframework/boot/security/oauth2/client/autoconfigure/reactive/ReactiveOAuth2ClientConfigurations$ReactiveClientRegistrationRepositoryConfiguration.class]: Failed to instantiate [org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository]: Factory method 'reactiveClientRegistrationRepository' threw exception with message: Unable to resolve Configuration with the provided Issuer of "http://34.142.221.97/realms/Yas"
2026-06-25T15:06:16.140Z application=storefront-bff traceId= spanId= level=INFO 1 --- [storefront-bff] [           main] .s.b.a.l.ConditionEvaluationReportLogger :

Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2026-06-25T15:06:16.249Z application=storefront-bff traceId= spanId= level=ERROR 1 --- [storefront-bff] [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'securityConfig' defined in URL [jar:nested:/app.jar/!BOOT-INF/classes/!/com/yas/storefrontbff/config/SecurityConfig.class]: Unsatisfied dependency expressed through constructor parameter 0: Error creating bean with name 'reactiveClientRegistrationRepository' defined in class path resource [org/springframework/boot/security/oauth2/client/autoconfigure/reactive/ReactiveOAuth2ClientConfigurations$ReactiveClientRegistrationRepositoryConfiguration.class]: Failed to instantiate [org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository]: Factory method 'reactiveClientRegistrationRepository' threw exception with message: Unable to resolve Configuration with the provided Issuer of "http://34.142.221.97/realms/Yas"
        at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:804)
        at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:240)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1382)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1221)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:565)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:525)
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:333)
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:371)
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:331)
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:196)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.instantiateSingleton(DefaultListableBeanFactory.java:1218)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingleton(DefaultListableBeanFactory.java:1184)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:1121)
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:993)
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:620)
        at org.springframework.boot.web.server.reactive.context.ReactiveWebServerApplicationContext.refresh(ReactiveWebServerApplicationContext.java:69)
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:756)
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:445)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:321)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1365)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1354)
        at com.yas.storefrontbff.StorefrontBffApplication.main(StorefrontBffApplication.java:15)
        at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(Unknown Source)
        at java.base/java.lang.reflect.Method.invoke(Unknown Source)
        at org.springframework.boot.loader.launch.Launcher.launch(Launcher.java:106)
        at org.springframework.boot.loader.launch.Launcher.launch(Launcher.java:64)
        at org.springframework.boot.loader.launch.JarLauncher.main(JarLauncher.java:40)
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'reactiveClientRegistrationRepository' defined in class path resource [org/springframework/boot/security/oauth2/client/autoconfigure/reactive/ReactiveOAuth2ClientConfigurations$ReactiveClientRegistrationRepositoryConfiguration.class]: Failed to instantiate [org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository]: Factory method 'reactiveClientRegistrationRepository' threw exception with message: Unable to resolve Configuration with the provided Issuer of "http://34.142.221.97/realms/Yas"
        at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:657)
        at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:645)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1362)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1194)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:565)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:525)
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:333)
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:371)
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:331)
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:201)
        at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:229)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1762)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1651)
        at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:912)
        at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:791)
        ... 26 common frames omitted
Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository]: Factory method 'reactiveClientRegistrationRepository' threw exception with message: Unable to resolve Configuration with the provided Issuer of "http://34.142.221.97/realms/Yas"
        at org.springframework.beans.factory.support.SimpleInstantiationStrategy.lambda$instantiate$0(SimpleInstantiationStrategy.java:183)
        at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiateWithFactoryMethod(SimpleInstantiationStrategy.java:72)
        at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:152)
        at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:653)
        ... 40 common frames omitted
Caused by: java.lang.IllegalArgumentException: Unable to resolve Configuration with the provided Issuer of "http://34.142.221.97/realms/Yas"
        at org.springframework.security.oauth2.client.registration.ClientRegistrations.getBuilder(ClientRegistrations.java:286)
        at org.springframework.security.oauth2.client.registration.ClientRegistrations.fromIssuerLocation(ClientRegistrations.java:193)
        at org.springframework.boot.security.oauth2.client.autoconfigure.OAuth2ClientPropertiesMapper.getBuilderFromIssuerIfPossible(OAuth2ClientPropertiesMapper.java:99)
        at org.springframework.boot.security.oauth2.client.autoconfigure.OAuth2ClientPropertiesMapper.getClientRegistration(OAuth2ClientPropertiesMapper.java:73)
        at org.springframework.boot.security.oauth2.client.autoconfigure.OAuth2ClientPropertiesMapper.lambda$asClientRegistrations$0(OAuth2ClientPropertiesMapper.java:67)
        at java.base/java.util.HashMap.forEach(Unknown Source)
        at org.springframework.boot.security.oauth2.client.autoconfigure.OAuth2ClientPropertiesMapper.asClientRegistrations(OAuth2ClientPropertiesMapper.java:66)
        at org.springframework.boot.security.oauth2.client.autoconfigure.reactive.ReactiveOAuth2ClientConfigurations$ReactiveClientRegistrationRepositoryConfiguration.reactiveClientRegistrationRepository(ReactiveOAuth2ClientConfigurations.java:53)
        at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(Unknown Source)
        at java.base/java.lang.reflect.Method.invoke(Unknown Source)
        at org.springframework.beans.factory.support.SimpleInstantiationStrategy.lambda$instantiate$0(SimpleInstantiationStrategy.java:155)
        ... 43 common frames omitted
Caused by: org.springframework.web.client.ResourceAccessException: I/O error on GET request for "http://34.142.221.97/realms/Yas/.well-known/openid-configuration": Connection refused
        at org.springframework.web.client.RestTemplate.createResourceAccessException(RestTemplate.java:780)
        at org.springframework.web.client.RestTemplate.doExecute(RestTemplate.java:760)
        at org.springframework.web.client.RestTemplate.exchange(RestTemplate.java:629)
        at org.springframework.security.oauth2.client.registration.ClientRegistrations.lambda$oidc$0(ClientRegistrations.java:201)
        at org.springframework.security.oauth2.client.registration.ClientRegistrations.getBuilder(ClientRegistrations.java:273)
        ... 53 common frames omitted
Caused by: java.net.ConnectException: Connection refused
        at java.base/sun.nio.ch.Net.pollConnect(Native Method)
        at java.base/sun.nio.ch.Net.pollConnectNow(Unknown Source)
        at java.base/sun.nio.ch.NioSocketImpl.timedFinishConnect(Unknown Source)
        at java.base/sun.nio.ch.NioSocketImpl.connect(Unknown Source)
        at java.base/java.net.Socket.connect(Unknown Source)
        at java.base/sun.net.NetworkClient.doConnect(Unknown Source)
        at java.base/sun.net.www.http.HttpClient.openServer(Unknown Source)
        at java.base/sun.net.www.http.HttpClient.openServer(Unknown Source)
        at java.base/sun.net.www.http.HttpClient.<init>(Unknown Source)
        at java.base/sun.net.www.http.HttpClient.New(Unknown Source)
        at java.base/sun.net.www.http.HttpClient.New(Unknown Source)
        at java.base/sun.net.www.protocol.http.HttpURLConnection.getNewHttpClient(Unknown Source)
        at java.base/sun.net.www.protocol.http.HttpURLConnection.plainConnect0(Unknown Source)
        at java.base/sun.net.www.protocol.http.HttpURLConnection.plainConnect(Unknown Source)
        at java.base/sun.net.www.protocol.http.HttpURLConnection.connect(Unknown Source)
        at org.springframework.http.client.SimpleClientHttpRequest.executeInternal(SimpleClientHttpRequest.java:80)
        at org.springframework.http.client.AbstractStreamingClientHttpRequest.executeInternal(AbstractStreamingClientHttpRequest.java:87)
        at org.springframework.http.client.AbstractClientHttpRequest.execute(AbstractClientHttpRequest.java:80)
        at org.springframework.web.client.RestTemplate.doExecute(RestTemplate.java:754)
        ... 56 common frames omitted

nhatthanh@yas-vm:~/Group_15_project_1_devops$ kubectl logs -n dev storefront-bff-6b4d8bf675-sxl7w --tail=200

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v4.0.2)

2026-06-25T15:06:01.843Z application=storefront-bff traceId= spanId= level=INFO 1 --- [storefront-bff] [           main] c.y.s.StorefrontBffApplication           : Starting StorefrontBffApplication v1.0-SNAPSHOT using Java 25.0.2 with PID 1 (/app.jar started by root in /)
2026-06-25T15:06:01.857Z application=storefront-bff traceId= spanId= level=INFO 1 --- [storefront-bff] [           main] c.y.s.StorefrontBffApplication           : The following 1 profile is active: "dev"
2026-06-25T15:06:11.130Z application=storefront-bff traceId= spanId= level=INFO 1 --- [storefront-bff] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode
2026-06-25T15:06:11.141Z application=storefront-bff traceId= spanId= level=INFO 1 --- [storefront-bff] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data Redis repositories in DEFAULT mode.
2026-06-25T15:06:11.342Z application=storefront-bff traceId= spanId= level=INFO 1 --- [storefront-bff] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 87 ms. Found 0 Redis repository interfaces.
2026-06-25T15:06:13.298Z application=storefront-bff traceId= spanId= level=INFO 1 --- [storefront-bff] [           main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=4f214d62-ce60-32eb-a7da-fcecabd3c996
2026-06-25T15:06:16.087Z application=storefront-bff traceId= spanId= level=WARN 1 --- [storefront-bff] [           main] onfigReactiveWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'securityConfig' defined in URL [jar:nested:/app.jar/!BOOT-INF/classes/!/com/yas/storefrontbff/config/SecurityConfig.class]: Unsatisfied dependency expressed through constructor parameter 0: Error creating bean with name 'reactiveClientRegistrationRepository' defined in class path resource [org/springframework/boot/security/oauth2/client/autoconfigure/reactive/ReactiveOAuth2ClientConfigurations$ReactiveClientRegistrationRepositoryConfiguration.class]: Failed to instantiate [org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository]: Factory method 'reactiveClientRegistrationRepository' threw exception with message: Unable to resolve Configuration with the provided Issuer of "http://34.142.221.97/realms/Yas"
2026-06-25T15:06:16.140Z application=storefront-bff traceId= spanId= level=INFO 1 --- [storefront-bff] [           main] .s.b.a.l.ConditionEvaluationReportLogger :

Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2026-06-25T15:06:16.249Z application=storefront-bff traceId= spanId= level=ERROR 1 --- [storefront-bff] [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'securityConfig' defined in URL [jar:nested:/app.jar/!BOOT-INF/classes/!/com/yas/storefrontbff/config/SecurityConfig.class]: Unsatisfied dependency expressed through constructor parameter 0: Error creating bean with name 'reactiveClientRegistrationRepository' defined in class path resource [org/springframework/boot/security/oauth2/client/autoconfigure/reactive/ReactiveOAuth2ClientConfigurations$ReactiveClientRegistrationRepositoryConfiguration.class]: Failed to instantiate [org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository]: Factory method 'reactiveClientRegistrationRepository' threw exception with message: Unable to resolve Configuration with the provided Issuer of "http://34.142.221.97/realms/Yas"
        at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:804)
        at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:240)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1382)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1221)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:565)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:525)
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:333)
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:371)
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:331)
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:196)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.instantiateSingleton(DefaultListableBeanFactory.java:1218)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingleton(DefaultListableBeanFactory.java:1184)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:1121)
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:993)
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:620)
        at org.springframework.boot.web.server.reactive.context.ReactiveWebServerApplicationContext.refresh(ReactiveWebServerApplicationContext.java:69)
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:756)
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:445)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:321)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1365)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1354)
        at com.yas.storefrontbff.StorefrontBffApplication.main(StorefrontBffApplication.java:15)
        at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(Unknown Source)
        at java.base/java.lang.reflect.Method.invoke(Unknown Source)
        at org.springframework.boot.loader.launch.Launcher.launch(Launcher.java:106)
        at org.springframework.boot.loader.launch.Launcher.launch(Launcher.java:64)
        at org.springframework.boot.loader.launch.JarLauncher.main(JarLauncher.java:40)
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'reactiveClientRegistrationRepository' defined in class path resource [org/springframework/boot/security/oauth2/client/autoconfigure/reactive/ReactiveOAuth2ClientConfigurations$ReactiveClientRegistrationRepositoryConfiguration.class]: Failed to instantiate [org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository]: Factory method 'reactiveClientRegistrationRepository' threw exception with message: Unable to resolve Configuration with the provided Issuer of "http://34.142.221.97/realms/Yas"
        at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:657)
        at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:645)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1362)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1194)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:565)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:525)
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:333)
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:371)
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:331)
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:201)
        at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:229)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1762)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1651)
        at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:912)
        at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:791)
        ... 26 common frames omitted
Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository]: Factory method 'reactiveClientRegistrationRepository' threw exception with message: Unable to resolve Configuration with the provided Issuer of "http://34.142.221.97/realms/Yas"
        at org.springframework.beans.factory.support.SimpleInstantiationStrategy.lambda$instantiate$0(SimpleInstantiationStrategy.java:183)
        at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiateWithFactoryMethod(SimpleInstantiationStrategy.java:72)
        at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:152)
        at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:653)
        ... 40 common frames omitted
Caused by: java.lang.IllegalArgumentException: Unable to resolve Configuration with the provided Issuer of "http://34.142.221.97/realms/Yas"
        at org.springframework.security.oauth2.client.registration.ClientRegistrations.getBuilder(ClientRegistrations.java:286)
        at org.springframework.security.oauth2.client.registration.ClientRegistrations.fromIssuerLocation(ClientRegistrations.java:193)
        at org.springframework.boot.security.oauth2.client.autoconfigure.OAuth2ClientPropertiesMapper.getBuilderFromIssuerIfPossible(OAuth2ClientPropertiesMapper.java:99)
        at org.springframework.boot.security.oauth2.client.autoconfigure.OAuth2ClientPropertiesMapper.getClientRegistration(OAuth2ClientPropertiesMapper.java:73)
        at org.springframework.boot.security.oauth2.client.autoconfigure.OAuth2ClientPropertiesMapper.lambda$asClientRegistrations$0(OAuth2ClientPropertiesMapper.java:67)
        at java.base/java.util.HashMap.forEach(Unknown Source)
        at org.springframework.boot.security.oauth2.client.autoconfigure.OAuth2ClientPropertiesMapper.asClientRegistrations(OAuth2ClientPropertiesMapper.java:66)
        at org.springframework.boot.security.oauth2.client.autoconfigure.reactive.ReactiveOAuth2ClientConfigurations$ReactiveClientRegistrationRepositoryConfiguration.reactiveClientRegistrationRepository(ReactiveOAuth2ClientConfigurations.java:53)
        at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(Unknown Source)
        at java.base/java.lang.reflect.Method.invoke(Unknown Source)
        at org.springframework.beans.factory.support.SimpleInstantiationStrategy.lambda$instantiate$0(SimpleInstantiationStrategy.java:155)
        ... 43 common frames omitted
Caused by: org.springframework.web.client.ResourceAccessException: I/O error on GET request for "http://34.142.221.97/realms/Yas/.well-known/openid-configuration": Connection refused
        at org.springframework.web.client.RestTemplate.createResourceAccessException(RestTemplate.java:780)
        at org.springframework.web.client.RestTemplate.doExecute(RestTemplate.java:760)
        at org.springframework.web.client.RestTemplate.exchange(RestTemplate.java:629)
        at org.springframework.security.oauth2.client.registration.ClientRegistrations.lambda$oidc$0(ClientRegistrations.java:201)
        at org.springframework.security.oauth2.client.registration.ClientRegistrations.getBuilder(ClientRegistrations.java:273)
        ... 53 common frames omitted
Caused by: java.net.ConnectException: Connection refused
        at java.base/sun.nio.ch.Net.pollConnect(Native Method)
        at java.base/sun.nio.ch.Net.pollConnectNow(Unknown Source)
        at java.base/sun.nio.ch.NioSocketImpl.timedFinishConnect(Unknown Source)
        at java.base/sun.nio.ch.NioSocketImpl.connect(Unknown Source)
        at java.base/java.net.Socket.connect(Unknown Source)
        at java.base/sun.net.NetworkClient.doConnect(Unknown Source)
        at java.base/sun.net.www.http.HttpClient.openServer(Unknown Source)
        at java.base/sun.net.www.http.HttpClient.openServer(Unknown Source)
        at java.base/sun.net.www.http.HttpClient.<init>(Unknown Source)
        at java.base/sun.net.www.http.HttpClient.New(Unknown Source)
        at java.base/sun.net.www.http.HttpClient.New(Unknown Source)
        at java.base/sun.net.www.protocol.http.HttpURLConnection.getNewHttpClient(Unknown Source)
        at java.base/sun.net.www.protocol.http.HttpURLConnection.plainConnect0(Unknown Source)
        at java.base/sun.net.www.protocol.http.HttpURLConnection.plainConnect(Unknown Source)
        at java.base/sun.net.www.protocol.http.HttpURLConnection.connect(Unknown Source)
        at org.springframework.http.client.SimpleClientHttpRequest.executeInternal(SimpleClientHttpRequest.java:80)
        at org.springframework.http.client.AbstractStreamingClientHttpRequest.executeInternal(AbstractStreamingClientHttpRequest.java:87)
        at org.springframework.http.client.AbstractClientHttpRequest.execute(AbstractClientHttpRequest.java:80)
        at org.springframework.web.client.RestTemplate.doExecute(RestTemplate.java:754)
        ... 56 common frames omitted

nhatthanh@yas-vm:~/Group_15_project_1_devops$ kubectl describe pod storefront-bff-6b4d8bf675-sxl7w -n dev
Name:             storefront-bff-6b4d8bf675-sxl7w
Namespace:        dev
Priority:         0
Service Account:  storefront-bff
Node:             minikube/192.168.49.2
Start Time:       Thu, 25 Jun 2026 09:45:43 +0000
Labels:           app.kubernetes.io/instance=dev-storefront-bff
                  app.kubernetes.io/name=storefront-bff
                  pod-template-hash=6b4d8bf675
Annotations:      kubectl.kubernetes.io/restartedAt: 2026-06-25T09:16:21Z
Status:           Running
IP:               10.244.2.80
IPs:
  IP:           10.244.2.80
Controlled By:  ReplicaSet/storefront-bff-6b4d8bf675
Containers:
  storefront-bff:
    Container ID:   docker://55df08338a1a928b3eddfacb29df3a963feac75701d8c256674cfbb8e4c7f473
    Image:          ghcr.io/nashtech-garage/yas-storefront-bff:latest
    Image ID:       docker-pullable://ghcr.io/nashtech-garage/yas-storefront-bff@sha256:b320e530e5daf04a13497c3ca7fe759e6561efbfae19044d3fb240fd67b137de
    Ports:          80/TCP (http), 8090/TCP (metric)
    Host Ports:     0/TCP (http), 0/TCP (metric)
    State:          Waiting
      Reason:       CrashLoopBackOff
    Last State:     Terminated
      Reason:       Error
      Exit Code:    1
      Started:      Thu, 25 Jun 2026 15:05:58 +0000
      Finished:     Thu, 25 Jun 2026 15:06:16 +0000
    Ready:          False
    Restart Count:  63
    Liveness:       http-get http://:metric/actuator/health/liveness delay=120s timeout=1s period=10s #success=1 #failure=30
    Readiness:      http-get http://:metric/actuator/health/readiness delay=120s timeout=1s period=10s #success=1 #failure=30
    Environment Variables from:
      yas-postgresql-credentials-secret  Secret  Optional: false
      yas-keycloak-credentials-secret    Secret  Optional: false
      yas-redis-credentials-secret       Secret  Optional: false
    Environment:
      LOGGING_CONFIG:                                              /opt/yas/config/logback.xml
      SPRING_DATASOURCE_URL:                                       jdbc:postgresql://postgresql.postgres:5432/postgres
      SPRING_CONFIG_ADDITIONAL_LOCATION:                           /opt/yas/config/application.yaml,/opt/yas/gateway-routes-config/gateway-routes-config.yaml,/opt/yas/extra-config/storefront-bff-extra-config.yaml
      SPRING_SECURITY_OAUTH2_CLIENT_PROVIDER_KEYCLOAK_ISSUER_URI:  http://34.142.221.97/realms/Yas
      PGSSLMODE:                                                   disable
    Mounts:
      /opt/yas/config from yas-configuration (rw)
      /opt/yas/extra-config from storefront-bff-extra-config (rw)
      /opt/yas/gateway-routes-config from yas-gateway-routes-config (rw)
      /var/run/secrets/kubernetes.io/serviceaccount from kube-api-access-hmrv4 (ro)
Conditions:
  Type                        Status
  PodReadyToStartContainers   True
  Initialized                 True
  Ready                       False
  ContainersReady             False
  PodScheduled                True
Volumes:
  yas-configuration:
    Type:      ConfigMap (a volume populated by a ConfigMap)
    Name:      yas-configuration-configmap
    Optional:  false
  yas-gateway-routes-config:
    Type:      ConfigMap (a volume populated by a ConfigMap)
    Name:      yas-gateway-routes-config-configmap
    Optional:  false
  storefront-bff-extra-config:
    Type:      ConfigMap (a volume populated by a ConfigMap)
    Name:      storefront-bff-extra-configmap
    Optional:  false
  kube-api-access-hmrv4:
    Type:                    Projected (a volume that contains injected data from multiple sources)
    TokenExpirationSeconds:  3607
    ConfigMapName:           kube-root-ca.crt
    Optional:                false
    DownwardAPI:             true
QoS Class:                   BestEffort
Node-Selectors:              <none>
Tolerations:                 node.kubernetes.io/not-ready:NoExecute op=Exists for 300s
                             node.kubernetes.io/unreachable:NoExecute op=Exists for 300s
Events:
  Type     Reason   Age                     From     Message
  ----     ------   ----                    ----     -------
  Warning  BackOff  4m9s (x317 over 5h19m)  kubelet  spec.containers{storefront-bff}: Back-off restarting failed container storefront-bff in pod storefront-bff-6b4d8bf675-sxl7w_dev(5be1c984-39bc-4c17-83c4-b7a453d33058)
  Normal   Pulled   2m51s (x64 over 5h23m)  kubelet  spec.containers{storefront-bff}: Container image "ghcr.io/nashtech-garage/yas-storefront-bff:latest" already present on machine and can be accessed by the pod
  Normal   Created  2m50s (x64 over 5h23m)  kubelet  spec.containers{storefront-bff}: Container created
nhatthanh@yas-vm:~/Group_15_project_1_devops$ kubectl get deploy,rs,pod -n dev | grep storefront-bff
deployment.apps/storefront-bff   0/1     1            0           6h37m
replicaset.apps/storefront-bff-6b4d8bf675   1         1         0       5h23m
replicaset.apps/storefront-bff-7684fd64b5   1         1         0       5h34m
pod/storefront-bff-6b4d8bf675-sxl7w   0/1     CrashLoopBackOff   63 (3m13s ago)   5h23m
pod/storefront-bff-7684fd64b5-mfhc4   0/1     CrashLoopBackOff   66 (100s ago)    5h34m
nhatthanh@yas-vm:~/Group_15_project_1_devops$ kubectl describe deploy storefront-bff -n dev
Name:                   storefront-bff
Namespace:              dev
CreationTimestamp:      Thu, 25 Jun 2026 08:32:04 +0000
Labels:                 app.kubernetes.io/instance=dev-storefront-bff
                        app.kubernetes.io/managed-by=Helm
                        app.kubernetes.io/name=storefront-bff
                        app.kubernetes.io/version=latest
                        helm.sh/chart=backend-0.1.0
Annotations:            argocd.argoproj.io/tracking-id: dev-storefront-bff:apps/Deployment:dev/storefront-bff
                        configmap.reloader.stakater.com/reload: yas-gateway-routes-config-configmap,storefront-bff-extra-configmap
                        deployment.kubernetes.io/revision: 4
                        reloader.stakater.com/search: true
Selector:               app.kubernetes.io/instance=dev-storefront-bff,app.kubernetes.io/name=storefront-bff
Replicas:               1 desired | 1 updated | 2 total | 0 available | 2 unavailable
StrategyType:           RollingUpdate
MinReadySeconds:        0
RollingUpdateStrategy:  25% max unavailable, 25% max surge
Pod Template:
  Labels:           app.kubernetes.io/instance=dev-storefront-bff
                    app.kubernetes.io/name=storefront-bff
  Annotations:      kubectl.kubernetes.io/restartedAt: 2026-06-25T09:16:21Z
  Service Account:  storefront-bff
  Containers:
   storefront-bff:
    Image:       ghcr.io/nashtech-garage/yas-storefront-bff:latest
    Ports:       80/TCP (http), 8090/TCP (metric)
    Host Ports:  0/TCP (http), 0/TCP (metric)
    Liveness:    http-get http://:metric/actuator/health/liveness delay=120s timeout=1s period=10s #success=1 #failure=30
    Readiness:   http-get http://:metric/actuator/health/readiness delay=120s timeout=1s period=10s #success=1 #failure=30
    Environment Variables from:
      yas-postgresql-credentials-secret  Secret  Optional: false
      yas-keycloak-credentials-secret    Secret  Optional: false
      yas-redis-credentials-secret       Secret  Optional: false
    Environment:
      LOGGING_CONFIG:                                              /opt/yas/config/logback.xml
      SPRING_DATASOURCE_URL:                                       jdbc:postgresql://postgresql.postgres:5432/postgres
      SPRING_CONFIG_ADDITIONAL_LOCATION:                           /opt/yas/config/application.yaml,/opt/yas/gateway-routes-config/gateway-routes-config.yaml,/opt/yas/extra-config/storefront-bff-extra-config.yaml
      SPRING_SECURITY_OAUTH2_CLIENT_PROVIDER_KEYCLOAK_ISSUER_URI:  http://34.142.221.97/realms/Yas
      PGSSLMODE:                                                   disable
    Mounts:
      /opt/yas/config from yas-configuration (rw)
      /opt/yas/extra-config from storefront-bff-extra-config (rw)
      /opt/yas/gateway-routes-config from yas-gateway-routes-config (rw)
  Volumes:
   yas-configuration:
    Type:      ConfigMap (a volume populated by a ConfigMap)
    Name:      yas-configuration-configmap
    Optional:  false
   yas-gateway-routes-config:
    Type:      ConfigMap (a volume populated by a ConfigMap)
    Name:      yas-gateway-routes-config-configmap
    Optional:  false
   storefront-bff-extra-config:
    Type:          ConfigMap (a volume populated by a ConfigMap)
    Name:          storefront-bff-extra-configmap
    Optional:      false
  Node-Selectors:  <none>
  Tolerations:     <none>
Conditions:
  Type           Status  Reason
  ----           ------  ------
  Available      False   MinimumReplicasUnavailable
  Progressing    False   ProgressDeadlineExceeded
OldReplicaSets:  storefront-bff-7684fd64b5 (1/1 replicas created)
NewReplicaSet:   storefront-bff-6b4d8bf675 (1/1 replicas created)
Events:          <none>
nhatthanh@yas-vm:~/Group_15_project_1_devops$ kubectl get deploy storefront-bff -n dev -o yaml | sed -n '1,220p'
apiVersion: apps/v1
kind: Deployment
metadata:
  annotations:
    argocd.argoproj.io/tracking-id: dev-storefront-bff:apps/Deployment:dev/storefront-bff
    configmap.reloader.stakater.com/reload: yas-gateway-routes-config-configmap,storefront-bff-extra-configmap
    deployment.kubernetes.io/revision: "4"
    kubectl.kubernetes.io/last-applied-configuration: |
      {"apiVersion":"apps/v1","kind":"Deployment","metadata":{"annotations":{"argocd.argoproj.io/tracking-id":"dev-storefront-bff:apps/Deployment:dev/storefront-bff","configmap.reloader.stakater.com/reload":"yas-gateway-routes-config-configmap,storefront-bff-extra-configmap","reloader.stakater.com/search":"true"},"labels":{"app.kubernetes.io/instance":"dev-storefront-bff","app.kubernetes.io/managed-by":"Helm","app.kubernetes.io/name":"storefront-bff","app.kubernetes.io/version":"latest","helm.sh/chart":"backend-0.1.0"},"name":"storefront-bff","namespace":"dev"},"spec":{"replicas":1,"selector":{"matchLabels":{"app.kubernetes.io/instance":"dev-storefront-bff","app.kubernetes.io/name":"storefront-bff"}},"template":{"metadata":{"labels":{"app.kubernetes.io/instance":"dev-storefront-bff","app.kubernetes.io/name":"storefront-bff"}},"spec":{"containers":[{"env":[{"name":"LOGGING_CONFIG","value":"/opt/yas/config/logback.xml"},{"name":"SPRING_DATASOURCE_URL","value":"jdbc:postgresql://postgresql.postgres:5432/postgres"},{"name":"SPRING_CONFIG_ADDITIONAL_LOCATION","value":"/opt/yas/config/application.yaml,/opt/yas/gateway-routes-config/gateway-routes-config.yaml,/opt/yas/extra-config/storefront-bff-extra-config.yaml"},{"name":"SPRING_SECURITY_OAUTH2_CLIENT_PROVIDER_KEYCLOAK_ISSUER_URI","value":"http://34.142.221.97/realms/Yas"},{"name":"PGSSLMODE","value":"disable"}],"envFrom":[{"secretRef":{"name":"yas-postgresql-credentials-secret"}},{"secretRef":{"name":"yas-keycloak-credentials-secret"}},{"secretRef":{"name":"yas-redis-credentials-secret"}}],"image":"ghcr.io/nashtech-garage/yas-storefront-bff:latest","imagePullPolicy":"IfNotPresent","lifecycle":{"preStop":{"exec":{"command":["sh","-c","sleep 10"]}}},"livenessProbe":{"failureThreshold":30,"httpGet":{"path":"/actuator/health/liveness","port":"metric"},"initialDelaySeconds":120,"periodSeconds":10,"successThreshold":1},"name":"storefront-bff","ports":[{"containerPort":80,"name":"http","protocol":"TCP"},{"containerPort":8090,"name":"metric"}],"readinessProbe":{"failureThreshold":30,"httpGet":{"path":"/actuator/health/readiness","port":"metric"},"initialDelaySeconds":120,"periodSeconds":10,"successThreshold":1},"resources":{},"securityContext":{},"volumeMounts":[{"mountPath":"/opt/yas/config","name":"yas-configuration"},{"mountPath":"/opt/yas/gateway-routes-config","name":"yas-gateway-routes-config"},{"mountPath":"/opt/yas/extra-config","name":"storefront-bff-extra-config"}]}],"securityContext":{},"serviceAccountName":"storefront-bff","terminationGracePeriodSeconds":45,"volumes":[{"configMap":{"name":"yas-configuration-configmap"},"name":"yas-configuration"},{"configMap":{"name":"yas-gateway-routes-config-configmap"},"name":"yas-gateway-routes-config"},{"configMap":{"name":"storefront-bff-extra-configmap"},"name":"storefront-bff-extra-config"}]}}}}
    reloader.stakater.com/search: "true"
  creationTimestamp: "2026-06-25T08:32:04Z"
  generation: 5
  labels:
    app.kubernetes.io/instance: dev-storefront-bff
    app.kubernetes.io/managed-by: Helm
    app.kubernetes.io/name: storefront-bff
    app.kubernetes.io/version: latest
    helm.sh/chart: backend-0.1.0
  name: storefront-bff
  namespace: dev
  resourceVersion: "1332070"
  uid: 77e21519-e7eb-4749-b83a-66757af32718
spec:
  progressDeadlineSeconds: 600
  replicas: 1
  revisionHistoryLimit: 10
  selector:
    matchLabels:
      app.kubernetes.io/instance: dev-storefront-bff
      app.kubernetes.io/name: storefront-bff
  strategy:
    rollingUpdate:
      maxSurge: 25%
      maxUnavailable: 25%
    type: RollingUpdate
  template:
    metadata:
      annotations:
        kubectl.kubernetes.io/restartedAt: "2026-06-25T09:16:21Z"
      labels:
        app.kubernetes.io/instance: dev-storefront-bff
        app.kubernetes.io/name: storefront-bff
    spec:
      containers:
      - env:
        - name: LOGGING_CONFIG
          value: /opt/yas/config/logback.xml
        - name: SPRING_DATASOURCE_URL
          value: jdbc:postgresql://postgresql.postgres:5432/postgres
        - name: SPRING_CONFIG_ADDITIONAL_LOCATION
          value: /opt/yas/config/application.yaml,/opt/yas/gateway-routes-config/gateway-routes-config.yaml,/opt/yas/extra-config/storefront-bff-extra-config.yaml
        - name: SPRING_SECURITY_OAUTH2_CLIENT_PROVIDER_KEYCLOAK_ISSUER_URI
          value: http://34.142.221.97/realms/Yas
        - name: PGSSLMODE
          value: disable
        envFrom:
        - secretRef:
            name: yas-postgresql-credentials-secret
        - secretRef:
            name: yas-keycloak-credentials-secret
        - secretRef:
            name: yas-redis-credentials-secret
        image: ghcr.io/nashtech-garage/yas-storefront-bff:latest
        imagePullPolicy: IfNotPresent
        lifecycle:
          preStop:
            exec:
              command:
              - sh
              - -c
              - sleep 10
        livenessProbe:
          failureThreshold: 30
          httpGet:
            path: /actuator/health/liveness
            port: metric
            scheme: HTTP
          initialDelaySeconds: 120
          periodSeconds: 10
          successThreshold: 1
          timeoutSeconds: 1
        name: storefront-bff
        ports:
        - containerPort: 80
          name: http
          protocol: TCP
        - containerPort: 8090
          name: metric
          protocol: TCP
        readinessProbe:
          failureThreshold: 30
          httpGet:
            path: /actuator/health/readiness
            port: metric
            scheme: HTTP
          initialDelaySeconds: 120
          periodSeconds: 10
          successThreshold: 1
          timeoutSeconds: 1
        resources: {}
        securityContext: {}
        terminationMessagePath: /dev/termination-log
        terminationMessagePolicy: File
        volumeMounts:
        - mountPath: /opt/yas/config
          name: yas-configuration
        - mountPath: /opt/yas/gateway-routes-config
          name: yas-gateway-routes-config
        - mountPath: /opt/yas/extra-config
          name: storefront-bff-extra-config
      dnsPolicy: ClusterFirst
      hostAliases:
      - hostnames:
        - identity.yas.local.com
        ip: 10.244.1.118
      restartPolicy: Always
      schedulerName: default-scheduler
      securityContext: {}
      serviceAccount: storefront-bff
      serviceAccountName: storefront-bff
      terminationGracePeriodSeconds: 45
      volumes:
      - configMap:
          defaultMode: 420
          name: yas-configuration-configmap
        name: yas-configuration
      - configMap:
          defaultMode: 420
          name: yas-gateway-routes-config-configmap
        name: yas-gateway-routes-config
      - configMap:
          defaultMode: 420
          name: storefront-bff-extra-configmap
        name: storefront-bff-extra-config
status:
  conditions:
  - lastTransitionTime: "2026-06-25T08:32:04Z"
    lastUpdateTime: "2026-06-25T08:32:04Z"
    message: Deployment does not have minimum availability.
    reason: MinimumReplicasUnavailable
    status: "False"
    type: Available
  - lastTransitionTime: "2026-06-25T09:55:44Z"
    lastUpdateTime: "2026-06-25T09:55:44Z"
    message: ReplicaSet "storefront-bff-6b4d8bf675" has timed out progressing.
    reason: ProgressDeadlineExceeded
    status: "False"
    type: Progressing
  observedGeneration: 5
  replicas: 2
  terminatingReplicas: 0
  unavailableReplicas: 2
  updatedReplicas: 1
nhatthanh@yas-vm:~/Group_15_project_1_devops$