# Imagem base para construção
FROM gradle:8.11.1-jdk21-alpine AS build

WORKDIR /app

COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

COPY src ./src

RUN chmod +x ./gradlew

RUN ./gradlew clean build -x test

FROM openjdk:21-slim

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]