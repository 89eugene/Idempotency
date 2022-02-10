FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} billing.jar
ENTRYPOINT ["java","-jar","/billing.jar"]

