# Description
This project is a simple implementation of CRUD operations and java security using springboot framework.

Use Case: maintains an Employee Management System which can be accessed to different extents by authenticated users of different authority.

This project contains involves *lots of comments* and a couple of files(fully commented) which were just made for learning purpose. *Feel free to ignore them*.

**UPDATED WITH JWT TOKENS (FIND BELOW SS)**
                          

## Features involved
### 1. REST apis for CRUD operations

1. CREATE AN EMPLOYEE  using POST request on /employees 
2. GET AN EMPLOYEE by id using GET request on /employees/{id} <img width="828" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/10012c73-1dea-4932-b090-9eb73b9b80aa">

3. DELETE AN EMPLOYEE by id using DELETE request on /employees/{id} <img width="802" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/e534ad55-2ab5-4eec-b6e2-fc3d37815e74">

4. GET ALL EMPLOYEES using DELETE request on /employees
5. UPDATE AN EXISTING EMPLOYEE using PUT on /employees/{id} (yet to be done)
6. MAKE SMALL PATCHES ON EXISTING EMPLOYEE using PATCH on /employees/{id} (yet to be done)

### 2. Exception handling

Uses Optional<>, customExceptions and Exception Handlers.
<img width="839" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/ac0c2443-8258-4010-8a28-63bfbd21334d">

### 3. Validations of user data

Uses spring boot starter validation for providing the validations on employee fields.

<img width="837" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/3768d365-7af5-4c27-820f-609ba8c81918">

### 4. java security

using spring boot security dependency
User entity is created for providing authentication and authorization
There are 3 levels of access:
- public: anyone can access them(no authentication required "/", "/home", "/register/user"
  <img width="841" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/600b57cf-a71b-4a42-b1eb-6f6379507e60">

  <img width="839" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/7c4716f7-ebfc-46c7-a6b9-90cb939f997e">

- Normal user: role -> "USER" can also access "/user/home" and GET requests on employee entity.
  <img width="833" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/3e30d009-109d-41d4-947f-44c47d1fc067">

  <img width="827" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/1c72204b-a9ee-4c7d-b3d7-043dd0e01682">
  
  <img width="793" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/7b6629bf-7593-4545-b373-e5e977b7656d">

- Admin User: role -> "USER,ADMIN" can also access "/admin/home" and perform all CRUD operations on employee entity. <img width="813" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/a23e0201-c362-4b88-8bb4-7440dbc7dd84">

<img width="828" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/ed48343d-ef8e-4330-848f-0979284a212e">
post request

<img width="851" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/80f312a1-8040-4d12-8d44-fecf8eb58273">


### 5. Server side rendering 

Using view engine thymleaf

### 6. Custom error and login page

<img width="948" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/3967fb1e-bd72-439c-953d-15bf15d1f0c5">

### 7. Prior Database initialization 

using CommandLineRunner

<img width="948" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/4f865118-a7f0-407e-8c24-37b39017788d">

<img width="961" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/976bfeb7-4b5c-45d9-9a44-bb54d5e37dbb">

Thank you! :)

----------------------------------- (UPDATED)  JWT TOKEN IMPLEMENTATION -------------------------------

 # ROLE BASED AUTHENTICATION & AUTHORIZATION USING JWT TOKENS

 ## USER_ROLE 
 
 Only get apis and user home access available

POST "/authenticate" (signIn endpoint)

<img width="844" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/72c0f9f6-d320-44d4-882b-82727d3c4ad2">

GET "/me" ONLY AUTHENTICATED USER
<img width="840" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/1464566e-0f1b-48e6-a2d5-ffab899561c5">

GET apis "/user/home", /employees" & "/employees/{id}" works with USER_ROLE but other operations not allowed.

<img width="837" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/0e9cf520-0fb9-4261-9e4c-17a90776ee8b">

<img width="844" alt="Screenshot 2024-07-09 at 6 02 35 PM" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/f590ae53-19ab-4096-ac65-4416904c436c">

<img width="837" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/e2811b9b-6af7-44e8-953b-59cc889e1d1f">


POST, DELETE ETC. apis "/admin/home", /employees" & "/employees/{id}" works with ADMIN_ROLE AND ADMIN HAVE ACCESS TO OTHER APIS AS WELL

<img width="817" alt="Screenshot 2024-07-09 at 6 08 22 PM" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/299c1bc1-c013-4d2a-a3b8-60de51206571">

<img width="834" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/ead580c4-5b98-4b07-8d01-fed7ef321cc4">

<img width="831" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/4c319fb0-8f04-47eb-8552-e663af895ef1">

 <img width="842" alt="image" src="https://github.com/vedantnaudiyal/RESTapis/assets/174436138/b31fcf0d-ab1b-4082-9582-bab2ca0b04e3">

