package org.gestion.web.controller;

import org.gestion.entite.Utilisateur;
import org.gestion.services.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class RestUtilisateurController {

	@Autowired
	@Qualifier("utilisateurServiceJpa")
	private IUtilisateurService utilisateurServiceJpa;

	@Autowired
	@Qualifier("utilisateurServiceRepository")
	private IUtilisateurService utilisateurServiceRepository;



	// ********************************** //
	// ******* GET LIST utilisateurS ********** //
	// ********************************** //

	@RequestMapping(path = "/withJpa", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Utilisateur> getUtilisateursWithJPA() {
		return utilisateurServiceJpa.getUtilisateurs();
	}

	@RequestMapping(path = "/withRepository", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Utilisateur> getUtilisateursWithRepository() {
		return utilisateurServiceRepository.getUtilisateurs();
	}

	// *********************************** //
	// ******* GET utilisateur BY ID ********** //
	// *********************************** //

	@RequestMapping(path = "/{idUtilisateur}/path-param", method = RequestMethod.GET)
	@ResponseBody
	public Utilisateur getUtilisateurByIdWithPathParam(@PathVariable("idUtilisateur") String idUtilisateur) {
		return utilisateurServiceRepository.getUtilisateurById(Integer.parseInt(idUtilisateur));
	}

	@RequestMapping(path = "/query-param", method = RequestMethod.GET)
	@ResponseBody
	public Utilisateur getUtilisateurByIdWithQueryParam(@RequestParam("idUtilisateur") String idUtilisateur) {
		return utilisateurServiceRepository.getUtilisateurById(Integer.parseInt(idUtilisateur));
	}

	// *********************************** //
	// ********** CREATE utilisateurs ********** //
	// *********************************** //

	@RequestMapping(path = "/createutilisateur", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	public Utilisateur utilisateur(@RequestBody Utilisateur newUtilisateur) {
		
		return utilisateurServiceJpa.create(newUtilisateur);
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
