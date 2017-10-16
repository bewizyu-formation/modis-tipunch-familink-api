package org.gestion.services.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.gestion.entite.Contact;
import org.gestion.entite.Groupe;
import org.gestion.entite.Profil;
import org.gestion.entite.Utilisateur;
import org.gestion.services.IContactService;
import org.gestion.services.IGroupeService;
import org.gestion.services.IInitialisationDonnees;
import org.gestion.services.IProfilService;
import org.gestion.services.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InitialisationDonneesBDDJPA implements IInitialisationDonnees{

	@Autowired
	@Qualifier("profilServiceJpa")
	private IProfilService profilServiceJpa;

	@Autowired
	@Qualifier("contactServiceRepository")
	private IContactService contactServiceRepository;
	
	@Autowired
	@Qualifier("utilisateurServiceRepository")
	private IUtilisateurService utilisateurServiceRepository;
	
	@Autowired
	@Qualifier("groupeServiceRepository")
	private IGroupeService groupeServiceRepository;
	
	@Override
	public void initialiserProfils() {
		// TODO Auto-generated method stub
		
		profilServiceJpa.create(new Profil("SENIOR","#FFFF00"));
		profilServiceJpa.create(new Profil("MEDECIN","#FFFFFF"));
		profilServiceJpa.create(new Profil("FAMILLE","#00FF00"));
		
	}

	@Override
	public void initialiserContact() {
		// TODO Auto-generated method stub
		
		contactServiceRepository.create(new Contact( "", "Martin", "Damien", 
				"https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50", "0612853748",
				"150 Cours Tolstoï", "69300", "Villeurbanne", profilServiceJpa.getProfilById(2)));
		
		contactServiceRepository.create(new Contact( "vr.you@hotmail.fr", "Tilk", "Van Rottana", 
				"https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50", "0665298463",
				"150 boulevard Stalingrad", "69000", "Lyon", profilServiceJpa.getProfilById(3)));
		
		contactServiceRepository.create(new Contact( "celikbas.ahmet@gmail.com", "Pomme", "Ahmet", 
				"https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50", "0712156432",
				"3 rue du Général de Gaulle", "38300", "La tour des pins", profilServiceJpa.getProfilById(3)));
		
		contactServiceRepository.create(new Contact( "julien.bertrand6384@gmail.com", "Trello", "Julien", 
				"https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50", "0712156432",
				"Place Grand Clément", "69300", "Villeurbanne", profilServiceJpa.getProfilById(3)));
		
		contactServiceRepository.create(new Contact( "vieu@yahoo.com", "Fernandel", "Marcel", 
				"https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?f=y", "0417969524",
				"56 Avenue Anatole France", "69100", "Caluire et Caluire", profilServiceJpa.getProfilById(1)));
		
		contactServiceRepository.create(new Contact( "cestmavraieadressepoubelle@gmail.com", "Fernandel", "Marcelle", 
				"https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?f=y", "0417969524",
				"56 Avenue Anatole France", "69100", "Caluire et Caluire", profilServiceJpa.getProfilById(1)));
		
	}

	@Override
	public void initialiserUtilisateur() {
		// TODO Auto-generated method stub
		
		utilisateurServiceRepository.create( new Utilisateur( "vr.you@hotmail.fr", "71ec2af811cdf898bce6904a75a48d75", contactServiceRepository.getContactById(2) ) );
		utilisateurServiceRepository.create( new Utilisateur( "celikbas.ahmet@gmail.com", "bd990c98217acc3fc01b58d119c878f4", contactServiceRepository.getContactById(3) ) );
		utilisateurServiceRepository.create( new Utilisateur( "julien.bertrand6384@gmail.com", "2288f19af4174ba13c653f1cef8d98f3", contactServiceRepository.getContactById(4) ) );
		utilisateurServiceRepository.create( new Utilisateur( "cestmavraieadressepoubelle@gmail.com", "9187e41a6995d859f23f4276035de75a", contactServiceRepository.getContactById(6) ) );

	}

	@Override
	public void initialiserGroupe() {
		// TODO Auto-generated method stub
		
		Set<Contact> listeDeContacts = new HashSet<Contact>();
		listeDeContacts.add( contactServiceRepository.getContactById( utilisateurServiceRepository.getUtilisateurById(2).getContact().getIdContact() ) );
		Date date = new Date();
		date.toInstant();
		
		groupeServiceRepository.create( new Groupe( utilisateurServiceRepository.getUtilisateurById(2),
				"Papy Mougeot", date, listeDeContacts  ) );
		
		listeDeContacts.clear();
		listeDeContacts.add( contactServiceRepository.getContactById( utilisateurServiceRepository.getUtilisateurById(3).getContact().getIdContact() ) );
		listeDeContacts.add( contactServiceRepository.getContactById(1) ); 
		listeDeContacts.add( contactServiceRepository.getContactById(6) ); 
		date.toInstant();
		
		groupeServiceRepository.create( new Groupe( utilisateurServiceRepository.getUtilisateurById(3),
				"Mère Theresa", date, listeDeContacts  ) );
		
	}

}
