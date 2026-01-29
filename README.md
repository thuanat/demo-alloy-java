# demo-alloy-java


VII. Thứ tự apply (RẤT QUAN TRỌNG)
kubectl apply -f k8s/namespace.yaml

kubectl apply -f k8s/backend/
kubectl apply -f k8s/alloy/gateway-config.yaml
kubectl apply -f k8s/alloy/gateway.yaml
kubectl apply -f k8s/alloy/agent-config.yaml
kubectl apply -f k8s/alloy/agent.yaml
kubectl apply -f k8s/app/demo-java.yaml