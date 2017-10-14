package org.gestion.web.controller;

import java.util.List;

import org.gestion.entite.Contact;
import org.gestion.entite.FormUtilisateur;
import org.gestion.entite.Profil;
import org.gestion.entite.Utilisateur;
import org.gestion.services.IContactService;
import org.gestion.services.IProfilService;
import org.gestion.services.IUtilisateurService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Julien Bertrand
 */

@RestController
@RequestMapping("/utilisateurs")

@CrossOrigin(origins = "*", allowedHeaders = "authorization")

public class RestUtilisateurController {

	@Autowired
	@Qualifier("utilisateurServiceJpa")
	private IUtilisateurService utilisateurServiceJpa;

	@Autowired
	@Qualifier("utilisateurServiceRepository")
	private IUtilisateurService utilisateurServiceRepository;

	@Autowired
	@Qualifier("contactServiceRepository")
	private IContactService contactServiceRepository;
	
	@Autowired
	@Qualifier("profilServiceRepository")
	private IProfilService profilServiceRepository;

	// ********************************** //
	// ******* GET LIST utilisateurS ********** //
	// ********************************** //

	@RequestMapping(path = "", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Utilisateur> getUtilisateursWithJPA() {
		return utilisateurServiceJpa.getUtilisateurs();
	}

	// *********************************** //
	// ******* GET utilisateur BY ID ********** //
	// *********************************** //

	@RequestMapping(path = "/{idUtilisateur}", method = RequestMethod.GET)
	@ResponseBody
	public Utilisateur getUtilisateurById(@PathVariable("idUtilisateur") String idUtilisateur) {
		return utilisateurServiceRepository.getUtilisateurById(Integer.parseInt(idUtilisateur));
	}

	// *********************************** //
	// ********** CREATE utilisateurs ********** //
	// *********************************** //

	@RequestMapping(path = "/POST", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public String createUser(@RequestBody FormUtilisateur monFormUtilisateur) {
		
		JSONObject jObj;
		jObj = new JSONObject();
		try {
					Profil monProfil = new Profil();
					monProfil = profilServiceRepository.getProfilById(monFormUtilisateur.getIdProfil());
					
					Contact monContact = new Contact(monFormUtilisateur.getEmail(), monFormUtilisateur.getNom(), monFormUtilisateur.getPrenom(), 
							monFormUtilisateur.getGravatar(), monFormUtilisateur.getNumTel(), monFormUtilisateur.getAdresse(),
							monFormUtilisateur.getCodePostal(), monFormUtilisateur.getVille(), monProfil);
					
					monContact = contactServiceRepository.create(monContact);
					
					Utilisateur newUtilisateur = new Utilisateur(monFormUtilisateur.getEmail(), monFormUtilisateur.getPassword(),monContact);
										
					utilisateurServiceRepository.create(newUtilisateur);
					
					jObj.put("action", "creation utilisateur");
					jObj.put("description", "Utilisateur créé");
					
			} catch (Exception e) {

				jObj.put("action", "creation utilisateur");
				jObj.put("description", "Echec creation utilisateur");

			}
		return jObj.toString();
	}

	// *********************************** //
	// ******* UPDATE utilisateur BY ID ******** //
	// *********************************** //

	@RequestMapping(path = "", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public void updateUtilisateur(@RequestBody Utilisateur updateUtilisateur) {
		utilisateurServiceRepository.update(updateUtilisateur);
	}

	//
	// *********************************** //
	// ******* DELETE utilisateur BY ID ******** //
	// *********************************** //

	@RequestMapping(path = "/{idUtilisateur}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUtilisateur(@PathVariable("idUtilisateur") String idUtilisateur) {
		utilisateurServiceRepository.deleteUtilisateur(Integer.parseInt(idUtilisateur));

	}
}
