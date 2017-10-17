package org.gestion.web.controller;

import org.gestion.entite.Login;
import org.gestion.services.IUtilisateurService;
import org.gestion.services.impl.EmailSender;
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

	// ******************************************* //
	// ******* Envoie un email à l'utilisateur pour réinitialisaer le mdp ********** //
	// ******************************************* //

	@RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public String Email(@RequestBody Login newLogin) {

		JSONObject jObj;
		jObj = new JSONObject();

		try {

			EmailSender.envoyerMailSMTP( utilisateurServiceJpa.getUtilisateurByEmail(newLogin.getEmail()) );

			jObj.put("description", "Email reconnu");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			jObj.put("action", "login");
			jObj.put("description", "Email inconnu");

		}
		return jObj.toString();

	}
}
