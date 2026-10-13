# Bank Accounts Microservice (Spring Boot)

BAYI Mostapha - BDCC3

A microservice for managing bank accounts and customers, built with **Spring Boot**. It exposes the same business layer through three APIs: a classic **REST** web service (documented with **Swagger**), **Spring Data REST** (with projections), and **GraphQL**.

This project follows the approach shown in these videos:
- Bank accounts microservice: https://www.youtube.com/watch?v=2-qIoZcvhAw
- GraphQL integration: https://www.youtube.com/watch?v=FsdR09jlqaE

---

## Table of Contents

1. [Technologies](#technologies)
2. [Project Architecture](#project-architecture)
3. [Work Done](#work-done)
    - [1. Project setup](#1-project-setup)
    - [2. JPA entities](#2-jpa-entities)
    - [3. Repository layer and DAO tests](#3-repository-layer-and-dao-tests)
    - [4. RESTful web service](#4-restful-web-service)
    - [5. Swagger documentation](#5-swagger-documentation)
    - [6. Spring Data REST and projections](#6-spring-data-rest-and-projections)
    - [7. DTOs and mappers](#7-dtos-and-mappers)
    - [8. Service layer](#8-service-layer)
    - [9. Exception handling](#9-exception-handling)
    - [10. GraphQL web service](#10-graphql-web-service)
4. [Author](#author)

## Technologies

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (in-memory)
- Lombok
- Springdoc OpenAPI / Swagger UI
- Spring Data REST
- Spring for GraphQL
- Postman (REST client for testing)

## Project Architecture

![Project architecture](images/img_11.png)

Useful URLs (default port `8081`):

| Tool       | URL                                    |
|------------|----------------------------------------|
| REST API   | http://localhost:8081/api/bankAccounts |
| Swagger UI | http://localhost:8081/swagger-ui.html  |
| H2 Console | http://localhost:8081/h2-console       |
| GraphiQL   | http://localhost:8081/graphiql         |

## Work Done

### 1. Project setup

Created a Spring Boot project with the following dependencies: **Web, Spring Data JPA, H2, Lombok**.

### 2. JPA entities

Created the JPA entity `BankAccount`, then the `Customer` entity linked to accounts.

![JPA entities](images/img_12.png)

### 3. Repository layer and DAO tests

Created the `BankAccountRepository` and `CustomerRepository` interfaces based on Spring Data JPA, and tested the DAO layer.

![Repository tests](images/img_13.png)

### 4. RESTful web service

Created the REST controller that manages accounts (list, find by id, create, update, delete) and tested it.

![REST controller](images/img_1.png)

### 5. Swagger documentation

Generated and tested the Swagger documentation of the REST API.

![Swagger UI](images/img_2.png)

### 6. Spring Data REST and projections

Exposed a RESTful API with Spring Data REST, using projections to control which fields are returned.

![Spring Data REST](images/img_14.png)

### 7. DTOs and mappers

Created the DTOs and the mappers that convert between entities and DTOs, so entities are never exposed directly by the API.

![DTOs and mappers](images/img_15.png)

### 8. Service layer

Created the business service layer of the microservice, used by both the REST and GraphQL controllers.

![Service layer](images/img_16.png)

### 9. Exception handling

Added a global exception handler to return clear error responses.

![Exception handling](images/img_17.png)

![Exception handler](images/img_6.png)

### 10. GraphQL web service

Integrated GraphQL into the microservice: schema definition, queries, and mutations.

![GraphQL integration](images/img_3.png)

**Accounts list**

![GraphQL accounts list](images/img_4.png)

**Mutation**

![GraphQL mutation](images/img_7.png)

**Find account by id**

![GraphQL find account by id](images/img_5.png)

**Delete account**

![GraphQL delete account](images/img_8.png)

**Customers**

![GraphQL customers](images/img_9.png)