// 
// Decompiled by Procyon v0.5.36
// 

package Objet;

public class TypeMateriel
{
    private String referenceInterne;
    private String libelleTypeMateriel;
    private Famille laFamille;
    
    public TypeMateriel(final String referenceInterne, final String libelleTypeMateriel, final Famille laFamille) {
        this.referenceInterne = referenceInterne;
        this.libelleTypeMateriel = libelleTypeMateriel;
        this.laFamille = laFamille;
    }
    
    public String getReferenceInterne() {
        return this.referenceInterne;
    }
    
    public void setReferenceInterne(final String referenceInterne) {
        this.referenceInterne = referenceInterne;
    }
    
    public String getLibelleTypeMateriel() {
        return this.libelleTypeMateriel;
    }
    
    public void setLibelleTypeMateriel(final String libelleTypeMateriel) {
        this.libelleTypeMateriel = libelleTypeMateriel;
    }
    
    public Famille getLaFamille() {
        return this.laFamille;
    }
    
    public void setLaFamille(final Famille laFamille) {
        this.laFamille = laFamille;
    }
}
