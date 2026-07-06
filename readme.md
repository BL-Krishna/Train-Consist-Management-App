# 🚆 Train Consist Management App

A Core Java application developed to simulate the management of a train consist (collection of bogies) using real-world software engineering principles and Java data structures.

This project is designed as a step-by-step learning application where each Use Case introduces a new Java concept, data structure, algorithm, or software engineering principle.

---

# 📌 Project Objectives

- Learn Core Java through a real-world application.
- Understand Object-Oriented Programming concepts.
- Practice Java Collections Framework.
- Implement Searching and Sorting Algorithms.
- Apply Exception Handling and Regular Expressions.
- Improve code quality using Repository-Service architecture.
- Follow Git best practices using feature branches.

---

# 🏗️ Architecture

```
Presentation Layer
        │
        ▼
Service Layer
        │
        ▼
Repository Layer
        │
        ▼
Collections (ArrayList, LinkedList, HashMap, HashSet)
```

---

# 📂 Project Structure

```
Train-Consist-Management-App
│
├── src
│
├── trainconsist
│       TrainConsistApplication.java
│
├── model
│       Bogie.java
│       PassengerBogie.java
│       GoodsBogie.java
│       BogieType.java
│       CargoType.java
│
├── repository
│       TrainRepository.java
│
├── service
│       TrainService.java
│       SearchService.java
│       SafetyService.java
│       ReportService.java
│
├── util
│       BubbleSort.java
│       BinarySearch.java
│       RegexValidator.java
│
├── exception
│       InvalidCapacityException.java
│       CargoSafetyException.java
│
└── README.md
```

---

# 🧰 Technologies Used

- Java 17+
- IntelliJ IDEA
- Git
- GitHub
- JUnit 5

---

# 🎯 Software Engineering Principles

- Object-Oriented Programming
- SOLID Principles
- Repository Pattern
- Service Layer Pattern
- Clean Code
- Separation of Concerns
- Single Responsibility Principle
- Exception Handling
- Defensive Programming

---

# 📚 Java Concepts Covered

- Classes & Objects
- Constructors
- Encapsulation
- Inheritance
- Polymorphism
- Abstraction
- Interfaces
- Enums
- Generics
- Collections Framework
- Streams API
- Lambda Expressions
- Method References
- Comparator
- Comparable
- Regular Expressions
- Exception Handling
- File Handling
- Searching Algorithms
- Sorting Algorithms

---

# 📊 Data Structures Used

| Data Structure | Purpose |
|---------------|---------|
| ArrayList | Store Passenger Bogies |
| LinkedList | Train Consist |
| HashSet | Unique Bogie IDs |
| HashMap | Fast Bogie Lookup |
| Queue | Waiting Operations |
| Stack | Undo Operations (Future Enhancement) |

---

# 📖 Use Cases

## UC1
Initialize Train Consist

## UC2
Passenger Bogie Management

## UC3
Unique Bogie Identification

## UC4
Train Consist using LinkedList

## UC5
Goods Bogie Management

## UC6
Cargo Allocation

## UC7
Sorting Bogies

## UC8
Searching Bogies

## UC9
Safety Validation

## UC10
Capacity Validation

## UC11
Regex Validation

## UC12
Exception Handling

## UC13
Streams API Operations

## UC14
Statistics & Reporting

## UC15
Performance Improvements

## UC16
Sorting Algorithms

## UC17
Searching Algorithms

## UC18
Optimization

## UC19
Advanced Reports

## UC20
Final Integrated Train Consist Management System

---

# 🌳 Git Workflow

## Repository

```
Train-Consist-Management-App
```

## Branch Structure

```
main
develop

feature/UC1-Initialize_Train
feature/UC2-Passenger_Bogie_Management
feature/UC3-Unique_Bogie_IDs
feature/UC4-LinkedList_Train_Consist
...
feature/UC20-Final_Train_Management_System
```

---

# 📝 Commit Message Format

```
[Krrish CH] : Initialized Train Consist application

[Krrish CH] : Added passenger bogie management

[Krrish CH] : Implemented unique bogie IDs using HashSet

[Krrish CH] : Implemented linked list based train consist
```

---

# ▶️ Running the Project

Clone the repository

```bash
git clone <repository-url>
```

Open in IntelliJ IDEA.

Run

```
TrainConsistApplication.java
```

---

# 📖 Learning Outcomes

After completing this project you will understand:

- Core Java
- OOP
- Collections Framework
- LinkedList
- HashMap
- HashSet
- Queue
- Searching Algorithms
- Sorting Algorithms
- Streams API
- Lambda Expressions
- Exception Handling
- Regex
- Repository Pattern
- Clean Architecture
- Git Workflow

---

# 🚀 Future Enhancements

- Database Integration
- Spring Boot REST API
- Authentication
- Railway Scheduling
- Ticket Booking
- Seat Allocation
- Coach Maintenance Module
- Admin Dashboard
- Passenger Management
- RESTful Services

---

# 👨‍💻 Developed By

**Krrish CH**

Core Java | Data Structures | Software Engineering | Git | IntelliJ IDEA