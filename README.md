# 🔧 AutoTech — Sistema de Gestão de Oficina Mecânica

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)


Aplicação web full-stack desenvolvida para a atividade **API REST e Aplicação Web Integrada**, composta por uma **API RESTful em Java (Spring Boot)** conectada a um banco de dados **MySQL** e uma **interface web responsiva** (HTML, CSS e JavaScript separados) que consome a API via `Fetch API`.

🔗 **Repositório Oficial:** [IgorBarretodeLima/AutoTech-Sistema-de-Gest-o](https://github.com/IgorBarretodeLima/AutoTech-Sistema-de-Gest-o)

---

## 🎯 Problema Atendido, Público Usuário e Funcionalidades

* **Problema Resolvido:** Digitaliza e centraliza a rotina operacional de uma oficina mecânica que anteriormente era controlada por planilhas manuais ou fichas de papel, eliminando perda de histórico de veículos, descontrole de estoque de peças e falhas no acompanhamento de serviços.
* **Público Usuário:**
  * **Recepcionistas / Atendentes:** Realizam o cadastro de clientes, veículos e abertura de ordens de serviço.
  * **Mecânicos:** Consultam ordens de serviço atribuídas e verificam peças disponíveis.
  * **Gestores:** Gerenciam o catálogo de peças, equipe técnica, status das ordens e faturamento.
* **Funcionalidades Principais:**
  * Operações completas de **CRUD** (Listar, Consultar por ID, Cadastrar, Atualizar e Excluir) para **5 entidades** do domínio.
  * Validação de dados na API com retorno de mensagens explicativas e códigos HTTP semânticos (`200`, `201`, `204`, `400`, `404`, `500`).
  * Interface web dinâmica que exibe estados de carregamento, sucesso, lista vazia, validação e falha de conexão, atualizando os dados em tela sem exigir recarregamento manual da página.

---

## 🛠️ Tecnologias Utilizadas

* **Back-end:** Java 17+, Spring Boot 3 (Spring Web, Spring Data JPA, Bean Validation), Maven Wrapper (`mvnw`).
* **Banco de Dados:** MySQL 8.0+.
* **Front-end:** HTML5, CSS3 e JavaScript ES6+ (`Fetch API`) em arquivos separados.
* **Testes e Documentação:** Springdoc OpenAPI (Swagger UI) / Coleção Postman e JUnit.

---

## 📂 Estrutura do Projeto

```text
AutoTech-Sistema-de-Gest-o/
├── Banco_AutoTech/               # Scripts SQL de criação do banco, tabelas e carga inicial
├── src/
│   ├── main/
│   │   ├── java/com/dt2/autotech/
│   │   │   ├── controller/       # Controladores REST (@RestController)
│   │   │   ├── entities/         # Entidades JPA (@Entity)
│   │   │   ├── exception/        # Tratamento global de exceções (@RestControllerAdvice)
│   │   │   └── repository/       # Interfaces de acesso a dados (JpaRepository)
│   │   └── resources/
│   │       ├── static/           # Aplicação Web integrada (index.html, css/, js/)
│   │       └── application.properties.example
│   └── test/                     # Testes automatizados da API
├── pom.xml                       # Dependências Maven
└── README.md
