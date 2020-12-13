package com.example.restservice.carshowroom;

import com.example.restservice.vehicle.Vehicle;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/fulfilment")
public class CarShowroomController {
    private CarShowRoomService carShowRoomService;

    @GetMapping
    public ResponseEntity<List<CarShowRoom>> getAllShowrooms() {
        List<CarShowRoom> allCarShowrooms = carShowRoomService.getAllCarShowrooms();
        return ResponseEntity.ok(allCarShowrooms);
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<Vehicle>> getVehiclesFromShowroom(@PathVariable int id)
    {
        List<Vehicle> vehicles = carShowRoomService.getAllCarsForShowroom(id);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{id}/fill")
    public ResponseEntity<Double> getPercentage(@PathVariable int id)
    {
        double percentage = carShowRoomService.getPercentage(id);
        return ResponseEntity.ok(percentage);
    }

    @PostMapping
    public ResponseEntity<CarShowRoom> addCarShowroom(@RequestBody CarShowRoom carShowRoom)
    {
        CarShowRoom newOne = carShowRoomService.addCarShowroom(carShowRoom);
        return ResponseEntity.created(URI.create("/" + newOne.getCsid())).body(newOne);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeCarShowroom(@PathVariable int id)
    {
        carShowRoomService.deleteCarShowroom(id);
        return ResponseEntity.noContent().build();
    }

    /* TU TEZ BY BYLO FAJNIE JAKIS ERROR HANDLER */
}
