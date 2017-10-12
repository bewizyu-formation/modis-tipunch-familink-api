package org.gestion.web.controller;

import org.gestion.entite.EmailSender;
import org.gestion.entite.Login;
import org.gestion.entite.Token;
import org.gestion.entite.Utilisateur;
import org.gestion.services.IUtilisateurService;
import org.gestion.services.impl.UtilisateurServiceJpa;
import org.hibernate.query.criteria.internal.expression.ConcatExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@RequestMapping("/forgot-password")
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

	@RequestMapping( method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
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
			monUtilisateur=new Utilisateur();
			return jObj.toString();
			
	}
}
