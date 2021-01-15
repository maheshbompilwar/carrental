package com.carrental.app.rent_a_car.service;

import com.carrental.app.rent_a_car.entity.VehicleEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;

import java.util.List;

public interface VehicleService {
    ResponseMessage createVehicle(VehicleEntity vehicleDto);

    List<VehicleEntity> getVehicles();

    VehicleEntity getVehicle(long id);

    ResponseMessage updateVehicle(VehicleEntity vehicleDto);

    ResponseMessage deleteVehicle(long id);
}
