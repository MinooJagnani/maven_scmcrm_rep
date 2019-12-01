package maven_smcrm_utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeMessage.RecipientType;

import org.testng.Reporter;

public class EmailUtility {
	public static void sendEmailText() throws FileNotFoundException, IOException, MessagingException
	{
		Reporter.log("enter EMAIL", true);

		Properties p = new Properties();
		p.load(new FileInputStream("./mail_properties1.properties"));
		Session session = Session.getInstance(p, new EmailConfigure());
		MimeMessage mail= new MimeMessage(session);
		InternetAddress to = new InternetAddress("minoo.jagnani@gmail.com");
		mail.addRecipient(RecipientType.TO,to);
		mail.setSubject("code");
		mail.setText("Hi");
		Transport.send(mail);
		Reporter.log("AFTER EMAIL SEND WITH TEXT", true);

	}
	
	public static void sendEmailWithAttacment() throws FileNotFoundException, IOException, MessagingException
	{
		Properties p = new Properties();
		p.load(new FileInputStream("./mail_properties1.properties"));
		Session session = Session.getInstance(p, new EmailConfigure());
		MimeMessage mail= new MimeMessage(session);
		InternetAddress to = new InternetAddress("minoo.jagnani@gmail.com");
		mail.addRecipient(RecipientType.TO,to);
		mail.setSubject("code");
	
		
		mail.setText("Hi, this is with attachment");
		
		//add attachment
		Multipart multipart = new MimeMultipart();
		MimeBodyPart bp = new MimeBodyPart();
		FileDataSource ds = new FileDataSource(new File("C:\\minoo\\DEMO\\abc1.png"));
		bp.setDataHandler(new DataHandler(ds));
		bp.setFileName("my photo");
		multipart.addBodyPart(bp);
		mail.setContent(multipart);
		Transport.send(mail);
		Reporter.log("AFTER EMAIL SEND WITH Attachment", true);
	}


}




