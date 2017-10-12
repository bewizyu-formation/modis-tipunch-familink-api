package org.gestion.dev.repository.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.gestion.config.ServicesConfig;
import org.gestion.repository.*;
import org.gestion.services.impl.UtilisateurServiceJpa;
import org.gestion.services.impl.ProfilServiceJpa;
import org.gestion.entite.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@ContextConfiguration(classes = { ServicesConfig.class })
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
//test
@RunWith(SpringRunner.class)
//ajout de l'annotation
@WebAppConfiguration
public class BDDRepositoryJPATest {
	
	@Autowired 
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired 
	private ProfilRepository profilService;
	
	@Autowired 
	private ContactRepository contactService;
	
	@Autowired 
	private GroupeRepository groupeService;
	
	@Autowired 
	private MessageRepository messageService;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
	
		{
			
			Profil monProfil= new Profil("MEDECIN","#ff0000");
			
			profilService.save(monProfil);
			
			Contact monContact = new Contact("vr.you@hotmail.fr","Van", "YOU", "https://www.gravatar.com/avatar/19c519f177768c3ce57ebf0cf160b157", "0762729266", "37 rue du progres", "69100",
					"Villeurbanne", monProfil);
			contactService.save(monContact);
			
			Utilisateur utilisateur=new Utilisateur("vr.you@hotmail.fr", "MDP", monContact);
			
			utilisateurRepository.save(utilisateur);
			
			
			Contact monContact2 = new Contact("blabla@hotmail.fr","Julien", "BERTRAND", "https://www.gravatar.com/avatar/19c519f177768c3ce57ebf0cf160b157", "0000000000", "NOMOD", "69100",
					"Villeurbanne", monProfil);
			contactService.save(monContact2);
			
			Set<Contact> maListeContacts = new HashSet();
			maListeContacts.add(monContact);
			maListeContacts.add(monContact2);
			
			
			Date maDate = new Date();
			System.out.println(maDate);
			Groupe monGroupe = new Groupe(utilisateur, "TI-PUNCH", maDate);
			
			monGroupe.setContactsDuGroupe(maListeContacts);
			groupeService.save(monGroupe);
			
			
			
			Message monMessage = new Message(monGroupe, "Ca marche Capitaine !!!!", maDate, false,
					monContact, monContact2);
			messageService.save(monMessage);
			
			//assertTrue(1==1);
		}	
	}
}
