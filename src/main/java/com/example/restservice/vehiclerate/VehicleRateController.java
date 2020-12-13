package com.example.restservice.vehiclerate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("api/rating")
public class VehicleRateController {
    private VehicleRateService vehicleRateService;

    public VehicleRateController(VehicleRateService vehicleRateService) {
        this.vehicleRateService = vehicleRateService;
    }

    @PostMapping
    public ResponseEntity<VehicleRate> createVehicleRate(@RequestBody VehicleRate rate)
    {
        VehicleRate newOne = vehicleRateService.addRate(rate);
        return ResponseEntity.created(URI.create("/" + newOne.getId())).body(newOne);
    }
}
