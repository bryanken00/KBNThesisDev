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
		user = EmailAddress;
		pass_ = Password;
	}
	
    public void sendAccountEmail() {
        // Sender's email configuration
        final String username = "accountinfo@kissedbynature.online";
        final String password = "KENKENken0011@";

        // Recipient's email address
        String recipientEmail = EmailAdd;

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
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Kissed By Nature Account.");
            message.setText("KBN account \nUsername:" + user + "\nPassword:" + pass_ + "\nbit.ly/40Th5Qj");

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}