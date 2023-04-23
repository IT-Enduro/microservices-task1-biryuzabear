FROM openjdk:17-jdk-slim
COPY build/libs/cinema-service-0.0.1.jar /app/cinema-service-0.0.1.jar
WORKDIR /app
EXPOSE 8060
CMD ["java", "-jar", "cinema-service-0.0.1.jar"]