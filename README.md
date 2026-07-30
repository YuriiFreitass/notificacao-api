# Notificação API

API REST desenvolvida com **Java 21** e **Spring Boot** para demonstrar a utilização de mensageria assíncrona com **RabbitMQ**.

Ao cadastrar um usuário, a aplicação publica um evento no RabbitMQ. Em seguida, um consumidor processa esse evento e registra uma notificação no banco de dados.

---

## Tecnologias

- Java 21
- Spring Boot 4
- Spring Web MVC
- Spring Data JPA
- Hibernate
- RabbitMQ
- MySQL
- Docker
- Bean Validation
- SpringDoc OpenAPI (Swagger)
- MapStruct
- Lombok
- Maven

---

## Arquitetura

A aplicação segue a arquitetura em camadas:

```
Controller
      │
      ▼
Service
      │
      ▼
Repository
      │
      ▼
MySQL
```

Fluxo da mensageria:

```
Cliente
   │
POST /v1/usuarios
   │
   ▼
UsuarioController
   │
   ▼
UsuarioService
   │
   ▼
RabbitMQ Producer
   │
   ▼
Exchange
   │
   ▼
Queue
   │
   ▼
RabbitMQ Consumer
   │
   ▼
NotificacaoService
   │
   ▼
Tabela notificacoes
```

---

## Funcionalidades

### Usuários

- Cadastro de usuários
- Listagem paginada
- Busca por ID
- Atualização
- Exclusão

### Mensageria

- Publicação de eventos utilizando RabbitMQ
- Consumo automático das mensagens
- Persistência das notificações

### Validações

- Bean Validation
- Validação de e-mail
- Tratamento de e-mail duplicado
- Tratamento de usuário não encontrado
- Tratamento global de exceções

---

## Endpoints

| Método | Endpoint | Descrição |
|---------|----------|-----------|
| POST | `/v1/usuarios` | Cadastra um usuário |
| GET | `/v1/usuarios` | Lista usuários |
| GET | `/v1/usuarios/{id}` | Busca usuário por ID |
| PUT | `/v1/usuarios/{id}` | Atualiza usuário |
| DELETE | `/v1/usuarios/{id}` | Remove usuário |

---

## Documentação

Após iniciar a aplicação:

```
http://localhost:8080/swagger-ui/index.html
```

---

## Como executar

### Clonar o projeto

```bash
git clone https://github.com/YuriiFreitass/notificacao-api
```

### Entrar na pasta

```bash
cd notificacao-api
```

### Subir RabbitMQ e MySQL

```bash
docker compose up -d
```

### Executar a aplicação

```bash
./mvnw spring-boot:run
```

---

## Fluxo da aplicação

1. O cliente realiza um cadastro de usuário.
2. O usuário é salvo no banco de dados.
3. Um evento é publicado no RabbitMQ.
4. O consumidor recebe o evento.
5. Uma notificação é criada automaticamente.
6. A notificação é persistida no banco.

---

## Conceitos aplicados

- API REST
- Arquitetura em camadas
- DTOs
- MapStruct
- Bean Validation
- Tratamento global de exceções
- Mensageria assíncrona
- RabbitMQ
- JPA/Hibernate
- Docker
- Paginação
- Clean Code

---

## Autor

**Yuri Freitas**

Desenvolvedor Java Backend
