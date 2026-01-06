# API T-Do

API REST simples para gerenciamento de tarefas.

## Tecnologias

- Java 17
- Spring Boot
- PostgreSQL
- JPA / Hibernate

## Funcionalidades
- Criar tarefa
- Listar Tarefas
- Marcar tarefa como concluída
- Filtrar por status

## Endpoints
- POST /tarefas
- GET /tarefas
- GET /tarefas?concluida=true
- PATCH /tarefas/{id}/concluir
