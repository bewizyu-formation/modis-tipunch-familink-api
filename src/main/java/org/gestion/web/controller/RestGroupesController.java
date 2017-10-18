package org.gestion.web.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.gestion.entite.Contact;
import org.gestion.entite.ContactForm;
import org.gestion.entite.Groupe;
import org.gestion.entite.GroupeForm;
import org.gestion.entite.Token;
import org.gestion.entite.Utilisateur;
import org.gestion.services.IContactService;
import org.gestion.services.IGroupeService;
import org.gestion.services.impl.UtilisateurServiceRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ahmet Celikbas, Julien Bertrand
 */

@RestController
@RequestMapping("/groupes")
@CrossOrigin(origins = "*", allowedHeaders = "authorization")
public class RestGroupesController {

	@Autowired
	@Qualifier("groupeServiceJpa")
	private IGroupeService groupeServiceJpa;

	private Token tokenHandler = new Token();

	@Autowired
	@Qualifier("groupeServiceRepository")
	private IGroupeService groupeServiceRepository;

	@Autowired
	@Qualifier("contactServiceRepository")
	private IContactService contactServiceRepository;

	@Autowired
	private RestUtilisateurController restUtilisateurController;

	@Autowired
	private RestContactController restContactController;

	@Autowired
	private RestProfileController restProfileController;

	@Autowired
	UtilisateurServiceRepository utilisateurService;
	
	Groupe monGroupe ;

	// ********************************** //
	// ******* GET LIST groupes ********** //
	// ********************************** //

	@RequestMapping(path = "", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Groupe> getGroupesWithJPA(
			@RequestHeader(value = "Authorization", required = true) String requestToken) {

		return groupeServiceJpa.getGroupes();
	}

	// ********************************** //
	// ******* GET LIST group by id****** //
	// ********************************** //

	@RequestMapping(path = "/{idGroupe}", method = RequestMethod.GET)
	@ResponseBody
	public Groupe getGroupeById(@PathVariable("idGroupe") String idGroupe) {
		return groupeServiceRepository.getGroupeById(Integer.parseInt(idGroupe));
	}

	// *********************************** //
	// ********** CREATE Group ********** //
	// *********************************** //

	@RequestMapping(path = "", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public String createGroupe(@RequestBody GroupeForm nouveauGroupe) {

		Set<Contact> listeContactGroupe = new HashSet<Contact>();

		Utilisateur utilisateurTemp = restUtilisateurController
				.getUtilisateurById(Integer.toString(nouveauGroupe.getIdUtilisateurProprietaire()));

		listeContactGroupe.add(
				restContactController.getContactById(Integer.toString(utilisateurTemp.getContact().getIdContact())));

		Groupe newGroupe = new Groupe(
				restUtilisateurController
						.getUtilisateurById(Integer.toString(nouveauGroupe.getIdUtilisateurProprietaire())),
				nouveauGroupe.getNom(), nouveauGroupe.getDateDeCreation(), listeContactGroupe);

		groupeServiceRepository.create(newGroupe);
		return new JSONObject().toString();

	}
	// *********************************** //
	// ******* UPDATE group BY ID ******** //
	// *********************************** //

	@RequestMapping(path = "", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public String updateGroupe(@RequestBody GroupeForm updateGroupe) {

		Groupe newGroupe = new Groupe(updateGroupe.getIdGroupe(),
				restUtilisateurController
						.getUtilisateurById(Integer.toString(updateGroupe.getIdUtilisateurProprietaire())),
				updateGroupe.getNom(), updateGroupe.getDateDeCreation(), updateGroupe.getContactsDuGroupe());

		groupeServiceRepository.update(newGroupe);
		return new JSONObject().toString();

	}

	// *********************************************************** //
	// ******* Ajout contact à la liste d'un groupe BY ID ******** //
	// *********************************************************** //

	@RequestMapping(path = "/update_liste_contact", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public String updateGroupeListe(@RequestBody ContactForm contactForm) {

		Contact nouveauContact = new Contact(contactForm.getIdContact(), contactForm.getEmail(), contactForm.getNom(),
				contactForm.getPrenom(), contactForm.getGravatar(), contactForm.getNumTel(), contactForm.getAdresse(),
				contactForm.getCodePostal(), contactForm.getVille(),
				restProfileController.getProfilById(Integer.toString(contactForm.getIdProfil())));
		contactServiceRepository.create(nouveauContact);
		groupeServiceRepository.addContactToGroup(nouveauContact, contactForm.getIdGroupe());
		return new JSONObject().toString();

	}

	//
	// *********************************** //
	// ******* DELETE group BY ID ******** //
	// *********************************** //

	@RequestMapping(path = "/{idGroupe}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteGroupe(@PathVariable("idGroupe") String idGroupe) {
		groupeServiceRepository.deleteGroupe(Integer.parseInt(idGroupe));

	}

	// ********************************** //
	// ***** GET LIST contacts d'un groupe **** //
	// ********************************** //

	@RequestMapping(path = "/{idGroupe}/contacts", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Set<Contact> getContactsByIdGroupe(@PathVariable("idGroupe") String idGroupe,
				@RequestHeader(value = "Authorization", required = true) String requestToken) {

			Groupe monGroupe = new Groupe();
			monGroupe=groupeServiceRepository.getGroupeById(Integer.parseInt(idGroupe));
			return monGroupe.getContactsDuGroupe();

	}
	
	// *********************************** //
	// ********** CREATE contacts dans un groupe ********** //
	// *********************************** //

	@RequestMapping(path = "/{idGroupe}/contact", method = RequestMethod.POST, produces = "application/json", consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public String createContact(@RequestBody ContactForm nouveauContact,@PathVariable("idGroupe") String idGroupe,
			@RequestHeader(value = "Authorization", required = true) String requestToken) {

		JSONObject jObj;
		jObj = new JSONObject();

		try {
			Contact newContact = new Contact(nouveauContact.getEmail(), nouveauContact.getNom(),
					nouveauContact.getPrenom(), nouveauContact.getGravatar(), nouveauContact.getNumTel(),
					nouveauContact.getAdresse(), nouveauContact.getCodePostal(), nouveauContact.getVille(),
					restProfileController.getProfilById(Integer.toString(nouveauContact.getIdProfil())));
			contactServiceRepository.create(newContact);
			
			monGroupe = new Groupe();
			monGroupe = groupeServiceRepository.getGroupeById(Integer.parseInt(idGroupe));
			Set<Contact> listeDeContacts = monGroupe.getContactsDuGroupe();
			listeDeContacts.add(newContact);
			groupeServiceJpa.updateListeContacts(Integer.parseInt(idGroupe), listeDeContacts);

			jObj.put("action", "creation contact");
			jObj.put("description", "Contact créé");

		} catch (Exception e) {

			jObj.put("action", "creation contact");
			jObj.put("description", "Echec creation contact");

		}
		return jObj.toString();
	}

}