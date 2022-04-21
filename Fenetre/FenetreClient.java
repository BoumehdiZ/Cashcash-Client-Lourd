// 
// Decompiled by Procyon v0.5.36
// 

package Fenetre;

import javax.swing.JLabel;
import Objet.Mail;
import java.sql.SQLException;
import Objet.GestionMateriels;
import javax.swing.JOptionPane;
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
import Objet.Client;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class FenetreClient extends JFrame
{
    private JPanel contentPane;
    private JTextField txt_numClient;
    private JTextField txt_nomClient;
    private JTextField txt_prenomClient;
    private JTextField txt_raisonSociale;
    private JTextField txt_siren;
    private JTextField txt_codeApe;
    private JTextField txt_adresse;
    private JTextField txt_telephone;
    private JTextField txt_fax;
    private JTextField txt_email;
    private JTextField txt_dureeDeplacement;
    private JTextField txt_DistanceKm;
    private JTextField txt_numAgence;
    
    public FenetreClient(final Client unClient) {
        this.setTitle("Fiche client");
        final PersistanceSQL pSQL = new PersistanceSQL("192.168.1.35", 3306, "ppe");
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 712, 373);
        this.setLocationRelativeTo(null);
        (this.contentPane = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        final JLabel lbl_txt_numClient = DefaultComponentFactory.getInstance().createLabel("Num\u00e9ro client :");
        lbl_txt_numClient.setBounds(41, 38, 92, 14);
        this.contentPane.add(lbl_txt_numClient);
        final JLabel lbl_nomClient = DefaultComponentFactory.getInstance().createLabel("Nom :");
        lbl_nomClient.setBounds(41, 73, 92, 14);
        this.contentPane.add(lbl_nomClient);
        final JLabel lbl_prenomClient = DefaultComponentFactory.getInstance().createLabel("Pr\u00e9nom :");
        lbl_prenomClient.setBounds(41, 110, 92, 14);
        this.contentPane.add(lbl_prenomClient);
        final JLabel lbl_raisonSociale = DefaultComponentFactory.getInstance().createLabel("Raison sociale :");
        lbl_raisonSociale.setBounds(41, 149, 92, 14);
        this.contentPane.add(lbl_raisonSociale);
        final JLabel lbl_siren = DefaultComponentFactory.getInstance().createLabel("Siren");
        lbl_siren.setBounds(41, 185, 92, 14);
        this.contentPane.add(lbl_siren);
        final JLabel lbl_codeApe = DefaultComponentFactory.getInstance().createLabel("Code APE :");
        lbl_codeApe.setBounds(41, 221, 92, 14);
        this.contentPane.add(lbl_codeApe);
        final JLabel lbl_adresse = DefaultComponentFactory.getInstance().createLabel("Adresse :");
        lbl_adresse.setBounds(41, 255, 92, 14);
        this.contentPane.add(lbl_adresse);
        final JLabel lbl_t\u00e9l\u00e9phone = DefaultComponentFactory.getInstance().createLabel("T\u00e9l\u00e9phone :");
        lbl_t\u00e9l\u00e9phone.setBounds(41, 293, 92, 14);
        this.contentPane.add(lbl_t\u00e9l\u00e9phone);
        final JLabel lbl_fax = DefaultComponentFactory.getInstance().createLabel("Fax :");
        lbl_fax.setBounds(325, 38, 92, 14);
        this.contentPane.add(lbl_fax);
        final JLabel lbl_email = DefaultComponentFactory.getInstance().createLabel("Email : ");
        lbl_email.setBounds(325, 73, 92, 14);
        this.contentPane.add(lbl_email);
        final JLabel lbl_dureeDeplacement = DefaultComponentFactory.getInstance().createLabel("Dur\u00e9e de d\u00e9placement :");
        lbl_dureeDeplacement.setBounds(325, 110, 137, 14);
        this.contentPane.add(lbl_dureeDeplacement);
        final JLabel lbl_distanceKm = DefaultComponentFactory.getInstance().createLabel("Distance kilom\u00e9trique :");
        lbl_distanceKm.setBounds(325, 149, 137, 14);
        this.contentPane.add(lbl_distanceKm);
        final JLabel lbl_numAgence = DefaultComponentFactory.getInstance().createLabel("Num\u00e9ro d'agence :");
        lbl_numAgence.setBounds(325, 185, 124, 14);
        this.contentPane.add(lbl_numAgence);
        (this.txt_numClient = new JTextField()).setBounds(143, 35, 161, 20);
        this.contentPane.add(this.txt_numClient);
        this.txt_numClient.setColumns(10);
        this.txt_numClient.setText(unClient.getNumClient());
        this.txt_numClient.setEditable(false);
        (this.txt_nomClient = new JTextField()).setBounds(143, 70, 161, 20);
        this.contentPane.add(this.txt_nomClient);
        this.txt_nomClient.setColumns(10);
        this.txt_nomClient.setText(unClient.getNom());
        this.txt_nomClient.setEditable(false);
        (this.txt_prenomClient = new JTextField()).setBounds(143, 107, 161, 20);
        this.contentPane.add(this.txt_prenomClient);
        this.txt_prenomClient.setColumns(10);
        this.txt_prenomClient.setText(unClient.getPrenom());
        this.txt_prenomClient.setEditable(false);
        (this.txt_raisonSociale = new JTextField()).setBounds(143, 146, 161, 20);
        this.contentPane.add(this.txt_raisonSociale);
        this.txt_raisonSociale.setColumns(10);
        this.txt_raisonSociale.setText(unClient.getRaisonSociale());
        this.txt_raisonSociale.setEditable(false);
        (this.txt_siren = new JTextField()).setBounds(143, 182, 161, 20);
        this.contentPane.add(this.txt_siren);
        this.txt_siren.setColumns(10);
        this.txt_siren.setText(unClient.getSiren());
        this.txt_siren.setEditable(false);
        (this.txt_codeApe = new JTextField()).setBounds(143, 218, 161, 20);
        this.contentPane.add(this.txt_codeApe);
        this.txt_codeApe.setColumns(10);
        this.txt_codeApe.setText(unClient.getCodeApe());
        this.txt_codeApe.setEditable(false);
        (this.txt_adresse = new JTextField()).setBounds(143, 252, 161, 20);
        this.contentPane.add(this.txt_adresse);
        this.txt_adresse.setColumns(10);
        this.txt_adresse.setText(unClient.getAdresse());
        this.txt_adresse.setEditable(false);
        (this.txt_telephone = new JTextField()).setBounds(143, 290, 161, 20);
        this.contentPane.add(this.txt_telephone);
        this.txt_telephone.setColumns(10);
        this.txt_telephone.setText(unClient.getTelClient());
        this.txt_telephone.setEditable(false);
        (this.txt_fax = new JTextField()).setBounds(480, 38, 161, 20);
        this.contentPane.add(this.txt_fax);
        this.txt_fax.setColumns(10);
        this.txt_fax.setText(unClient.getFax());
        this.txt_fax.setEditable(false);
        (this.txt_email = new JTextField()).setBounds(480, 73, 161, 20);
        this.contentPane.add(this.txt_email);
        this.txt_email.setColumns(10);
        this.txt_email.setText(unClient.getEmail());
        this.txt_email.setEditable(false);
        (this.txt_dureeDeplacement = new JTextField()).setBounds(480, 110, 161, 20);
        this.contentPane.add(this.txt_dureeDeplacement);
        this.txt_dureeDeplacement.setColumns(10);
        this.txt_dureeDeplacement.setText(Integer.toString(unClient.getDureeDeplacement()));
        this.txt_dureeDeplacement.setEditable(false);
        (this.txt_DistanceKm = new JTextField()).setBounds(480, 149, 161, 20);
        this.contentPane.add(this.txt_DistanceKm);
        this.txt_DistanceKm.setColumns(10);
        this.txt_DistanceKm.setText(Integer.toString(unClient.getDistanceKm()));
        this.txt_DistanceKm.setEditable(false);
        (this.txt_numAgence = new JTextField()).setBounds(480, 185, 161, 20);
        this.contentPane.add(this.txt_numAgence);
        this.txt_numAgence.setColumns(10);
        this.txt_numAgence.setText(unClient.getNumClient());
        this.txt_numAgence.setEditable(false);
        final JButton btn_menu = new JButton("Menu Principal");
        btn_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                FenetreClient.this.dispose();
                final FenetreMenu fenetre = new FenetreMenu();
                fenetre.setVisible(true);
            }
        });
        btn_menu.setBounds(10, 4, 123, 23);
        this.contentPane.add(btn_menu);
        final JButton btn_contrat = new JButton("Le contrat");
        btn_contrat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                try {
                    final FenetreContratMaintenance fenetreContratMaintenance = new FenetreContratMaintenance(unClient.getLeContrat());
                    fenetreContratMaintenance.setVisible(true);
                    FenetreClient.this.dispose();
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Le client n°" + unClient.getNumClient() + " n'a pas de contrat !", "Erreur", 0);
                }
            }
        });
        btn_contrat.setBounds(338, 249, 129, 26);
        this.contentPane.add(btn_contrat);
        final JButton btn_xml = new JButton("Cr\u00e9ation XML");
        btn_xml.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                final GestionMateriels gestionMateriels = new GestionMateriels(pSQL);
                try {
                    gestionMateriels.creerXml(gestionMateriels, unClient);
                    JOptionPane.showMessageDialog(null, "Cr\u00e9ation r\u00e9ussie !", "XML", 1);
                }
                catch (SQLException | NullPointerException ex2) {
                    final Exception ex;
                    final Exception e = ex;
                    JOptionPane.showMessageDialog(null, "Le xml ne s'est pas cr\u00e9er !", "Erreur xml", 0);
                }
            }
        });
        btn_xml.setBounds(491, 249, 129, 26);
        this.contentPane.add(btn_xml);
        final JButton btn_materiel = new JButton("Le(s) mat\u00e9riel(s)");
        btn_materiel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                if (!unClient.getLesMateriels().isEmpty()) {
                    final FenetreClientMateriel fenetreClientMateriel = new FenetreClientMateriel(unClient);
                    fenetreClientMateriel.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Le client n°" + unClient.getNumClient() + " n'a pas de mat\u00e9riels !", "Erreur", 0);
                }
            }
        });
        btn_materiel.setBounds(338, 287, 129, 26);
        this.contentPane.add(btn_materiel);
        final JButton btn_relance = new JButton("Relance par mail");
        btn_relance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                final Mail mail = new Mail();
                mail.envoyerPDF(unClient);
            }
        });
        btn_relance.setBounds(491, 287, 129, 26);
        this.contentPane.add(btn_relance);
    }
}
