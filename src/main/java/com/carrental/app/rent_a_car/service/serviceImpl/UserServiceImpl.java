package com.carrental.app.rent_a_car.service.serviceImpl;

import com.carrental.app.rent_a_car.config.JwtUtil;
import com.carrental.app.rent_a_car.entity.UserEntity;
import com.carrental.app.rent_a_car.model.ResponseMessage;
import com.carrental.app.rent_a_car.repository.UserRepository;
import com.carrental.app.rent_a_car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public ResponseMessage createUser(UserEntity userEntity) {

        boolean flag = isUserNameExist(userEntity);
        if (!flag) {
            userEntity.setPassword(bcryptEncoder.encode(userEntity.getPassword()));
            userRepository.save(userEntity);
            return new ResponseMessage("Record added Successfully...", true);
        }else {
            return new ResponseMessage("Username Already exist Successfully...", false);
        }
    }

    public boolean isUserNameExist(UserEntity userEntity) {
        UserEntity existingUser = userRepository.findByUsername(userEntity.getUsername());
        if (existingUser != null) {
            return true;
        } else {
            return false;
        }
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles = null;
        UserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity!=null){
            //roles= Arrays.asList(new SimpleGrantedAuthority(adminEntity.getRole()));
            roles= Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new User(userEntity.getUsername(),userEntity.getPassword(),roles);
        }
        throw new UsernameNotFoundException("User not found for "+username);
    }
}
