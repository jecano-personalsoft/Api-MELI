# Api-MELI

Este proyecto fue generado con Spring Boot Framework en la versión 2.7.2.

## Requisitos:

1. Tener instalado Maven.
2. Tener instalado JAVA VM 8 o superior.
3. Poder hacer uso de GIT para descargar el repositorio.

Nota: se recomienda ejecutar el proyecto sobre linux toda vez que es más simple realizar las configuraciones y correr los procesos.

## Ejecución através de Linux Terminal mediante **bash**

> git clone https://github.com/jecano-personalsoft/Api-MELI.git <br>
> cd Api-MELI <br>
> chmod 777 install.sh <br>
> ./install.sh <br>

## Ejecución de la api dockerizada manualmente

- Compilar la app en docker:<br><br>
  > docker build -t "api-meli" .

- Ejecutar la app con Docker:<br><br>
  > docker run -p 8080:8080 api-meli

Nota: se debe eliminar manualmente el archivo logback-spring.xml en caso de que no se ejecute el fichero install.sh. Esto es debido a que al contenerizar la api, docker no es capáz de crear o encontrar el directorio de los logs y no fue posible configurarlo para que funcione sin problemas. La ruta donde se ubica es:
  > Api-MELI\src/main/resources/

## Librerías utilizadas

1. Lombok: ayuda a mejorar los tiempos de codificación ya que puede realizar muchos procesos de forma automática como por ejemplo, la creación de getters y setters que toman un poco de tiempo dependiendo del IDE. Además, al generar etters y setters garantizamos que no tendremos que estar cambiando los nombres cada vez que se actualice el nombre de una variable.

2. Logback: sirve para garantizar la trazabilidad del aplicativo generando logs.

## Consideraciones

- Se adiciona un postman collection con el fin de poder realizar consultas sobre lo desarrollado en la ruta:<br><br>

  > Api-MELI\src\main\resources\api-MELI.postman_collection.json

- Se adiciona un archivo con formato jmx (Apache JMetter) en el que se realizan pruebas de carga y consumo masivo en la ruta del proyecto:<br><br>

  > Api-MELI\src\main\resources\plan_pruebas.jmx
  
- Se adiciona la librería Lombok para trabajar de una manera más simplificada el tema de los getters y setters en las clases del proyecto. Además, se implementa el manejo de logs mediante el plugin de Logback haciendo uso de los decoradores de Lombok para agilizar el desarrollo.<br><br>

  Nota: el archivo de configuración de los logs se encuentra en:<br><br>
  
    > Api-MELI\src\main\resources\logback-spring.xml

- Se adiciona un archivo Dockerfile que contiene la información necesaria para ejecutar y dockerizar el proyecto api.<br><br>

  > Api-MELI\Dockerfile

- Se adiciona un archivo .sh que configura y ejecuta toda la aplicación. Además levanda el docker y ejecuta la imagen generada automáticamente.<br><br>

  > Api-MELI\install.sh

## Estructura de directorios

##### Estructura de la capa de código

Directorio raíz: Api-MELI/src/main/java

1. controllers:
  Contiene los controladores y la información del enrutamiento de los endpoints que ejecutarán los request desde el front end.
2. models:
  Contiene los modelos o DAO necesarios que se usan para emitir los datos cuando se devulve la respuesta hacia el front end.
3. services: 
  Capa de servicio de datos, contiene la interfaz de implementación de la capa de servicio de datos así como su implementación.
4. utiles:
  Herramientas de diferentes usos como constantes, variables globales, archivos de uso general (helpers), datos transversales, etc.

##### Estructura de la capa de recursos

Directorio raíz: Api-MELI/src/main/resources

1. Aquí se pueden colocar varios archivos de recursos estáticos como imagenes, archivos de configuración, plantillas, etc.

## Seguridad de la Api

- ¿Qué componentes usarías para securitizar tu API?<br><br>

  Existen varias alternativas. Sin embargo, una forma sencilla sería trabajar con sesiones cuando la aplicación tiene todo incluido como las vistas, controladores, servicios, etc. Por otro lado, al realizar microservicios o aplicaciones desacopladas entre sí; se podría utilizar mejor el método de Token Authentication, Oauth2 con JWT u otro servicio que incremente la seguridad como LDAP, SSO, entre otros.<br><br>
  
- ¿Cómo asegurarías tu API desde el ciclo de vida de desarrollo?<br><br>

  Para poder garantizar que un API sea perdurable durante su ciclo de vida, se debe partir por realizar una buena planificación y diseño de la misma toda vez que si esto no se realiza de manera adecuada; la API podría retirarse incluso antes de finalizar su desarrollo. Por otro lado, durante su fase de desarrollo es necesario que cuente con buenos estándares de codificación, pruebas y documentación. Esto último garantizará que la API sea sostenible durante mucho tiempo incluso por desarrolladores nuevos en el proyecto. Por último, es importante monitorear las APIs para garantizar que efectivamente se estén usando y así no generar sobrecostos o afectaciones de rendimiento.
