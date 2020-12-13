package com.example.restservice.carshowroom;

import com.example.restservice.vehicle.Vehicle;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "CarShowRoom")
@Getter
public class CarShowRoom implements Serializable {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int csid;
    private String name;
    private int maximumVehicleNumber;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "carShowRoom")
    private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();


    public CarShowRoom(String name, int maximumVehicleNumber) {
        this.name = name;
        this.maximumVehicleNumber = maximumVehicleNumber;
    }

    public CarShowRoom() {
    }

    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaximumVehicleNumber() {
        return maximumVehicleNumber;
    }

    public void setMaximumVehicleNumber(int maximumVehicleNumber) {
        this.maximumVehicleNumber = maximumVehicleNumber;
    }

    public Collection<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Collection<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }
}
