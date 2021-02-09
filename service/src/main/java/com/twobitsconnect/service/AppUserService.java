package com.twobitsconnect.service;

import com.twobitsconnect.dto.AppUserRegistrationRequestDto;
import com.twobitsconnect.exception.RegisterException;
import com.twobitsconnect.model.AppUser;

public interface AppUserService {
    AppUser registerUser(AppUserRegistrationRequestDto appUserRegistrationRequestDto) throws RegisterException;
}
