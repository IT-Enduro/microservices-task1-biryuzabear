FROM openjdk:17-jdk-slim
COPY build/libs/films-service-0.0.1.jar /app/films-service-0.0.1.jar
WORKDIR /app
EXPOSE 8070
CMD ["java", "-jar", "films-service-0.0.1.jar"]