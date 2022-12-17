# Trips con Spring Boot

Se desarrolla un Backend para venta de boletos de autobus utilizando Spring Boot Y las dependencias Spring Web, Spring JPA, MySQL Driver, Lombok y Slf4j.

### Especificaciones
Se tienen terminales en diferentes estados de la República, las cuales son origen y destino de los viajes. Cada terminal tiene adscritos un conjunto de autobuses y uno de conductores, los cuales son asignados a cada viaje según su disponibilidad y de manera independiente unos de otros. Los viajes son programados con origen, destino, fecha y hora de salida. El precio del boleto se establece al programar el viaje (dependiendo de diferentes factores). Todos los autobuses tienen cuarenta asientos y se clasifican en las clases primera, segunda y tercera; otras características importantes que se deben tomar en cuenta son la matrícula del autobús y su estado mecánico (operativo o en mantenimiento). Los clientes deben registrarse con: nombre completo, domicilio, correo electrónico y telefono. Cuando el cliente compra un vije selecciona un asiento. Para cada viaje de ida, hay uno de regreso con el mismo autobús y el mismo conductor. El usuario "administrador" tiene acceso y puede modificar todas las tablas (operaciones CRUD), los usuario "cliente" pueden leer "viajes", crear-leer-actualizar su propia información en "clientes" y crear-leer "boletos" (no puede hacer cancelaciones ni cambios).

![tripsSpringBootDBdeer.png](./imgs/tripsSpringBootDBdeer.png)

### Desarrollo

1. Se crea un proyecto Spring Boot con las dependencias Spring Web, Spring JPA y MySQL Driver.
2. Se configura el acceso a la base de datos (previamente creada) en application.properties.
3. Se crean las entidades en com.trips.tripsspringboot.entity y se verifica que se se crean las tablas en la base de datos (previamente creada).
4. Se crean las interfaces que "extends" de JpaRepository para poder hacer las consultas. Se crean en com.trips.tripsspringboot.repository.
5. Se crea un seeder en com.trips.tripsspringboot.config para insertar datos en las tablas, con ayuda de las interfaces en repository.
6. Se crean controladores en com.trips.tripsspringboot.controller para los "end points" del api. Los controladores se comunican con los servicios (interfaces y sus implementaciones) y estos con los repositorios (interfaces).

### Compilación-Construcción-Ejecución
Para compilar y ejecutar en desarrollo:
~~~
mvn clean   //opcional
mvn spring-boot:run
~~~

Para compilar y construir un archivo jar:
~~~
mvn clean   //recomendado
mvn package
~~~

Para ejecutar el jar
~~~
java -jar ./target/tripsSpringBoot-0.0.1-SNAPSHOT.jar
~~~

Como administrador, se puede acceder a los siguientes end points:

GET
~~~
http://localhost:8080/clientes
http://localhost:8080/clientes/{id}
http://localhost:8080/terminales
http://localhost:8080/terminales/{id}
~~~

POST
~~~
http://localhost:8080/clientes
http://localhost:8080/terminales
~~~

PUT, DELETE
~~~
http://localhost:8080/clientes/{id}
http://localhost:8080/terminales/{id}
~~~

