# Api-MELI

Este proyecto fue generado con Spring Boot Framework en la versión 2.7.2.

## Consideraciones

- Se adiciona un postman collection con el fin de poder realizar consultas sobre lo desarrollado en la ruta:

  > pi-random-backend-apirest\src\main\resources\api-MELI.postman_collection.json

- Se adiciona un archivo con formato jmx (Apache JMetter) en el que se realizan pruebas de carga y consumo masivo en la ruta del proyecto:

  > pi-random-backend-apirest\src\main\resources\plan_pruebas.jmx

## Seguridad de la Api

- ¿Qué componentes usarías para securitizar tu API?

  Existen varias alternativas. Sin embargo, una forma sencilla sería trabajar con sesiones cuando la aplicación tiene todo incluido como las vistas, controladores, servicios, etc. Por otro lado, al realizar microservicios o aplicaciones desacopladas entre sí; se podría utilizar mejor el método de Token Authentication, Oauth2 con JWT u otro servicio que incrementen la seguridad como LDAP, SSO, entre otros.