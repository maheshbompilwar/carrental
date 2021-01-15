package com.carrental.app.rent_a_car.service.serviceImpl;

import com.carrental.app.rent_a_car.entity.VehicleEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.repository.VehicleRepository;
import com.carrental.app.rent_a_car.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public ResponseMessage createVehicle(VehicleEntity vehicleEntity) {
        vehicleRepository.save(vehicleEntity);
        return new ResponseMessage("Record Added Successfully...", true);
    }

    @Override
    public List<VehicleEntity> getVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public VehicleEntity getVehicle(long id) {
        return vehicleRepository.findVehicleEntityById(id);
    }

    @Override
    public ResponseMessage updateVehicle(VehicleEntity vehicleEntity) {

        if (vehicleRepository.findVehicleEntityById(vehicleEntity.getId()) == null)
            throw new RuntimeException("Record Not Available...");

       vehicleRepository.save(vehicleEntity);
        return new ResponseMessage("Record Added Successfully...", true);
    }

    @Override
    public ResponseMessage deleteVehicle(long id) {
        if (vehicleRepository.findVehicleEntityById(id) == null)
            throw new RuntimeException("Record Not Available...");
        vehicleRepository.deleteById(id);
        return new ResponseMessage("Record Deleted Successfully...", true);
    }
}
