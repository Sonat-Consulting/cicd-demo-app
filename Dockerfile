FROM openjdk:8-jdk-alpine

ARG ARTIFACT

COPY ${ARTIFACT} app2.jar

ENTRYPOINT ["java", "-jar", "/app2.jar"]
