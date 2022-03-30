package com.phoenix.data.dto;

import com.phoenix.data.models.Authority;
import com.phoenix.data.models.Cart;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

//for spring security
@Data
public class AppUserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;

}
