# ---- Build Stage ----
FROM eclipse-temurin:17-jdk AS build
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/app.jar

# ---- Runtime Stage using distroless ----
FROM gcr.io/distroless/java17-debian11
COPY --from=build /app/app.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
