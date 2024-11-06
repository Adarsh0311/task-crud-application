# Task Management Application (Backend)

This repository contains the backend code for a Task Management application, built with Spring Boot and PostgreSQL. The application supports managing tasks with file attachments, filtering tasks based on specific criteria, and other CRUD operations.

## Features

- **Task Management**: Create, read, update, and delete tasks.
- **File Attachments**: Upload and associate files with tasks.
- **Filtering**: Use multiple filters, such as task status and priority, using Spring Data JPA Specifications.
- **PostgreSQL Database**: Utilizes PostgreSQL for data persistence.

## Tech Stack

- **Java**: The application is developed using Java.
- **Spring Boot**: For building REST APIs and managing dependencies.
- **Spring Data JPA**: For database interactions.
- **PostgreSQL**: As the relational database management system.
- **Spring Specifications**: For implementing flexible and dynamic filtering.

## Project Structure

- **Entities**:
    - `Task`: Represents a task with basic attributes like title, description, status, and priority.
    - `TaskFile`: Represents files associated with tasks.
- **Controllers**: REST endpoints to interact with tasks and their associated files.
- **Services**: Business logic for handling task and file operations.
- **Repositories**: Data access layer using Spring Data JPA.
- **Specifications**: Filtering functionality for tasks.
- **exception**: for handling custom exception with http responses.

## Getting Started

### Prerequisites

- Java 17 or higher
- PostgreSQL
- Maven


### Setup Instructions

1. **Clone the repository**:

   ```bash
   git clone <url>
   cd task-management-application


2. **Configure Database**: Update application.properties with your PostgreSQL database credentials.   

### Future Enhancements
- Integration with the frontend part of the application.
- Additional filtering options.
- User authentication and authorization

### Contributing
Feel free to submit issues and pull requests. Contributions are welcome!
