package com.mahika.shipmenttracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mahika.shipmenttracker.model.Shipment;
import com.mahika.shipmenttracker.service.ShipmentService;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {
    @Autowired
    private ShipmentService service;

    @PostMapping
    public Shipment create(@RequestBody Shipment s) {
        return service.createShipment(s);
    }

    @GetMapping
    public List<Shipment> getAll() {
        return service.getAllShipments();
    }
}
