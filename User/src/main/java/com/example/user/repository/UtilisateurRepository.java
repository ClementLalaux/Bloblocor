package com.example.user.repository;


import com.example.user.entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur,Long> {

    Optional<Utilisateur> findUtilisateurByUsername(String username);
}
