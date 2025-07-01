# Spring Boot CRUD API

This project is a simple **CRUD (Create, Read, Update, Delete)** API built using **Spring Boot**, **Spring Data JPA**, and **MySQL (XAMPP)**.

## 📦 Features

- RESTful API Endpoints
- MySQL database integration (via XAMPP)
- Spring Data JPA for ORM
- Cross-Origin Resource Sharing (CORS) enabled
- Maven-based project

---

## ⚙️ Tech Stack

- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- MySQL (via XAMPP)
- Maven

---

## 🧰 Prerequisites

- Java JDK 17+
- Maven installed
- XAMPP with MySQL running
- IDE like IntelliJ or Eclipse

---

## 📁 Project Structure

MakingApi/
├── src/
│ ├── main/
│ │ ├── java/com/example/MakingApi/
│ │ │ ├── controller/Controller.java
│ │ │ ├── model/Model.java
│ │ │ ├── repository/Repository.java
│ │ │ └── MakingApiApplication.java
│ │ └── resources/
│ │ ├── application.properties
│ │ └── ...
├── pom.xml
└── README.md

| Method | Endpoint               | Description           |
| ------ | ---------------------- | --------------------- |
| GET    | `/api/model`           | Get all entries       |
| GET    | `/api/model/{id}`      | Get entry by ID       |
| POST   | `/api/model`           | Create new entry      |
| PUT    | `/api/model/{id}`      | Update entry by ID    |
| DELETE | `/api/model/{id}`      | Delete entry by ID    |
| DELETE | `/api/model`           | Delete all entries    |
| GET    | `/api/model/published` | Get published entries |
