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
@Table(name = "USER")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fullName;
    private String emailId;
    private String username;
    private String password;
    private String contactNo;
    private Timestamp dob;
    private String address;
    private String city;
    private String country;
    private Timestamp regDate;
    private Timestamp updateDate;
    private String role;
}
