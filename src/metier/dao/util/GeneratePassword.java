package metier.dao.util;


import java.security.SecureRandom;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class GeneratePassword {	
	
	
	public static void main(String[] args) {
		
		String pass = generateRandomPassword(8);
		
		sendEMailToUser("youssef el gourari message from ehealth", pass ,"youssefelgourari97@gmail.com");

	}
	
	
	public static void sendEMailToUser(String messages, String password, String email) {
		String username = "healthapp775@gmail.com";
		String pass = "health2021";
		
		Properties prop = new Properties();
		
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "25");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(username, pass);
		    }
		});
		
		Message message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Mail Subject");
		} catch (AddressException e3) {
			e3.printStackTrace();
		} catch (MessagingException e3) {
			e3.printStackTrace();
		}
		
		
		String message_envoyer = messages + " \n " + password ;
		
		try {
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(message_envoyer, "text/html");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);
			message.setContent(multipart);
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	 public static String generateRandomPassword(int len)
	    {
	        // ASCII range - alphanumeric (0-9, a-z, A-Z)
	        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	 
	        SecureRandom random = new SecureRandom();
	        StringBuilder sb = new StringBuilder();
	 
	        // each iteration of loop choose a character randomly from the given ASCII range
	        // and append it to StringBuilder instance
	 
	        for (int i = 0; i < len; i++) {
	            int randomIndex = random.nextInt(chars.length());
	            sb.append(chars.charAt(randomIndex));
	        }
	 
	        return sb.toString();
	    }
}
