package com.example.user.controller;

import com.example.user.dto.UtilisateurDTO;
import com.example.user.entity.Utilisateur;
import com.example.user.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class UtilisateurController {


   private UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping("")
    public ResponseEntity<Utilisateur> createUser(@RequestBody Utilisateur utilisateur){
        Utilisateur user = utilisateurService.createUser(utilisateur);
        return ResponseEntity.ok(user);
    }

    @GetMapping("")
    public ResponseEntity<List<UtilisateurDTO>> getAll(){
        return new ResponseEntity<>(utilisateurService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<UtilisateurDTO> get(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(utilisateurService.getUserById(id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
        utilisateurService.deleteUserById(id);
        return new ResponseEntity<>("User deleted succcessfully", HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<UtilisateurDTO> update(@RequestBody UtilisateurDTO utilisateurDTO, @RequestParam(value = "id") Long id){
        UtilisateurDTO utilisateur = utilisateurService.updateUserById(id,utilisateurDTO);
        return new ResponseEntity<>(utilisateur,HttpStatus.OK);
    }

}
