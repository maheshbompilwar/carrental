package com.carrental.app.rent_a_car.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "VEHICLE_DETAILS")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String vehicleTitle;
    private String vehiclesBrand;
    private String vehicleOverview;
    private double pricePerDay;
    private String fuelType;
    private int modelYear;
    private int seatingCapacity;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;
    private boolean airConditioner;
    private boolean powerDoorLocks;
    private boolean antiLockBrakingSystem;
    private boolean brakeAssist;
    private boolean powerSteering;
    private boolean driverAirbag;
    private boolean passengerAirbag;
    private boolean powerWindows;
    private boolean cdPlayer;
    private boolean centralLocking;
    private boolean crashSensor;
    private boolean leatherSeats;
    private Timestamp regDate;
    private Timestamp updateDate;
}
