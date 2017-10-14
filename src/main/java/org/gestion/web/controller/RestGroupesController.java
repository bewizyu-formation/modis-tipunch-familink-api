package org.gestion.web.controller;

import java.util.List;

import org.gestion.entite.Groupe;
import org.gestion.entite.GroupeForm;
import org.gestion.entite.Token;
import org.gestion.services.IGroupeService;
import org.gestion.services.impl.UtilisateurServiceRepository;
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
	private RestUtilisateurController restUtilisateurController;

	@Autowired
	UtilisateurServiceRepository utilisateurService;

	// ********************************** //
	// ******* GET LIST groupes ********** //
	// ********************************** //

	@RequestMapping(path = "", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Groupe> getGroupesWithJPA(
			@RequestHeader(value = "Authorization", required = true) String requestToken) {

		/* TODO : vérifier la validiée du token */
		
		
		// System.out.println("requestToken = " + requestToken);

		// ********************************** //
		// *** GET LIST groupByUtilisateur*** //
		// ********************************** //

		/*
		 * TODO : Retourner uniquement les groupes liés à l'utilisateur (IdUtilisateur
		 * contenu dans le token)
		 */
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

	@RequestMapping(path = "", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public void createGroupe(@RequestBody GroupeForm nouveauGroupe) {

		Groupe newGroupe = new Groupe(
				restUtilisateurController
						.getUtilisateurById(Integer.toString(nouveauGroupe.getIdUtilisateurProprietaire())),
				nouveauGroupe.getNom(), nouveauGroupe.getDateDeCreation());

		groupeServiceRepository.create(newGroupe);

	}
	// *********************************** //
	// ******* UPDATE group BY ID ******** //
	// *********************************** //

	@RequestMapping(path = "", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public void updateGroupe(@RequestBody GroupeForm updateGroupe) {

		Groupe newGroupe = new Groupe(updateGroupe.getIdGroupe(),
				restUtilisateurController
						.getUtilisateurById(Integer.toString(updateGroupe.getIdUtilisateurProprietaire())),
				updateGroupe.getNom(), updateGroupe.getDateDeCreation());

		groupeServiceRepository.update(newGroupe);

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
}