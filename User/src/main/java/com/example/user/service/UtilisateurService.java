package com.example.user.service;

import com.example.user.dto.UtilisateurDTO;
import com.example.user.entity.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    Utilisateur createUser(String firstname, String lastname, String email, String phone, boolean isDriver, boolean isAdmin);
    UtilisateurDTO getUserById(Long id);
    List<UtilisateurDTO> getAllUsers();
    void deleteUserById(Long id);
    UtilisateurDTO updateUserById(Long id, UtilisateurDTO userDTO);



}
