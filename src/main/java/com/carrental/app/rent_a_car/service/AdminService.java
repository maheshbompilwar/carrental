package com.carrental.app.rent_a_car.service;

import com.carrental.app.rent_a_car.entity.AdminEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;

import java.util.List;

public interface AdminService {
    ResponseMessage createAdmin(AdminEntity adminEntity);

    List<AdminEntity> getAdmins();

    AdminEntity getAdmin(long id);

    ResponseMessage updateAdmin(AdminEntity adminEntity);

    ResponseMessage deleteAdmin(long id);

    ResponseMessage authenticate(AdminEntity adminEntity);
}
