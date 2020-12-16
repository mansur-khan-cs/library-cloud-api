FROM openjdk:8
EXPOSE 8080
ADD target/library-cloud-api.jar library-cloud-api.jar
ENTRYPOINT ["java", "-jar", "/library-cloud-api.jar"]