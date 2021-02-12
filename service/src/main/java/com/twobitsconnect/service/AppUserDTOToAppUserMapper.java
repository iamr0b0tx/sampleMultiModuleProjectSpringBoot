package com.twobitsconnect.service;

import com.twobitsconnect.dto.AppUserRegistrationRequestDto;
import com.twobitsconnect.model.AppUser;
import com.twobitsconnect.model.Role;

import java.util.List;

public class AppUserDTOToAppUserMapper {
    public static AppUser convertAppUserDTOToAppUser(AppUserRegistrationRequestDto appUserRegistrationRequestDto){
        AppUser appUser = new AppUser();
        appUser.setEmail(appUserRegistrationRequestDto.getEmail().trim().toLowerCase());
        appUser.setPassword(appUserRegistrationRequestDto.getPassword());
        appUser.setRoles(List.of(Role.ROLE_USER));
        return appUser;
    }
}