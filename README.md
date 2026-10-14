# SmartCare – Patient Health Record System

SmartCare is a web-based patient health record management application developed using Java, Spring Boot, Thymeleaf, and MySQL. It helps manage patient profiles and maintain their medical history in an organized way.

Developed as part of an internship project at the Fuel Group of Institutions.

## Features

- **Patient Management:** Add, view, update, and delete patient records.
- **Medical History Tracking:** Maintain patient medical history, problems, and treatments.
- **RESTful APIs:** Backend endpoints for patient record management.
- **Database Integration:** Store and retrieve data using MySQL.
- **Web Interface:** User-friendly pages built with Thymeleaf, HTML, and CSS.

## Tech Stack

- **Language:** Java
- **Backend:** Spring Boot, Spring Data JPA, Hibernate
- **Frontend:** Thymeleaf, HTML5, CSS3, JavaScript
- **Database:** MySQL
- **Build Tool:** Maven
- **IDE:** Eclipse

## Prerequisites

Before running the project, make sure you have:

- Java Development Kit (JDK)
- MySQL Server
- Maven, or the included Maven Wrapper

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/chepatil779/SmartCare-Patient-Health-Record-System.git
cd SmartCare-Patient-Health-Record-System
```

### 2. Configure the Database

Create a MySQL database named `smartcare`.

Configure the following environment variables before running the application:

- `DB_URL` – JDBC URL of your MySQL database
- `DB_USERNAME` – MySQL username
- `DB_PASSWORD` – MySQL password
- `PORT` – Application port (optional; defaults to 8080)

Do not commit database passwords or other secrets to GitHub.

### 3. Run the Application

Run the main Spring Boot application class, `SmartcareApplication.java`, from your IDE.

Alternatively, from the project directory, use the Maven Wrapper if it is available:

```bash
./mvnw spring-boot:run
```

On Windows Command Prompt, use:

```bat
mvnw.cmd spring-boot:run
```

### 4. Access the Application

Open your browser and visit:

http://localhost:8080

## Author

**Chetana Patil**

## Project Status

Deployment in progress.
