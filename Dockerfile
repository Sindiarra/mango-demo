# Utiliser une image JDK pour construire
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copier et builder le projet (si Maven wrapper)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN ./mvnw dependency:go-offline

COPY src src
RUN ./mvnw clean package -DskipTests

# Étape d'exécution
FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

# Exposer le port de l'app Spring Boot
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
