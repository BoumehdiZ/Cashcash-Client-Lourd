// 
// Decompiled by Procyon v0.5.36
// 

package Objet;

public class Materiel
{
    private int numSerie;
    private DateTp dateVente;
    private DateTp dateInstallation;
    private double prixVente;
    private String emplacement;
    private TypeMateriel leType;
    private Client leClient;
    private ContratMaintenance leContrat;
    
    public Materiel(final int numSerie, final DateTp dateVente, final DateTp dateInstallation, final double prixVente, final String emplacement, final TypeMateriel leType) {
        this.numSerie = numSerie;
        this.dateVente = dateVente;
        this.dateInstallation = dateInstallation;
        this.prixVente = prixVente;
        this.emplacement = emplacement;
        this.leType = leType;
        this.leClient = null;
    }
    
    public String xmlMateriel() {
        String xml = "<materiel numSerie=\"" + this.numSerie + "\"> \n";
        xml = String.valueOf(xml) + "<type refInterne=\"" + this.leType.getReferenceInterne() + "\" libelle=\"" + this.leType.getLibelleTypeMateriel() + "\"/> \n";
        xml = String.valueOf(xml) + "<famille code=\"" + this.leType.getLaFamille().getCodeFamille() + "\" libelle=\"" + this.leType.getLaFamille().getLibelleFamille() + "\"/> \n";
        xml = String.valueOf(xml) + "<date_vente>" + this.dateVente.toString() + "</date_vente> \n";
        xml = String.valueOf(xml) + "<date_installation>" + this.dateInstallation.toString() + "</date_installation> \n";
        xml = String.valueOf(xml) + "<prix_vente>" + this.prixVente + "</prix_vente> \n";
        xml = String.valueOf(xml) + "<emplacement>\"" + this.emplacement + "\"</emplacement> \n";
        if (this.leClient.getLeContrat() != null && this.leClient.getMaterielsSousContrat().contains(this)) {
            xml = String.valueOf(xml) + "<nbJourAvantEcheance>" + this.leClient.getLeContrat().getJoursRestants() + "</nbJourAvantEcheance> \n";
        }
        xml = String.valueOf(xml) + "</materiel> \n";
        return xml;
    }
    
    public int getNumSerie() {
        return this.numSerie;
    }
    
    public void setNumSerie(final int numSerie) {
        this.numSerie = numSerie;
    }
    
    public DateTp getDateVente() {
        return this.dateVente;
    }
    
    public void setDateVente(final DateTp dateVente) {
        this.dateVente = dateVente;
    }
    
    public DateTp getDateInstallation() {
        return this.dateInstallation;
    }
    
    public void setDateInstallation(final DateTp dateInstallation) {
        this.dateInstallation = dateInstallation;
    }
    
    public double getPrixVente() {
        return this.prixVente;
    }
    
    public void setPrixVente(final double prixVente) {
        this.prixVente = prixVente;
    }
    
    public String getEmplacement() {
        return this.emplacement;
    }
    
    public void setEmplacement(final String emplacement) {
        this.emplacement = emplacement;
    }
    
    public TypeMateriel getLeType() {
        return this.leType;
    }
    
    public void setLeType(final TypeMateriel leType) {
        this.leType = leType;
    }
    
    public Client getLeClient() {
        return this.leClient;
    }
    
    public void setLeClient(final Client leClient) {
        this.leClient = leClient;
    }
    
    public ContratMaintenance getLeContrat() {
        return this.leContrat;
    }
    
    public void setLeContrat(final ContratMaintenance leContrat) {
        this.leContrat = leContrat;
    }
}
