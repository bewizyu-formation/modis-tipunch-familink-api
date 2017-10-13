package org.gestion.web.controller;

import java.util.List;

import org.gestion.entite.Utilisateur;
import org.gestion.services.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

public class RestUtilisateurController {

	@Autowired
	@Qualifier("utilisateurServiceJpa")
	private IUtilisateurService utilisateurServiceJpa;

	@Autowired
	@Qualifier("utilisateurServiceRepository")
	private IUtilisateurService utilisateurServiceRepository;

	@Autowired
	private RestContactController restContactController;

	// ********************************** //
	// ******* GET LIST utilisateurS ********** //
	// ********************************** //

	@RequestMapping(path = "/", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Utilisateur> getUtilisateursWithJPA() {
		return utilisateurServiceJpa.getUtilisateurs();
	}

	// *********************************** //
	// ******* GET utilisateur BY ID ********** //
	// *********************************** //

	@RequestMapping(path = "/{idUtilisateur}", method = RequestMethod.GET)
	@ResponseBody
	public Utilisateur getUtilisateurByIdWithPathParam(@PathVariable("idUtilisateur") String idUtilisateur) {
		return utilisateurServiceRepository.getUtilisateurById(Integer.parseInt(idUtilisateur));
	}

	// *********************************** //
	// ********** CREATE utilisateurs ********** //
	// *********************************** //

	@RequestMapping(path = "/", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public void createUser(@RequestBody Utilisateur nouvelUtilisateur) {

		Utilisateur newUtilisateur = new Utilisateur(nouvelUtilisateur.getEmail(), nouvelUtilisateur.getMotDePasse(),
				restContactController.getContactById(Integer.toString(nouvelUtilisateur.getNewIdContact())));

		utilisateurServiceRepository.create(newUtilisateur);
	}

	// *********************************** //
	// ******* UPDATE utilisateur BY ID ******** //
	// *********************************** //

	@RequestMapping(path = "/", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
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
