# Description
This project is a simple implementation of CRUD operations and java security using springboot framework.

Use Case: maintains an Employee Management System which can be accessed to different extents by authenticated users of different authority.

This project contains involves *lots of comments* and a couple of files(fully commented) which were just made for learning purpose. *Feel free to ignore them*.
## Features involved
### 1. REST apis for CRUD operations

1. CREATE AN EMPLOYEE  using POST request on /employees 
2. GET AN EMPLOYEE by id using GET request on /employees/{id}
3. DELETE AN EMPLOYEE by id using DELETE request on /employees/{id}
4. GET ALL EMPLOYEES using DELETE request on /employees
5. UPDATE AN EXISTING EMPLOYEE using PUT on /employees/{id}
6. MAKE SMALL PATCHES ON EXISTING EMPLOYEE using PATCH on /employees/{id}

### 2. Exception handling

Uses Optional<>, customExceptions and Exception Handlers.

### 3. Validations of user data

Uses spring boot starter validation for providing the validations on employee fields.

### 4. java security

using spring boot security dependency
User entity is created for providing authentication and authorization
There are 3 levels of access:
- public: anyone can access them(no authentication required "/", "/home", "/register/user"
- Normal user: role -> "USER" can also access "/user/home" and GET requests on employee entity.
- Admin User: role -> "USER,ADMIN" can also access "/admin/home" and perform all CRUD operations on employee entity.

### 5. Server side rendering 

Using view engine thymleaf

### 6. Custom error and login page

### 7. Prior Database initialization 

using CommandLineRunner
