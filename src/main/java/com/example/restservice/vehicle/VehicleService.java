package com.example.restservice.vehicle;

import com.example.restservice.vehiclerate.VehicleRateRepository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private VehicleRepository vehRepository;
    private VehicleRateRepository rateRepository;

    /* POST */
    public Vehicle addVehicle(Vehicle vehicle)
    {
        return vehRepository.save(vehicle);
    }

    /* DELETE */
    public void deleteVehicle(int id)
    {
        Vehicle toRemove = vehRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("nie ma takiego szamochodu"));
        vehRepository.delete(toRemove);
    }

    /* GET */
    public double getVehicleRate(int id) {
        Vehicle vehicle = vehRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Nie ma takiego szamochodu"));

        double rate = rateRepository.getvehicleRateById(id);
        return BigDecimal.valueOf(rate).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }

    public void createCSVForVehicles() {
        List<Vehicle> vehicles = vehRepository.findAll();
        File csv = new File("vehicles.csv");

        try {
            FileOutputStream fos = new FileOutputStream(csv);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            List<String> strings = vehicles.stream().map(vehicle -> vehicle.toString()).collect(Collectors.toList());

            strings.stream().forEach(veh -> {
                try {
                    bw.write(veh);
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bw.close();
            // jakis colapse tutaj kliknalem i znkl jeden z catchow
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
