package com.carrental.app.rent_a_car.service;

import com.carrental.app.rent_a_car.entity.UserEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    ResponseMessage createUser(UserEntity userDto);

    List<UserEntity> getUsers();

    UserEntity getUser(long id);

    ResponseMessage updateUser(UserEntity userEntity);

    ResponseMessage deleteUser(long id);
}
