# API Challenge: CRUD de Alunos

API REST para gerenciar alunos, com nome, notas dos dois semestres, professor e sala. Fiz esse projeto em 2024 como desafio para seleção de um bootcamp. O objetivo era colocar em prática a estrutura em camadas (Controller → Service → Repository), a persistência com JPA.

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-6DB33F?logo=springboot&logoColor=white)
![H2](https://img.shields.io/badge/H2-in--memory-1F6FEB)
![Docker](https://img.shields.io/badge/Docker-ready-2496ED?logo=docker&logoColor=white)
![License](https://img.shields.io/badge/license-MIT-blue)

## Tecnologias

- **Java 17**
- **Spring Boot 3.2**: Web, Data JPA, Data REST, DevTools
- **H2 Database** (banco em memória)
- **Lombok**
- **springdoc-openapi** (Swagger UI)
- **Maven** (com Maven Wrapper)
- **Docker / Docker Compose**

## Estrutura

```
src/main/java/com/example/demo
├── controller/   # AlunoController: endpoints REST
├── service/      # AlunoService: regras de negócio
├── respository/  # AlunoRespository: acesso a dados (JpaRepository)
└── entity/       # Aluno: entidade JPA
```

## Modelo `Aluno`

| Campo                  | Tipo     |
|------------------------|----------|
| `id`                   | `long`   |
| `nome`                 | `String` |
| `notaPrimeiroSemestre` | `double` |
| `notaSegundoSemestre`  | `double` |
| `professor`            | `String` |
| `numSala`              | `int`    |

## Endpoints

Base: `http://localhost:8080/api/alunos`

| Método   | Rota    | Descrição                  |
|----------|---------|----------------------------|
| `GET`    | `/`     | Lista todos os alunos      |
| `GET`    | `/{id}` | Busca um aluno pelo id     |
| `POST`   | `/`     | Cadastra um novo aluno     |
| `PUT`    | `/{id}` | Atualiza um aluno existente |
| `DELETE` | `/{id}` | Remove um aluno            |

Exemplo de requisição:

```bash
curl -X POST http://localhost:8080/api/alunos \
  -H "Content-Type: application/json" \
  -d '{
        "nome": "Maria Silva",
        "notaPrimeiroSemestre": 8.5,
        "notaSegundoSemestre": 9.0,
        "professor": "João",
        "numSala": 12
      }'
```

A documentação interativa fica em **http://localhost:8080/swagger-ui.html**.

## Como rodar

### Com Maven

Pré-requisito: JDK 17+.

```bash
./mvnw spring-boot:run
```

### Com Docker

```bash
docker compose up --build
```

A aplicação sobe em `http://localhost:8080`.

O banco é H2 em memória, então os dados se perdem quando a aplicação reinicia.

## Licença

Distribuído sob a licença MIT. Veja [LICENSE](LICENSE).
