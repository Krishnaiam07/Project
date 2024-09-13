# Project
Backend development on e-commerce
Spring Boot Backend Development Project Setup Guide
Overview
This project is a Spring Boot application using an H2 database for development and JWT-based authentication. It includes various endpoints for managing users, products, orders, inventory, and cart items.

Prerequisites
JDK 17 or later
Spring Boot STS (Spring Tool Suite) or any IDE that supports Spring Boot
Maven
Deployed on Tomcat Server
Setup Instructions
1. Clone the Repository
Clone the repository to your local machine:

bash

git clone https://github.com/Krishnaiam07/Project.git
cd Project
2. Application Properties
Ensure the application properties are set correctly for H2 database and JWT configuration. You can configure these in src/main/resources/application.properties.

3. Run the Application
Run the Spring Boot application:

bash

mvn spring-boot:run

## Database Setup

The following tables have been created for the project:

- **`app_user`**: Stores user information with columns for `id`, `username`, `password`, `role`, and timestamps for creation and updates.
- **`product`**: Contains product details including `id`, `name`, `price`, and timestamps for creation and updates. Initial data has been inserted with various products.
- **`cart`**: Manages user shopping carts with `id`, `user_id`, and `product_id`.
- **`orders`**: Records order details with `id`, `user_id`, `total_amount`, `status`, and timestamps for creation and updates.
- **`order_item`**: Represents order items with `product_id` and `quantity`.
- **`inventory`**: Tracks inventory with `id`, `product_id`, `quantity`, `location`, and the last update timestamp.




API Endpoints
Cart Management
Create Cart Item

URL: http://localhost:8080/carts
Method: POST
Request Body:

{
  "userId": 1,
  "productId": 101
}
Read Cart Item

URL: http://localhost:8080/carts/{id}
Method: GET
Path Variable: {id} (e.g., 1)
Update Cart Item

URL: http://localhost:8080/carts/{id}
Method: PUT
Path Variable: {id} (e.g., 1)
Request Body:

{
  "userId": 1,
  "productId": 102
}
Delete Cart Item

URL: http://localhost:8080/carts/{id}
Method: DELETE
Path Variable: {id} (e.g., 1)
Get User Cart Items

URL: http://localhost:8080/carts/user/{userId}
Method: GET
Path Variable: {userId} (e.g., 1)
Inventory Management
Create Inventory Item

URL: http://localhost:8080/inventories
Method: POST
Request Body:

{
  "productId": 101,
  "quantity": 50,
  "location": "Warehouse A",
  "lastUpdated": "2024-09-13T14:00:00"
}
Read Inventory Item

URL: http://localhost:8080/inventories/{id}
Method: GET
Path Variable: {id} (e.g., 1)
Update Inventory Item

URL: http://localhost:8080/inventories/{id}
Method: PUT
Path Variable: {id} (e.g., 1)
Request Body:

{
  "productId": 101,
  "quantity": 100,
  "location": "Warehouse B",
  "lastUpdated": "2024-09-13T15:00:00"
}
Delete Inventory Item

URL: http://localhost:8080/inventories/{id}
Method: DELETE
Path Variable: {id} (e.g., 1)
Order Management
Place Order

URL: http://localhost:8080/api/orders/placeOrder
Method: POST
Request Body:

{
  "items": [
    {
      "productId": 101,
      "quantity": 2
    },
    {
      "productId": 102,
      "quantity": 1
    }
  ]
}
Create Order (if available)

URL: http://localhost:8080/orders
Method: POST
Request Body:

{
  "userId": 1,
  "totalAmount": 150.00,
  "status": "Processing"
}
Read Order (if available)

URL: http://localhost:8080/orders/{id}
Method: GET
Path Variable: {id} (e.g., 1)
Update Order (if available)

URL: http://localhost:8080/orders/{id}
Method: PUT
Path Variable: {id} (e.g., 1)
Request Body:

{
  "userId": 1,
  "totalAmount": 200.00,
  "status": "Shipped"
}
Delete Order (if available)

URL: http://localhost:8080/orders/{id}
Method: DELETE
Path Variable: {id} (e.g., 1)
Product Management
Create Product

URL: http://localhost:8080/products
Method: POST
Request Body:

{
  "name": "Sample Product",
  "price": 99.99
}
Read Product

URL: http://localhost:8080/products/{id}
Method: GET
Path Variable: {id} (e.g., 1)
Update Product

URL: http://localhost:8080/products/{id}
Method: PUT
Path Variable: {id} (e.g., 1)
Request Body:

{
  "name": "Updated Product",
  "price": 89.99
}
Delete Product

URL: http://localhost:8080/products/{id}
Method: DELETE
Path Variable: {id} (e.g., 1)
Search Products

URL: http://localhost:8080/products/search

Method: GET

Request Parameters:

name (optional): Filter products by name (e.g., Laptop)
page (optional): Page number for pagination (e.g., 0)
size (optional): Number of items per page (e.g., 10)
sortBy (optional): Field to sort by (e.g., price)
Example Request:

bash

http://localhost:8080/products/search?name=Laptop&page=0&size=10&sortBy=price
User Management
Register User

URL: http://localhost:8080/register
Method: POST
Request Body:

{
  "username": "exampleUser",
  "password": "examplePassword",
  "role": "USER"
}
Login User

URL: http://localhost:8080/login
Method: POST
Request Body:

{
  "username": "exampleUser",
  "password": "examplePassword"
}
