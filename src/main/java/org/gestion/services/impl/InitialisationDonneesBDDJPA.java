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
	@Qualifier("contactServiceJpa")
	private IContactService contactServiceJpa;
	
	@Autowired
	@Qualifier("utilisateurServiceRepository")
	private IUtilisateurService utilisateurServiceRepository;
	
	@Autowired
	@Qualifier("groupeServiceRepository")
	private IGroupeService groupeServiceRepository;
	
	@Override
	public void initialiserProfils() {

		
		profilServiceJpa.create(new Profil("SENIOR","#FFFF00"));
		profilServiceJpa.create(new Profil("MEDECIN","#FFFFFF"));
		profilServiceJpa.create(new Profil("FAMILLE","#0000FF"));
		
	}

	@Override
	public void initialiserContact() {

		
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
		
		contactServiceRepository.create(new Contact( "Ldpont@wanadoo.fr", "Dupont", "Lisandre", 
				"https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?f=y", "0258743119",
				"92 Rue Victor Hugo", "72100", "Châlons-sur-Saône", profilServiceJpa.getProfilById(1)));
		
		contactServiceRepository.create(new Contact( "miton.jeanne@orange.fr", "Miton", "Jeanne", 
				"https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?f=y", "0195657802",
				"28 Rue de Belleville", "75100", "Paris", profilServiceJpa.getProfilById(1)));
		
		contactServiceRepository.create(new Contact( "molier_alexandre@gmail.com", "Molier", "Alexandre", 
				"https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?f=y", "0365014790",
				"10 rue de la République", "92420", "Meudon", profilServiceJpa.getProfilById(2)));
		
		contactServiceRepository.create(new Contact( "diot.laure@yahoo.fr", "Diot", "Laura", 
				"https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?f=y", "0152745600",
				"10 rue de la République", "92420", "Meudon", profilServiceJpa.getProfilById(2)));
		
		contactServiceRepository.create(new Contact( "vernier.anais@employe-sncf.fr", "Vernier", "Anaïs", 
				"https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?f=y", "0358741290",
				"10 boulevard du 14 Juillet", "10000", "Troyes", profilServiceJpa.getProfilById(3)));
		
		contactServiceRepository.create(new Contact( "vernier.sophie", "Vernier", "Sophie", 
				"https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?f=y", "0344201412",
				"2 rue du stade", "10120", "Thennelière", profilServiceJpa.getProfilById(3)));
		
		contactServiceRepository.create(new Contact( "vincent63000@laposte.fr", "Janvier", "Vincent", 
				"https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?f=y", "0498503247",
				"1 Boulevard du 11 Novembre", "63000", "Clermont-Ferrand", profilServiceJpa.getProfilById(3)));
		
		contactServiceRepository.create(new Contact( "robert.henry@gmail.com", "Henry", "Robert", 
				"https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?f=y", "0412580076",
				"72 rue Emile Zola", "63000", "Clermont-Ferrand", profilServiceJpa.getProfilById(3)));
		
	}

	@Override
	public void initialiserUtilisateur() {
		
		utilisateurServiceRepository.create( new Utilisateur( "vr.you@hotmail.fr", "71ec2af811cdf898bce6904a75a48d75", contactServiceRepository.getContactById(2) ) );
		utilisateurServiceRepository.create( new Utilisateur( "celikbas.ahmet@gmail.com", "bd990c98217acc3fc01b58d119c878f4", contactServiceRepository.getContactById(3) ) );
		utilisateurServiceRepository.create( new Utilisateur( "julien.bertrand6384@gmail.com", "2288f19af4174ba13c653f1cef8d98f3", contactServiceRepository.getContactById(4) ) );
		utilisateurServiceRepository.create( new Utilisateur( "cestmavraieadressepoubelle@gmail.com", "9187e41a6995d859f23f4276035de75a", contactServiceRepository.getContactById(6) ) );
		utilisateurServiceRepository.create( new Utilisateur( "molier_alexandre@gmail.com", "79b240acdaf445e99da9095d59d5c533", contactServiceRepository.getContactById(9) ) );
		utilisateurServiceRepository.create( new Utilisateur( "vernier.anais@employe-sncf.fr", "933d80f211683fa3d839cbfdd61696d6b", contactServiceRepository.getContactById(11) ) );
		utilisateurServiceRepository.create( new Utilisateur( "robert.henry@gmail.com", "5fa453394911350c93a08e196112d33f", contactServiceRepository.getContactById(14) ) );

	}

	@Override
	public void initialiserGroupe() {
		
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
		
		listeDeContacts.clear();
		listeDeContacts.add( contactServiceRepository.getContactById( utilisateurServiceRepository.getUtilisateurById(5).getContact().getIdContact() ) ); 
		listeDeContacts.add( contactServiceRepository.getContactById(10) );
		listeDeContacts.add( contactServiceRepository.getContactById(11) );
		listeDeContacts.add( contactServiceRepository.getContactById(12) );
		date.toInstant();
		
		groupeServiceRepository.create( new Groupe( utilisateurServiceRepository.getUtilisateurById(5),
				"Réné Robert", date, listeDeContacts  ) );
		
		listeDeContacts.clear();
		listeDeContacts.add( contactServiceRepository.getContactById( utilisateurServiceRepository.getUtilisateurById(7).getContact().getIdContact() ) );
		listeDeContacts.add( contactServiceRepository.getContactById(13) ); 
		listeDeContacts.add( contactServiceRepository.getContactById(6) ); 
		listeDeContacts.add( contactServiceRepository.getContactById(8) );
		listeDeContacts.add( contactServiceRepository.getContactById(4) );
		listeDeContacts.add( contactServiceRepository.getContactById(9) );
		listeDeContacts.add( contactServiceRepository.getContactById(7) );

		date.toInstant();
		
		groupeServiceRepository.create( new Groupe( utilisateurServiceRepository.getUtilisateurById(7),
				"Mamie Germaine", date, listeDeContacts  ) );
				
	}
	
	@Override
	public void initialiserGroupesD1Contact() {
		
		Set<Groupe> listeGroupeD1Contact = new HashSet<Groupe>();
		listeGroupeD1Contact.add(groupeServiceRepository.getGroupeById(1));
		listeGroupeD1Contact.add(groupeServiceRepository.getGroupeById(2));
		
		Contact monContact = contactServiceRepository.getContactById(4);
		
		contactServiceJpa.updateListeGroupes(monContact.getIdContact(), listeGroupeD1Contact);
		
		
	}

}
