# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY .mvn/ .mvn
COPY pom.xml ./
RUN mvn dependency:resolve

COPY src ./src

CMD ["mvn", "spring-boot:run"]