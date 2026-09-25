FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests package
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ARG APP_COMMIT=local
ENV APP_COMMIT=${APP_COMMIT}
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]