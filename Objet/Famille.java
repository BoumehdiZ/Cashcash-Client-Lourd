// 
// Decompiled by Procyon v0.5.36
// 

package Objet;

public class Famille
{
    private String codeFamille;
    private String libelleFamille;
    
    public Famille(final String codeFamille, final String libelleFamille) {
        this.codeFamille = codeFamille;
        this.libelleFamille = libelleFamille;
    }
    
    public String getCodeFamille() {
        return this.codeFamille;
    }
    
    public void setCodeFamille(final String codeFamille) {
        this.codeFamille = codeFamille;
    }
    
    public String getLibelleFamille() {
        return this.libelleFamille;
    }
    
    public void setLibelleFamille(final String libelleFamille) {
        this.libelleFamille = libelleFamille;
    }
}
