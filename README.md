# Astrology Booking Application

## Project Description

The Astrology Booking Application is designed to facilitate the booking of astrology sessions with professional astrologers. The application allows users to register, log in, browse available astrologers, book sessions, and make payments. The application also provides features for astrologers to manage their availability and for users to leave reviews.

### Features

- User registration and authentication
- Browse and search for astrologers
- Book astrology sessions
- Make payments for booked sessions
- Leave reviews for astrologers
- Manage astrologer availability

## Setting Up the Project Locally

To set up the project locally, follow these steps:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/abhiya492/astrology-booking.git
   cd astrology-booking
   ```

2. **Set up MongoDB:**
   Ensure you have MongoDB installed and running. You can use a local instance or a cloud-based MongoDB service like MongoDB Atlas.

3. **Configure application properties:**
   Update the `src/main/resources/application.properties` file with your MongoDB URI and other configurations.

4. **Build the project:**
   ```bash
   ./mvnw clean install
   ```

## Running the Project

To run the project, use the following command:

```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`.

## Running Tests

To run the tests, use the following command:

```bash
./mvnw test
```

## API Endpoints

### User Endpoints

- **Register a new user:**
  ```
  POST /users/register
  ```

- **Get all users:**
  ```
  GET /users
  ```

### Authentication Endpoints

- **Login:**
  ```
  POST /auth/login
  ```

### Astrologer Endpoints

- **Add a new astrologer:**
  ```
  POST /astrologers
  ```

- **Get all astrologers:**
  ```
  GET /astrologers
  ```

### Booking Endpoints

- **Book a slot:**
  ```
  POST /bookings
  ```

- **Get bookings by user:**
  ```
  GET /bookings/user/{userId}
  ```

### Review Endpoints

- **Add a review:**
  ```
  POST /reviews
  ```

- **Get reviews by astrologer:**
  ```
  GET /reviews/astrologer/{astrologerId}
  ```

### Payment Endpoints

- **Process a payment:**
  ```
  POST /payments
  ```

- **Verify a payment:**
  ```
  GET /payments/verify/{paymentId}
  ```

- **Refund a payment:**
  ```
  POST /payments/refund/{paymentId}
  ```
