//Package declaration - the folder where all service-layer code goes
package com.mahika.shipmenttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
//In spring, a bean is just an object that is managed by the Spring IoC (Inversion of control) container. It takes care of creating the object, injecting dependencies (@Autowired) into it and controlling its lifecycle
import org.springframework.stereotype.Service; //Java file using the @Service annotation comes from Spring’s library specifically from org.springframework.stereotype.
import com.mahika.shipmenttracker.model.Shipment;
import com.mahika.shipmenttracker.repository.ShipmentRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShipmentService { //Marks the class as a service layer responsible for business logic
    @Autowired
    private ShipmentRepository repo; //Injects the repository so you can access DB operations

    public Shipment createShipment(Shipment s) { //Business logic for creating a shipment
        s.setCreatedDate(LocalDate.now()); //Sets creation date to now
        s.setStatus("InTransit"); //Sets status to "InTransit"
        return repo.save(s); //saves to db
    }

    public List<Shipment> getAllShipments() {
        return repo.findAll(); //Fetches all shipments from DB.
    }
}



//using of @Service
//Declares that this class is part of the service layer in my application. Please manage it as a bean so I can inject and use it wherever I need
// It marks the class as a Spring bean (object that Spring creates and manages).

// It's part of the layered architecture:
// @Controller → For handling HTTP requests
// @Service → For business logic
// @Repository → For database interaction

