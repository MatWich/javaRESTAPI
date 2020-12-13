package com.example.restservice.carshowroom;

import com.example.restservice.vehicle.Vehicle;
import com.example.restservice.vehicle.VehicleRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class CarShowRoomService {
    private CarShowRoomRepository showRoomRepository;
    private VehicleRepository vehicleRepository;


    /* GET */
    public List<CarShowRoom> getAllCarShowrooms()
    {
        return showRoomRepository.findAll();
    }

    /* POST */
    public CarShowRoom addCarShowroom(CarShowRoom cs)
    {
        return showRoomRepository.save(cs);
    }

    public void deleteCarShowroom(int id)
    {
        CarShowRoom toRemove = showRoomRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Nie ma takiego salonu"));
        showRoomRepository.delete(toRemove);
    }

    public List<Vehicle> getAllCarsForShowroom(int id)
    {
        CarShowRoom carShowRoom = showRoomRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("nie ma takiego salonu"));
        return vehicleRepository.findAllByShowroomId(id);
    }

    public double getPercentage(int id)
    {
        CarShowRoom carShowRoom = showRoomRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("nie ma takiego salonu :("));
        List<Vehicle> vehicles = vehicleRepository.findAllByShowroomId(id);
        double percentageFill = (vehicles.size() / carShowRoom.getMaximumVehicleNumber()) * 100;

        return BigDecimal.valueOf(percentageFill).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }


}
