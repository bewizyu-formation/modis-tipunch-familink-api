package org.gestion.services;

import org.gestion.entite.Utilisateur;

public interface IEmailSenderService {
	
	boolean envoyerMailSMTP( Utilisateur utilisateur );

}
