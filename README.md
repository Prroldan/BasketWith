# BasketWith
Proyecto final de FCT con Kotlin, utilizando Spring Boot y Android.
---Realizado por: Pablo Rodríguez Roldán---

La primera versíon de la aplicación BasketWith se ha realizado
con un rol único, el rol de Usuario.

##DATOS DE PRUEBA 
Se podrán utilizar distintos usuarios para los datos de prueba:
  - Username: Usuario / Password: 1234
  - Username: Usuario2 / Password: 1234
  - Username: Usuario3 / Password: 1234



Esta es la primera versíon de esta aplicacón, teniendo en cuenta en siguientes actualizaciones
mejoras y nuevas funcionalidades de la misma.

Url de heroku: https://api-basketwith.herokuapp.com/ (Con fallo en la creación de la base de datos)

---DOCKER-COMPOSE---
version: '3.1'
services:
  db:
    container_name: basketwithdb
    image: postgres:9.5
    volumes:
        - basketwithdb:/var/lib/postgresql/data
    environment:
        - POSTGRES_PASSWORD=basketwith
        - POSTGRES_USER=basketwith
        - POSTGRES_DB=basket
        - PGDATA=/var/lib/postgresql/data/pgdata
    ports:
        - 5432:5432

volumes:
  basketwithdb: {}
   
##spring.datasource.url=postgres://localhost:5432/basket
##spring.datasource.username=basketwith
##spring.datasource.password=basketwith

