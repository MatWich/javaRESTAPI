package com.example.restservice.vehicle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")
public class VehicleController {
    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    /* GET */
    @GetMapping("/api/rating")
    public ResponseEntity<Double> getVehicleRate(@PathVariable int id)
    {
        double vehicleRate = vehicleService.getVehicleRate(id);
        return ResponseEntity.ok().build();     // czyli w sumie tylko kod 200
    }

    @GetMapping("/csv")
    public ResponseEntity<?> getCSVFile() {
        vehicleService.createCSVForVehicles();
        return ResponseEntity.ok().build();
    }

    /* POST */
    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle)
    {
        Vehicle newOne = vehicleService.addVehicle(vehicle);
        return ResponseEntity.ok().build(); // kod 201
    }

    /* DELETE */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeVehicle(@PathVariable int id)
    {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.ok().build();
    }


    /* MOZE COS DO 404? */

}
