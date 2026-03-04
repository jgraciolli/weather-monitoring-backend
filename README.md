Weather Monitoring API

API REST desenvolvida com Spring Boot para gerenciamento de estações meteorológicas e suas respectivas leituras climáticas.

---

🚀 Tecnologias

* Java
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven
* Documentação com Swagger

---

📌 Funcionalidades

* CRUD de estações meteorológicas
* CRUD de leituras climáticas
* Filtro de leituras por período
* Exclusão em cascata (ao deletar uma estação, as leituras relacionadas são removidas automaticamente)

---

📘 Manual de Execução da Aplicação

✅ Pré-requisitos

Ter instalado na máquina:

* Java 17+
* Maven
* PostgreSQL
* Postman ou Insomnia

---

1 - Clonar ou baixar o repositório

git clone https://github.com/jgraciolli/weather-monitoring-backend.git

cd weather-monitoring-backend

Ou baixe o projeto e extraia na sua máquina.

---

2 - Configurar o Banco de Dados

Criar o banco no PostgreSQL:

CREATE DATABASE weather_db;

---

Configurar o application.properties

Editar o arquivo:

src/main/resources/application.properties

Configurar com suas credenciais locais:

spring.datasource.url=jdbc:postgresql://localhost:5432/weather_db
spring.datasource.username=postgres
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

---

3 - Rodar a Aplicação

Na raiz do projeto:

mvn spring-boot:run

A aplicação iniciará em:

http://localhost:8080

---

4 - Acessar Documentação Swagger

Após iniciar a aplicação, acesse no navegador:

http://localhost:8080/swagger-ui/index.html

---

🧪 Testando com Postman ou Insomnia

Base URL:

http://localhost:8080

---

Criar uma Estação

POST /stations

Body (JSON):

{
"name": "Station A",
"location": "São José dos Campos",
"latitude": -23.22,
"longitude": -45.90,
"status": "ACTIVE"
}

---

Criar Leitura Climática

POST /weather/{stationId}

Body (JSON):

{
"temperature": 25.5,
"humidity": 70,
"pressure": 1013,
"windSpeed": 10
}
