# Cod2d Consumer

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Sumário</h2></summary>
  <ol>
    <li><a href="#dd">Design Docs</a></li>
    <li><a href="#tech">Principais Tecnologias Utilizadas</a></li>
    <li><a href="#prerequisites">Pre-requisitos</a></li>
    <li><a href="#installation">Instalação OS X & Linux</a></li>
    <li><a href="#tests">Testes de integração e unitários</a></li>
    <li><a href="#swagger">Documentação Swagger</a></li>
  </ol>
</details>

<div id="dd"></div>

## Docs
[Docs - Diagrama de Sequencia](https://cod2d.atlassian.net/wiki/spaces/INICIO/pages/edit-v2/6193170)

<div id="tech"></div>

## ⚙️ Principais Tecnologias Utilizadas

* [Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
* [Apache Maven 3.8.3](https://maven.apache.org/download.cgi)
* [Spring](https://spring.io/)
* [RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq/)

<div id="prerequisites"></div>

### 🛠️ Pré-requisitos (Instalação Manual)

Para instalar na sua máquina e rodar a aplicação será necessário instalar as tecnologias abaixo
```sh
Java 14
Apache Maven 3.8.3 
Plugin Lombok
```
<div id="installation"></div>

### 🚀 Instalação OS X & Linux:

**Java 11 - SDKMAN:**

```sh
https://sdkman.io/install
sdk i java 11.0.2-open
```

**Lombok plugin:**

```sh
Intellij: https://projectlombok.org/setup/intellij
Eclipse : https://projectlombok.org/setup/eclipse
```

**Executar o projeto com configuração local:**

```sh
sdk use java 11.0.2-open
./mvnw clean spring-boot:run -Dspring-boot.run.profiles=local
```
O projeto por padrão vai rodar em http://localhost:5000.
Necessário configuração das varíaveis de ambiente locais manualmente, porém o projeto já possui variaveis default para rodar em ambiente local.
Setar a varíavel "ENV=hml" para apontar para ambiente stage.

<div id="tests"></div>

### &#9989; Testes de integração e unitários

Rodando todos os testes:
```shell 
mvn clean test
```

Rodando testes rapidos:
```shell 
mvn test -Dgroups="Fast" -Djacoco.skip=true
```
Rodando testes lentos:
```shell 
mvn test -Dgroups="Slow" -Djacoco.skip=true
```

**Executar o coverage report:**

```sh
sdk use java 11.0.2-open
./mvnw clean install jacoco:report
```
ou

```sh
sdk use java 11.0.2-open
./mvnw clean verify
```


<div id="deploy"></div>

### Deploy
Por padrão o deploy da aplicação é feito via CI/CD do Gitlab e enviado ao Argocd
   
    mvn compile jib:build
