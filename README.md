# Parkable - Sistema de Gerenciamento de Estacionamento

![Java](https://img.shields.io/badge/Java-21-blue?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.5-green?logo=spring&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-4.0-red?logo=apachemaven&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.1-green?logo=thymeleaf&logoColor=white)

Aplicação web full-stack para gerenciamento de um estacionamento, desenvolvida como um projeto de estudo para demonstrar habilidades no ecossistema Java e Spring. O projeto conta com uma API REST completa para todas as operações e um dashboard web interativo para visualização e controle em tempo real.

---

## 📸 Visão Geral da Interface

A aplicação conta com um dashboard limpo e moderno, que centraliza todas as operações do estacionamento.

#### **Formulários de Ação**
*Formulários para adicionar novas vagas e registrar a entrada de veículos de forma rápida e intuitiva.*
![Formulários de Ação](assets/forms-actions.png)

#### **Veículos Ativos no Pátio**
*Tabela com todos os veículos atualmente estacionados, permitindo o registro de saída com um único clique.*
![Veículos Ativos](assets/active-vehicles.png)

#### **Status das Vagas**
*Visualização em grid de todas as vagas do estacionamento, com status (Livre/Ocupada) indicado por cores e ícones.*
![Status das Vagas](assets/spots-status.png)

#### **Histórico de Saídas**
*Registro completo de todos os veículos que já passaram pelo estacionamento, ordenado dos mais recentes para os mais antigos.*
![Histórico de Saídas](assets/history.png)

---

## 📜 Descrição Completa

Parkable é uma solução robusta para o controle de pátios de estacionamento. A aplicação permite o gerenciamento completo do ciclo de vida de uma vaga, desde o cadastro e visualização de status até o registro de entrada e saída de veículos. A lógica de negócio inclui cálculo de preço baseado no tempo de permanência e um histórico detalhado de todas as operações.

O backend foi construído seguindo as melhores práticas de design de APIs REST, utilizando o padrão DTO (Data Transfer Object) e Mappers para desacoplar a camada de API do modelo de persistência de dados. O frontend, renderizado no lado do servidor com Thymeleaf, oferece uma interface de usuário limpa, moderna e responsiva para interagir com o sistema. Para garantir a portabilidade e simplificar a configuração do ambiente, a aplicação foi totalmente containerizada com **Docker** e orquestrada com **Docker Compose**, permitindo que todo o sistema (aplicação + banco de dados PostgreSQL) seja executado com um único comando.

## 🚀 Funcionalidades

-   [x] **API REST Completa:** Endpoints para todas as operações de CRUD de Vagas e Registros de Estacionamento.
-   [x] **Dashboard Interativo:** Interface web com Thymeleaf para visualização e gerenciamento em tempo real.
-   [x] **Controle de Vagas:** Adição e exclusão de vagas, com visualização de status (Livre/Ocupada).
-   [x] **Registro de Veículos:** Formulários para registrar a entrada de carros e motos, com seleção dinâmica de vagas livres.
-   [x] **Finalização de Estadia:** Funcionalidade para registrar a saída de veículos com um único clique.
-   [x] **Cálculo Automático de Preço:** Lógica de negócio que calcula o valor a ser pago com base no tempo de permanência.
-   [x] **Histórico de Operações:** Tabela com o histórico de todos os veículos que já saíram, ordenada dos mais recentes para os mais antigos.

## 💪 Desafios Superados

Durante o desenvolvimento, vários desafios foram superados, servindo como grandes pontos de aprendizado:

-   **Design de API REST:** Aprofundamento no uso correto dos verbos HTTP (`POST`, `PUT`, `DELETE`), códigos de status (`201`, `204`, `404`) e design de URLs semânticas.
-   **Padrão DTO e Mapeamento:** Implementação do padrão DTO para desacoplar as camadas da aplicação, garantindo segurança e flexibilidade. Utilização da biblioteca **MapStruct** para automatizar o mapeamento entre Entidades e DTOs, incluindo casos complexos de mapeamento de objetos aninhados.
-   **Configuração de Build (Maven):** Resolução de problemas complexos de configuração do `pom.xml`, incluindo a configuração correta do `maven-compiler-plugin` para o MapStruct e a resolução de conflitos de filtragem de recursos (`maven-resources-plugin`) com os placeholders do Spring Boot.
-   **Thymeleaf Dinâmico:** Criação de uma interface rica com renderização condicional (`th:if`, `th:switch`), iteração sobre listas (`th:each`), formatação de datas e números, e estilização dinâmica com `th:classappend`.

## 🛠️ Tecnologias Utilizadas

-   **Backend:**
    -   Java 21
    -   Spring Boot 3.5.5
    -   Spring Web
    -   Spring Data JPA / Hibernate
-   **Frontend:**
    -   Thymeleaf
    -   HTML5
    -   CSS3
-   **Banco de Dados:**
    -   H2 Database (In-Memory & File-based)
-   **Build & Dependências:**
    -   Apache Maven
    -   Lombok
    -   MapStruct

## ⚙️ Instalação e Uso

### 🐳 Rodando com Docker (Método Recomendado)
Esta é a forma mais simples e rápida de executar o projeto, pois todo o ambiente (aplicação + banco de dados PostgreSQL) é gerenciado pelo Docker.

1.  **Pré-requisitos:**
    * Docker e Docker Compose instalados.

2.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/lucass-barreto/parkable-app.git](https://github.com/lucass-barreto/parkable-app.git)
    cd parkable-app
    ```

3.  **Configure as variáveis de ambiente:**
    Na raiz do projeto, crie um arquivo `.env` a partir do exemplo `.env.example`. O comando abaixo faz uma cópia para você:
    ```bash
    cp .env.example .env
    ```

4.  **Suba o ambiente com Docker Compose:**
    Este comando irá construir a imagem da aplicação e iniciar os containers da aplicação e do banco de dados em segundo plano.
    ```bash
    docker-compose up --build -d
    ```

5.  **Acesse a Aplicação:**
    Após alguns instantes, a aplicação estará disponível no seu navegador:
    * **Interface Web (Dashboard):** [http://localhost:8080/ui/dashboard](http://localhost:8080/ui/dashboard)


### 🐋 Imagem no Docker Hub
Uma imagem pré-construída desta aplicação está disponível publicamente no Docker Hub. Você pode baixá-la diretamente com o comando:
    ```bash
    docker pull lucassbarreto/parkable-app:latest
    ```
**Para mais detalhes, visite o repositório no [Docker Hub](https://hub.docker.com/r/lucassbarreto/parkable-app).**

## 📫 Contato

**Lucas Barreto Oliveira**

* **GitHub:** [@lucass-barreto](https://github.com/lucass-barreto)
* **LinkedIn:** [@lucass-barreto](https://www.linkedin.com/in/lucass-barreto)
* **Email:** lucasbo.dev@gmail.com
