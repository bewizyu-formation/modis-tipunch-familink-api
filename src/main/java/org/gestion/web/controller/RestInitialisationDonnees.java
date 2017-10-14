package org.gestion.web.controller;

import org.gestion.services.IInitialisationDonnees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

/** Controller exécuté une fois que le contexte spring est entièrement chargé: event)
 * 
 * @author Damien Pickel
 *
 */

@Controller
public class RestInitialisationDonnees  extends ContextRefreshedEvent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7619789121561803369L;

	public RestInitialisationDonnees(ApplicationContext source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private IInitialisationDonnees initialisationDonnees;
	
	@EventListener
	public void initialisationDonneesBDD(ContextRefreshedEvent event){
		
		
		initialisationDonnees.initialiserProfils();
		initialisationDonnees.initialiserContact();		
		initialisationDonnees.initialiserUtilisateur();
		
	}

}
