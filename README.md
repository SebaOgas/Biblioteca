# Trabajo Práctico de API REST sin paginación

Alumno: Sebastián Andrés Ogás (legajo N.° 48867)

Universidad Tecnológica Nacional - Facultad Regional Mendoza

Cátedra: Desarrollo de Software
 
## Descripción

Este proyecto fue desarrollado utilizando Java con Spring Boot, con la base de datos H2.

Puede ser probado en Render creando un WebService, y conectándose al mismo mediante una herramienta como Postman.

También puede ser descargado y ejecutado localmente, así pudiendo acceder a la [consola de H2](http://localhost:8084/h2-console/) y a [Swagger](http://localhost:8084/swagger-ui/index.html), utilizando el puerto 8084.

Se provee un [archivo](biblioteca.postman_collection.json) collection de Postman, con un ejemplo de request por cada uno de los servicios.
Además, contiene una carpeta llamada "Carga de Ejemplo" que, de ser ejecutada teniendo la base de datos vacía, creará algunas filas en todas las tablas para demostrar más fácilmente el funcionamiento.

La collection de Postman tiene además una variable llamada _url_, que puede ser modificada según dónde se hostee el servidor (si se ejecuta localmente, podría ser ```http://localhost:8084```, o un enlace a Render si se utiliza este sitio web).