package com.example.user.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UtilisateurDTO {
    private Long id;

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private boolean isDriver;
    private boolean isAdmin;

    public UtilisateurDTO(String username, String firstname, String lastname, String email, String phone, boolean isDriver, boolean isAdmin) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.isDriver = isDriver;
        this.isAdmin = isAdmin;
    }
}
