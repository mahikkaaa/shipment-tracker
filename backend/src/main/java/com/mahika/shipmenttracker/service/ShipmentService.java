package com.mahika.shipmenttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mahika.shipmenttracker.model.Shipment;
import com.mahika.shipmenttracker.repository.ShipmentRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShipmentService {
    @Autowired
    private ShipmentRepository repo;

    public Shipment createShipment(Shipment s) {
        s.setCreatedDate(LocalDate.now());
        s.setStatus("InTransit");
        return repo.save(s);
    }

    public List<Shipment> getAllShipments() {
        return repo.findAll();
    }
}
