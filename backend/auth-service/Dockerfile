FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY target/auth-service-1.0.0.jar auth-service.jar


ENTRYPOINT ["java", "-jar", "auth-service.jar"]
