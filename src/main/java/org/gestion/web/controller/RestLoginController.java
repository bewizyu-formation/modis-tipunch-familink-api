package org.gestion.web.controller;

import java.util.List;

import org.gestion.entite.Groupe;
import org.gestion.entite.Login;
import org.gestion.entite.Token;
import org.gestion.entite.Utilisateur;
import org.gestion.services.IGroupeService;
import org.gestion.services.IUtilisateurService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")

public class RestLoginController {

	@Autowired
	@Qualifier("utilisateurServiceJpa")
	private IUtilisateurService utilisateurServiceJpa;

	@Autowired
	@Qualifier("utilisateurServiceRepository")
	private IUtilisateurService utilisateurServiceRepository;

	@Autowired
	@Qualifier("groupeServiceJpa")
	private IGroupeService groupeServiceJpa;

	private Utilisateur monUtilisateur;
	private Groupe monGroupe;

	// *********************************** //
	// ******* GET utilisateur BY EMAIL ********** //
	// *********************************** //

	@RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
	public String Login(@RequestBody Login newLogin) {
		JSONObject jObj;
		jObj = new JSONObject();

		try {
			try {

				monUtilisateur = utilisateurServiceJpa.getUtilisateurByEmail(newLogin.getEmail());

			} catch (Exception e) {

				jObj.put("action", "login");
				jObj.put("description", "Utilisateur inconnu");
				monUtilisateur = new Utilisateur();

			}

			if (monUtilisateur == null) {

				jObj.put("action", "login");
				jObj.put("description", "Mot de Passe érroné");

				return jObj.toString();

			} else {

				if (monUtilisateur.getMotDePasse().equals(newLogin.getMotDePasse())) {

					Token monToken = new Token();
					String base64encodedString = monToken.creerToken(monUtilisateur.getIdUtilisateur());
					jObj.put("action", "login");
					jObj.put("description", "Connexion réussie");
					jObj.put("token", base64encodedString);

					try {
						
						monGroupe = groupeServiceJpa.getGroupeByUtilisateur(monUtilisateur);

						jObj.put("userData", new JSONObject(monGroupe));

					} catch (Exception e) {

						jObj.put("userGroup", "");

					}

					return jObj.toString();
				}
			}
			jObj.put("action", "login");
			jObj.put("description", "Mot de passe érroné");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jObj.toString();

	}
}
