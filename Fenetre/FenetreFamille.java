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
import Objet.Famille;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class FenetreFamille extends JFrame
{
    private JPanel contentPane;
    private JTextField txt_codeFamille;
    private JTextField txt_libelle;
    
    public FenetreFamille(final Famille uneFamille) {
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 450, 300);
        this.setLocationRelativeTo(null);
        (this.contentPane = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        final JLabel lbl_codeFamille = new JLabel("Code famille :");
        lbl_codeFamille.setBounds(75, 76, 89, 14);
        this.contentPane.add(lbl_codeFamille);
        final JLabel lbl_libelle = new JLabel("Libelle :");
        lbl_libelle.setBounds(75, 101, 46, 14);
        this.contentPane.add(lbl_libelle);
        (this.txt_codeFamille = new JTextField()).setBounds(174, 73, 114, 20);
        this.contentPane.add(this.txt_codeFamille);
        this.txt_codeFamille.setColumns(10);
        this.txt_codeFamille.setText(uneFamille.getCodeFamille());
        this.txt_codeFamille.setEditable(false);
        (this.txt_libelle = new JTextField()).setBounds(174, 98, 114, 20);
        this.contentPane.add(this.txt_libelle);
        this.txt_libelle.setColumns(10);
        this.txt_libelle.setText(uneFamille.getLibelleFamille());
        this.txt_libelle.setEditable(false);
        final JButton btn_menu = new JButton("Menu Principal");
        btn_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                FenetreFamille.this.dispose();
                final FenetreMenu fenetre = new FenetreMenu();
                fenetre.setVisible(true);
            }
        });
        btn_menu.setBounds(10, 11, 128, 26);
        this.contentPane.add(btn_menu);
    }
}
