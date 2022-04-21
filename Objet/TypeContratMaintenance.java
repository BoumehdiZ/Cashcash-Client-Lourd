// 
// Decompiled by Procyon v0.5.36
// 

package Objet;

public class TypeContratMaintenance
{
    private String refTypeContrat;
    private String delaiIntervention;
    private int tauxApplicable;
    
    public TypeContratMaintenance(final String refTypeContrat, final String delaiIntervention, final int tauxApplicable) {
        this.refTypeContrat = refTypeContrat;
        this.delaiIntervention = delaiIntervention;
        this.tauxApplicable = tauxApplicable;
    }
    
    public String getRefTypeContrat() {
        return this.refTypeContrat;
    }
    
    public void setRefTypeContrat(final String refTypeContrat) {
        this.refTypeContrat = refTypeContrat;
    }
    
    public String getDelaiIntervention() {
        return this.delaiIntervention;
    }
    
    public void setDelaiIntervention(final String delaiIntervention) {
        this.delaiIntervention = delaiIntervention;
    }
    
    public int getTauxApplicable() {
        return this.tauxApplicable;
    }
    
    public void setTauxApplicable(final int tauxApplicable) {
        this.tauxApplicable = tauxApplicable;
    }
}
