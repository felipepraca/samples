# Sample Endpoint using maven

1. Download [maven](https://maven.apache.org/download.cgi)
2. Install [maven](https://maven.apache.org/install.html)
3. Na raiz do projeto rode o comando ``` ./mvnw spring-boot:run```
4. Em outro terminal rode o comando ```curl -i -XGET "http://localhost:8080/healthCheck"``` a resposta é aleatória, então vc poderá ver os resultados ```HTTP/1.1 200``` e ```HTTP/1.1 500 ```
