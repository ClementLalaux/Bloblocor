package com.example.authentification.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    @Column(name = "isdriver")
    private boolean isDriver;
    @Column(name = "isadmin")
    private boolean isAdmin;
    private String avatar;


    public Utilisateur(String username, String encodePassword) {
        this.username = username;
        this.password = encodePassword;
    }

    public Utilisateur(String username, String password, String firstname, String lastname, String email, String phone, int isDriver, int isAdmin,String avatar) {
        this.username = username;

        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.isDriver = isDriver == 1;
        this.isAdmin = isAdmin == 1;
        this.avatar = avatar;
    }
}
