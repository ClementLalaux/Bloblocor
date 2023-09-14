package com.example.user.service;

import com.example.user.dto.UtilisateurDTO;
import com.example.user.dto.UtilisateurResponseDTO;
import com.example.user.entity.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    Utilisateur createUser(Utilisateur utilisateur);
    UtilisateurDTO getUserById(Long id);
    List<UtilisateurDTO> getAllUsers();
    String deleteUserById(Long id);
    UtilisateurResponseDTO updateUserById(Long id, UtilisateurDTO userDTO);

    UtilisateurDTO getUserByUsername(String username);

}
