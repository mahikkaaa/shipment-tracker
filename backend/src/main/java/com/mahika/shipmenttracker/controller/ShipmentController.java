package com.mahika.shipmenttracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // imports several key Spring Web annotations used to build RESTful APIs. It’s a Spring framework package that contains annotations for: creating REST controllers, handling HTTP requests, mapping URL paths, managing request/response data
import com.mahika.shipmenttracker.model.Shipment;
import com.mahika.shipmenttracker.service.ShipmentService;

import java.util.List;

@RestController //Combines @Controller and @ResponseBody to return JSON
@RequestMapping("/api/shipments") //Base URL for all shipment APIs
public class ShipmentController {
    @Autowired
    private ShipmentService service; //injects the service so controller can call the business logic 

    @PostMapping //POST Endpoint
    public Shipment create(@RequestBody Shipment s) { //Accepts JSON shipment object in request body and Calls createShipment() in service.
        return service.createShipment(s); //returnd the saved shipment as a response
    }

    @GetMapping //GET Endpoint
    public List<Shipment> getAll() {
        return service.getAllShipments(); //Returns a list of all shipments in the DB.
    }
}



// Common REST Annotations

// - @RestController
// Marks a class as a controller where every method returns a JSON/XML response.
// → Used instead of @Controller + @ResponseBody.

// - @RequestMapping
// Maps HTTP requests to specific handler methods.

// - @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
// Shortcut annotations for different HTTP request methods.

// - @PathVariable
// Used to extract variables from the URL path (like /shipment/{id}).

// - @RequestBody
// Binds the incoming request JSON body to a Java object.