# cash_online
## Tecnologías utilizadas

![Java version](https://img.shields.io/badge/java-11-yellow)
![Springboot](https://img.shields.io/badge/springboot-MVC-blueviolet)
![Springboot2](https://img.shields.io/badge/springboot-JPA-brightgreen)
![Database1](https://img.shields.io/badge/BDD-MySQL-blue)
![Database1](https://img.shields.io/badge/BDD-FlyWay-violet)
![ORM](https://img.shields.io/badge/ORM-Hibernate-green)
![Testing1](https://img.shields.io/badge/Tests-JUnit5-orange)
![Testing2](https://img.shields.io/badge/Tests-Mockito-red)


Challenge para entrevista de cash-online. Servicio simple, con operaciones CRUD de usuarios y préstamos. 
Para más información ver archivo `src/main/resources/consigna.doc`.
La base de datos se popula inicialmente con Flyway mediante los scripts que se encuentran en la ruta `src/main/resources/db` creando:
* El schema.
* Tablas `users` y `loan`.
* Dos usuarios y tres loan para cada uno.

## Requisitos

Antes de empezar, asegurate de cumplir los siguientes requisitos:

* Tener instalado `Java 11`
* Tener instalado `Apache Maven` en la computadora con OS `Windows/Linux/Mac`.
* Utilizar un IDE que permita importar proyectos Maven.
* Tener instalado `MySQL`.

## Setup cash-online

Para correr el proyecto localmente:

* Asegurarse que Sql server esta corriendo.
* Verificar que la version activa de java sea 11.
* Importar el proyecto en el IDE de elección como proyecto Maven.
* Ejecutar el siguiente comando para compilar desde cero:
```
mvn clean install
```
* Listo! Ya podes darle play y probar las APIs