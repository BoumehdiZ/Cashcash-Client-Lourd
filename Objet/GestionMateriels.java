// 
// Decompiled by Procyon v0.5.36
// 

package Objet;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.ErrorHandler;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Iterator;
import java.util.ArrayList;
import java.sql.SQLException;

public class GestionMateriels
{
    private PersistanceSQL donnees;
    
    public GestionMateriels(final PersistanceSQL lesDonnees) {
        this.donnees = lesDonnees;
    }
    
    public Client getClient(final int idClient) throws SQLException {
        final Client client = (Client)this.donnees.ChargerDepuisBase(Integer.toString(idClient), "Client");
        return client;
    }
    
    public String XmlClient(final Client unClient) {
        ArrayList<Materiel> listeMaterielsAssures = null;
        ArrayList<Materiel> listeMaterielsNonAssures = null;
        String xml = "<?xml version = \"1.0\" encoding=\"UTF-8\" ?> \n";
        xml = String.valueOf(xml) + "<listeMateriel> \n";
        xml = String.valueOf(xml) + "<materiels numClient=\"" + unClient.getNumClient() + "\"> \n";
        if (unClient.getLesMateriels() != null) {
            listeMaterielsNonAssures = unClient.getMaterielsHorsContrat();
            if (unClient.getLeContrat() != null) {
                listeMaterielsAssures = unClient.getMaterielsSousContrat();
            }
            if (listeMaterielsAssures != null) {
                xml = String.valueOf(xml) + "<sousContrat> \n";
                for (final Materiel m : listeMaterielsAssures) {
                    xml = String.valueOf(xml) + m.xmlMateriel();
                }
                xml = String.valueOf(xml) + "</sousContrat> \n";
            }
            if (listeMaterielsNonAssures != null) {
                xml = String.valueOf(xml) + "<horsContrat> \n";
                for (final Materiel m : listeMaterielsNonAssures) {
                    xml = String.valueOf(xml) + m.xmlMateriel();
                }
                xml = String.valueOf(xml) + "</horsContrat> \n";
            }
        }
        xml = String.valueOf(xml) + "</materiels> \n";
        xml = String.valueOf(xml) + "</listeMateriel> \n";
        return xml;
    }
    
    public static boolean XmlClientValide(final String xml) throws ParserConfigurationException {
        final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setValidating(true);
        final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        documentBuilder.setErrorHandler(new ErrorHandler() {
            @Override
            public void error(final SAXParseException arg0) throws SAXException {
            }
            
            @Override
            public void fatalError(final SAXParseException arg0) throws SAXException {
            }
            
            @Override
            public void warning(final SAXParseException arg0) throws SAXException {
            }
        });
        try {
            documentBuilder.parse(xml);
            return true;
        }
        catch (SAXException | IOException ex2) {
            final Exception ex;
            final Exception e = ex;
            e.printStackTrace();
            return false;
        }
    }
    
    public void creerXml(final GestionMateriels gm, final Client unClient) throws SQLException {
        final FichierXML xml = new FichierXML();
        final String nomFichier = "materielClient" + unClient.getNumClient() + ".xml";
        final String xmlStr = gm.XmlClient(unClient);
        try {
            xml.ouvrir(nomFichier, "e");
            xml.ecriture(xmlStr);
            xml.fermer();
            XmlClientValide(nomFichier);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
