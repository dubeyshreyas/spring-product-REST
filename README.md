# Product Management REST API

## Overview
This is a **Spring Boot REST API** project for managing products. The API allows users to perform **CRUD operations** on products using **Spring Boot, Spring MVC, Spring Data JPA, and PostgreSQL**. Users can interact with the API via **Postman** or a web browser.

## Features
- Create a new product
- Retrieve product details
- Update product information
- Delete a product
- List all products
- Query products by brand, category, and price

## Technologies Used
- **Spring Boot** (REST API framework)
- **Spring MVC** (Request handling)
- **Spring Data JPA** (Database interaction)
- **PostgreSQL** (Relational database)
- **Maven** (Build tool)
- **Postman** (API testing)

## Installation & Setup
### 1. Clone the Repository
```sh
 git clone https://github.com/your-repo/spring-rest-api.git
 cd spring-rest-api
```

### 2. Configure Database
Update the `application.properties` file with your **PostgreSQL** credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/productdb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build and Run the Application
```sh
 mvn clean install
 mvn spring-boot:run
```
The server will start on **http://localhost:8080/**.

## API Endpoints
### CRUD Operations
#### 1. Create a Product
**POST** `/product-api/v1/products`
- **Request Body (JSON):**
```json
{
  "productName": "Laptop",
  "productId": 1,
  "brand": "Dell",
  "category": "Electronics",
  "price": 1500.00
}
```

#### 2. Get All Products
**GET** `/product-api/v1/products`

#### 3. Get Product by ID
**GET** `/product-api/v1/products/id/{id}`

#### 4. Update a Product
**PUT** `/product-api/v1/products`
- **Request Body (JSON):**
```json
{
  "productName": "Updated Laptop",
  "productId": 1,
  "brand": "Dell",
  "category": "Electronics",
  "price": 1600.00
}
```

#### 5. Delete a Product
**DELETE** `/product-api/v1/products/id/{id}`

### Querying Methods
#### 6. Get Products by Brand
**GET** `/product-api/v1/products/brand/{brand}`

#### 7. Get Products by Brand Containing Name
**GET** `/product-api/v1/products/brand/{brand}/product-name/{productname}`

#### 8. Get Products by Category (Request Param)
**GET** `/product-api/v1/products/category?category={category}`

#### 9. Get Products by Brand and Price Less Than
**GET** `/product-api/v1/products/brand/price?brand={brand}&price={price}`

#### 10. Get Products by Lesser Price (Native Query)
**GET** `/product-api/v1/products/price/{price}`

#### 11. Get Products by Category and Name (Native Query)
**GET** `/product-api/v1/products/category/{category}/product-name/{name}`

#### 12. Get Products by Brand (Named Query)
**GET** `/product-api/v1/products/product-brand/{brand}`

#### 13. Get Products by Price and Name
**GET** `/product-api/v1/products/price/{price}/p-name/{product}`

## Testing with Postman
- Open Postman
- Import the API endpoints
- Send requests and verify responses

## License
This project is open-source and free to use under the [MIT License](LICENSE).

---
