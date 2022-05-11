FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/MiniProjet-1.0.jar MiniProjet-1.0.jar
ENTRYPOINT ["java","-jar","/MiniProjet-1.0.jar"]
