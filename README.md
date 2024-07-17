
# Hotel Reservation System

This project is a Hotel Reservation System that allows users to add hotels, customers, rooms, and make room bookings. The backend is built with Java and Spring Boot. The database used is PostgreSQL.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Deployment](#deployment)
- [Contributing](#contributing)
- [License](#license)

## Features

- Add new hotels
- Add new customers
- Add new rooms to hotels
- Book rooms for customers
- View booking details

## Prerequisites

- Java 11 or higher
- Maven
- PostgreSQL
- Git

## Installation

### Backend

1. Clone the repository:

   ```sh
   git clone https://github.com/roshanabhishek/hotel-reservation.git
   cd hotel-reservation
   ```

2. Set up the PostgreSQL database and update the `application.properties` file with your database credentials.

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/hotel_reservation
   spring.datasource.username=yourUsername
   spring.datasource.password=yourPassword
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Build and run the backend:

   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

## API Endpoints

Here are some of the key API endpoints available in the system:

- **Add a Hotel**
  - **Endpoint:** `POST /api/hotels`
  - **Request Body:** 
    ```json
    {
      "name": "Hotel Name",
      "address": "Hotel Address",
      "rating": 5
    }
    ```

- **Add a Customer**
  - **Endpoint:** `POST /api/customers`
  - **Request Body:**
    ```json
    {
      "firstName": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com",
      "phoneNumber": "1234567890"
    }
    ```

- **Add a Room**
  - **Endpoint:** `POST /api/rooms`
  - **Request Body:**
    ```json
    {
      "hotelId": 1,
      "roomNumber": "101",
      "roomType": "Deluxe",
      "price": 150.0
    }
    ```

- **Book a Room**
  - **Endpoint:** `POST /api/bookings`
  - **Request Body:**
    ```json
    {
      "customerId": 1,
      "roomId": 1,
      "checkInDate": "2024-07-01",
      "checkOutDate": "2024-07-05"
    }
    ```

## Deployment

You can deploy the application using various platforms like Heroku, AWS, or any other cloud service. For detailed deployment instructions, refer to the [deployment guide](docs/deployment.md).

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
