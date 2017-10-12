package org.gestion.web.controller;

import org.gestion.entite.Contact;
import org.gestion.entite.Profil;
import org.gestion.entite.Utilisateur;
import org.gestion.services.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/utilisateur")
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

	@RequestMapping(path = "/utilisateurs", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Utilisateur> getUtilisateursWithJPA() {
		return utilisateurServiceJpa.getUtilisateurs();
	}

//	@RequestMapping(path = "/withRepository", method = RequestMethod.GET, produces = "application/json")
//	@ResponseBody
//	public List<Utilisateur> getUtilisateursWithRepository() {
//		return utilisateurServiceRepository.getUtilisateurs();
//	}

	// *********************************** //
	// ******* GET utilisateur BY ID ********** //
	// *********************************** //

	@RequestMapping(path = "/{idUtilisateur}", method = RequestMethod.GET)
	@ResponseBody
	public Utilisateur getUtilisateurByIdWithPathParam(@PathVariable("idUtilisateur") String idUtilisateur) {
		return utilisateurServiceRepository.getUtilisateurById(Integer.parseInt(idUtilisateur));
	}

//	@RequestMapping(path = "/query-param", method = RequestMethod.GET)
//	@ResponseBody
//	public Utilisateur getUtilisateurByIdWithQueryParam(@RequestParam("idUtilisateur") String idUtilisateur) {
//		return utilisateurServiceRepository.getUtilisateurById(Integer.parseInt(idUtilisateur));
//	}

	// *********************************** //
	// ********** CREATE utilisateurs ********** //
	// *********************************** //


    @RequestMapping(path="/createUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void createUser (@RequestBody Utilisateur nouveaulUtilisateur) {
        System.out.println("coucou");

        Profil nouveauProfil = new Profil("MEDECIN","#FFFF00");
	Contact nouveauContact = new Contact("jean.jacques@paul.fr", "paul", "pierre", "http://dggggs.fr", "0645124679", "2 rue des peupliers", "56600", "hugg", nouveauProfil);
        Utilisateur newUtlilisateur= new Utilisateur("jean.jacques@paul.fr", "hfkccjcjchh", nouveauContact);
        

    System.out.println("coucou");
        // utilisateurServiceJpa.create(newUtlilisateur);
 
         utilisateurServiceRepository.create(newUtlilisateur);
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
