# demo-spring-1

Simple Spring Boot demo app: a minimal CRUD service managing Account entities.

## Table of contents

- [Project structure](#project-structure)
- [Requirements](#requirements)
- [Configuration](#configuration)
- [Build & run](#build--run)
- [API reference](#api-reference)
- [Database setup](#database-setup)
- [Testing](#testing)
- [Notes](#notes)
- [References](#references)

## Project structure

Top-level layout (important files):

```markdown
# demo-spring-1

Simple Spring Boot demo app: a minimal CRUD service managing Account entities.

## Table of contents

- [Project structure](#project-structure)
- [Requirements](#requirements)
- [Configuration](#configuration)
- [Build & run](#build--run)
- [API reference](#api-reference)
- [Database setup](#database-setup)
- [Testing](#testing)
- [Notes](#notes)
- [References](#references)

## Project structure

Top-level layout (important files):
```

- `src/`: source files
  - `main/`: main source set
    - `java/`: Java source files
    - `resources/`: non-Java resources
  - `test/`: test source set
    - `java/`: Java test files
    - `resources/`: non-Java test resources
- `pom.xml`: Maven configuration file

## Requirements

- Java 11 or later
- Maven 3.6 or later

## Configuration

Adjust configuration in `src/main/resources/application.properties`:

- `server.port`: server port (default: 8080)
- `spring.datasource.*`: datasource settings
- `spring.jpa.*`: JPA/Hibernate settings

## Build & run

Build and run (wrapper included):

```sh
./mvnw clean package
./mvnw spring-boot:run
```

## API reference

REST API for Account entities:

- `GET /api/accounts`: list all accounts
- `GET /api/accounts/{id}`: get account by ID
- `POST /api/accounts`: create new account
- `PUT /api/accounts/{id}`: update account by ID
- `DELETE /api/accounts/{id}`: delete account by ID

## Database setup

- Embedded H2 database (default)
- Configure datasource in `application.properties`
- Database initialization scripts: `src/main/resources/data.sql`

## Testing

- Unit tests: `src/test/java`
- Integration tests: `src/test/java`
- Run tests with: `./mvnw test`

## Notes

- Demo application, not for production use
- Sample data included for testing

## References

- Spring Boot documentation: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
- Spring Data JPA documentation: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
- H2 database documentation: https://www.h2database.com/html/main.html
