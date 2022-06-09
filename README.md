### Spring Cloud Microservice Project
Example microservice project with spring cloud ecosystem.

### Tech
- Java 11
- Docker
- Maven
- Spring Boot (Rest API, JPA)
- Spring Cloud Hoxton
- Spring Cloud Config Server
- Spring Cloud Gateway For Gateway Server
- Spring Cloud Zipkin To Trace Api Calls
- Spring Boot Admin For Tracing Services
- Hystrix For Circuit Breaker
- Eureka Server For Service Discovery
- Feign Client For Rest Communication Over Eureka
- MySQL For Storing Orders
- Cassandra For Account Service
- Elasticsearch For Searching Orders
- RabbitMQ To Inform Order Service When New Order Placed
- Fabric8 For Containerization / Dockerize Services
- Order Service Developed By DDD Hexagonal Architecture Perspective

### Services
- Account Service - for creating new users and getting users details
- Admin Server - can be trace all service activities including heap space
- Config Server - services read their configuration over config server
- Client Service - it is responsible from sending rest request over Feign Client
- Discovery Service - for service communication with eureka
- Gateway Server - it handles all request and redirects to internal services also it has Circuit Breaker Pattern
- Main Service - it just main application for keeping common dependencies and extending them for submodules
- Notification Service - message queue service with rabbitmq it handles new orders
- Order Service - responsible from orders and in this service I used DDD hexagonal architecture

### Default Service Links If You Want To Run On Your IDE
 - Spring Boot Admin - http://localhost:9000/wallboard
 - RabbitMQ - http://localhost:15672
 - Elasticsearch - http://localhost:9200
 - Eureka Server - http://localhost:8761
 - Zipkin - http://localhost:9411/zipkin/
 - Gateway - http://localhost:8088

### License

This project is licensed under the MIT License.

### Author

[Ali Arslan](https://aliarslan.blogkafem.net/)