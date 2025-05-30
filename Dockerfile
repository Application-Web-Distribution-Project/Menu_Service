# Utilise l’image officielle OpenJDK 17 comme base
FROM openjdk:17-jdk-slim

# Répertoire de travail à l’intérieur du conteneur
WORKDIR /app

# Copie du fichier .jar généré (assure-toi de l'avoir compilé avec Maven)
COPY target/Menu-0.0.1-SNAPSHOT.jar /app/menu-service.jar

# Expose le port utilisé dans application.properties (8081)
EXPOSE 8081

# Commande pour lancer l’application Spring Boot
ENTRYPOINT ["java", "-jar", "/app/menu-service.jar"]
