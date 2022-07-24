chmod -R 775 ../Api-MELI/
chown -R $USER:`id -gn` ../Api-MELI/
mvn install
docker build -t "api-meli" .
docker run -p 8080:8080 api-meli
