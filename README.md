# CryptoApp

CryptoApp é uma API básica, mas funcional, para gerenciamento de criptomoedas. Desenvolvida com o framework Spring Boot versão 3.0.5, a aplicação utiliza o Java 17 e fornece um conjunto de recursos para manipular informações sobre diferentes criptomoedas.

## Características

- Conexão com banco de dados MySQL.
- Persistência de dados com JPA.

## Dependências

- Spring Boot Starter Web
- Spring Boot Starter JDBC
- Spring Boot Starter Data JPA
- MySQL Connector Java

## Como executar

1. Clone o repositório
2. Navegue até o diretório do projeto
3. Execute o comando `mvn spring-boot:run`
4. Acesse a API através do `http://localhost:8080`

## Contribuição

Fique à vontade para contribuir com o projeto, abrindo issues ou enviando pull requests.

## Rotas disponíveis

Aqui estão as rotas disponíveis na API CryptoApp:

### Coin

1. **Listar Coins**
   - Método: GET
   - URL: `localhost:8080/coin`
   
2. **Adicionar Coin**
   - Método: POST
   - URL: `localhost:8080/coin`
   - Corpo da requisição (JSON): 
     ```json
     {
       "name": "DOLAR",
       "price": "5.5555",
       "quantity": "15"
     }
     ```

3. **Obter Coin por Tipo**
   - Método: GET
   - URL: `localhost:8080/coin/BITCOIN`

4. **Atualizar Coin por ID**
   - Método: PUT
   - URL: `localhost:8080/coin`
   - Corpo da requisição (JSON):
     ```json
     {
       "id": 10,
       "name": "BITCOIN",
       "price": 5.50,
       "quantity": 5
     }
     ```

5. **Deletar Coin por ID**
   - Método: DELETE
   - URL: `localhost:8080/coin/12`
   - Corpo da requisição (JSON):
     ```json
     {
       "name": "Bitcoin",
       "price": "5.5555",
       "quantity": "15"
     }
     ```
