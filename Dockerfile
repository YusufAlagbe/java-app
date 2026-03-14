FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/java-app-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar
EXPOSE 7000
CMD ["java", "-jar", "app.jar"]
