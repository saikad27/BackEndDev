import jakarta.mail.*;
        import jakarta.mail.internet.*;
        import java.util.Properties;

public class EmailSender {

    public static void main(String[] args) {
        // Sender and receiver details
        final String fromEmail = "sairajkad501@gmail.com";
        final String password = "kryfsozftgcsqqpe"; // Use App Password if 2FA is enabled
        final String toEmail = "dhanshreekad25@gmail.com";

        // SMTP server configuration
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // For Gmail
        props.put("mail.smtp.port", "587"); // TLS Port
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS

        // Create a session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Compose the message
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            msg.setSubject("Hello from Java!");
            msg.setText("This is a test email sent from a Java program.");

            // Send the message
            Transport.send(msg);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

