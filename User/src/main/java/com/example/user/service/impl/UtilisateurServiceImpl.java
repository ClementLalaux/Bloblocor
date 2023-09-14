package com.example.user.service.impl;

import com.example.user.dto.UtilisateurDTO;
import com.example.user.entity.Utilisateur;
import com.example.user.repository.UtilisateurRepository;
import com.example.user.service.UtilisateurService;
import com.example.user.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    @Autowired
    private Mapper mapper;

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    public UtilisateurServiceImpl(UtilisateurRepository userRepository) {
        this.utilisateurRepository = userRepository;
    }


    @Override
    public Utilisateur createUser(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
        return utilisateur;
    }

    @Override
    public UtilisateurDTO getUserById(Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if(utilisateur.isPresent()){
            UtilisateurDTO utisateurDTO = mapper.mapToDto(utilisateur.get());
            return utisateurDTO;
        }
        throw new RuntimeException("Not found");
    }

    @Override
    public UtilisateurDTO getUserByUsername(String username) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findUtilisateurByUsername(username);
        if(utilisateur.isPresent()){
            UtilisateurDTO utisateurDTO = mapper.mapToDto(utilisateur.get());
            return utisateurDTO;
        }
        throw new RuntimeException("Not found");
    }



    @Override
    public List<UtilisateurDTO> getAllUsers() {
        List<Utilisateur> utilisateurs = (List<Utilisateur>) utilisateurRepository.findAll();
        List<UtilisateurDTO> utilisateurDTOS =  utilisateurs.stream().map(user->mapper.mapToDto(user)).toList();

        return utilisateurDTOS;
    }

    @Override
    public String deleteUserById(Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if(utilisateur.isPresent()){
            utilisateurRepository.deleteById(id);
            return("User deleted");
        }
        throw new RuntimeException("Not found");
    }

    @Override
    public UtilisateurDTO updateUserById(Long id, UtilisateurDTO utilisateurDTO) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if(utilisateur.isPresent()){
            Utilisateur utilisateur1 = utilisateur.get();
            utilisateur1.setFirstname(utilisateurDTO.getFirstname());
            utilisateur1.setUsername(utilisateurDTO.getUsername());
            utilisateur1.setLastname(utilisateurDTO.getLastname());
            utilisateur1.setEmail(utilisateurDTO.getEmail());
            utilisateur1.setPhone(utilisateurDTO.getPhone());
            utilisateur1.setDriver(utilisateurDTO.isDriver());
            utilisateur1.setAdmin(utilisateurDTO.isAdmin());
            utilisateurRepository.save(utilisateur1);
            return mapper.mapToDto(utilisateur1);
        }
        throw new RuntimeException("Not found");
    }


}
