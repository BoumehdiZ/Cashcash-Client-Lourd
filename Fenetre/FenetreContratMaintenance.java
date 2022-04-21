// 
// Decompiled by Procyon v0.5.36
// 

package Fenetre;

import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import Objet.PersistanceSQL;
import Objet.ContratMaintenance;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class FenetreContratMaintenance extends JFrame
{
    private JPanel contentPane;
    private JTextField txt_numContrat;
    private JTextField txt_dateSignature;
    private JTextField txt_dateEcheance;
    private JTextField txt_refContrat;
    
    public FenetreContratMaintenance(final ContratMaintenance unContrat) {
        final PersistanceSQL pSQL = new PersistanceSQL("192.168.1.35", 3306, "ppe");
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 582, 316);
        this.setLocationRelativeTo(null);
        (this.contentPane = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        final JLabel lbl_numContrat = DefaultComponentFactory.getInstance().createLabel("Num\u00e9ro contrat :");
        lbl_numContrat.setBounds(127, 64, 109, 14);
        this.contentPane.add(lbl_numContrat);
        final JLabel lbl_dateSignature = DefaultComponentFactory.getInstance().createLabel("Date signature :");
        lbl_dateSignature.setBounds(127, 108, 109, 14);
        this.contentPane.add(lbl_dateSignature);
        final JLabel lbl_dateEcheance = DefaultComponentFactory.getInstance().createLabel("Date \u00e9ch\u00e9ance :");
        lbl_dateEcheance.setBounds(127, 153, 109, 14);
        this.contentPane.add(lbl_dateEcheance);
        final JLabel lbl_refContrat = DefaultComponentFactory.getInstance().createLabel("R\u00e9f\u00e9rence du contrat :");
        lbl_refContrat.setBounds(127, 191, 158, 14);
        this.contentPane.add(lbl_refContrat);
        (this.txt_numContrat = new JTextField()).setBounds(314, 61, 128, 20);
        this.contentPane.add(this.txt_numContrat);
        this.txt_numContrat.setColumns(10);
        this.txt_numContrat.setText(unContrat.getNumContrat());
        this.txt_numContrat.setEditable(false);
        (this.txt_dateSignature = new JTextField()).setBounds(314, 105, 128, 20);
        this.contentPane.add(this.txt_dateSignature);
        this.txt_dateSignature.setColumns(10);
        this.txt_dateSignature.setText(unContrat.getDateSignature().afficheDate());
        this.txt_dateSignature.setEditable(false);
        (this.txt_dateEcheance = new JTextField()).setBounds(314, 150, 128, 20);
        this.contentPane.add(this.txt_dateEcheance);
        this.txt_dateEcheance.setColumns(10);
        this.txt_dateEcheance.setText(unContrat.getDateEcheance().afficheDate());
        this.txt_dateEcheance.setEditable(false);
        (this.txt_refContrat = new JTextField()).setBounds(314, 188, 128, 20);
        this.contentPane.add(this.txt_refContrat);
        this.txt_refContrat.setColumns(10);
        this.txt_refContrat.setText(unContrat.getLeTypeContratMaintenance().getRefTypeContrat());
        this.txt_refContrat.setEditable(false);
        final JButton btn_renouveler = new JButton("Renouveler");
        btn_renouveler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                final FenetreRenouvellement fenetreRenouvellement = new FenetreRenouvellement(unContrat);
                fenetreRenouvellement.setVisible(true);
                FenetreContratMaintenance.this.dispose();
            }
        });
        btn_renouveler.setBounds(398, 14, 146, 23);
        this.contentPane.add(btn_renouveler);
        final JButton btn_materiels = new JButton("Le(s) mat\u00e9riel(s) assur\u00e9(s)");
        btn_materiels.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                final FenetreContratMateriel fenetreContratMateriel = new FenetreContratMateriel(unContrat);
                fenetreContratMateriel.setVisible(true);
            }
        });
        btn_materiels.setBounds(188, 244, 198, 23);
        this.contentPane.add(btn_materiels);
        final JButton btn_menu = new JButton("Menu Principal");
        btn_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                FenetreContratMaintenance.this.dispose();
                final FenetreMenu fenetre = new FenetreMenu();
                fenetre.setVisible(true);
            }
        });
        btn_menu.setBounds(12, 12, 134, 26);
        this.contentPane.add(btn_menu);
        final JButton btn_client = new JButton("Le client");
        btn_client.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                final FenetreClient fenetreClient = new FenetreClient(unContrat.getLeClient());
                fenetreClient.setVisible(true);
                FenetreContratMaintenance.this.dispose();
            }
        });
        btn_client.setBounds(22, 244, 146, 23);
        this.contentPane.add(btn_client);
        final JButton btn_type = new JButton("Le type du contrat");
        btn_type.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final FenetreTypeContrat fenetreContratMaintenance = new FenetreTypeContrat(unContrat.getLeTypeContratMaintenance());
                fenetreContratMaintenance.setVisible(true);
            }
        });
        btn_type.setBounds(398, 244, 146, 23);
        this.contentPane.add(btn_type);
    }
}
