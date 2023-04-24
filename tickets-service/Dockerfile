FROM openjdk:17-jdk-slim
COPY build/libs/tickets-service-0.0.1.jar /app/tickets-service-0.0.1.jar
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "tickets-service-0.0.1.jar"]