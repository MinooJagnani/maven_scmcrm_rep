package maven_smcrm_utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class EmailConfigure extends Authenticator
{
	public PasswordAuthentication getPasswordAuthentication()
	{
		PasswordAuthentication p = new PasswordAuthentication("minoo.jagnani@gmail.com","b1202gpaoa");
		return p;
	}

}
