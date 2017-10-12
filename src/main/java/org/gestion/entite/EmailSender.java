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


	public static boolean envoyerMailSMTP() {


		boolean result = false;

		try {

			final String username = "elboy62@gmail.com";
			final String password = "boyel6262";
			
			String to = "elboy62@gmail.com";

			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.starttls.enable", "true");

			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress("elboy62@gmail.com"));

			InternetAddress[] internetAddresses = new InternetAddress[1];

			internetAddresses[0] = new InternetAddress("elboy62@gmail.com");


			message.setRecipients(Message.RecipientType.TO, internetAddresses);

			message.setSubject("Demande de nouveau mot de passe");

			
			Token monToken = new Token();
			monToken.creerToken();

			message.setText("http://localhost:4200/ReinitialisationMDP/"+monToken.getCorps());

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