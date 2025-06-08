package com.mahika.shipmenttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mahika.shipmenttracker.model.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {}
