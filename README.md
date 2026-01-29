# demo-alloy-java

VII. Thứ tự apply (RẤT QUAN TRỌNG)
kubectl apply -f k8s/00-namespace.yaml

kubectl apply -f k8s/backend/
kubectl apply -f k8s/alloy/gateway-config.yaml
kubectl apply -f k8s/alloy/gateway.yaml
kubectl apply -f k8s/alloy/agent-config.yaml
kubectl apply -f k8s/alloy/agent.yaml
kubectl apply -f k8s/app/demo-java.yaml

VIII. Demo test
kubectl port-forward deploy/demo-java -n monitor 8080

curl http://localhost:8080/success
curl http://localhost:8080/slow
curl http://localhost:8080/error

IX. Kết quả mong đợi

Tempo: thấy trace /error, /slow, /success

Loki: log INFO / WARN / ERROR

Mimir: metrics request / latency

Grafana: click log ↔ trace ↔ metric