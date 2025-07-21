# Library Management System (Console-Based)

A simple Java console application for managing a library's books and users. This project covers core and advanced Java concepts like OOP, collections, file handling, and serialization.

---

## Features

- Add, remove, and search books
- Register new users
- Borrow and return books
- List all books and users
- Save and load data using file serialization

---

## Project Structure

```bash
LibraryManagementSystem/
├── src/
│ └── main/
│ └── java/
│ ├── model/
│ │ ├── Book.java
│ │ └── User.java
│ ├── service/
│ │ └── LibraryService.java
│ ├── utils/
│ │ └── FileHandler.java
│ └── main/
│ └── Main.java
├── data/ # Stores .dat files (books, users)
├── pom.xml
└── README.md
```

---

## How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/Chaganti-Reddy/LibraryManagementSystem.git
cd LibraryManagementSystem
```

2. Create Required Folder

Make sure the data/ folder exists to store file data:

```bash 
mkdir -p data
```

3. Build and Run using Maven

```bash
mvn compile
mvn exec:java
```

Sample CLI Menu

```bash
========== MENU ==========
1  Add Book
2  Remove Book
3  Search Book
4  Register User
5  Borrow Book
6  Return Book
7  List All Books
8  List All Users
9  Save & Exit
```
