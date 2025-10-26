# 1. Image de base : Java 21 JDK
FROM eclipse-temurin:21-jdk

# 2. Définir le répertoire de travail dans le conteneur
WORKDIR /app

# 3. Copier le JAR compilé depuis target/ vers /app/
COPY target/*.jar app.jar

# 4. Indiquer que l'application écoute sur le port 8080
EXPOSE 8080

# 5. Commande pour lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]