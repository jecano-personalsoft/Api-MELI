# Api-MELI

Este proyecto fue generado con Spring Boot Framework en la versión 2.7.2.

## Requisitos:

1. Tener instalado Maven.
2. Tener instalado JAVA VM 8 o superior.
3. Poder hacer uso de GIT para descargar el repositorio.

Nota: se recomienda ejecutar el proyecto sobre linux toda vez que es mas simple configurar y correr todas las parametrizaciones.

## Ejecución através de Linux Terminal

> git clone https://github.com/jecano-personalsoft/Api-MELI.git
> cd Api-MELI
> chmod 777 install.sh
> ./install.sh


Compilar la app en docker:
  > docker build -t "api-meli" .

Ejecutar la app con Docker:
  > docker run --env LOG_DIR=/opt/logs --env LOG_LEVEL=DEBUG -p 8080:8080 api-meli -d

## Consideraciones

- Se adiciona un postman collection con el fin de poder realizar consultas sobre lo desarrollado en la ruta:

  > pi-random-backend-apirest\src\main\resources\api-MELI.postman_collection.json

- Se adiciona un archivo con formato jmx (Apache JMetter) en el que se realizan pruebas de carga y consumo masivo en la ruta del proyecto:

  > pi-random-backend-apirest\src\main\resources\plan_pruebas.jmx
  
- Se adiciona la librería Lombok para trabajar de una manera más simplificada el tema de los getters y setters en las clases del proyecto. Además, se implementa el manejo de logs mediante el plugin de Logback haciendo uso de los decoradores de Lombok para agilizar el desarrollo.

  Nota: el archivo de configuración de los logs se encuentra en:
  
    > pi-random-backend-apirest\src\main\resources\logback-spring.xml

## Seguridad de la Api

- ¿Qué componentes usarías para securitizar tu API?

  Existen varias alternativas. Sin embargo, una forma sencilla sería trabajar con sesiones cuando la aplicación tiene todo incluido como las vistas, controladores, servicios, etc. Por otro lado, al realizar microservicios o aplicaciones desacopladas entre sí; se podría utilizar mejor el método de Token Authentication, Oauth2 con JWT u otro servicio que incrementen la seguridad como LDAP, SSO, entre otros.