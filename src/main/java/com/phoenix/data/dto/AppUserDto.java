package com.phoenix.data.dto;


import lombok.Data;


//for spring security
@Data
public class AppUserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;

}
