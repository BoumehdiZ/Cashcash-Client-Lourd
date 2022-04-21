// 
// Decompiled by Procyon v0.5.36
// 

package Fenetre;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import Objet.Materiel;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class FenetreMateriel extends JFrame
{
    private JPanel contentPane;
    
    public FenetreMateriel(final Materiel unMateriel) {
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 601, 297);
        this.setLocationRelativeTo(null);
        (this.contentPane = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        final Label lbl_numSerie = new Label("Num\u00e9ro s\u00e9rie : ");
        lbl_numSerie.setBounds(22, 68, 87, 22);
        this.contentPane.add(lbl_numSerie);
        final Label lbl_dateVente = new Label("Date de vente : ");
        lbl_dateVente.setBounds(22, 96, 87, 22);
        this.contentPane.add(lbl_dateVente);
        final Label lbl_dateInstallation = new Label("Date d'installation : ");
        lbl_dateInstallation.setBounds(22, 129, 115, 22);
        this.contentPane.add(lbl_dateInstallation);
        final Label lbl_prixVente = new Label("Prix de vente : ");
        lbl_prixVente.setBounds(22, 167, 87, 22);
        this.contentPane.add(lbl_prixVente);
        final Label lbl_emplacement = new Label("Emplacement : ");
        lbl_emplacement.setBounds(292, 68, 87, 22);
        this.contentPane.add(lbl_emplacement);
        final Label lbl_referenceType = new Label("R\u00e9f\u00e9rence type : ");
        lbl_referenceType.setBounds(292, 97, 115, 22);
        this.contentPane.add(lbl_referenceType);
        final Button btn_menu = new Button("Menu Principal");
        btn_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                FenetreMateriel.this.dispose();
                final FenetreMenu fenetre = new FenetreMenu();
                fenetre.setVisible(true);
            }
        });
        btn_menu.setBounds(22, 10, 99, 22);
        this.contentPane.add(btn_menu);
        final TextField txt_numSerie = new TextField();
        txt_numSerie.setBounds(139, 66, 99, 23);
        this.contentPane.add(txt_numSerie);
        txt_numSerie.setText(Integer.toString(unMateriel.getNumSerie()));
        txt_numSerie.setEditable(false);
        final TextField txt_dateVente = new TextField();
        txt_dateVente.setBounds(139, 95, 99, 23);
        this.contentPane.add(txt_dateVente);
        txt_dateVente.setText(unMateriel.getDateVente().toString());
        txt_dateVente.setEditable(false);
        final TextField txt_dateInstallation = new TextField();
        txt_dateInstallation.setBounds(139, 129, 99, 23);
        this.contentPane.add(txt_dateInstallation);
        txt_dateInstallation.setText(unMateriel.getDateInstallation().toString());
        txt_dateInstallation.setEditable(false);
        final TextField txt_prixVente = new TextField();
        txt_prixVente.setBounds(139, 167, 99, 23);
        this.contentPane.add(txt_prixVente);
        txt_prixVente.setText(Double.toString(unMateriel.getPrixVente()));
        txt_prixVente.setEditable(false);
        final TextField txt_emplacement = new TextField();
        txt_emplacement.setBounds(409, 67, 99, 23);
        this.contentPane.add(txt_emplacement);
        txt_emplacement.setText(unMateriel.getEmplacement());
        txt_emplacement.setEditable(false);
        final TextField txt_referenceType = new TextField();
        txt_referenceType.setBounds(409, 96, 99, 23);
        this.contentPane.add(txt_referenceType);
        txt_referenceType.setText(unMateriel.getLeType().getReferenceInterne());
        txt_referenceType.setEditable(false);
    }
}
