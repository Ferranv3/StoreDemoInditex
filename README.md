# Spring Boot DDD Store

## Description
This Spring Boot project implements a pricing service for an e-commerce platform. It provides REST APIs to manage and retrieve pricing information based on product ID, brand ID, and application dates. The service utilizes an in-memory H2 database for storing pricing data, making it fast and efficient for development and testing purposes.

### Features
- Retrieve applicable prices based on product ID, brand ID, and date.
- List all available prices in the system.
- In-memory H2 database integration for quick setup and testing.
- Layered architecture following Domain-Driven Design (DDD) principles.

### Technologies
- Java 17
- Spring Boot - Server-side application framework.
- H2 Database - In-memory database.
- JPA / Hibernate - For ORM and database interaction.
- JUnit & Mockito - For unit and integration testing.
- Maven - Dependency management and build tool.

## REST API Endpoints
1. Get All Prices:
    - Method: GET
    - Endpoint: /api/v1/prices/all
    - Description: Retrieves a list of all prices.
2. Get Applicable Price:
    - Method: GET
    - Endpoint: /api/v1/prices/applicable
    - Parameters:
        - date - The date for which to find the price.
        - productId - The ID of the product.
        - brandId - The ID of the brand.
    - Description: Retrieves the applicable price for a given product and brand on a specific date.

## Testing
Run the following command to execute unit and integration tests:

```bash
mvn test
```

## Installation and Running the Application
Clone the Repository:
```bash
git clone https://github.com/Ferranv3/SpringBoot-DDD-Store.git
```
Navigate to the Project Directory:
```bash
cd SpringBoot-DDD-Store
```
Build the Project with Maven:
```bash
mvn clean install
```

Run the Application:
```bash
mvn spring-boot:run
```

## License
MIT License or specify another license.

## Contact
Developer: Your Name
Email: your.email@example.com
