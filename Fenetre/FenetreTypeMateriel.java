// 
// Decompiled by Procyon v0.5.36
// 

package Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import Objet.TypeMateriel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class FenetreTypeMateriel extends JFrame
{
    private JPanel contentPane;
    private JTextField txt_reference;
    private JTextField txt_libelle;
    private JTextField txt_codeFamille;
    
    public FenetreTypeMateriel(final TypeMateriel unTypeMateriel) {
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 450, 300);
        this.setLocationRelativeTo(null);
        (this.contentPane = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        final JLabel lbl_reference = new JLabel("R\u00e9f\u00e9rence : ");
        lbl_reference.setBounds(46, 80, 86, 14);
        this.contentPane.add(lbl_reference);
        final JLabel lbl_libelle = new JLabel("Libelle :");
        lbl_libelle.setBounds(46, 109, 63, 14);
        this.contentPane.add(lbl_libelle);
        final JLabel lbl_codeFamille = new JLabel("Code famille :");
        lbl_codeFamille.setBounds(46, 134, 86, 14);
        this.contentPane.add(lbl_codeFamille);
        (this.txt_reference = new JTextField()).setBounds(142, 77, 86, 20);
        this.contentPane.add(this.txt_reference);
        this.txt_reference.setColumns(10);
        this.txt_reference.setText(unTypeMateriel.getReferenceInterne());
        this.txt_reference.setEditable(false);
        (this.txt_libelle = new JTextField()).setBounds(142, 106, 86, 20);
        this.contentPane.add(this.txt_libelle);
        this.txt_libelle.setColumns(10);
        this.txt_libelle.setText(unTypeMateriel.getLibelleTypeMateriel());
        this.txt_libelle.setEditable(false);
        (this.txt_codeFamille = new JTextField()).setBounds(142, 131, 86, 20);
        this.contentPane.add(this.txt_codeFamille);
        this.txt_codeFamille.setColumns(10);
        this.txt_codeFamille.setText(unTypeMateriel.getLaFamille().getCodeFamille());
        this.txt_codeFamille.setEditable(false);
        final JButton btn_menu = new JButton("Menu Principal");
        btn_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                FenetreTypeMateriel.this.dispose();
                final FenetreMenu fenetre = new FenetreMenu();
                fenetre.setVisible(true);
            }
        });
        btn_menu.setBounds(10, 11, 122, 23);
        this.contentPane.add(btn_menu);
    }
}
