package com.example.restservice.vehiclerate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleRateService {
    @Autowired
    private VehicleRateRepository repository;

    private VehicleRateService(VehicleRateRepository vehicleRateRepository) {
        this.repository = vehicleRateRepository;
    }

    public VehicleRate addRate(VehicleRate rate) {
        return repository.save(rate);
    }
}
