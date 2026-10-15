# 🎓 API para gerenciamento de cadastros

Uma API RESTful desenvolvida em **Java** e **Spring Boot** para gerenciamento de cadastros utilizando alunos como referência. O projeto implementa operações CRUD completas, separação estrita por camadas com DTOs, mapeamento com **MapStruct**, atualizações parciais com **PATCH**, containerização com **Docker** e tratamento global de exceções.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17+** / **Spring Boot 3**
- **Spring Data JPA** (Persistência de Dados)
- **Spring Validation** (Validação de Payloads)
- **MapStruct** (Mapeamento de alta performance entre Entidades e DTOs)
- **PostgreSQL** (Banco de Dados Relacional)
- **Docker** & **Docker Compose** (Containerização do ambiente)
- **Lombok** (Produtividade e redução de código boilerplate)
- **Maven** (Gerenciador de dependências)

---

## 🚀 Arquitetura e Destaques Técnicos

- **Padrão DTO Granular:** Uso de DTOs especializados para cada operação (`AlunoRequestDTO`, `AlunoPatchRequestDTO` e `AlunoResponseDTO`) para garantir a segurança da camada de domínio.
- **PATCH Parcial com MapStruct:** Utilização de `@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)` acoplado à injeção via `@MappingTarget` para realizar atualizações parciais sem sobrescrever dados existentes com `null`.
- **Tratamento Global de Exceções:** Captura centralizada de erros com `@RestControllerAdvice` e transformação em contratos JSON padronizados (`StandardError` e `ValidationError`), garantindo retornos HTTP adequados (ex: `404 Not Found`, `400 Bad Request`).
- **Gerenciamento de Memória Eficiente:** Métodos de atualização operam via alteração em memória por referência (`void`), evitando alocações desnecessárias.

---

## 📌 Endpoints da API

| Método | Rota | Descrição | Status Sucesso |
| :--- | :--- | :--- | :--- |
| `POST` | `/alunos` | Cadastra um novo aluno | `201 Created` |
| `GET` | `/alunos` | Lista todos os alunos cadastrados | `200 OK` |
| `GET` | `/alunos/{id}` | Busca um aluno específico pelo ID | `200 OK` |
| `PUT` | `/alunos/{id}` | Atualização completa dos dados do aluno | `200 OK` |
| `PATCH` | `/alunos/{id}` | Atualização parcial (ex: alterar apenas e-mail) | `200 OK` |
| `DELETE` | `/alunos/{id}` | Remove um aluno da base de dados | `204 No Content` |

---

## ⚙️ Como Executar o Projeto

### Pré-requisitos
- **JDK 17** ou superior instalado
- **Docker** e **Docker Compose** instalados
- **Git**

### Passo a Passo

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/SEU-USUARIO/NOME-DO-REPOSITORIO.git
   cd NOME-DO-REPOSITORIO
   ```

2. **Suba o banco de dados PostgreSQL via Docker Compose:**
   ```bash
   docker compose up -d
   ```

3. **Execute a aplicação Spring Boot:**
   ```bash
   ./mvnw spring-boot:run
   ```

A API estará acessível em `http://localhost:8080`.

---

## 📋 Exemplo de Payload (PATCH /alunos/{id})

Para realizar uma atualização parcial alterando apenas o e-mail, envie:

```json
{
  "email": "novo.email@dominio.com"
}
```

Os demais campos (`name`, `cpf`) serão preservados na base de dados com seus valores originais.
