package com.example.user.service;

import com.example.user.dto.UtilisateurDTO;
import com.example.user.entity.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    Utilisateur createUser(Utilisateur utilisateur);
    UtilisateurDTO getUserById(Long id);
    List<UtilisateurDTO> getAllUsers();
    void deleteUserById(Long id);
    UtilisateurDTO updateUserById(Long id, UtilisateurDTO userDTO);



}
