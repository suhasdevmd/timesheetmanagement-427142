package iiitb.timesheet.model;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class SendMail {
	
	private  static Properties properties = null;
	
	static {
		try {
			properties = new Properties();
			InputStream  inputStream  = SendMail.class.getClassLoader().getResourceAsStream("mail.properties");
			properties.load(inputStream);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void sendTextMail(String email, String msgSubject, String msgBody) throws  Exception {
		System.out.println("email : "+email);

		String to = email;
		String from = "webmaster.iiitb@gmail.com";

		String subject = msgSubject;
		String body = msgBody;
		
		System.out.println("to : "+to);
		System.out.println("from :"+from );

		if (properties.isEmpty()) {
			throw new Exception("Cannot  send mail. Host  data not available.");
		}

		System.out.println("username = "+properties.get("mail.login.username")+"password = "+properties.get("mail.login.password"));
		
		Session  session  = Session.getInstance(properties, new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(
						(String)properties.get("mail.login.username"), 
						(String)properties.get("mail.login.password"));
			}
		});

		InternetAddress  fromAddress  = new InternetAddress(from);
		InternetAddress  toAddress =  new  InternetAddress(to);

		Message  msg  = new MimeMessage(session);
		msg.setFrom(fromAddress);
		msg.setSubject(subject);
		msg.setRecipient(RecipientType.TO, toAddress);
		msg.setContent(body, "text/plain");
		Transport.send(msg);
	}
}