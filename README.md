# Sistema de Venda de Ingressos

API REST desenvolvida com Spring Boot para simular o fluxo de venda de ingressos, desde o cadastro de usuários e eventos até a realização de compras e geração de ingressos.

> 🚧 Projeto em desenvolvimento.

## Tecnologias

- Java 17
- Spring Boot 3.2.5
- Spring Data JPA / Hibernate
- MySQL
- Maven

## Ferramentas

- IntelliJ IDEA
- Postman
- Git
- GitHub

## Funcionalidades atuais

Atualmente, a API possui o CRUD de usuários:

- Cadastro de usuários
- Listagem de usuários
- Busca de usuário por ID
- Atualização de usuário
- Exclusão de usuário
- Tratamento centralizado de exceções
- Retorno de códigos HTTP adequados para cada operação

## Arquitetura

O projeto utiliza uma arquitetura em camadas:

```text
Cliente → Controller → Service → Repository → MySQL
```

### Controller

Responsável por receber as requisições HTTP, chamar os serviços necessários e construir as respostas da API.

Não contém regras de negócio.

### Service

Responsável pelas regras de negócio, validações e comunicação com a camada Repository.

### Repository

Responsável pelo acesso e persistência dos dados no banco através do Spring Data JPA.

### Entity

Representa os objetos do domínio da aplicação e realiza o mapeamento desses dados para as tabelas do banco de dados.

### Exception / GlobalExceptionHandler

As exceções representam erros específicos da aplicação, como `UsuarioNaoEncontradoException`.

O `GlobalExceptionHandler` captura essas exceções e as converte em respostas HTTP apropriadas, como `404 Not Found`.

## Como executar o projeto

### Pré-requisitos

Antes de executar a aplicação, é necessário possuir:

- JDK 17
- MySQL
- Maven

O Postman pode ser utilizado para testar os endpoints da API.

### 1. Criar o banco de dados

Crie um banco MySQL chamado:

```sql
CREATE DATABASE sistema_ingressos;
```

### 2. Configurar as credenciais do banco

O projeto utiliza variáveis de ambiente para armazenar as credenciais do MySQL:

```text
DB_USERNAME
DB_PASSWORD
```

Caso prefira, também é possível configurar as credenciais diretamente no `application.properties`, desde que dados sensíveis não sejam enviados ao repositório.

### 3. Executar a aplicação

Na raiz do projeto, execute:

```bash
mvn spring-boot:run
```

Quando a aplicação iniciar corretamente, a API estará disponível em:

```text
http://localhost:8080
```

Os endpoints podem ser testados utilizando o Postman ou outro cliente HTTP.

## Endpoints atuais

### Usuários

| Método | Endpoint | Descrição | Status de sucesso |
|---|---|---|---|
| POST | `/usuarios` | Cadastra um novo usuário | `201 Created` |
| GET | `/usuarios` | Lista todos os usuários | `200 OK` |
| GET | `/usuarios/{id}` | Busca um usuário pelo ID | `200 OK` |
| PUT | `/usuarios/{id}` | Atualiza um usuário | `200 OK` |
| DELETE | `/usuarios/{id}` | Exclui um usuário | `204 No Content` |

Ao buscar, atualizar ou excluir um usuário inexistente, a API retorna:

```text
404 Not Found
```

## Status do projeto

🚧 Sistema em desenvolvimento.

Atualmente, o CRUD de usuários está implementado e testado.

## Próximas etapas

- Implementar os CRUDs das entidades:
  - Evento
  - Compra
  - Ingresso
- Implementar DTOs
- Desenvolver as regras de negócio do fluxo de compra
- Implementar a geração de ingressos
- Implementar segurança e autenticação com Spring Security e JWT
- Realizar o deploy da aplicação
