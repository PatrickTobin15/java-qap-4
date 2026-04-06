# Data Persistence Project – Java

## Project Description

This is a Java console application that demonstrates two methods of data persistence

- **File I/O** – The Drug records are saved to and read from a local text file (`drugs.txt`) using `BufferedWriter` and `BufferedReader`.
- **Database I/O** – The Patient records are saved to and retrieved from a **PostgreSQL** database using **JDBC**.

The app provides a simple **Scanner-based menu** which is allowing the user to choose from any of the four persistence operations.

---

## How It Went

This project was definitely putting my mind to the test which I honestly quite enjoyed.

The trickiest part was making sure the database credentials and table name matched exactly between pgAdmin and the Java code.

---

## How to Run

### Prerequisites
- Java JDK 11+
- PostgreSQL installed and running

### Setup
1. Open **pgAdmin** and run `create_table.sql` to create the `patients` table within your database.
2. Open `PatientDBManager.java` and update the three constants at the top:
   ```java
   private static final String URL      = "jdbc:postgresql://localhost:5432/YOUR_DB_NAME";
   private static final String USER     = "YOUR_USERNAME"; or default postgres
   private static final String PASSWORD = "YOUR_PASSWORD"; or default postgres
   ```
3. Compile all `.java` files and run `Main.java`.

### Menu Options
```
1. Save a Drug to file
2. Read all Drugs from file
3. Save a Patient to database
4. Read all Patients from database
5. Exit
```

---

## Project Structure

```
src/
├── Main.java              # Entry point, Scanner menu
├── Drug.java              # Drug entity class
├── Patient.java           # Patient entity class
├── DrugFileManager.java   # File I/O logic for Drug
└── PatientDBManager.java  # JDBC logic for Patient
create_table.sql           # SQL script to create patients table
drugs.txt                  # Generated at runtime when drugs are saved
```

---
