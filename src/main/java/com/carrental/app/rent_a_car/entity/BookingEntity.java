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
@Table(name = "BOOKING")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long bookingNumber;
    private String userEmail;
    private long vehicleId;
    private Timestamp fromDate;
    private Timestamp toDate;
    private String message;
    private boolean status;
    private Timestamp postingDate;
    private Timestamp lastUpdateDate;
}
