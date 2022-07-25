chmod -R 777 ../Api-MELI/
chown -R $USER:`id -gn` ../Api-MELI/
mkdir -p /springBoot/api_meli/config/
mv ./src/main/resources/logback-spring.xml /springBoot/api_meli/config/
chmod -R 777 /springBoot/api_meli/config/
chown -R $USER:`id -gn` /springBoot/api_meli/config/
mvn clean
mvn install
docker build -t "api-meli" .
docker run --env LOG_DIR=/logs/api_meli --env LOG_LEVEL=DEBUG -p 8080:8080 api-meli