# Library 📚

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

> **Idiomas / Languages:** > 🇧🇷 [Português](#versão-em-português) | 🇺🇸 [English](#english-version)

---

## Versão em Português

Um sistema de gerenciamento de biblioteca (CRUD) desenvolvido em Java com persistência em banco de dados PostgreSQL. Este projeto foi construído focando em uma arquitetura limpa e bem definida.

### 🛠️ Arquitetura e Organização
O projeto está dividido em camadas para garantir a separação de responsabilidades:
* **UI (User Interface):** Camada de interação com o usuário.
* **Service:** Contém toda a lógica de negócio da aplicação.
* **Persistence (Persistência):** Responsável pela comunicação com o banco de dados.

**Diferencial Técnico:** O sistema utiliza o padrão de **Interfaces e Implementações (`.impl`)**. As interfaces definem os contratos, enquanto as classes de implementação contêm a lógica real, facilitando a manutenção e futuras expansões.

### 📋 Pré-requisitos
* **JDK 23** ou superior.
* **PostgreSQL** (versão 42.7.1 ou compatível).
* Uma IDE Java (IntelliJ, Eclipse, VS Code).

### 🚀 Como Começar
1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/End-A/Library.git](https://github.com/End-A/Library.git)
    ```
2.  **Configuração do Banco:**
    * Abra o arquivo `BancoDeDados.java`.
    * Edite as variáveis `host`, `user`, `password` e o nome do `database` conforme as configurações do seu servidor local.
3.  **Execução:**
    * Certifique-se de que o driver JDBC do PostgreSQL está configurado.
    * Execute a classe principal através da sua IDE.

---

## English Version

A simple and efficient Library Management System (CRUD) built with Java and PostgreSQL. This project was developed focusing on a tiered architecture and organized code.

### 🛠️ Architecture & Tech Stack
The project follows a layered architecture to ensure separation of concerns:
* **UI:** User Interface and interaction.
* **Service:** Business logic and core rules.
* **Persistence:** Data access layer.

**Technical Highlight:** We utilize the **Interface/Implementation (`.impl`)** pattern. Interfaces define the system contracts, while logic is encapsulated within implementation classes, promoting low coupling.

### 📋 Prerequisites
* **Java JDK 23** or higher.
* **PostgreSQL** (version 42.7.1 or compatible).

### 🚀 Getting Started
1.  **Clone the repository:**
    ```bash