package com.twobitsconnect.controller;

import com.twobitsconnect.dto.ApiResponse;
import com.twobitsconnect.dto.AppUserRegistrationRequestDto;
import com.twobitsconnect.exception.RegisterException;
import com.twobitsconnect.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SignUpController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody AppUserRegistrationRequestDto appUserDTO){
        try {
            appUserService.registerUser(appUserDTO);
        }
        catch (RegisterException RegisterException){
            return ResponseEntity.badRequest().body(RegisterException.getMessage());
        }
        return new ResponseEntity<>(new ApiResponse(true, "Registered successfully"), HttpStatus.CREATED);

    }
}