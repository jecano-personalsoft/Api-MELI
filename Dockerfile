FROM eclipse-temurin:8
MAINTAINER jecano@personalsoft.com
RUN adduser --system --group springApp
USER springApp:springApp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINt ["java", "-jar", "/app.jar"] 
