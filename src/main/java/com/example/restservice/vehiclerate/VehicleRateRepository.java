package com.example.restservice.vehiclerate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleRateRepository extends JpaRepository<VehicleRate, Integer> {
    @Query(value = "SELECT AVG(CAST(VALUE AS DOUBLE)) from RATING where vehicle_id = ?1", nativeQuery = true)
    double getvehicleRateById(int id);
}
