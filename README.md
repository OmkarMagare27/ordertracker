# 📦 OrderTracker — eCommerce Order Tracking System

A full-stack Spring Boot application for tracking and managing customer orders. This project includes a backend API with PostgreSQL and a responsive HTML/JavaScript frontend. Built with real-time updates, 93%+ test coverage, and deployed readiness.

---

## 🚀 Features

- ✅ Create, fetch, update, and delete orders
- ✅ Responsive frontend (HTML/CSS/JS) with live status dropdowns
- ✅ RESTful API with Spring Boot 3 + PostgreSQL 17
- ✅ Custom native SQL query using `@Query`
- ✅ Unit testing with **JUnit 5**, **Mockito**, and **MockMvc**
- ✅ 📈 Code coverage with **JaCoCo** (95%)
- ✅ 🔧 Follows clean architecture: controller → service → repository
- ✅ Ready for deployment (Render/Railway)

---

## 🧰 Tech Stack

| Layer       | Technology                       |
|-------------|-----------------------------------|
| Backend     | Java 17, Spring Boot 3.4.5        |
| Database    | PostgreSQL 17                     |
| Frontend    | HTML5, CSS3, Vanilla JavaScript   |
| Testing     | JUnit 5, Mockito, MockMvc         |
| Build Tool  | Maven                             |
| Coverage    | JaCoCo                            |
| IDE         | VS Code                           |

---

## 📂 Folder Structure

ordertracker/ 
├── src/ │ 
├── main/ │ 
│ └── java/com/omkar/ordertracker/ │
│ ├── controller/OrderController.java │ 
│ ├── model/Order.java │ 
│ ├── service/OrderService.java │ 
│ └── repository/OrderRepository.java 
│ ├── test/ │ 
│ └── java/com/omkar/ordertracker/ │ 
│ ├── controller/OrderControllerTest.java │ 
│ └── service/OrderServiceTest.java 
│ └── resources/static/index.html ✅ 
├── pom.xml 
├── target/site/jacoco/index.html 📈 └── .gitignore


---

## 🔍 SQL Integration

The following native query is used in `OrderRepository.java` to retrieve orders by status:

```java
@Query(value = "SELECT * FROM orders WHERE status = :status", nativeQuery = true)
List<Order> findByStatus(@Param("status") String status);
✅ Used in the endpoint: GET /orders/status/{status}

🧪 Testing & Code Coverage
✅ Commands to run tests:
./mvnw clean test
./mvnw jacoco:report

Open coverage report:
target/site/jacoco/index.html

📈 Coverage Summary:
Class/Layer	      Coverage
Service Layer	      100%
Controller Layer	  100%
Model + Entity	    100%
Total	               95%

📸 Screenshots
Included the following:

🎯 Live frontend UI (index.html)
![image](https://github.com/user-attachments/assets/a3fd6b4a-8655-4965-b162-462efa023c6b)

📬 Postman test (POST + GET)
![image](https://github.com/user-attachments/assets/1631bc30-7f44-42ae-9d53-77add8d6b40f)


📈 JaCoCo HTML report (95%+ coverage)
![image](https://github.com/user-attachments/assets/98f34d0e-7c95-4ac9-b5f3-ab7461cee6d8)


🐘 PostgreSQL table in pgAdmin
![image](https://github.com/user-attachments/assets/a057cedd-fd96-4c65-a39c-72e6306fc5a6)


🔧 Running Locally
./mvnw spring-boot:run

App runs at:
http://localhost:8080

🧑‍💻 Author
Omkar Magare
📫 LinkedIn : https://www.linkedin.com/in/omkar-rajesh-magare/
💼 GitHub: github.com/OmkarMagare27

📄 License
This project is intended for educational and portfolio purposes.
