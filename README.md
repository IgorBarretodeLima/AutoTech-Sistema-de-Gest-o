# 🌿 AutoTech — Sistema de Gestão Inteligente de Oficina

O **AutoTech** é uma aplicação web Full Stack desenvolvida para automatizar e organizar a rotina operacional de oficinas mecânicas. O sistema integra uma **API RESTful em Java com Spring Boot** a um **painel administrativo interativo (SPA)** construído com HTML5, CSS3 e JavaScript puro, permitindo gerenciar todo o fluxo de atendimento em tempo real.

---

## 🎯 Para que serve?

Em oficinas mecânicas, o controle manual de clientes, histórico de veículos, estoque de peças e distribuição de serviços entre mecânicos gera atrasos e perda de informações. O AutoTech centraliza toda a operação em um único painel visual, permitindo:

- **Controlar Ordens de Serviço (OS):** Acompanhar serviços abertos, em andamento e concluídos, com cálculo automático da receita total.
- **Vincular Clientes e Veículos:** Associar cada veículo ao seu respectivo proprietário, evitando duplicidade de cadastros.
- **Gerenciar Equipe Técnica:** Organizar mecânicos por especialidade e registro profissional.
- **Monitorar Estoque de Peças:** Controlar códigos de fabricante, preços unitários e quantidades disponíveis.

---

## ✨ Funcionalidades Principais

- **Dashboard com Indicadores (KPIs):** Exibição em tempo real do total de ordens em aberto, clientes ativos, veículos registrados e receita total gerada.
- **CRUD Completo via API REST:**
  - `GET`: Listagem dinâmica em formato de cards responsivos[cite: 9, 12, 14, 16].
  - `POST`: Cadastro via modais interativos com preenchimento automático de chaves estrangeiras (`<select>` dinâmicos)[cite: 10, 13, 17].
  - `PUT`: Atualização rápida de status das Ordens de Serviço (ex.: marcar como **Concluída**)[cite: 9].
  - `DELETE`: Exclusão segura de registros diretamente pelos cards[cite: 9, 12, 14, 16].
- **Filtro Instantâneo:** Barra de pesquisa que filtra os cards da seção ativa em tempo real conforme o usuário digita[cite: 9].
- **Monitoramento de Conexão:** Indicador visual na barra lateral que verifica automaticamente se o servidor Spring Boot está online (`● API Conectada`)[cite: 9, 11, 14, 16].

---

## 🛠️ Tecnologias Utilizadas

### Back-end
- **Java** & **Spring Boot** (Spring Web, Spring Data JPA)
- **Jackson** (Serialização/Desserialização JSON)
- **Banco de Dados Relacional** (JPA / Hibernate)
- **Maven** (Gerenciamento de dependências)

### Front-end
- **HTML5 Semântico**
- **CSS3 Moderno** (CSS Variables, Flexbox, CSS Grid, design responsivo)
- **JavaScript (ES6+)** (`Fetch API`, `async/await`, manipulação dinâmica do DOM)

---

## 🏗️ Arquitetura do Projeto

text
autotech/
├── src/
│   └── main/
│       ├── java/com/dt2/autotech/
│       │   ├── controller/      # Endpoints REST (/api/ordens, /api/clientes, etc.)
│       │   ├── entities/        # Modelos JPA (Cliente, Veiculo, Mecanico, Peca, OrdemServico)
│       │   ├── repository/      # Interfaces Spring Data JPA
│       │   └── AutotechApplication.java
│       └── resources/
│           ├── static/          # Interface Web (index.html)
│           └── application.properties
├── docs/                        # Capturas de tela do sistema em funcionamento
├── pom.xml
└── README.md
'
🚀 Como Executar o Projeto
Clone o repositório:

Bash
git clone [https://github.com/seu-usuario/autotech.git](https://github.com/seu-usuario/autotech.git)
Abra no IntelliJ IDEA (ou IDE de sua preferência):

Aguarde o Maven baixar todas as dependências do pom.xml.

Configure o banco de dados:

Verifique as credenciais em src/main/resources/application.properties.

Inicie a aplicação:

Execute a classe AutotechApplication.java.

Acesse no navegador:

Abra http://localhost:8080/ e verifique se o indicador no canto inferior esquerdo exibe ● API Conectada.

###📸 Demonstração do Sistema em Funcionamento
Abaixo estão as capturas de tela comprovando a integração completa entre o Front-end e a API Spring Boot:

1. Cadastro e Listagem de Veículos
Vinculação de veículo ao cliente cadastrado e exibição imediata no card da frota:

<img width="1919" height="1001" alt="Captura de tela 2026-11-23 161758" src="https://github.com/user-attachments/assets/fe43fa7b-34ac-4748-aa14-065fd179f5e8" />

<img width="554" height="623" alt="Captura de tela 2026-11-23 161831" src="https://github.com/user-attachments/assets/2afbe46f-2020-40b5-bbc9-f04305218d15" />

<img width="1919" height="985" alt="Captura de tela 2026-11-23 161843" src="https://github.com/user-attachments/assets/a4f5d6cc-0faf-4b15-8fd1-67780ec84787" />

2. Cadastro de Mecânicos
Registro de profissional e atualização automática da equipe técnica

<img width="1919" height="990" alt="Captura de tela 2026-11-23 161857" src="https://github.com/user-attachments/assets/95a0dc72-5900-4e75-8a8e-98213e7b0601" />

<img width="1919" height="756" alt="Captura de tela 2026-11-23 164430" src="https://github.com/user-attachments/assets/ec79d139-26fb-4d71-8799-05ddcd8cf582" />

3. Controle de Estoque de Peças
Cadastro de peças com código de fabricante, valor unitário e quantidade em estoque:

<img width="588" height="614" alt="Captura de tela 2026-11-23 161943" src="https://github.com/user-attachments/assets/c7b5a88b-b0c0-4a2b-8013-36a5fbe1c370" />

<img width="1445" height="826" alt="Captura de tela 2026-11-23 161948" src="https://github.com/user-attachments/assets/7a0e2549-3f83-4eac-8aeb-100b0fbdc77f" />

4. Abertura de Ordem de Serviço e Atualização dos KPIs
Abertura de OS associando veículo e mecânico, refletindo imediatamente no card de serviço e na receita total do dashboard:

<img width="1919" height="949" alt="Captura de tela 2026-11-23 162000" src="https://github.com/user-attachments/assets/b1602d73-97fe-4c03-a821-819eb07a275e" />

<img width="826" height="811" alt="Captura de tela 2026-11-23 162016" src="https://github.com/user-attachments/assets/eca93ac0-55ac-4958-a332-214ab28e76d0" />

<img width="1919" height="995" alt="Captura de tela 2026-11-23 162644" src="https://github.com/user-attachments/assets/dab8f67c-1081-4037-99c6-a23f10d4b3ac" />
