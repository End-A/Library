# Library
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
# 📚 Library Management System (Java CRUD)

This is a robust Library Management System developed in Java, designed to handle fundamental CRUD (Create, Read, Update, Delete) operations for a book collection.

The project was built with a strong focus on clean architecture and software engineering principles, ensuring code maintainability and scalability through a layered design.

## 🚀 Key Features

* **Create:** Register new books into the system.
* **Read:** Retrieve and list all registered books.
* **Update:** Edit details of existing book records.
* **Delete:** Remove books from the database.

## 🛠️ Tech Stack & Architecture

* **Language:** Java (JDK 23)
* **Database:** PostgreSQL
* **JDBC Driver:** PostgreSQL JDBC Driver (v42.7.1 or compatible)

### Project Structure

The application follows a tiered architecture to ensure clear separation of concerns:

* `ui`: User Interface layer, handling user interactions.
* `service`: Business Logic layer, where the core rules reside.
* `persistence`: Data Access layer, responsible for database communication.

**Design Pattern:** The project utilizes **Interfaces** to define contracts for the Service and Persistence layers. The actual logic is encapsulated within **`.impl`** (Implementation) packages, promoting low coupling and high cohesion.

## 📋 Prerequisites

To run this project locally, you will need:

* **Java Development Kit (JDK):** Version 23 or higher.
* **PostgreSQL:** A running instance of PostgreSQL server.
* **IDE:** Any Java IDE (IntelliJ IDEA, Eclipse, VS Code, etc.).

## ⚙️ Database Configuration (Action Required)

Before running the application, you must configure your database credentials.

1.  Create a PostgreSQL database (e.g., `library_db`).
2.  Navigate to the **`BancoDeDados.java`** file (located in the persistence or infrastructure layer).
3.  Update the following fields with your local environment settings:

```java'''
// Locate these lines in BancoDeDados.java
String url = "jdbc:postgresql://localhost:5432/TrabalhoPOO";
Connection con = DriverManager.getConnection(url, "postgres", "12345");

---
Developed by [End-A](https://github.com/End-A)