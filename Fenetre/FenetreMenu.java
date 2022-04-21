// 
// Decompiled by Procyon v0.5.36
// 

package Fenetre;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Objet.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Font;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Toolkit;
import Objet.PersistanceSQL;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class FenetreMenu extends JFrame
{
    private JPanel contentPane;
    private JTextField txt_id;
    
    public FenetreMenu() {
        this.setVisible(true);
        final PersistanceSQL pSQL = new PersistanceSQL("192.168.1.35", 3306, "ppe");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(FenetreMenu.class.getResource("/images/logo.ico")));
        this.setTitle("CashCash");
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 353, 198);
        this.setLocationRelativeTo(null);
        (this.contentPane = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        final JLabel lbl_CashCash = DefaultComponentFactory.getInstance().createTitle("CASHCASH");
        lbl_CashCash.setFont(new Font("Tahoma", 0, 24));
        lbl_CashCash.setBounds(104, 23, 118, 40);
        this.contentPane.add(lbl_CashCash);
        (this.txt_id = new JTextField()).setBounds(156, 74, 126, 20);
        this.contentPane.add(this.txt_id);
        this.txt_id.setColumns(10);
        final JButton btn_rechercher = new JButton("Rechercher");
        btn_rechercher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String id = FenetreMenu.this.txt_id.getText();
                try {
                    if (!id.contentEquals("")) {
                        final Client unClient = (Client)pSQL.ChargerDepuisBase(id, "Client");
                        final FenetreClient fenetreClient = new FenetreClient(unClient);
                        fenetreClient.setVisible(true);
                        FenetreMenu.this.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Recherche invalide !", "Erreur de saisie", 0);
                    }
                }
                catch (Exception e2) {
                    FenetreMenu.this.txt_id.setText("");
                    JOptionPane.showMessageDialog(null, "Le Client n°" + id + " n'existe pas !", "Erreur", 0);
                }
            }
        });
        btn_rechercher.setBounds(104, 118, 115, 23);
        this.contentPane.add(btn_rechercher);
        final JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Num\u00e9ro client :");
        lblNewJgoodiesLabel.setBounds(52, 77, 94, 14);
        this.contentPane.add(lblNewJgoodiesLabel);
    }
}
