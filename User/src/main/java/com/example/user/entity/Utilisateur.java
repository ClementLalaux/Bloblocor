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

}
