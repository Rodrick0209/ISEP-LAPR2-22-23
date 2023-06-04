package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.ui.console.utils.Files;
import pt.isep.lei.esoft.auth.domain.model.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import static java.nio.file.Files.readAllBytes;
import static pt.ipp.isep.dei.esoft.project.ui.console.utils.Files.*;

/**
 * The type Send email.
 */
public class SendEmail {

    /**
     * Send email to employee.
     *
     * @param email the email
     */
    public static void sendEmailToEmployee(String email) {
        String to = email;
        String from = "noreply.realestate.isep@gmail.com";
        String file = path + "emailEmployee.txt";
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("noreply.realestate.isep@gmail.com", "gighmvaxdiidrhaj");
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("This is test subject line");
            String content = readFile(file);
            message.setText(content);
            Transport.send(message);
        } catch (MessagingException | IOException e) {
            System.out.println("Error. Email not sent.");
        }

    }

    /**
     * Send email to user.
     *
     * @param email the email
     */
    public static void sendEmailToUser(String email) {
        String to = email;
        String from = "noreply.realestate.isep@gmail.com";
        String file = path + "emailUser.txt";
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("noreply.realestate.isep@gmail.com", "gighmvaxdiidrhaj");
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("This is test subject line");
            String content = readFile(file);
            message.setText(content);
            Transport.send(message);
        } catch (MessagingException | IOException e) {
            System.out.println("Error. Email not sent.");
        }

    }

    private static String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        byte[] fileBytes = readAllBytes(path);
        return new String(fileBytes);
    }


}
