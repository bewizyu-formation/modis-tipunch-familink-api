package org.gestion.web.controller;

import org.gestion.entite.EmailSender;
import org.gestion.entite.Login;
import org.gestion.entite.Utilisateur;
import org.gestion.services.IUtilisateurService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forgot-password")
@CrossOrigin(origins = "*", allowedHeaders = "authorization")
public class RestMotDePasseOublieController {

	@Autowired
	@Qualifier("utilisateurServiceJpa")
	private IUtilisateurService utilisateurServiceJpa;

	@Autowired
	@Qualifier("utilisateurServiceRepository")
	private IUtilisateurService utilisateurServiceRepository;

	private Utilisateur monUtilisateur;

	// *********************************** //
	// ******* GET utilisateur BY EMAIL ********** //
	// *********************************** //

	@RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public String MotDePasse(@RequestBody Login newLogin) {

		JSONObject jObj;
		jObj = new JSONObject();

		try {

			monUtilisateur = utilisateurServiceJpa.getUtilisateurByEmail(newLogin.getEmail());

			EmailSender.envoyerMailSMTP();

			jObj.put("description", "Email reconnu");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			jObj.put("action", "login");
			jObj.put("description", "Email inconnu");

		}
		monUtilisateur = new Utilisateur();
		return jObj.toString();

	}
}
