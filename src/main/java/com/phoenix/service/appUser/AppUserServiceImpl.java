package com.phoenix.service.appUser;

import com.phoenix.data.dto.AppUserDto;
import com.phoenix.data.dto.AppUserResponseDto;
import com.phoenix.data.models.AppUser;
import com.phoenix.data.repository.AppUserRepository;
import com.phoenix.web.exceptions.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AppUserResponseDto register(AppUserDto appUserDto) {
//   check that user doesnt exist
            if (appUserRepository.existsByEmail(appUserDto.getEmail())){
                throw new UserAlreadyExistException("User with email already exist");
            }
//            create an app user object

        AppUser appUser = new AppUser();
        appUser.setFirstName(appUserDto.getFirstName());
        appUser.setLastName(appUserDto.getLastName());
        appUser.setEmail(appUserDto.getEmail());
        appUser.setPassword(bCryptPasswordEncoder.encode(appUserDto.getPassword()));
        appUser.setAddress(appUserDto.getAddress());

        appUserRepository.save(appUser);
        //            return response
        return buildUserResponse(appUser);
    }


        private AppUserResponseDto buildUserResponse(AppUser appUser){
            return  AppUserResponseDto.builder()
                    .firstName(appUser.getFirstName())
                    .lastName(appUser.getLastName())
                    .email(appUser.getEmail())
                    .address(appUser.getAddress())
                    .build();
        }
    }