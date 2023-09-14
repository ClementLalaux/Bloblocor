package com.example.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Entity
@Data
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String avatar;
    private String phone;
    @Column(name = "isdriver")
    private boolean isDriver;
    @Column(name = "isadmin")
    private boolean isAdmin;

    public Utilisateur(String username,String avatar, String firstname, String lastname, String email, String phone, int isDriver, int isAdmin) {
        this.username = username;
        this.avatar = avatar;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.isDriver = isDriver == 1;
        this.isAdmin = isAdmin  == 1;
    }
}
