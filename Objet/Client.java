// 
// Decompiled by Procyon v0.5.36
// 

package Objet;

import java.util.Iterator;
import java.util.ArrayList;

public class Client
{
    private String numClient;
    private String prenom;
    private String nom;
    private String raisonSociale;
    private String siren;
    private String codeApe;
    private String adresse;
    private String telClient;
    private String email;
    private String fax;
    private int dureeDeplacement;
    private int distanceKm;
    private int numeroAgence;
    private ArrayList<Materiel> lesMateriels;
    private ContratMaintenance leContrat;
    
    public Client(final String numClient, final String prenom, final String nom, final String raisonSociale, final String siren, final String codeApe, final String adresse, final String telClient, final String fax, final String email, final int dureeDeplacement, final int distanceKm, final int numeroAgence) {
        this.numClient = numClient;
        this.prenom = prenom;
        this.nom = nom;
        this.raisonSociale = raisonSociale;
        this.siren = siren;
        this.codeApe = codeApe;
        this.adresse = adresse;
        this.telClient = telClient;
        this.fax = fax;
        this.email = email;
        this.dureeDeplacement = dureeDeplacement;
        this.distanceKm = distanceKm;
        this.numeroAgence = numeroAgence;
        this.leContrat = null;
        this.lesMateriels = new ArrayList<Materiel>();
    }
    
    public ArrayList<Materiel> getMateriel() {
        return this.lesMateriels;
    }
    
    public ArrayList<Materiel> getMaterielsSousContrat() {
        return this.leContrat.getLesMaterielsAssures();
    }
    
    public ArrayList<Materiel> getMaterielsHorsContrat() {
        final ArrayList<Materiel> listeMaterielsHorsContrat = new ArrayList<Materiel>();
        if (this.getLesMateriels() != null) {
            if (this.getLeContrat() != null) {
                for (final Materiel m : this.getLesMateriels()) {
                    if (!this.getMaterielsSousContrat().contains(m)) {
                        listeMaterielsHorsContrat.add(m);
                    }
                }
            }
            else {
                for (final Materiel m : this.getLesMateriels()) {
                    listeMaterielsHorsContrat.add(m);
                }
            }
        }
        return listeMaterielsHorsContrat;
    }
    
    public boolean estAssure() {
        boolean assure = false;
        if (this.leContrat.estValide()) {
            assure = true;
        }
        return assure;
    }
    
    public void ajouteMateriel(final Materiel unMateriel) {
        this.lesMateriels.add(unMateriel);
    }
    
    public String getNumClient() {
        return this.numClient;
    }
    
    public void setNumClient(final String numClient) {
        this.numClient = numClient;
    }
    
    public String getRaisonSociale() {
        return this.raisonSociale;
    }
    
    public void setRaisonSociale(final String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }
    
    public String getSiren() {
        return this.siren;
    }
    
    public void setSiren(final String siren) {
        this.siren = siren;
    }
    
    public String getCodeApe() {
        return this.codeApe;
    }
    
    public void setCodeApe(final String codeApe) {
        this.codeApe = codeApe;
    }
    
    public String getAdresse() {
        return this.adresse;
    }
    
    public void setAdresse(final String adresse) {
        this.adresse = adresse;
    }
    
    public String getTelClient() {
        return this.telClient;
    }
    
    public void setTelClient(final String telClient) {
        this.telClient = telClient;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public int getDureeDeplacement() {
        return this.dureeDeplacement;
    }
    
    public void setDureeDeplacement(final int dureeDeplacement) {
        this.dureeDeplacement = dureeDeplacement;
    }
    
    public int getDistanceKm() {
        return this.distanceKm;
    }
    
    public void setDistanceKm(final int distanceKm) {
        this.distanceKm = distanceKm;
    }
    
    public ArrayList<Materiel> getLesMateriels() {
        return this.lesMateriels;
    }
    
    public void setLesMateriels(final ArrayList<Materiel> lesMateriels) {
        this.lesMateriels = lesMateriels;
    }
    
    public ContratMaintenance getLeContrat() {
        return this.leContrat;
    }
    
    public void setLeContrat(final ContratMaintenance leContrat) {
        this.leContrat = leContrat;
    }
    
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(final String prenom) {
        this.prenom = prenom;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(final String nom) {
        this.nom = nom;
    }
    
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(final String fax) {
        this.fax = fax;
    }
    
    public int getNumeroAgence() {
        return this.numeroAgence;
    }
    
    public void setNumeroAgence(final int numeroAgence) {
        this.numeroAgence = numeroAgence;
    }
}
