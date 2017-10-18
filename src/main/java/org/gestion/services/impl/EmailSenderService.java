package org.gestion.services.impl;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.gestion.entite.Token;
import org.gestion.entite.Utilisateur;

public class EmailSenderService {

	public static boolean envoyerMailSMTP(Utilisateur utilisateur) {

		boolean result = false;

		try {

			final String username = "tipunchfamilink@gmail.com";
			final String password = "familink";

			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.starttls.enable", "true");

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress("tipunchfamilink@gmail.com"));

			InternetAddress internetAddresses = new InternetAddress();

			internetAddresses = new InternetAddress(utilisateur.getEmail());

			message.setRecipient(Message.RecipientType.TO, internetAddresses);

			message.setSubject("Demande de nouveau mot de passe");

			Token monToken = new Token();
			monToken.creerToken(utilisateur.getIdUtilisateur());

			message.setText("Veuillez cliquer sur lien pour réinitialiser votre mot de passse:" + "\n"
					+ "http://localhost:4200/update-password/" + monToken.getCorps());

			message.setSentDate(new Date());

			Transport.send(message);

			result = true;

		} catch (AddressException e) {

			e.printStackTrace();

		} catch (MessagingException e) {

			e.printStackTrace();

		}

		return result;

	}

}