
## Deploy applications

### optional
 1. kubectl delete --all pods
 2. kubectl delete --all deployments
 ###
 
 #
 1. minikube start
 2. minikube dashboard
 3. eval $(minikube docker-env)
 4. kubectl create deployment beverageservice --image=group3_beverage:latest
 5. kubectl expose deployment beverageservice --type=NodePort --port=8080
 
 6. kubectl create deployment dbhandler --image=group3_db:latest
 7. kubectl expose deployment dbhandler --type=NodePort --port=9999
 
 8. kubectl create deployment managementservice --image=group3_management:latest
 9. kubectl expose deployment managementservice --type=NodePort --port=8090
10. minikube service beverageservice
 
 11. minikube service dbhandler
 
 12. minikube service managementservice
 
 

