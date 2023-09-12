package com.example.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String phone;
    private boolean isDriver;
    private boolean isAdmin;

    public Utilisateur(String username, String firstname, String lastname, String email, String phone, boolean isDriver, boolean isAdmin) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.isDriver = isDriver;
        this.isAdmin = isAdmin;
    }
}
