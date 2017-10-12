package org.gestion.dev.repository.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.gestion.config.ServicesConfig;
import org.gestion.entite.Profil;
import org.gestion.web.controller.RestProfileController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServicesConfig.class)
public class RestProfileControllerTest {
	
	@Autowired
	private RestProfileController restProfileController;
	Profil profil = new Profil("VOISIN","#012345");
	List<Profil> listeProfil = new ArrayList<Profil>();
	
	@Test
	public void createProfilTest(){
		
		int tailleInitiale = restProfileController.getProfilList().size();
		restProfileController.CreateProfil(profil);
		Assert.assertEquals(tailleInitiale+1, restProfileController.getProfilList().size() );
		listeProfil = restProfileController.getProfilList();
		assertTrue(listeProfil.contains(profil));
		
	}
	
	@Test
	public void getProfilByIdTest(){
		
		String idProfil = "3";
		assertTrue( restProfileController.getProfilById(idProfil) != null );
		
	}
	
	@Test
	public void getProfileListTest(){
		assertTrue(restProfileController.getProfilList().size() >= 3);
	}
	
	@Test
	public void deleteProfileTest(){
		
		int tailleInitiale = restProfileController.getProfilList().size();
		String idProfil = "14";
		restProfileController.deleteProfil(idProfil );
		Assert.assertEquals(tailleInitiale-1, restProfileController.getProfilList().size() );
		assertTrue( restProfileController.getProfilById(idProfil) == null );
		
	}
	
	@Test
	public void updateProfileTest(){
		String idProfil = "3";
		Profil oldProfil = restProfileController.getProfilById(idProfil);
		Profil updateProfil = new Profil(Integer.parseInt(idProfil),"MEDECIN","#FFF000");
		restProfileController.updateProfil(updateProfil );
		Profil newProfil = restProfileController.getProfilById(idProfil);
		assertFalse( oldProfil.equals(newProfil) );
	}

}
