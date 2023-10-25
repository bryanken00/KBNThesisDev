package KBN.Module.Marketing.preRegis;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	
	private String EmailAdd = "";
	private String user = "";
	private String pass_ = "";
	
	public void setDetails(String EmailAddress,String Username, String Password) {
		EmailAdd = EmailAddress;
		user = Username;
		pass_ = Password;
	}
	
    public void sendAccountEmail() {
        // Namecheap email configuration
        final String username = "no-reply@kissbynature.shop";
        final String password = "KENKENken0011@";

        // Set up properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "mail.privateemail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465"); // Use port 465 for SSL
        props.put("mail.smtp.ssl.enable", "true"); // Enable SSL

        // Create a session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a MimeMessage
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(EmailAdd));
            message.setSubject("KBN Account");
            message.setText("KBN account \nUsername:" + user + "\nPassword:" + pass_ + "\nLogin Here: https://kissbynature.shop/homepage/");

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}