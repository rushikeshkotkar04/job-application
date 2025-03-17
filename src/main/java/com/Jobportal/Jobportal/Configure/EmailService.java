package com.Jobportal.Jobportal.Configure;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

@Service
public class EmailService {
    public void sendEmail(String email, String subject, String body) {
        String host = "smtp.gmail.com";  // Gmail SMTP server
        final String username = "rshksh019@gmail.com"; // your Gmail address
        final String password = "vtzs nrvm orjf uniy"; // your Gmail password or App Password if 2FA is enabled

        // Recipient's email
        String to = email;
        System.out.println(to);

        // Set properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");  // Use port 587 for TLS
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enables TLS

        // Get the default Session object
        Session sess = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object
            MimeMessage message = new MimeMessage(sess);

            // Set From: header field
            message.setFrom(new InternetAddress(username));

            // Set To: header field
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Set the actual message
            message.setText(body);

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
