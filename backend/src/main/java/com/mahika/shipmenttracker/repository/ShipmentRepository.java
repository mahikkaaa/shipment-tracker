//Package declaration.
package com.mahika.shipmenttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository; //interface that provides basic CRUD Operations
import com.mahika.shipmenttracker.model.Shipment; //the model/entity we are persisting, as in Shipment is used as a class (i.e. entity type) in ShipmentRepository.java and it tells Spring Data JPA that this repository is for managing Shipment entities which are saved in the database 

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {} //This creates a repository with ready-to-use methods like: save(), findAll(), findById(), deleteById() all without writing actual SQL
// shipmentRepository.findAll();        // Get all shipments
// shipmentRepository.save(shipment);  // Save a new shipment
// shipmentRepository.findById(1L);     // Find shipment with ID = 1


//ShipmentRepository is a special interface that gives us CRUD operations for the Shipment table, where the primary key is a Long.

//Where is the Database - In ShipmentRepository.java we are interacting with a database but the database itself is not visible directly in Java code
//The actual databse is running as a separate service on the local machine(localhost), on a server or inside a docker container, connected to the application through application configuration file (application.properties)
//Through configuration in application.properties the Java app knows where the database is (for spring boot apps)
//Example
//application.properties
//spring.datasource.url=jdbc:mysql://localhost:3306/shipment_db
//spring.datasource.username=root
//spring.datasource.password=password

//This tells your app: Use MySQL, Connect to a database named shipment_db, Use username root and password password

//What does the ShipmentRepository.java do?
//ShipmentRepository is usually an interface that talks to the database behind the scenes using JPA or Hibernate (Java frameworks).
//public interface ShipmentRepository extends JpaRepository<Shipment, Long> {}
//It connects the Shipment class (your Entity) to a table in the database. It lets you run queries like findById, save, delete, etc., without writing SQL yourself.


//Where is the actual data stored?
//In a physical database system like MySQL/PostgreSQL. The Shipment class represents a table (usually named shipment).
//The fields in the class (id, trackingId, etc.) are the columns in that table. So if you run shipmentRepository.save(shipment), it’s inserting a row into your shipment table.


//Database Testing
//Use the H2 In-Memory Database (for quick testing)
//H2 is an in-memory database (nothing gets saved after you stop the app). Your app connects to it when it starts. Spring Boot auto-creates tables based on your @Entity classes like Shipment.

//To view H2 database in the browser
//run the springboot app - mvn spring-boot:run
//Open the browser and go to - http://localhost:8080/h2-console
//Use the following settings (JDBC URL: jdbc:h2:mem:testdb, User Name: sa, Password: (leave empty), Click “Connect”)
//To see table - SELECT * FROM SHIPMENT;