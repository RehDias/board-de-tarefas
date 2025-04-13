# Task Board App
Sistema de gerenciamento de tarefas em formato de board, com funcionalidades para organização de cards por colunas, ideal para controle de atividades em projetos.

## Tecnologias Utilizadas
Back-end
Java

- Spring Boot
- Spring Data JPA
- MySQL
- Lombok

## Sobre o Projeto
Este projeto foi desenvolvido como parte dos estudos na plataforma Digital Innovation One (DIO), com foco em práticas de modelagem de dados relacionais, uso de JPA com o MySQL e estruturação de um sistema de gerenciamento de tarefas similar a ferramentas como Trello.

## Funcionalidades
- Criação de tarefas (cards)

- Organização de tarefas por colunas (como "A Fazer", "Fazendo", "Concluído")

- Atualização de status e movimentação entre colunas

- Relatórios de tempo entre movimentações e bloqueios

- Relacionamento entre boards, tarefas e status

## Como Executar o Projeto
### Pré-requisitos
- Java 17

- Maven

- MySQL

### Passos para executar:
1. Clone o repositório:

```bash
git clone <url-do-repositório>
```

2. Configure seu banco de dados MySQL no arquivo application.properties:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/task_board_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
3. Execute o projeto com:

```bash
./mvnw spring-boot:run
```
4. Utilize a coleção do Postman disponível na raiz do projeto para testar as rotas da API.
