package com.carrental.app.rent_a_car.service.serviceImpl;

import com.carrental.app.rent_a_car.entity.AdminEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.repository.AdminRepository;
import com.carrental.app.rent_a_car.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public ResponseMessage createAdmin(AdminEntity adminEntity) {
        adminRepository.save(adminEntity);
        return new ResponseMessage("Record Added Successfully...", true);
    }

    @Override
    public List<AdminEntity> getAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public AdminEntity getAdmin(long id) {
        return adminRepository.findAdminEntityById(id);
    }

    @Override
    public ResponseMessage updateAdmin(AdminEntity adminEntity) {
        if (adminRepository.findAdminEntityById(adminEntity.getId()) == null)
            throw new RuntimeException("Record Not Available...");
        adminRepository.save(adminEntity);
        return new ResponseMessage("Record Updated Successfully...", true);
    }

    @Override
    public ResponseMessage deleteAdmin(long id) {
        if (adminRepository.findAdminEntityById(id) == null)
            throw new RuntimeException("Record Not Available...");
        adminRepository.deleteById(id);
        return new ResponseMessage("Record Deleted Successfully...", true);
    }

    @Override
    public ResponseMessage authenticate(AdminEntity adminEntity) {
        AdminEntity storedAdmin = adminRepository.findAdminEntityByUserName(adminEntity.getUserName());
        if (storedAdmin != null && storedAdmin.getPassword().equals(adminEntity.getPassword())) {
            return new ResponseMessage("Authenticated Successfully...", true);
        } else
            return new ResponseMessage("Authentication Failure...", false);
    }
}
