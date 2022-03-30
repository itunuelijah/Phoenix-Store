package com.phoenix.data.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    private double price;

    private int quantity;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-ss HH-mm-ss")
    private LocalDateTime dateCreated;
    private String imageUrl;

}
