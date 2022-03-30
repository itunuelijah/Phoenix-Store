package com.phoenix.service.appUser;

import com.phoenix.data.dto.AppUserDto;
import com.phoenix.data.dto.AppUserResponseDto;

public interface AppUserService {
    AppUserResponseDto register(AppUserDto appUserDto);

}
