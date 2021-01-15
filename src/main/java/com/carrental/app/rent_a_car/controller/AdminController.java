package com.carrental.app.rent_a_car.controller;

import com.carrental.app.rent_a_car.entity.AdminEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping(value = "")
    public String welcome() {
        return "Welcome to admin ...";
    }

    @PostMapping(value = "authenticate")
    public ResponseMessage authenticate(@RequestBody AdminEntity adminEntity) {
        return adminService.authenticate(adminEntity);
    }

    @PostMapping(value = "createAdmin")
    public ResponseMessage createUser(@RequestBody AdminEntity adminEntity) {
        return adminService.createAdmin(adminEntity);
    }

    @GetMapping(value = "getAdmins")
    public List<AdminEntity> getAdmins() {
        return adminService.getAdmins();
    }

    @GetMapping(value = "getAdmin/{id}")
    public AdminEntity getAdmin(@PathVariable long id) {
        return adminService.getAdmin(id);
    }

    @PostMapping(value = "updateAdmin")
    public ResponseMessage updateAdmin(@RequestBody AdminEntity adminEntity) {
        return adminService.updateAdmin(adminEntity);
    }

    @GetMapping(value = "deleteAdmin/{id}")
    public ResponseMessage deleteAdmin(@PathVariable long id) {
        return adminService.deleteAdmin(id);
    }
}
