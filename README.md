# WhatsApp Clone

A feature-rich clone of WhatsApp built using modern backend technologies, integrating secure authentication and real-time messaging.

## Key Features
- **OAuth 2.0 Authentication**: Secure user authentication via Keycloak as the authorization server using JWT.
- **Real-time Messaging**: Seamless communication between users implemented with Spring WebSocket.
- **PostgreSQL Database**: Structured data storage using Hibernate JPA for ORM and PostgreSQL.
- **File Uploads**: Supports media uploads up to 50MB, with configurable output paths for storing files.
- **Spring Boot Microservices**: Modular and scalable architecture powered by Spring Boot.


## Tech Stack
- **Backend**: Spring Boot (JPA, WebSocket, Spring Security)
- **Database**: PostgreSQL
- **Authentication**: Keycloak (OAuth 2.0, JWT)
- **Server**: Dockerized containers for PostgreSQL and Keycloak.

## Infrastructure
- **Docker-Compose Setup**:
  - PostgreSQL database container with persistent volumes.
  - Keycloak for authentication, running in development mode.
- **Bridge Network**: Services communicate within the `whatsapp-clone` Docker network.

## Configuration
- **Application Port**: `8081`
- **Keycloak Port**: `9090`
- **Database Port**: `5432`

This project serves as an ideal foundation for building real-time, secure messaging applications. 🚀
