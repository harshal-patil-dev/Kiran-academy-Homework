# IPL Management System

A Spring Boot REST API project developed for practicing CRUD operations using Hibernate and MySQL.

---

## 🚀 Technologies Used

* Java 21
* Spring Boot
* Spring MVC
* Hibernate ORM
* MySQL
* Maven
* Postman
* Eclipse IDE

---

## 📂 Project Architecture

```
Controller
    ↓
Service
    ↓
DAO (Repository)
    ↓
MySQL Database
```

The project follows a layered architecture to keep the code clean, modular, and easy to maintain.

---

## 📌 Features

* Insert One Player
* Insert Multiple Players
* Get One Player
* Get All Players
* Update One Player (PUT)
* Update Multiple Players (PUT)
* Update One Player (PATCH)
* Delete One Player
* Delete Multiple Players

---

## 🛠 REST APIs

| Method | API                  |
| ------ | -------------------- |
| POST   | /insert-one-player   |
| POST   | /insert-all-player   |
| GET    | /get-all-players     |
| GET    | /get-one-player      |
| PUT    | /update-one-player   |
| PUT    | /update-many-players |
| PATCH  | /update-one-player   |
| DELETE | /delete-one-player   |
| DELETE | /delete-many-players |

---

## 🗄 Database

* MySQL
* Hibernate ORM
* SessionFactory
* Transaction Management

---

## 📮 API Testing

All APIs were tested using **Postman**.

---

## ▶️ How to Run

1. Clone the repository.
2. Open the project in Eclipse or VS Code.
3. Configure MySQL in `application.properties`.
4. Run `IPLProjectApplication.java`.
5. Test the APIs using Postman.

---

## 📖 Concepts Covered

* Spring Boot
* Dependency Injection
* IOC
* Spring Container
* REST APIs
* CRUD Operations
* Hibernate
* SessionFactory
* Maven
* Layered Architecture
* Postman Testing

---

## 👨‍💻 Developed By

Harshal Patil
