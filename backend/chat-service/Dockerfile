FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY target/chat-service-0.0.1-SNAPSHOT.jar chat-service.jar

ENTRYPOINT ["java", "-jar", "chat-service.jar"]
