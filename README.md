# Smart Expense Tracker API

A RESTful API built with Java and Spring Boot for managing personal expenses. The application provides endpoints to create, retrieve, update, delete, filter, and summarize expenses while following a clean layered architecture.


---

## Table of Contents

- Project Overview
- Features
- Technology Stack
- Project Architecture
- Prerequisites
- API Documentation
- Sample Request & Response
- Validation
- Exception Handling
- Screenshots
- Future Enhancements
- Author
- AI Usage

---

## Project Overview

The Smart Expense Tracker API helps users manage their daily expenses through REST APIs.

The application demonstrates:

- RESTful API Development
- Layered Architecture
- Clean Code Practices
- Input Validation
- Exception Handling
- Unit Testing
- Maven Project Management
- Git & GitHub Workflow

---

## Features

- Add a new expense
- View all expenses
- View expense by ID
- Update an existing expense
- Delete an expense
- Filter expenses by category
- Calculate total expenses
- Input validation
- Global exception handling

---

## Technology Stack

| Technology | Version |
|------------|---------|
| Java | 21 |
| Spring Boot | 4.x |
| Maven | Latest |
| JUnit | 5 |
| Mockito | Latest |
| Postman | API Testing |
| Git | Version Control |
| GitHub | Repository Hosting |

---

## Project Architecture

The project follows a layered architecture.

```
Client
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository
   │
   ▼
In-Memory Data Store
```

Each layer has a single responsibility, making the application easier to maintain and test.

---


## Prerequisites

Before running the application, install:

- Java JDK 21
- Maven (or use Maven Wrapper)
- Git
- Postman 

---


## API Documentation

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /expenses | Create a new expense |
| GET | /expenses | Retrieve all expenses |
| GET | /expenses/{id} | Retrieve expense by ID |
| PUT | /expenses/{id} | Update an expense |
| DELETE | /expenses/{id} | Delete an expense |
| GET | /expenses/category/{category} | Retrieve expenses by category |
| GET | /expenses/total | Calculate total expenses |

---

## Sample Request

POST `/expenses`

```json
{
  "title": "Coffee",
  "amount": 120,
  "category": "Food",
  "date": "2026-07-31"
}
```

---

## Sample Response

```json
{
  "id": 1,
  "title": "Coffee",
  "amount": 120.0,
  "category": "Food",
  "date": "2026-07-31"
}
```

---

## Validation

The application validates user input before processing requests.

Validation Rules

- Title must not be blank.
- Amount must be greater than zero.
- Category must not be blank.
- Date must not be null.

Invalid requests return an appropriate **400 Bad Request** response.

---

## Exception Handling

A Global Exception Handler provides consistent error responses.

Handled exceptions include:

- Expense Not Found
- Validation Errors
- Invalid Requests

---

## Screenshots


**Application Startup**


**Project Structure**

<img width="1047" height="546" alt="image" src="https://github.com/user-attachments/assets/232206c6-1fd7-41fc-80ee-856c6818b82d" />


_Figure 1. Spring Boot application running successfully on port 8080._


**POST Request**

<img width="899" height="1599" alt="image" src="https://github.com/user-attachments/assets/69e0aa3e-1913-4f98-8555-f33a3579bd07" />


_Figure 2.Successfully creating a new expense using the POST endpoint._


**GET Request**

<img width="1600" height="1000" alt="GET" src="https://github.com/user-attachments/assets/ae770443-e583-4e7f-b8b6-28190936a98c" />


_Figure 3. Retrieving all expenses from the application._


**Category Filter**

<img width="1600" height="1000" alt="category filter" src="https://github.com/user-attachments/assets/e49de370-130a-47ed-a110-9d6e80005ab1" />


_Figure 4. Retrieving particular category items from the application._


**TOTAL EXPENSE CALCULATOR**

<img width="1600" height="1000" alt="total" src="https://github.com/user-attachments/assets/29c530c3-2601-4f80-ac3c-742b8412a54e" />


_Figure 5. Calculating total expenses._


**DELETE**

<img width="1600" height="1000" alt="DELETE" src="https://github.com/user-attachments/assets/60f2194c-f92b-4bc2-9185-bd5347f7992d" />


_Figure 6. Deleting the particular ID._


**DELETION VERIFICATION**

<img width="1600" height="1000" alt="VERIFY DELETE" src="https://github.com/user-attachments/assets/8cf7fbdc-c9d4-4014-9481-c3c0e306c90c" />


_Figure 7. Verifying after deletion of respective IDs._


**VALIDATION**

<img width="1600" height="1000" alt="VALIDATION" src="https://github.com/user-attachments/assets/208a3af5-b24b-4f14-a757-8029d25d0016" />


_Figure 8. Validation using invalid data._


**Unit Tests**

<img width="1920" height="1020" alt="Screenshot 2026-07-31 163646" src="https://github.com/user-attachments/assets/a2b783cd-949f-438a-9f03-13655348d989" />


_Figure 9. All unit tests executed successfully._


---

## Future Enhancements

Possible improvements include:

- Database integration using MySQL or PostgreSQL
- Spring Data JPA
- Spring Security with JWT Authentication
- Docker support
- Monthly Summary Report

---

## Author

**Chandra Sambavi**

Electronics and Communication Engineering

Coimbatore Institute of Technology

GitHub

https://github.com/Imsambavi

Email

chandrasambavi@gmail.com

---

## AI Usage

This project was developed with the assistance of AI as a learning and development aid.

Detailed information about AI usage is available in **AI_NOTES.md**.

---

## Assignment Status

- REST API Completed
- Validation Implemented
- Exception Handling Implemented
- Unit Tests Passing
- GitHub Repository Created
- Documentation Completed
