rem http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/

kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.0/aio/deploy/recommended.yaml

kubectl proxy

kubectl -n kubernetes-dashboard get secret $(kubectl -n kubernetes-dashboard get sa/kubernetes-dashboard -o jsonpath="{.secrets[0].name}") -o go-template="{{.data.token | base64decode}}"

