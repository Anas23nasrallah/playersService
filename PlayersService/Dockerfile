FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/playersservice-0.0.1-SNAPSHOT.jar playersservice.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "playersservice.jar"]