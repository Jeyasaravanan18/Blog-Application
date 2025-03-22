📝 Blog Application - REST API
A RESTful API for a blogging platform that allows users to create, update, delete, and retrieve blog posts. Built using Spring Boot, Hibernate, and MySQL, this project serves as a backend for managing blog content.

🚀 Features
✅ User Authentication & Authorization (JWT-based)
✅ Create, Read, Update, and Delete (CRUD) Blogs
✅ Comment on Blog Posts
✅ Like & Unlike Blog Posts
✅ Pagination & Sorting for Blogs
✅ Search Blogs by Title or Content
✅ Exception Handling & Validation

🛠 Tech Stack
Technology	Description
Java 17	Core backend programming language
Spring Boot	Backend framework for REST API development
Spring Security	Implements authentication & authorization (JWT)
Hibernate & JPA	ORM for database management
MySQL	Relational database for storing blogs & users
Maven	Dependency & project management
Swagger UI	API documentation & testing
⚙ Setup & Installation
🔹 Prerequisites
Ensure you have the following installed:
✅ Java 17
✅ Maven
✅ MySQL Server
✅ Postman (for testing APIs)

🔹 Steps to Run the Project
1️⃣ Clone the repository

sh
Copy
Edit
git clone https://github.com/Jeyasaravanan18/Blog-Application.git
cd Blog-Application
2️⃣ Configure the Database

Open src/main/resources/application.properties

Update MySQL credentials:

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/blog_db
spring.datasource.username=root
spring.datasource.password=your_password
Create a database in MySQL

sql
Copy
Edit
CREATE DATABASE blog_db;
3️⃣ Build & Run the Project

sh
Copy
Edit
mvn clean install
mvn spring-boot:run
4️⃣ Access the API

API runs on http://localhost:8080

Open Swagger UI for API testing:
👉 http://localhost:8080/swagger-ui.html

📌 API Endpoints
Method	Endpoint	Description
POST	/users/register	Register a new user
POST	/users/login	Authenticate & get JWT token
GET	/blogs	Get all blog posts
POST	/blogs	Create a new blog
PUT	/blogs/{id}	Update an existing blog
DELETE	/blogs/{id}	Delete a blog
POST	/blogs/{id}/comments	Add a comment to a blog
POST	/blogs/{id}/like	Like a blog post
For more details, check the Swagger API Docs.

📜 License
This project is licensed under the MIT License.

🤝 Contributing
Want to contribute? Follow these steps:
1️⃣ Fork the repository
2️⃣ Create a new branch (feature-new-feature)
3️⃣ Commit your changes
4️⃣ Push your branch
5️⃣ Submit a Pull Request (PR)

💡 Authors & Contributors
Forked & Modified by: Jeyasaravanan

Original Author: TejasMedade
