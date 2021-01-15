package com.carrental.app.rent_a_car.service.serviceImpl;

import com.carrental.app.rent_a_car.entity.UserEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.repository.UserRepository;
import com.carrental.app.rent_a_car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseMessage createUser(UserEntity userEntity) {
        userRepository.save(userEntity);
        return new ResponseMessage("Record added Successfully...", true);
    }

    @Override
    public List<UserEntity> getUsers() {
       return userRepository.findAll();
    }

    @Override
    public UserEntity getUser(long id) {
      return userRepository.findUserEntityById(id);
    }

    @Override
    public ResponseMessage updateUser(UserEntity userEntity) {
        if (userRepository.findUserEntityById(userEntity.getId()) == null)
            throw new RuntimeException("Record Not Available...");
       userRepository.save(userEntity);
        return new ResponseMessage("Record Updated Successfully...", true);
    }

    @Override
    public ResponseMessage deleteUser(long id) {
        if (userRepository.findUserEntityById(id) == null)
            throw new RuntimeException("Record Not Available...");
        userRepository.deleteById(id);
        return new ResponseMessage("Record Deleted Successfully...", true);
    }
}
