FROM eclipse-temurin:17-jdk

VOLUME /tmp
COPY target/collaboration-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
