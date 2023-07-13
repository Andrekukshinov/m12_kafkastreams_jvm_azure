build-and-push-img:
		cd connectors && \
		docker build . -t $(connectors-img) && \
		docker push $(connectors-img)

init-kubectl:
		kubectl create namespace confluent && \
        kubectl config set-context --current --namespace confluent && \
        helm repo add confluentinc https://packages.confluent.io/helm && \
        helm repo update && \
        helm upgrade --install confluent-operator confluentinc/confluent-for-kubernetes

terraform-first-run:
		az login && \
		cd terraform && \
		terraform init && \
		terraform apply -auto-approve && \
		make terraform-create-key && \
		echo 'change resource group and name if you were updating them in tf variables' && \
		az aks get-credentials --resource-group rg-kuksh0m12-westeurope --name aks-kuksh0m12-westeurope --overwrite-existing && \
		make init-kubectl


terraform-subs-run:
		cd terraform && \
		terraform apply -auto-approve && \
		make terraform-create-key && \
        make init-kubectl

terraform-create-key:
		terraform output -raw azure_acc_key > ../key.txt

terraform-get-key:
		cd terraform && \
		make terraform-create-key


apply-infrastructure:
		bash setConnectorImage.sh $(connectors-img) && \
 		kubectl apply -f confluent-platform.yaml && \
 		kubectl apply -f producer-app-data.yaml

tunnel-connect:
		kubectl port-forward connect-0 8083:8083

tunnel-control-center:
		kubectl port-forward controlcenter-0 9021:9021


submit-connector:
		bash maskKeyAndSubmit.sh

first-run:
		make build-and-push-img connectors-img=$(connectors-img) && \
		make terraform-first-run && \
		make apply-infrastructure connectors-img=$(connectors-img) && \
		make build-and-push-img-for-streams streams-img=$(streams-img)

subs-run:
		make terraform-subs-run && \
		make apply-infrastructure connectors-img=$(connectors-img) && \
        make build-and-push-img-for-streams streams-img=$(streams-img)

get-key-and-apply-infra:
		make terraform-get-key && \
		make apply-infrastructure connectors-img=$(connectors-img) && \
        make build-and-push-img-for-streams streams-img=$(streams-img)

build-and-push-img-for-streams:
		mvn clean install && \
		docker build . -t $(streams-img) && \
        docker push $(streams-img) && \
        bash setStreamsImage.sh && \
        kubectl apply -f kstream-app.yaml
