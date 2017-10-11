package org.gestion.web.controller;

import java.util.List;

import org.gestion.entite.Utilisateur;
import org.gestion.entite.Token;
import org.gestion.entite.Login;
import org.gestion.services.IUtilisateurService;
import org.gestion.services.impl.UtilisateurServiceJpa;
import org.hibernate.query.criteria.internal.expression.ConcatExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

	private Utilisateur monUtilisateur;
	
	// *********************************** //
	// ******* GET utilisateur BY EMAIL ********** //
	// *********************************** //

	@RequestMapping( method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public String Login(@RequestBody Login newLogin) {
			JSONObject jObj;
			jObj = new JSONObject();
			
			try {
				 try {
					
					 monUtilisateur = utilisateurServiceJpa.getUtilisateurByEmail(newLogin.getEmail());
					 
				} catch (Exception e) {
					
					jObj.put("action", "login");
					jObj.put("description", "Utilisateur inconnu");
					monUtilisateur=new Utilisateur();
					
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
						jObj.put("userData", new JSONObject(monUtilisateur));
						
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
