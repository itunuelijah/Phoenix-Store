package com.phoenix.data.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true, nullable = false)// added for spring security(nullable = false)
    private String email;

    //.....added for spring security
    @Column(nullable = false)
    private String password;
    private boolean enabled;

    @ElementCollection  //we use this to say the relationship because Authority is not an entity but similar to one to many relationship.
    //normally join collumn will be created to manage 1 to many relationship.
    //with the @ElementCollection, you can save a spring, enum or any other elemtn that is not an entity,.
    private List<Authority> authorities;// you can be student then or instructor or admin. thats why it is in list.

    //.......

    @Column(length = 500)
    private String address;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @OneToOne(cascade = CascadeType.PERSIST)
    private final Cart myCart;

    public AppUser(){

        this.myCart = new Cart();
        this.myCart.setTotalPrice(0.0);
    }
}
