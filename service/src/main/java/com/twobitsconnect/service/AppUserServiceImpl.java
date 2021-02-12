package com.twobitsconnect.service;

import com.twobitsconnect.config.UserDetailsServiceImpl;
import com.twobitsconnect.dto.AppUserRegistrationRequestDto;
import com.twobitsconnect.exception.RegisterException;
import com.twobitsconnect.model.AppUser;
import com.twobitsconnect.model.Role;
import com.twobitsconnect.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;


    @Override
    public AppUser registerUser(AppUserRegistrationRequestDto appUserRegistrationRequestDto) throws RegisterException {
        AppUser newUser = AppUserDTOToAppUserMapper.convertAppUserDTOToAppUser(appUserRegistrationRequestDto);
        AppUser appUser = appUserRepository.findByEmail(newUser.getEmail());

        if(appUser != null){
            throw new RegisterException(
                    "There is an account with email address " + appUserRegistrationRequestDto.getEmail()
            );

        }

        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser.setRoles(List.of(Role.ROLE_USER));
        return appUserRepository.save(newUser);
    }
}
