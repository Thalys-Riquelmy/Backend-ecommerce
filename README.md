# E-commerce Backend

Este é um projeto de backend para um sistema de e-commerce desenvolvido em Java utilizando o framework Spring Boot. O sistema gerencia entidades como `Usuario`, `Produto`, `Carrinho`, `Pedido`, `Endereco`, entre outras, oferecendo operações de CRUD através de uma API RESTful.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Lombok
- Maven

## Configuração do Projeto

### Pré-requisitos

- Java 17
- Maven
- PostgreSQL

### Configuração do Banco de Dados

Certifique-se de ter o PostgreSQL instalado e rodando em sua máquina. Crie um banco de dados chamado `Banco_funcional`.

### Configuração da Aplicação

No arquivo `application.properties`, configure as propriedades do banco de dados:

```properties
spring.application.name=ecommerce-backend
spring.datasource.url=jdbc:postgresql://localhost:5432/Banco_funcional
spring.datasource.username=postgres
spring.datasource.password=ATrick24
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update

### Estrutura do Projeto

model: Contém as classes de entidade JPA.
repository: Contém as interfaces de repositório Spring Data JPA.
service: Contém as classes de serviço que encapsulam a lógica de negócio.
controller: Contém os controladores REST que expõem as APIs para o cliente.

### Endpoints da API

•	UsuarioController
GET /api/usuarios: Lista todos os usuários.
GET /api/usuarios/{id}: Obtém um usuário pelo ID.
POST /api/usuarios: Cria um novo usuário.
PUT /api/usuarios/{id}: Atualiza um usuário existente.
DELETE /api/usuarios/{id}: Deleta um usuário pelo ID.

•	ProdutoController
GET /api/produtos: Lista todos os produtos.
GET /api/produtos/{id}: Obtém um produto pelo ID.
POST /api/produtos: Cria um novo produto.
PUT /api/produtos/{id}: Atualiza um produto existente.
DELETE /api/produtos/{id}: Deleta um produto pelo ID.

•	CarrinhoController
GET /api/carrinhos: Lista todos os carrinhos.
GET /api/carrinhos/{id}: Obtém um carrinho pelo ID.
POST /api/carrinhos: Cria um novo carrinho.
PUT /api/carrinhos/{id}: Atualiza um carrinho existente.
DELETE /api/carrinhos/{id}: Deleta um carrinho pelo ID.

•	EnderecoController
GET /api/enderecos: Lista todos os endereços.
GET /api/enderecos/{id}: Obtém um endereço pelo ID.
POST /api/enderecos: Cria um novo endereço.
PUT /api/enderecos/{id}: Atualiza um endereço existente.
DELETE /api/enderecos/{id}: Deleta um endereço pelo ID.

•	PedidoController
GET /api/pedidos: Lista todos os pedidos.
GET /api/pedidos/{id}: Obtém um pedido pelo ID.
POST /api/pedidos: Cria um novo pedido.
PUT /api/pedidos/{id}: Atualiza um pedido existente.
DELETE /api/pedidos/{id}: Deleta um pedido pelo ID.

•	PagamentoController
GET /api/pagamentos: Lista todos os pagamentos.
GET /api/pagamentos/{id}: Obtém um pagamento pelo ID.
POST /api/pagamentos: Cria um novo pagamento.
PUT /api/pagamentos/{id}: Atualiza um pagamento existente.
DELETE /api/pagamentos/{id}: Deleta um pagamento pelo ID.

•	ItemPedidoController
GET /api/itempedidos: Lista todos os itens de pedido.
GET /api/itempedidos/{id}: Obtém um item de pedido pelo ID.
POST /api/itempedidos: Cria um novo item de pedido.
PUT /api/itempedidos/{id}: Atualiza um item de pedido existente.
DELETE /api/itempedidos/{id}: Deleta um item de pedido pelo ID.

•	ItemCarrinhoController
GET /api/itemcarrinhos: Lista todos os itens de carrinho.
GET /api/itemcarrinhos/{id}: Obtém um item de carrinho pelo ID.
POST /api/itemcarrinhos: Cria um novo item de carrinho.
PUT /api/itemcarrinhos/{id}: Atualiza um item de carrinho existente.
DELETE /api/itemcarrinhos/{id}: Deleta um item de carrinho pelo ID.
