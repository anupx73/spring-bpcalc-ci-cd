# syntax=docker/dockerfile:1

#FROM eclipse-temurin:17-jdk-jammy
FROM maven:3.8.3-openjdk-17

WORKDIR /app

COPY .mvn/ .mvn
COPY pom.xml ./
RUN mvn dependency:resolve

COPY src ./src

CMD ["mvn", "spring-boot:run"]