# Expense Tracker

Expense Tracker is a Java application that allows you to track and manage your expenses. It's built with Java Swing for the GUI, FlatLaf for a modern look and feel, and SQLite DB for data persistence.

https://github.com/Surya-KN/ExpenseTracker/assets/95220715/06e2c3ca-6fd5-44e6-b847-c6363632b9a5
## Features

- Add new expenses




- Sort expenses based on categories
- Provides a summary of total expenses

## Prerequisites

- Java 17 or later (Make sure both `JAVA_HOME` and `Path` variables are set. )
- Maven

## Getting Started

Follow these steps to get the project up and running on your local machine:

1. Clone the repository:
```
git clone https://github.com/Surya-KN/ExpenseTracker.git
```
2. Navigate to the project directory:
```
cd ExpenseTracker
```
3. Build the project:
- for windows
  ```
  .\mvnw.cmd clean package
  ```
- for linux
  ```
   chmod +x ./mvnw
  ./mvnw clean package
  ```
4. Run the application:
```
java -jar target/ExpenseTracker-1.0-jar-with-dependencies.jar
```

