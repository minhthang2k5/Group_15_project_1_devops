#!/bin/bash
# Script khởi động tuần tự từng microservice trong yas-dev-developer
# Mỗi service sẽ được scale lên 1, đợi nó READY (1/1) rồi mới tiếp tục

NAMESPACE="yas-dev-developer"
SERVICES=(product media inventory customer order cart tax search sampledata storefront-bff backoffice-bff)

echo "=========================================="
echo "  BẮT ĐẦU KHỞI ĐỘNG TUẦN TỰ"
echo "  Tổng cộng: ${#SERVICES[@]} services"
echo "=========================================="

for i in "${!SERVICES[@]}"; do
  svc="${SERVICES[$i]}"
  num=$((i + 1))
  echo ""
  echo "[$num/${#SERVICES[@]}] Đang khởi động: $svc ..."
  kubectl scale deploy "$svc" -n "$NAMESPACE" --replicas=1

  # Đợi pod READY, timeout 300 giây (5 phút)
  echo "    Đang đợi $svc sẵn sàng (timeout 5 phút)..."
  if kubectl rollout status deploy/"$svc" -n "$NAMESPACE" --timeout=300s 2>/dev/null; then
    echo "    ✅ $svc đã lên 1/1 thành công!"
  else
    echo "    ⚠️  $svc chưa sẵn sàng sau 5 phút, tiếp tục với service tiếp theo..."
  fi
done

echo ""
echo "=========================================="
echo "  HOÀN TẤT! Kiểm tra kết quả:"
echo "=========================================="
kubectl get pods -n "$NAMESPACE"
