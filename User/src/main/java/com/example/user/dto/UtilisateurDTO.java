package com.example.user.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UtilisateurDTO {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private boolean isDriver;
    private boolean isAdmin;
}
