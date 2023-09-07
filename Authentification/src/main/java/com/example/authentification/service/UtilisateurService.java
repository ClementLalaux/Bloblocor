package com.example.authentification.service;

import com.example.authentification.entity.Utilisateur;
import com.example.authentification.repository.UtilisateurRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurService {
    private final UtilisateurRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UtilisateurService(UtilisateurRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public Utilisateur enregistrerUtilisateur(String username, String password, String firstname, String lastname, String phone, String email, boolean isAdmin,boolean isDriver) {
        Utilisateur user = new Utilisateur(username, password,firstname,lastname,email,phone,isDriver,isAdmin);
        return userRepository.save(user);
    }

    public Utilisateur trouverParUsername(String username) {
        Optional<Utilisateur> utilisateur = userRepository.findByUsername(username);
        if(utilisateur.isPresent()){
            return utilisateur.get();
        }
        throw new RuntimeException("Not found");
    }

    public Utilisateur trouverParId(Long id) {
        Optional<Utilisateur> utilisateur = userRepository.findById(id);
        if(utilisateur.isPresent()){
            return utilisateur.get();
        }
        throw new RuntimeException("Not found");
    }
}
