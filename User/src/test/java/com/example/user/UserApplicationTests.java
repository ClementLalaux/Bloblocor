package com.example.user;

import com.example.user.entity.Utilisateur;
import com.example.user.repository.UtilisateurRepository;
import com.example.user.service.UtilisateurService;
import com.example.user.service.impl.UtilisateurServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserApplicationTests {

	@Mock
	private UtilisateurRepository utilisateurRepository;

	@InjectMocks
	private UtilisateurServiceImpl utilisateurService;

	@Test
	public void shouldAddNewUserWhenValidData(){
		Utilisateur utilisateur = new Utilisateur("Insaiiin","Clement","Lalaux","Lalauxclement@gmail.com","0761147926",true,true);
		Mockito.when(utilisateurRepository.save(utilisateur)).thenReturn(utilisateur);

		Utilisateur user1 = utilisateurService.createUser(utilisateur);

		Assertions.assertEquals(utilisateur,user1);
	}

	@Test
	public void shouldReturnExceptionWhenUserByIdNotFound(){
		Utilisateur utilisateur = new Utilisateur(1L,"Insaiiin","Clement","Lalaux","Lalauxclement@gmail.com","0761147926",true,true);
		Mockito.when(utilisateurRepository.save(utilisateur)).thenReturn(utilisateur);
		Long id = 1L;
		Assertions.assertThrows(RuntimeException.class,()->{
			utilisateurService.getUserById(id);
		});
	}

}
