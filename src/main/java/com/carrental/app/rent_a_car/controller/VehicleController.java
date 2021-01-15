package com.carrental.app.rent_a_car.controller;

import com.carrental.app.rent_a_car.entity.VehicleEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle/")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping(value = "")
    public String welcome() {
        return "Welcome to vehicle ...";
    }

    @PostMapping(value = "createVehicle")
    public ResponseMessage createVehicle(@RequestBody VehicleEntity vehicleEntity) {
        return vehicleService.createVehicle(vehicleEntity);
    }

    @GetMapping(value = "getVehicles")
    public List<VehicleEntity> getVehicles() {
        return vehicleService.getVehicles();
    }

    @GetMapping(value = "getVehicle/{id}")
    public VehicleEntity getVehicle(@PathVariable long id) {
        return vehicleService.getVehicle(id);
    }

    @PostMapping(value = "updateVehicle")
    public ResponseMessage updateVehicle(@RequestBody VehicleEntity vehicleDto) {
        return vehicleService.updateVehicle(vehicleDto);
    }

    @GetMapping(value = "deleteVehicle/{id}")
    public ResponseMessage deleteVehicle(@PathVariable long id) {
        return vehicleService.deleteVehicle(id);
    }
}
