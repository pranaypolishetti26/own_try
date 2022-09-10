package com.example.demo.Utilities;
import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class Mail {
    public static boolean sendMail(String to)
    {
        String from = "sairammittu0306@gmail.com";
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sairammittu0306@gmail.com","Sairamgm*362");
            }
        });
        try
        {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Password Change Request");
            message.setText("We've received a password change request for your account. " +
                            "This link will expire in 24 hours. " +
                            "Please use the below link to reset your password and donot share the link."+
                            "If you did not request a password change, please ignore this email, no changes will be made to your account.");
            Transport.send(message);
            return true;
        }
        catch (MessagingException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
