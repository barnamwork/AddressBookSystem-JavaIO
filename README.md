# Address Book System - Java IO

A console-based Address Book application built incrementally using Git Flow.

---

## 📌 Project Overview

This project demonstrates managing contacts in an Address Book using Java, progressing through **13 Use Cases (UC1–UC13)**.  
Each Use Case builds on the previous one without removing earlier functionality, following a strict progressive development model.

The system supports:

- Full CRUD operations
- Duplicate prevention
- Dictionary grouping using Map
- Counting & Sorting
- File persistence using Java IO
- CSV-based storage and retrieval
- Git Flow based development

---

## 🚀 Features (Use Cases)

| UC    | Feature |
|-------|---------|
| UC1   | Add a new Contact |
| UC2   | Add multiple Contacts using Collections |
| UC3   | Edit existing Contact by name |
| UC4   | Delete a Contact by name |
| UC5   | Prevent Duplicate Entry (First Name + Last Name) |
| UC6   | Search Person by City or State |
| UC7   | View Persons by City or State using Map (Dictionary) |
| UC8   | Count contacts by City or State |
| UC9   | Sort contacts alphabetically by Name |
| UC10  | Sort contacts by City, State, or Zip |
| UC11  | Write Address Book to File using Java NIO |
| UC12  | Read Address Book from File |
| UC13  | Read/Write Address Book to CSV File |

---

## 🏗 Project Structure

```
src/
└── main/
    └── java/
        └── com/
            └── bridgelabz/
                └── addressbook/
                    ├── ContactPerson.java
                    ├── AddressBook.java
                    ├── AddressBookIO.java
                    └── AddressBookMain.java
```

---

## 📂 File Descriptions

### 1️⃣ ContactPerson.java
Represents a single contact in the Address Book.

Contains:
- Fields: firstName, lastName, address, city, state, zip, phone, email
- Getters & Setters
- equals() and hashCode() override (duplicate prevention)
- toString() override for display
- toCSV() method for CSV writing

---

### 2️⃣ AddressBook.java
Core business logic of the system.

Implements:
- List-based contact storage
- City & State dictionary using Map
- Add / Edit / Delete operations
- View by City / State
- Count by City / State
- Sorting by Name / City / State / Zip
- Load contacts from file

---

### 3️⃣ AddressBookIO.java
Handles file operations.

Implements:
- Write to CSV file
- Read from CSV file
- Java NIO Files API usage
- CSV parsing logic

Generated file:
```
AddressBook.csv
```

---

### 4️⃣ AddressBookMain.java
Application entry point.

Responsibilities:
- Console menu display
- User input handling
- Calls to AddressBook methods
- Integration of CSV read/write operations

---

## 🔀 Git Flow Strategy

Branch Structure:

- `main` → Stable release branch (README only)
- `develop` → Latest integrated development code
- `feature/uc1` … `feature/uc13` → Individual feature branches (kept alive)

---

## 🔄 Branch Workflow

```bash
git flow feature start uc<N>

# Implement UC code

git add .
git commit -m "[Barnam] : UC<N> - <description>"

git flow feature finish -k uc<N>

git push origin develop
git push origin feature/uc<N>
```

---

## 📝 Commit Convention

All commits strictly follow:

```
[Barnam] : <message>
```

Example:

```
[Barnam] : Implement UC13 - CSV File Read/Write Support
```

---

## ▶ How to Run

### Compile

```bash
javac -d out src/main/java/com/bridgelabz/addressbook/*.java
```

### Run

```bash
java -cp out com.bridgelabz.addressbook.AddressBookMain
```

---

## 🛠 Technologies Used

- Java (Console-based Application)
- Java Collections Framework (List, Map, HashMap)
- Java Streams API
- Java NIO (Files API)
- CSV File Handling
- Git Flow Branching Strategy
- Maven (Optional Build System)

---

## 📚 Key Concepts Implemented

- Object-Oriented Programming (Encapsulation, Abstraction)
- equals() & hashCode() override
- Comparator-based sorting
- Map-based dictionary grouping
- Duplicate detection logic
- File persistence using Java IO
- CSV parsing and writing
- Progressive feature development

---

## ✅ Final Status

✔ UC1 – UC13 Fully Implemented  
✔ Progressive Evolution Maintained  
✔ CSV Persistence Enabled  
✔ Clean Git Flow Structure  
✔ Production-Ready Console Application

---

## 👨‍💻 Author

Developed using structured Git Flow and clean commit history following:

```
[Barnam] : <message>
```

---