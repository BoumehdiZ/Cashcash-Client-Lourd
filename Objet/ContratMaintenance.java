// 
// Decompiled by Procyon v0.5.36
// 

package Objet;

import java.util.ArrayList;

public class ContratMaintenance
{
    private String numContrat;
    private DateTp dateSignature;
    private DateTp dateEcheance;
    private ArrayList<Materiel> lesMaterielsAssures;
    private TypeContratMaintenance leTypeContratMaintenance;
    private Client leClient;
    
    public ContratMaintenance(final String numContrat, final DateTp dateSignature, final DateTp dateEcheance, final TypeContratMaintenance leTypeContratMaintenance) {
        this.numContrat = numContrat;
        this.dateSignature = dateSignature;
        this.dateEcheance = dateEcheance;
        this.lesMaterielsAssures = new ArrayList<Materiel>();
        this.leTypeContratMaintenance = leTypeContratMaintenance;
    }
    
    public long getJoursRestants() {
        final DateTp aujourdhui = DateTp.aujourdhui();
        return this.dateEcheance.difference(aujourdhui);
    }
    
    public boolean estValide() {
        boolean valide = false;
        final DateTp aujourdhui = DateTp.aujourdhui();
        if (this.dateSignature.difference(aujourdhui) <= 0L && this.dateEcheance.difference(aujourdhui) >= 0L) {
            valide = true;
        }
        return valide;
    }
    
    public void ajouteMateriel(final Materiel unMateriel) {
        if (this.dateSignature.difference(unMateriel.getDateInstallation()) < 0L && this.estValide()) {
            this.lesMaterielsAssures.add(unMateriel);
        }
    }
    
    public String getNumContrat() {
        return this.numContrat;
    }
    
    public void setNumContrat(final String numContrat) {
        this.numContrat = numContrat;
    }
    
    public DateTp getDateSignature() {
        return this.dateSignature;
    }
    
    public void setDateSignature(final DateTp dateSignature) {
        this.dateSignature = dateSignature;
    }
    
    public DateTp getDateEcheance() {
        return this.dateEcheance;
    }
    
    public void setDateEcheance(final DateTp dateEcheance) {
        this.dateEcheance = dateEcheance;
    }
    
    public ArrayList<Materiel> getLesMaterielsAssures() {
        return this.lesMaterielsAssures;
    }
    
    public void setLesMaterielsAssures(final ArrayList<Materiel> lesMaterielsAssures) {
        this.lesMaterielsAssures = lesMaterielsAssures;
    }
    
    public TypeContratMaintenance getLeTypeContratMaintenance() {
        return this.leTypeContratMaintenance;
    }
    
    public void setLeTypeContratMaintenance(final TypeContratMaintenance leTypeContratMaintenance) {
        this.leTypeContratMaintenance = leTypeContratMaintenance;
    }
    
    public Client getLeClient() {
        return this.leClient;
    }
    
    public void setLeClient(final Client leClient) {
        this.leClient = leClient;
    }
}
