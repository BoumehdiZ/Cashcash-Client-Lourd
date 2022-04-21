// 
// Decompiled by Procyon v0.5.36
// 

package Objet;

import javax.activation.DataSource;
import javax.mail.Multipart;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.mail.Transport;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.Message;
import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import java.util.Properties;

public class Mail
{
    private String username;
    private String password;
    
    public Mail() {
        this.username = "CashcashLille59@gmail.com";
        this.password = "Cashcash59";
    }
    
    public void envoyer(final Client unClient) {
        final Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        final Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Mail.this.username, Mail.this.password);
            }
        });
        try {
            final Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("CashcashLille59@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(unClient.getEmail()));
            message.setSubject("CASHCASH : Fiche de Ralance");
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Bonjour " + unClient.getPrenom() + " " + unClient.getNom() + ", ");
            final Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            if (unClient.getLeContrat() != null) {
                messageBodyPart.setText("voici ci-joint une fiche de relance avec vos informations afin de facilit\u00e9 le renouvellement.");
            }
            else {
                messageBodyPart.setText("voici ci-joint une fiche de relance avec vos informations de cr\u00e9er un contrat de maintenance chez nous.");
            }
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            final DataSource source = (DataSource)new FileDataSource("relancePDF.pdf");
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("relancePDF.pdf");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Le mail a bien \u00e9t\u00e9 envoy\u00e9 !", "Mail", 1);
        }
        catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Le mail n'a pas \u00e9t\u00e9 transmis !", "Erreur", 0);
        }
    }
    
    public void envoyerPDF(final Client unClient) {
        final FichierPDF pdf = new FichierPDF();
        pdf.creerPDF(unClient);
        this.envoyer(unClient);
    }
}
