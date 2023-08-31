# EmpOperations Project

## Project Overview
EmpOperations is a Spring Boot web application designed for managing employee-related operations, including CRUD functionalities, user management, and authentication.

## Installation Guide

### Database Setup
1. Ensure you're using MySQL as the database and that the database service is running.
2. Create `Employee` and `User` tables in the database. You can use the following simplified SQL statements:
```sql
CREATE TABLE EMPLOYEES(
    EMPLOYEE_ID INT,
    NAME VARCHAR(45),
    PHONE_NUMBER VARCHAR(45),
    SUPERVISORS VARCHAR(45),
    PRIMARY KEY(EMPLOYEE_ID)
);

CREATE TABLE User (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    ...  -- other fields
);
```
3. Populate initial data as needed.
```sql
INSERT INTO Employee (name, position) VALUES ('John Doe', 'Manager');
INSERT INTO User (username, password) VALUES ('admin', 'password123');  -- Note: Password should be encrypted
```

### Project Configuration
1. Clone this repository to your local machine.
2. Ensure you have Java 17 and Maven installed.
3. If you are not using MySQL, modify the respective dependencies in `pom.xml` and adjust the database connection settings in the `application.properties` file.
4. Run `mvnw install` in the root directory of the project to install all necessary dependencies.
5. Launch the project with `mvnw spring-boot:run`.

## Usage Guide
- **Employee Management**: Use the relevant RESTful API endpoints for CRUD operations on employees.
- **User Management & Authentication**: Use the relevant API endpoints for user login and logout operations.

## Project Structure
- `model`: Defines the main data structures of the project.
- `repository`: Offers data access interfaces.
- `service`: Contains business logic related to employees.
- `controller`: Handles web requests related to employees and user authentication.
- `security`: Configures the project's security settings and authentication mechanisms.

## Known Issues
Due to the project requirement of hardcoded API authentication, there's a security risk. It's recommended to adopt JWT token generation for authentication purposes.

## Contact Information
For any questions about the project, please contact us at [philipzhang0204@gmail.com](philipzhang0204@gmail.com).

