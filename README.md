# BookManagement

A full-stack personal book management application built with Spring Boot and React.
Track your personal book collection, mark books as read, and automatically fetch book details via ISBN lookup using the OpenLibrary API.

![Java CI](https://github.com/IchBinJannick/BookManagment/actions/workflows/ci.yml/badge.svg)
![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)

---

## Features

- Add, edit, and delete books from your personal collection
- Mark books as read or unread
- Filter books by read status
- Automatic book data lookup via ISBN (OpenLibrary API)
- REST API with full CRUD operations
- Automated CI pipeline with tests on every push

---

## Tech Stack

**Backend**
- Java 21
- Spring Boot 3.3
- Spring Data JPA / Hibernate
- PostgreSQL 16
- Lombok
- Maven

**Frontend** *(in progress)*
- React
- Vite

**Infrastructure**
- Docker & Docker Compose
- GitHub Actions (CI)

---

## Getting Started

### Prerequisites

- Java 21
- Docker Desktop
- Maven

### 1. Clone the repository

```bash
git clone https://github.com/IchBinJannick/BookManagment.git
cd BookManagment
```

### 2. Start the database

```bash
cd backend
docker compose up -d
```

### 3. Run the application

```bash
./mvnw spring-boot:run
```

The API is now running at `http://localhost:8080`.

---

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/books` | Get all books |
| GET | `/api/books/{id}` | Get a single book |
| GET | `/api/books/unread` | Get all unread books |
| POST | `/api/books` | Add a new book |
| PUT | `/api/books/{id}` | Update a book |
| DELETE | `/api/books/{id}` | Delete a book |

### Example request

```json
POST /api/books
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "978-0132350884",
  "releaseYear": 2008,
  "read": false
}
```

---

## Running Tests

```bash
cd backend
./mvnw test
```

Tests run automatically on every push to `main` via GitHub Actions.

---

## Project Structure

```
BookManagment/
  backend/               # Spring Boot REST API
    src/
      main/java/
        controller/      # REST endpoints
        service/         # Business logic
        repository/      # Database access
        model/           # JPA entities
      test/              # JUnit & Mockito tests
    docker-compose.yml
    pom.xml
  frontend/              # React app (in progress)
```

---

## Roadmap

- [x] REST API with CRUD operations
- [x] PostgreSQL database
- [x] Automated tests with JUnit & Mockito
- [x] GitHub Actions CI pipeline
- [ ] ISBN lookup via OpenLibrary API
- [ ] React frontend
- [ ] Docker Compose for full stack
- [ ] Homeserver deployment

---

## License

MIT
