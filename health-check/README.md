# Health Check

Health Check é um endpoint que existe em quase todas as API que informa a saúde do sistema. Basícamente ele retorna um status code de sucesso se a API está no ar e funcionando corretamente, ou um status code de erro se algo estiver errado. Este endpoint é muito utilizado para ciclo de deploy continuo, pois ele garante que a nova versão da API esta funcionando corretamente antes de subir para produção de fato.

## Exercício:
1. Criar novo projeto nessa pastas, na sua linguagem e framework de preferência.
2. Esse projeto deve ter um endpoint GET na path `/healthCheck`
3. O endpoint deve retornar o status code da seguinte forma:
3.1 `200` `OK` quando o minuto for par e retorno 
3.2 `500` `Internal Server Error` quando o minuto for impar
4. O endpoint deve ter testes unitários para os dois senários
5. Esse README deve ser atualizado com as informações de como rodar e testar o projeto (comandos e dicas)

