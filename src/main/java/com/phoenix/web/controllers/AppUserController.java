package com.phoenix.web.controllers;

import com.phoenix.data.dto.AppUserDto;
import com.phoenix.data.dto.AppUserResponseDto;
import com.phoenix.service.appUser.AppUserService;
import com.phoenix.web.exceptions.BusinessLogicException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequestMapping("/api/appUser")
@RestController
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping()
    public ResponseEntity<?>register(@RequestBody AppUserDto appUserDto){

        AppUserResponseDto responseDto = appUserService.register(appUserDto);
        return ResponseEntity.ok().body(responseDto);
    }

}