# Expense Tracker

Expense Tracker is a Java application that allows you to track and manage your expenses. It's built with Java Swing for the GUI, FlatLaf for a modern look and feel, and SQLite DB for data persistence.

## Features

- Add new expenses
- Sort expenses based on categories
- Provides a summary of total expenses

## Prerequisites

- Java 8 or later
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
```
./mvnw.cmd clean package
```
4. Run the application:
```
java -jar target/ExpenseTracker-1.0-jar-with-dependencies.jar
```

## Configuring Java Version

The Java version used for the project is specified in the `pom.xml` file. If you want to use a different Java version, you can change it in the following properties:

```xml
<properties>
    <maven.compiler.source>19</maven.compiler.source>
    <maven.compiler.target>19</maven.compiler.target>
</properties>
```

Replace `19` with your desired Java version (e.g., 17 for Java 17).
