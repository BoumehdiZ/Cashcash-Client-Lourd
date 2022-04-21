// 
// Decompiled by Procyon v0.5.36
// 

package Objet;

import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;

public class PersistanceSQL
{
    Connection connexion;
    ResultSet resultat;
    ResultSet resultatMateriels;
    ResultSet resultatContrat;
    
    public PersistanceSQL(final String ipBase, final int port, final String nomBaseDonnees) {
        this.connexion = null;
        this.resultat = null;
        this.resultatMateriels = null;
        this.resultatContrat = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            this.connexion = DriverManager.getConnection("jdbc:mysql://" + ipBase + ":" + port + "/" + nomBaseDonnees, "zeyd", "zeyd");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Connexion indisponible !", "Erreur de connexion", 0);
            System.exit(0);
        }
    }
    
    public void RangerDansBase(final Object unObjet) {
        try {
            PreparedStatement req = null;
            final String simpleName;
            switch (simpleName = unObjet.getClass().getSimpleName()) {
                case "TypeContratMaintenance": {
                    final TypeContratMaintenance leTypeContratMaintenance = (TypeContratMaintenance)unObjet;
                    req = this.connexion.prepareStatement("REPLACE INTO type_contrat VALUES (?,?,?)");
                    req.setString(1, leTypeContratMaintenance.getRefTypeContrat());
                    req.setString(2, leTypeContratMaintenance.getDelaiIntervention());
                    req.setInt(3, leTypeContratMaintenance.getTauxApplicable());
                    req.executeUpdate();
                    break;
                }
                case "ContratMaintenance": {
                    final ContratMaintenance leContrat = (ContratMaintenance)unObjet;
                    req = this.connexion.prepareStatement("REPLACE INTO contrat_maintenance VALUES (?,?,?,?,?)");
                    req.setString(1, leContrat.getNumContrat());
                    req.setString(2, leContrat.getDateSignature().toString());
                    req.setString(3, leContrat.getDateEcheance().toString());
                    req.setString(4, leContrat.getLeTypeContratMaintenance().getRefTypeContrat());
                    req.setString(5, leContrat.getLeClient().getNumClient());
                    req.executeUpdate();
                    break;
                }
                case "Materiel": {
                    final Materiel leMateriel = (Materiel)unObjet;
                    req = this.connexion.prepareStatement("REPLACE INTO materiel VALUES (?,?,?,?,?,?,?,?)");
                    req.setInt(1, leMateriel.getNumSerie());
                    req.setString(2, leMateriel.getDateVente().toString());
                    req.setString(3, leMateriel.getDateInstallation().toString());
                    req.setDouble(4, leMateriel.getPrixVente());
                    req.setString(5, leMateriel.getEmplacement());
                    req.setString(6, leMateriel.getLeType().getReferenceInterne());
                    req.setString(7, leMateriel.getLeClient().getNumClient());
                    req.setString(8, leMateriel.getLeContrat().getNumContrat());
                    req.executeUpdate();
                    break;
                }
                case "Famille": {
                    final Famille laFamille = (Famille)unObjet;
                    req = this.connexion.prepareStatement("REPLACE INTO famille VALUES (?,?)");
                    req.setString(1, laFamille.getCodeFamille());
                    req.setString(2, laFamille.getLibelleFamille());
                    req.execute();
                    break;
                }
                case "TypeMateriel": {
                    final TypeMateriel leTypeMateriel = (TypeMateriel)unObjet;
                    req = this.connexion.prepareStatement("REPLACE INTO type_materiel VALUES (?,?,?)");
                    req.setString(1, leTypeMateriel.getReferenceInterne());
                    req.setString(2, leTypeMateriel.getLibelleTypeMateriel());
                    req.setString(3, leTypeMateriel.getLaFamille().getCodeFamille());
                    req.executeUpdate();
                    break;
                }
                case "Client": {
                    final Client client = (Client)unObjet;
                    req = this.connexion.prepareStatement("Replace INTO client VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    req.setString(1, client.getNumClient());
                    req.setString(2, client.getPrenom());
                    req.setString(3, client.getNom());
                    req.setString(4, client.getRaisonSociale());
                    req.setString(5, client.getSiren());
                    req.setString(6, client.getCodeApe());
                    req.setString(7, client.getAdresse());
                    req.setString(8, client.getTelClient());
                    req.setString(9, client.getFax());
                    req.setString(10, client.getEmail());
                    req.setInt(11, client.getDureeDeplacement());
                    req.setInt(12, client.getDistanceKm());
                    req.setInt(13, client.getNumeroAgence());
                    req.executeUpdate();
                    break;
                }
                default:
                    break;
            }
        }
        catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }
    
    public Object ChargerDepuisBase(final String id, final String nomClasse) throws SQLException {
        Object obj = null;
        final Statement req = this.connexion.createStatement();
        switch (nomClasse) {
            case "Type Contrat": {
                this.resultat = req.executeQuery("Select * from type_contrat where refTypeContrat = '" + id + "'");
                while (this.resultat.next()) {
                    final String refTypeContrat = this.resultat.getString("refTypeContrat");
                    final String delaiIntervention = this.resultat.getString("delai_intervention");
                    final int tauxApplicable = this.resultat.getInt("Taux_applicable");
                    obj = new TypeContratMaintenance(refTypeContrat, delaiIntervention, tauxApplicable);
                }
                break;
            }
            case "Contrat Maintenance": {
                this.resultat = req.executeQuery("Select * from contrat_maintenance where numero_contrat = " + id);
                while (this.resultat.next()) {
                    final String numContrat = this.resultat.getString("numero_contrat");
                    final String dateSig = this.resultat.getString("date_signature");
                    final int anneeDateSig = Integer.parseInt(dateSig.substring(0, 4));
                    final int moisDateSig = Integer.parseInt(dateSig.substring(5, 7));
                    final int jourDateSig = Integer.parseInt(dateSig.substring(8, 10));
                    final DateTp dateSignature = new DateTp(anneeDateSig, moisDateSig, jourDateSig);
                    final String dateEche = this.resultat.getString("date_echeance");
                    final int anneeDateEche = Integer.parseInt(dateEche.substring(0, 4));
                    final int moisDateEche = Integer.parseInt(dateEche.substring(5, 7));
                    final int jourDateEche = Integer.parseInt(dateEche.substring(8, 10));
                    final DateTp dateEcheance = new DateTp(anneeDateEche, moisDateEche, jourDateEche);
                    final String refTypeContrat2 = this.resultat.getString("refTypeContrat");
                    final TypeContratMaintenance leTypeContratMaintenance = (TypeContratMaintenance)this.ChargerDepuisBase(refTypeContrat2, "Type Contrat");
                    obj = new ContratMaintenance(numContrat, dateSignature, dateEcheance, leTypeContratMaintenance);
                }
                break;
            }
            case "Type Mat\u00e9riel": {
                this.resultat = req.executeQuery("Select * from type_materiel where reference = '" + id + "'");
                while (this.resultat.next()) {
                    final String referenceInterne = this.resultat.getString("reference");
                    final String libelleTypeMateriel = this.resultat.getString("libelle");
                    final String codeFamille = this.resultat.getString("code_famille");
                    final Famille laFamille = (Famille)this.ChargerDepuisBase(codeFamille, "Famille");
                    obj = new TypeMateriel(referenceInterne, libelleTypeMateriel, laFamille);
                }
                break;
            }
            case "Mat\u00e9riel": {
                this.resultat = req.executeQuery("Select * from materiel where numero_serie = " + id);
                while (this.resultat.next()) {
                    final int numSerie = this.resultat.getInt("numero_serie");
                    final String dateV = this.resultat.getString("date_de_vente");
                    final int anneeDateV = Integer.parseInt(dateV.substring(0, 4));
                    final int moisDateV = Integer.parseInt(dateV.substring(5, 7));
                    final int jourDateV = Integer.parseInt(dateV.substring(8, 10));
                    final DateTp dateVente = new DateTp(anneeDateV, moisDateV, jourDateV);
                    final String dateInstal = this.resultat.getString("date_installation");
                    final int anneeDateInstal = Integer.parseInt(dateInstal.substring(0, 4));
                    final int moisDateInstal = Integer.parseInt(dateInstal.substring(5, 7));
                    final int jourDateInstal = Integer.parseInt(dateInstal.substring(8, 10));
                    final DateTp dateInstallation = new DateTp(anneeDateInstal, moisDateInstal, jourDateInstal);
                    final Double prixVente = this.resultat.getDouble("prix_vente");
                    final String emplacement = this.resultat.getString("emplacement");
                    final String referenceInterne2 = this.resultat.getString("reference_type");
                    final TypeMateriel leTypeMateriel = (TypeMateriel)this.ChargerDepuisBase(referenceInterne2, "Type Mat\u00e9riel");
                    obj = new Materiel(numSerie, dateVente, dateInstallation, prixVente, emplacement, leTypeMateriel);
                }
                break;
            }
            case "Famille": {
                this.resultat = req.executeQuery("Select * from famille where code_famille = " + id);
                while (this.resultat.next()) {
                    final String codeFamille2 = this.resultat.getString("code_famille");
                    final String libelleFamille = this.resultat.getString("libelle");
                    obj = new Famille(codeFamille2, libelleFamille);
                }
                break;
            }
            case "Client": {
                Client leClient = null;
                this.resultat = req.executeQuery("Select * from client where numero_client = " + id);
                while (this.resultat.next()) {
                    final String numeroClient = this.resultat.getString("numero_client");
                    final String prenom = this.resultat.getString("prenomC");
                    final String nom = this.resultat.getString("nomC");
                    final String raisonSociale = this.resultat.getString("raison_sociale");
                    final String siren = this.resultat.getString("siren");
                    final String codeApe = this.resultat.getString("code_APE");
                    final String adresse = this.resultat.getString("adresse");
                    final String telClient = this.resultat.getString("telephone");
                    final String fax = this.resultat.getString("fax");
                    final String email = this.resultat.getString("email");
                    final int dureeDeplacement = this.resultat.getInt("duree_deplacement");
                    final int distanceKm = this.resultat.getInt("distance_km");
                    final int numeroAgence = this.resultat.getInt("numero_agence");
                    leClient = new Client(numeroClient, prenom, nom, raisonSociale, siren, codeApe, adresse, telClient, fax, email, dureeDeplacement, distanceKm, numeroAgence);
                    this.resultat = req.executeQuery("Select numero_contrat from contrat_maintenance where numero_client = " + leClient.getNumClient());
                    while (this.resultat.next()) {
                        final String numeroContrat = this.resultat.getString("numero_contrat");
                        final ContratMaintenance unContrat = (ContratMaintenance)this.ChargerDepuisBase(numeroContrat, "Contrat Maintenance");
                        unContrat.setLeClient(leClient);
                        leClient.setLeContrat(unContrat);
                    }
                    this.resultatMateriels = req.executeQuery("Select numero_serie, numero_contrat from Materiel where numero_client = " + leClient.getNumClient());
                    while (this.resultatMateriels.next()) {
                        final String numSerie2 = this.resultatMateriels.getString("numero_serie");
                        final String numContrat2 = this.resultatMateriels.getString("numero_contrat");
                        final Materiel leMateriel = (Materiel)this.ChargerDepuisBase(numSerie2, "Mat\u00e9riel");
                        if (leMateriel != null) {
                            leMateriel.setLeClient(leClient);
                            if (leClient.getLeContrat() != null && numContrat2 != null) {
                                leMateriel.setLeContrat(leClient.getLeContrat());
                                leClient.getLeContrat().ajouteMateriel(leMateriel);
                            }
                            leClient.ajouteMateriel(leMateriel);
                        }
                    }
                }
                obj = leClient;
                break;
            }
            default:
                break;
        }
        return obj;
    }
    
    public ArrayList<Client> ChargerLesClientsDepuisBase() throws SQLException {
        final ArrayList<Client> lesClients = new ArrayList<Client>();
        final Statement req = this.connexion.createStatement();
        final ResultSet resultatClient = req.executeQuery("Select numero_client from client");
        while (resultatClient.next()) {
            final String numeroClient = resultatClient.getString("numero_client");
            final Client unClient = (Client)this.ChargerDepuisBase(numeroClient, "Client");
            lesClients.add(unClient);
        }
        return lesClients;
    }
}
