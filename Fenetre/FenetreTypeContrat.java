// 
// Decompiled by Procyon v0.5.36
// 

package Fenetre;

import javax.swing.JLabel;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import Objet.TypeContratMaintenance;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class FenetreTypeContrat extends JFrame
{
    private JPanel contentPane;
    private JTextField txt_refTypeContrat;
    private JTextField txt_delaiIntervention;
    private JTextField txt_tauxApplicable;
    
    public FenetreTypeContrat(final TypeContratMaintenance unTypeContrat) {
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 333, 173);
        this.setLocationRelativeTo(null);
        (this.contentPane = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        final JLabel lbl_refTypeContrat = new JLabel("R\u00e9f\u00e9rence du type contrat :");
        lbl_refTypeContrat.setBounds(12, 25, 154, 14);
        this.contentPane.add(lbl_refTypeContrat);
        final JLabel lbl_delaiIntervention = new JLabel("Delai d'intervention :");
        lbl_delaiIntervention.setBounds(12, 67, 154, 14);
        this.contentPane.add(lbl_delaiIntervention);
        final JLabel lbl_tauxApplicable = new JLabel("Taux applicable :");
        lbl_tauxApplicable.setBounds(12, 103, 154, 14);
        this.contentPane.add(lbl_tauxApplicable);
        (this.txt_refTypeContrat = new JTextField()).setBounds(176, 22, 126, 20);
        this.contentPane.add(this.txt_refTypeContrat);
        this.txt_refTypeContrat.setColumns(10);
        this.txt_refTypeContrat.setText(unTypeContrat.getRefTypeContrat());
        this.txt_refTypeContrat.setEditable(false);
        (this.txt_delaiIntervention = new JTextField()).setBounds(176, 64, 126, 20);
        this.contentPane.add(this.txt_delaiIntervention);
        this.txt_delaiIntervention.setColumns(10);
        this.txt_delaiIntervention.setText(unTypeContrat.getDelaiIntervention());
        this.txt_delaiIntervention.setEditable(false);
        (this.txt_tauxApplicable = new JTextField()).setBounds(176, 100, 126, 20);
        this.contentPane.add(this.txt_tauxApplicable);
        this.txt_tauxApplicable.setColumns(10);
        this.txt_tauxApplicable.setText(Integer.toString(unTypeContrat.getTauxApplicable()));
        this.txt_tauxApplicable.setEditable(false);
    }
}
