package org.gestion.web.controller;

import org.gestion.entite.EmailSender;
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
@RequestMapping("/DemandeMDP")
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

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String getUtilisateurByIdWithQueryParam(@RequestParam("email") String email) {
			
			JSONObject jObj;
			jObj = new JSONObject();
			
			try {
					
				  monUtilisateur = utilisateurServiceJpa.getUtilisateurByEmail(email);
	
				  //EmailSender.envoyerMailSMTP("10.10.50.8",true);
				  
				  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				  /*Date date = new Date();
				  date.setTime(timestamp.getTime());
				  String formattedDate = new SimpleDateFormat("yyyyMMdd").format(date);
				  String aCoder = Integer.toString(monUtilisateur.getIdUtilisateur())+"-"+formattedDate;
				  String base64encodedString = Base64.getEncoder().encodeToString(aCoder.getBytes("utf-8"));*/
				  String base64encodedString = Base64.getEncoder().encodeToString("HELLO".getBytes("utf-8"));
				  //String token = "http://localhost:8080/atelier/mvc/ReinitialisationMDP/"+base64encodedString;
				  //jObj.put("action", "login");
				  //jObj.put("description", "email connu, envoie d'un mail");
				  jObj.put("tokenReinitialisation", base64encodedString);
					 
				} catch (Exception e) {
					
					jObj.put("action", "login");
					jObj.put("description", "email inconnu");
					
				}				
			monUtilisateur=new Utilisateur();
			return jObj.toString();
			
	}
}
