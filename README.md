# Academic ERP System

This project implements an Academic ERP system enabling Human Resources (HR) department employees to manage university departments and their employees effectively. The system supports CRUD operations (Create, Read, Update, Delete) for departments, displays employees associated with a department, and provides secure login using JWT authentication.

## Features

Department Management: Add, view, update, and delete university departments with specified capacities.

Employee Management: View details of employees associated with a department.

Secure Login: Implements JWT authentication for secure access to the system.

Role-based Access: Designed for HR department employees with appropriate permissions.

## Backend (Spring Boot)

### Architecture
The backend follows a layered architecture with clearly defined layers for controllers, services, repositories, and entities.

#### Controller Layer

AuthController: Handles login requests and JWT token generation.

DepartmentController: Manages department-related operations like create, read, update, and delete.

EmployeeController: Manages employee-related operations, including fetching employee data for a specific department.

#### Service Layer

AuthService: Handles business logic for authentication and token management.

DepartmentService: Implements department-related business logic.

EmployeeService: Implements employee-related business logic.

#### Repository Layer

DepartmentRepo: Interfaces with the database for department data.

EmployeeRepo: Interfaces with the database for employee data.

#### Model/Entity Layer

Department: Represents departments with fields such as department_id, name, and capacity.

Employee: Represents employees with fields such as employee_id, first_name, last_name, email, department_id, etc.

#### Database Design

Departments Table:
Fields: department_id, name, capacity

Employees Table:
Fields: employee_id, first_name, last_name, email, title, salary, password, department_id


## Frontend (React)

### Overview
The frontend is built using React and facilitates interaction with the backend via a REST API.

#### Features

Login:
Employees log in with their credentials, which sends a POST request to the backend.
The backend validates credentials and returns a JWT token upon successful authentication.
The token is stored securely (in local storage) and attached to subsequent API requests.
Department Management:

View a list of departments.
Create, update, or delete departments.
Navigate to view employees of a selected department.
Employee Management:

View employee details such as name, email, and title for a specific department.
Routing:

Implements React Router for seamless navigation across components:
Login: /
Departments: /departments
Create/Update Department: /departments/create or /departments/update/:id
View Employees: /departments/:id

## How to Run

### Backend
Clone the backend repository.
Configure the database in application.properties.
Run the application using an IDE (e.g., IntelliJ) or via command line:
mvn spring-boot:run
Backend runs on http://localhost:8080.

### Frontend
Clone the frontend repository.
Navigate to the project directory and install dependencies:
npm install
Start the development server:
npm start
Frontend runs on http://localhost:3000.

### Security
JWT Authentication: Secures API endpoints by requiring a valid token for protected routes.
Authorization Header: Frontend includes the JWT token in the Authorization header for authenticated requests.
Future Enhancements
Add role-based permissions for advanced user management.
Implement salary disbursement functionality for employees.
Improve frontend architecture to align with a layered structure for separation of concerns.