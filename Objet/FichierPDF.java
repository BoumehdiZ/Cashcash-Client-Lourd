// 
// Decompiled by Procyon v0.5.36
// 

package Objet;

import java.awt.Image;
import java.awt.Graphics2D;
import com.qoppa.pdfWriter.PDFPage;
import java.io.IOException;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import com.qoppa.pdfWriter.PDFGraphics;
import java.awt.print.PageFormat;
import com.qoppa.pdfWriter.PDFDocument;

public class FichierPDF
{
    public void creerPDF(final Client unClient) {
        try {
            final PDFDocument pdfDoc = new PDFDocument();
            final PDFPage page = pdfDoc.createPage(null);
            final Graphics2D graphics = page.createGraphics();
            graphics.setFont(PDFGraphics.HELVETICA.deriveFont(10.0f));
            graphics.drawString("Num\u00e9ro Client : " + unClient.getNumClient(), 10, 50);
            graphics.setFont(PDFGraphics.HELVETICA.deriveFont(24.0f));
            graphics.drawString("Fiche relance", 230, 85);
            final ImageIcon imgIcon = new ImageIcon(this.getClass().getResource("/images/logo.png"));
            final Image img = imgIcon.getImage();
            graphics.drawImage(img, 450, 20, 75, 75, null);
            graphics.setFont(PDFGraphics.HELVETICA.deriveFont(12.0f));
            graphics.drawString("Monsieur/Madame " + unClient.getPrenom() + " " + unClient.getNom() + ",", 50, 120);
            if (unClient.getLeContrat() != null) {
                if (unClient.getLeContrat().estValide()) {
                    graphics.drawString("Votre contrat n°" + unClient.getLeContrat().getNumContrat() + " arrivera \u00e0 \u00e9ch\u00e9ance le " + unClient.getLeContrat().getDateEcheance().afficheDate() + ".", 50, 140);
                }
                else {
                    graphics.drawString("Votre contrat n°" + unClient.getLeContrat().getNumContrat() + " est arriv\u00e9 \u00e0 \u00e9ch\u00e9ance le " + unClient.getLeContrat().getDateEcheance().afficheDate() + ".", 50, 140);
                }
                graphics.drawString("Si vous souhaitez le renouveler, veuillez nous recontactez.", 50, 160);
            }
            else {
                graphics.drawString("Vous avez achet\u00e9s des mat\u00e9riels chez nous sans les assur\u00e9s.", 50, 140);
                graphics.drawString("Si vous souhaitez les assur\u00e9s, veuillez nous recontactez.", 50, 160);
            }
            graphics.drawString("Cordialement,", 440, 200);
            graphics.drawString("CashCash", 440, 220);
            pdfDoc.addPage(page);
            pdfDoc.saveDocument("relancePDF.pdf");
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Le PDF ne s'est pas cr\u00e9er !", "Erreur PDF", 0);
        }
    }
}
