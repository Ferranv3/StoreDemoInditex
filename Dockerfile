FROM maven:3.6.3-openjdk-17-slim as builder
WORKDIR /app
COPY . .
RUN mvn clean package

FROM openjdk:17-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
