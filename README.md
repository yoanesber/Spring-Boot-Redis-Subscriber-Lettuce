# Redis Subscriber with Spring Boot

## 📖 Overview
This project is a Spring Boot application that implements a **Redis subscriber** using **Redis Lettuce**. The application listens to messages published to a specific Redis channel and processes them accordingly.

### 🚀 Key Features of Redis
- **Redis Pub/Sub Mechanism** – Subscribes to Redis channels and listens for incoming messages.
- **Spring Boot Integration** – Uses spring-boot-starter-data-redis for Redis communication.
- **Lettuce Client** – Implements Redis connection using Lettuce for efficient handling.
- **Asynchronous Processing** – Listens and processes messages in real time.

---

## 🤖 Tech Stack
The technology used in this project are:  
- `Spring Boot Starter Web` – Web application support.
- `Redis with Lettuce` – Redis integration with Lettuce Redis client for efficient handling.
---

## 🏗️ Project Structure
The project is organized into the following package structure:  
```bash
redis-subscriber-lettuce/
│── src/main/java/com/yoanesber/spring/redis_subscriber_lettuce/
│   ├── 📂config/                # Configuration classes for Redis
│   ├── 📂event/                 # Redis event listeners
│   ├── 📂service/               # Business logic layer
│   │   ├── 📂impl/              # Implementation of services
```
---

## ⚙ Environment Configuration
Configuration values are stored in `.env.development` and referenced in `application.properties`.  
Example `.env.development` file content:  
```properties
# Application properties
APP_PORT=8081
SPRING_PROFILES_ACTIVE=development

# Redis properties
REDIS_HOST=localhost
REDIS_PORT=6379
REDIS_USERNAME=default
REDIS_PASSWORD=your_password
REDIS_TIMEOUT=5
REDIS_CONNECT_TIMEOUT=3
REDIS_LETTUCE_SHUTDOWN_TIMEOUT=10
```

Example `application.properties` file content:  
```properties
# Application properties
spring.application.name=redis-publisher-lettuce
server.port=${APP_PORT}
spring.profiles.active=${SPRING_PROFILES_ACTIVE}

# Redis properties
spring.data.redis.host=${REDIS_HOST}
spring.data.redis.port=${REDIS_PORT}
spring.data.redis.username=${REDIS_USERNAME}
spring.data.redis.password=${REDIS_PASSWORD}
spring.data.redis.timeout=${REDIS_TIMEOUT}
spring.data.redis.connect-timeout=${REDIS_CONNECT_TIMEOUT}
spring.data.redis.lettuce.shutdown-timeout=${REDIS_LETTUCE_SHUTDOWN_TIMEOUT}
```
---

## 🛠️ Installation & Setup
A step by step series of examples that tell you how to get a development env running.  
1. Clone the repository
```bash
git clone https://github.com/yoanesber/Spring-Boot-Redis-Subscriber-Lettuce.git
cd Spring-Boot-Redis-Subscriber-Lettuce
```

2. Ensure Redis is installed and running:
```bash
redis-server
```

3. (Optional) If you want to add a specific user with access to a specific channel, you can run the following command in Redis CLI:
```bash
ACL SETUSER your_user +CHANNEL~your_channel on >your_password
```

4. Set up Redis user and password in `.env.development` file:
```properties
# Redis properties
REDIS_PASSWORD=your_password
```

5. Build and run the application
```bash
mvn spring-boot:run
```

6. Verify Redis Subscription Use Redis CLI to publish a message:
```bash
redis-cli
PUBLISH PAYMENT_SUCCESS "{\"event\":\"PAYMENT_SUCCESS\",\"message\":{\"id\":\"1\",\"orderId\":\"ORD123456789\",\"amount\":199.99,\"currency\":\"USD\",\"paymentMethod\":\"PAYPAL\",\"paymentStatus\":\"SUCCESS\",\"cardNumber\":null,\"cardExpiry\":null,\"cardCvv\":null,\"paypalEmail\":\"my@email.com\",\"bankAccount\":null,\"bankName\":null,\"transactionId\":\"TXN1742316764298\",\"retryCount\":0,\"createdAt\":\"2025-03-18T16:52:44.298336Z\",\"updatedAt\":\"2025-03-18T16:52:44.298336Z\"}}"
```
---

## 🔗 Related Repositories
For the Redis Publisher implementation, check out [Spring Boot Redis Publisher with Lettuce](https://github.com/yoanesber/Spring-Boot-Redis-Publisher-Lettuce).