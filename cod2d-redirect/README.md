# Cod2d-Redirect



### deploy:
criar imagem docker e subir para artifact registry do google cloud
https://console.cloud.google.com/artifacts?project=cod2d-producao

https://cloud.google.com/java/getting-started/jib?hl=pt-br


para subir para o google cloud artifacty
mvn compile jib:build

https://console.cloud.google.com/run/detail/us-central1/cod2d-redirect/metrics?project=cod2d-producao


https://github.com/GoogleCloudPlatform/java-docs-samples/tree/main/cloud-sql/mysql/servlet



https://codelabs.developers.google.com/codelabs/cloud-spring-petclinic-cloudsql#3


## Links para Teste

http://


acesso local 

ligar banco de dados
~/Documentos/johnny/IDEIAS-PROJETOS/COD2D/microservices/cloud-run/./cloud_sql_proxy -instances=cod2d-producao:us-central1:cod2d-database1=tcp:0.0.0.0:3306


rodar local
gcloud run deploy --image gcr.io/cod2d-producao/cod2d-redirect@sha256:3a7317eea2f96a64b8b42962c8476a41dc84fe4beb04e1efcb371f2fde03080c --max-instances=3 --port 5000


`gcloud config set run/region us-central1`