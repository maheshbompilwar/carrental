package com.carrental.app.rent_a_car.controller;

import com.carrental.app.rent_a_car.config.JwtUtil;
import com.carrental.app.rent_a_car.entity.UserEntity;
import com.carrental.app.rent_a_car.model.AuthenticationRequest;
import com.carrental.app.rent_a_car.model.AuthenticationResponse;
import com.carrental.app.rent_a_car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @RequestMapping(value="/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
        }catch (DisabledException e){
            throw new Exception("USER_DISABLED",e);
        }catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIALS",e);
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

//    @PostMapping(value = "/register")
//    public ResponseEntity<?> saveUser(@RequestBody UserEntity userEntity){
//        return ResponseEntity.ok(userDetailsService.createUser(userEntity));
//    }
}
