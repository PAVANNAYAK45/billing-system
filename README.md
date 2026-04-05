# Billing System API

## 📌 Overview

This is a RESTful backend application built using Spring Boot to manage invoices.
It allows users to create, retrieve, and delete invoices with automatic tax calculation.

---

## 🚀 Live Application

* 🔗 API Base URL: https://billing-system-apps.onrender.com
* 📘 Swagger UI: https://billing-system-apps.onrender.com/swagger-ui/index.html

---

## 🛠️ Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven
* Render (Cloud Deployment)

---

## ✨ Features

* Create Invoice
* Get All Invoices (with Pagination)
* Get Invoice by ID
* Delete Invoice
* Automatic Tax Calculation (18%)
* Input Validation
* Global Exception Handling
* Swagger API Documentation

---

## 📂 API Endpoints

### ➤ Create Invoice

POST /invoice

Request:

```json
{
  "customerName": "Pavan",
  "amount": 10000
}
```

---

### ➤ Get All Invoices (Pagination)

GET /invoice?page=0&size=5

---

### ➤ Get Invoice by ID

GET /invoice/{id}

---

### ➤ Delete Invoice

DELETE /invoice/{id}

---

## 📊 Sample Response

```json
{
  "id": 1,
  "customerName": "Pavan",
  "amount": 10000,
  "tax": 1800,
  "totalAmount": 11800
}
```

---

## ⚙️ How It Works

* Controller handles incoming requests
* Service layer processes business logic (tax calculation)
* Repository interacts with database
* Data stored in PostgreSQL

---

## 👨‍💻 Author

Dharamsoth Pavan Nayak
