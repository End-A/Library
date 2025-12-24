# Library 📚

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
Library 📚
Este é um sistema de gerenciamento de biblioteca (CRUD) desenvolvido em Java com persistência em banco de dados PostgreSQL. O projeto foi construído com foco em uma arquitetura limpa, utilizando o padrão de camadas para garantir a separação de responsabilidades.

## 🛠️ Arquitetura e Organização
O projeto está dividido em três níveis principais:

UI (User Interface): Camada de interação com o usuário.

Service: Onde reside toda a lógica de negócio e regras do sistema.

Persistência (Persistence): Camada responsável pela comunicação direta com o banco de dados.

Padrão de Projeto: O sistema utiliza o padrão de Interfaces e Implementações (.impl). As interfaces definem os contratos de serviço e persistência, enquanto a lógica real fica encapsulada nos pacotes de implementação, o que facilita a manutenção e evolução do código.

## 📋 Pré-requisitos
Java JDK 23 instalado.

PostgreSQL (versão 42.7.1 ou similar).

Uma IDE Java de sua preferência (IntelliJ, Eclipse ou VS Code).

## 🚀 Como Começar
1. Clonar o Repositório
Para baixar o projeto, execute o comando abaixo no seu terminal:

``Bash
git clone [https://github.com/End-A/Library.git](https://github.com/End-A/Library.git)

2. Configuração da Base de Dados
Para que a aplicação se comunique com o seu banco de dados, siga estes passos:

Localize o arquivo BancoDeDados.java.

Altere os valores das variáveis host, user, password e o nome do database para as credenciais do seu servidor PostgreSQL local.

Importante: Utilize o script SQL que você possui (o arquivo que era .txt e recomendamos mudar para .sql) para criar a estrutura das tabelas e realizar os inserts iniciais no seu banco.

3. Execução
Certifique-se de que o driver JDBC do PostgreSQL está configurado no projeto.

Localize a classe principal (que contém o método main) e execute-a através da sua IDE.

## ✅ Funcionalidades Atuais
O sistema permite o gerenciamento completo do ciclo de vida dos livros e usuários:

Cadastro: Adicionar novos livros ao acervo.

Listagem: Visualizar todos os livros cadastrados no sistema.

Atualização: Editar informações de registros existentes.

Exclusão: Remover livros do banco de dados.

Empréstimo: Funcionalidade para realizar e controlar o empréstimo de livros do acervo.

Desenvolvido por End-A(https://github.com/End-A)

