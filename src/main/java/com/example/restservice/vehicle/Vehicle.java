package com.example.restservice.vehicle;

import com.example.restservice.carshowroom.CarShowRoom;
import com.example.restservice.vehiclerate.VehicleRate;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Vehicle", schema = "cars")
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;
    private String name;
    private double price = 0.0;
    @Column(name = "prod_year")
    private int prod_year = 1999;
    @Column(name = "eng_capacity")
    private double eng_capacity = 0.0;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "vehicle")
    private Collection<VehicleRate> vehicleRate = new ArrayList<VehicleRate>();

    @ManyToOne
    @JoinColumn(name = "csid")
    @JsonBackReference
    private CarShowRoom carShowRoom;

    /*
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "vehicle")
    private List<VehicleRate> vehicleRates;
    */


    public Vehicle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProd_year() {
        return prod_year;
    }

    public void setProd_year(int prod_year) {
        this.prod_year = prod_year;
    }

    public double getEng_capacity() {
        return eng_capacity;
    }

    public void setEng_capacity(double eng_capacity) {
        this.eng_capacity = eng_capacity;
    }

    public Collection<VehicleRate> getVehicleRate() {
        return vehicleRate;
    }

    public void setVehicleRate(Collection<VehicleRate> vehicleRate) {
        this.vehicleRate = vehicleRate;
    }

    public CarShowRoom getCarShowRoom() {
        return carShowRoom;
    }

    public void setCarShowRoom(CarShowRoom carShowRoom) {
        this.carShowRoom = carShowRoom;
    }

}
