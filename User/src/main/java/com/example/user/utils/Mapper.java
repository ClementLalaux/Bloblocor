package com.example.user.utils;

import com.example.user.dto.UtilisateurDTO;
import com.example.user.dto.UtilisateurResponseDTO;
import com.example.user.entity.Utilisateur;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component
public class Mapper {

    public UtilisateurDTO mapToDto(Utilisateur utilisateur){
        ModelMapper mapper = new ModelMapper();

        UtilisateurDTO utilisateurDTO = mapper.map(utilisateur, UtilisateurDTO.class);
        return utilisateurDTO;
    }

    public Utilisateur mapToEntity(UtilisateurDTO utilisateurDTO){
        ModelMapper mapper = new ModelMapper();

        Utilisateur utilisateur = mapper.map(utilisateurDTO, Utilisateur.class);
        return utilisateur;
    }

    public UtilisateurResponseDTO mapToDtoResp(Utilisateur utilisateur){
        ModelMapper mapper = new ModelMapper();

        UtilisateurResponseDTO utilisateurDTO = mapper.map(utilisateur, UtilisateurResponseDTO.class);
        return utilisateurDTO;
    }

    public Utilisateur mapToEntityResp(UtilisateurResponseDTO utilisateurDTO){
        ModelMapper mapper = new ModelMapper();

        Utilisateur utilisateur = mapper.map(utilisateurDTO, Utilisateur.class);
        return utilisateur;
    }



}
