package com.example.user;

import com.example.user.dto.UtilisateurDTO;
import com.example.user.entity.Utilisateur;
import com.example.user.repository.UtilisateurRepository;
import com.example.user.service.impl.UtilisateurServiceImpl;
import com.example.user.utils.Mapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserApplicationTests {

	@Mock
	private UtilisateurRepository utilisateurRepository;

	@InjectMocks
	private UtilisateurServiceImpl utilisateurService;

	private final Mapper mapper = new Mapper();

	@BeforeEach
	void setUp() throws Exception {
		utilisateurService.setMapper(mapper);
	}


//	@Test
//	public void shouldAddNewUserWhenValidData(){
//		Utilisateur utilisateur = new Utilisateur("Insaiiin","Clement","Lalaux","Lalauxclement@gmail.com","0761147926",true,true);
//		Mockito.when(utilisateurRepository.save(utilisateur)).thenReturn(utilisateur);
//
//		Utilisateur user1 = utilisateurService.createUser(utilisateur);
//
//		Assertions.assertEquals(utilisateur,user1);
//	}
//
//	@Test
//	public void shouldReturnExceptionWhenUserByIdNotFound(){
//		Long id = 1L;
//		Mockito.when(utilisateurRepository.findById(id)).thenReturn(Optional.empty());
//		Assertions.assertThrows(RuntimeException.class, () -> {
//			utilisateurService.getUserById(id);
//		});
//	}
//
//	@Test
//	public void shouldReturnUserByIdWhenFound(){
//		Long id = 1L;
//		Utilisateur utilisateur = new Utilisateur(id, "Insaiiin", "Clement", "Lalaux", "Lalauxclement@gmail.com", "0761147926", true, true);
//
//		Mockito.when(utilisateurRepository.findById(id)).thenReturn(Optional.of(utilisateur));
//
//		UtilisateurDTO result = utilisateurService.getUserById(id);
//
//		Utilisateur utilisateur1 = mapper.mapToEntity(result);
//
//		Assertions.assertEquals(utilisateur, utilisateur1);
//
//		Mockito.verify(utilisateurRepository).findById(id);
//
//	}
//
//	@Test
//	public void shouldReturnListOfUsers(){
//		Utilisateur utilisateur1 = new Utilisateur(1L, "User1", "FirstName1", "LastName1", "user1@example.com", "1234567890", true, true);
//		Utilisateur utilisateur2 = new Utilisateur(2L, "User2", "FirstName2", "LastName2", "user2@example.com", "0987654321", true, false);
//		List<Utilisateur> utilisateurs = Arrays.asList(utilisateur1, utilisateur2);
//
//		Mockito.when(utilisateurRepository.findAll()).thenReturn(utilisateurs);
//
//		List<UtilisateurDTO> result = utilisateurService.getAllUsers();
//
//		Assertions.assertEquals(utilisateurs.size(), result.size());
//
//		for (Utilisateur utilisateur : utilisateurs) {
//			boolean userFound = result.stream().anyMatch(dto -> dto.getId().equals(utilisateur.getId()));
//			assertTrue(userFound);
//		}
//
//		Mockito.verify(utilisateurRepository).findAll();
//	}
//
//	@Test
//	public void shouldDeleteWhenDeleteByIdDone(){
//		Long idToDelete = 1L;
//
//		Utilisateur utilisateur = new Utilisateur(idToDelete, "Insaiiin", "Clement", "Lalaux", "Lalauxclement@gmail.com", "0761147926", true, true);
//
//		Mockito.when(utilisateurRepository.findById(idToDelete)).thenReturn(Optional.of(utilisateur));
//
//		Mockito.doNothing().when(utilisateurRepository).deleteById(idToDelete);
//
//		utilisateurService.deleteUserById(idToDelete);
//
//		Mockito.verify(utilisateurRepository, Mockito.times(1)).deleteById(idToDelete);
//		Mockito.when(utilisateurRepository.findById(idToDelete)).thenReturn(null);
//	}
//
//
//	@Test
//	public void shouldUpdateById(){
//		Long idToDelete = 2L;
//
//		Utilisateur utilisateur = new Utilisateur(idToDelete, "Insaiiin", "Clement", "Lalaux", "Lalauxclement@gmail.com", "0761147926", true, true);
//		UtilisateurDTO utilisateur2 = new UtilisateurDTO(idToDelete, "I", "Clement", "Lalaux", "Lalauxclement@gmail.com", "0761147926", true, true);
//
//		Utilisateur u = mapper.mapToEntity(utilisateur2);
//
//		utilisateurService.createUser(utilisateur);
//
//		Mockito.when(utilisateurRepository.findById(idToDelete)).thenReturn(Optional.of(utilisateur));
//
//		utilisateurService.updateUserById(idToDelete,utilisateur2);
//
//		Mockito.when(utilisateurRepository.findById(idToDelete)).thenReturn(Optional.of(u));
//
//	}


}
