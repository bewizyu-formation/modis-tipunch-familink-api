package org.gestion.web.controller;

import org.gestion.entite.Token;
import org.gestion.entite.Utilisateur;
import org.gestion.services.IUtilisateurService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ReinitialisationMDP")
@CrossOrigin(origins = "*", allowedHeaders = "authorization")
public class RestReinitialisationMotDePasseController {

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

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String getUtilisateurByIdWithQueryParam(@RequestParam("email") String email) {

		JSONObject jObj;
		jObj = new JSONObject();

		try {

			monUtilisateur = utilisateurServiceJpa.getUtilisateurByEmail(email);

			Token monToken = new Token();
			String base64encodedString = monToken.creerToken(monUtilisateur.getIdUtilisateur());
			jObj.put("tokenReinitialisation", base64encodedString);

		} catch (Exception e) {

			jObj.put("action", "login");
			jObj.put("description", "email inconnu");

		}
		monUtilisateur = new Utilisateur();
		return jObj.toString();
	}
}
