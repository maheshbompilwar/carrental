package com.carrental.app.rent_a_car.controller;

import com.carrental.app.rent_a_car.entity.UserEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "")
    public String welcome() {
        return "Welcome to user ...";
    }

    @PostMapping(value = "createUser")
    public ResponseMessage createUser(@RequestBody UserEntity userEntity) {
        return userService.createUser(userEntity);
    }

    @GetMapping(value = "getUsers")
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(value = "getUser/{id}")
    public UserEntity getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @PostMapping(value = "updateUser")
    public ResponseMessage updateUser(@RequestBody UserEntity userEntity) {
        return userService.updateUser(userEntity);
    }

    @GetMapping(value = "deleteUser/{id}")
    public ResponseMessage deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }
}
