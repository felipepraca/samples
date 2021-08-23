# Exemplo de CRUD (Create, Read, Update, Delete)

Para rodar o projeto vc precise do Docker instalado.

1. Na pasta raiz do projeto `sample-crud` rode o comando ```mvn clean package``` ele ira criar o `.jar` do projeto na pasta `target`
2. Na raiz do projeto `samples` rode o comando ```docker-compose up sample-crud```

Endpoints:

#### Criar novo tweet:
```shell
curl --location --request POST 'http://localhost:8070/tweet' \
--header 'Content-Type: application/json' \
--data-raw '{
    "text": "Oi",
    "sender": "Felipe",
    "date": "2021-08-20T13:28:40"
}'
```

#### Atualizar tweet 1:
```shell
curl --location --request PUT 'http://localhost:8070/tweet/1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "text": "Oi",
    "sender": "Andre",
    "date": "2021-08-20T13:28:40"
}'
```

#### Consultar todos os tweets:
```shell
curl --location --request GET 'http://localhost:8070/tweet' \
--header 'Content-Type: application/json'
```

#### Consultar um tweet:
```shell
curl --location --request GET 'http://localhost:8070/tweet/1' \
--header 'Content-Type: application/json'
```

#### Apagar um tweet:
```shell
curl --location --request DELETE 'http://localhost:8080/tweet/1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "text": "Oi",
    "sender": "Andre",
    "date": "2021-08-20T13:28:40"
}'
```
