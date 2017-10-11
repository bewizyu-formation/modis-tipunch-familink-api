package org.gestion.entite;


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

public class EmailSender {

	private final static String MAILER_VERSION = "Java";

	public static boolean envoyerMailSMTP(String serveur, boolean debug) {

		boolean result = false;

		try {

			Properties prop = System.getProperties();

			prop.put("mail.smtp.host", serveur);

			Session session = Session.getDefaultInstance(prop, null);

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress("vr.you@hotmail.fr"));

			InternetAddress[] internetAddresses = new InternetAddress[1];

			internetAddresses[0] = new InternetAddress("vr.you@hotmail.fr");

			message.setRecipients(Message.RecipientType.TO, internetAddresses);

			message.setSubject("Demande de nouveau mot de passe");

			message.setText("http://localhost:8080/atelier/mvc/ReinitialisationMDP/SEVMTE8=");

			message.setHeader("X-Mailer", MAILER_VERSION);

			message.setSentDate(new Date());
			
			// à enlever en prod 
			session.setDebug(debug);

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