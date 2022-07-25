FROM eclipse-temurin:8
RUN adduser --system --group springApp
USER springApp:springApp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /springBoot/api_meli/api_meli.jar
ENTRYPOINT java -jar -Dlogback.configurationFile=/springBoot/api_meli/config/logback-spring.xml /springBoot/api_meli/api_meli.jar
VOLUME /springBoot/api_meli/config