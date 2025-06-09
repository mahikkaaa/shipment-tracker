//this defines the package and helps organize the class in a logical namespace
package com.mahika.shipmenttracker.model;

import jakarta.persistence.*; //required for JPA Annotations (@Entity, @Id, etc)
import java.time.LocalDate; //represents date without time

//JPA - Java Persistence API - set of rules(a specification) in Java to map java objects (classes) to database tables. It allows us to save Java objects into a database, read/update/delete them without writing sql manually
//To use JPA, we need to annotate the class with @Entity, create a repository interface and JPA + Spring Boot does the rest like inserting into DB, querying etc
//So to insert we just have to write shipmentRepository.save(new Shipment("ABC123")); instead of INSERT INTO Shipment (tracking_id) VALUES ("ABC123");

@Entity //marks this class as a JPA Entity so it maps to a table in my database
public class Shipment {
    @Id //Primary key of the database
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increments Id
    private Long id;

    private String trackingId; //unique shipment identifier 
    private String status; // e.g., InTransit, Delivered, Failed
    private LocalDate createdDate; //when the shipment was created 

    // Getters & Setters - allow the access and modification of private fields (encapsulation in OOPs)
    public Long getId() { return id; } // called when someone wants to read the ID of a shipment object (Long shipmentId = Shipment.getId();)
    public void setId(Long id) { this.id = id; } //called when you want to assign an ID to the object manually, though usually it's auto-generated (shipment.setId(1L);)

    public String getTrackingId() { return trackingId; } //Returns the current tracking ID value.
    public void setTrackingId(String trackingId) { this.trackingId = trackingId; } //Sets the tracking ID (shipment.setTrackingId("ABC123");)

    public String getStatus() { return status; } //returns the current status of the shipment
    public void setStatus(String status) { this.status = status; } //sets the status (shipment.setStatus("Delivered");)

    public LocalDate getCreatedDate() { return createdDate; } //returns the creation date
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; } //sets the creation date (shipment.setCreatedDate(LocalDate.now());)
}

//Why JPA is useful in the project: 
//In the shipment tracker backend: Shipment.java is an entity AND ShipmentRepository is a JPA repository, So we get full database interaction with zero SQL writing

//JPA vs Hibernate
//JPA = Specification (interface, rules)
//Hibernate = Most common implementation of JPA
//So when we use Spring Boot with JPA, we're usually using: Spring Data JPA + Hibernate behind the scenes