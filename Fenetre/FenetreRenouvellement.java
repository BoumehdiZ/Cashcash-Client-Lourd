// 
// Decompiled by Procyon v0.5.36
// 

package Fenetre;

import javax.swing.JOptionPane;
import Objet.DateTp;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import Objet.PersistanceSQL;
import Objet.ContratMaintenance;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class FenetreRenouvellement extends JFrame
{
    private JPanel contentPane;
    private JDateChooser dc_dateNouvelleEcheance;
    
    public FenetreRenouvellement(final ContratMaintenance unContrat) {
        final PersistanceSQL pSQL = new PersistanceSQL("192.168.1.35", 3306, "ppe");
        this.setResizable(false);
        this.setDefaultCloseOperation(0);
        this.setBounds(100, 100, 371, 124);
        this.setLocationRelativeTo(null);
        (this.contentPane = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        final JLabel lbl_dateRenouvellement = new JLabel("Date de renouvellement :");
        lbl_dateRenouvellement.setCursor(Cursor.getPredefinedCursor(0));
        lbl_dateRenouvellement.setBounds(37, 26, 163, 14);
        this.contentPane.add(lbl_dateRenouvellement);
        (this.dc_dateNouvelleEcheance = new JDateChooser()).setDateFormatString("dd-MM-yyyy");
        this.dc_dateNouvelleEcheance.setBounds(218, 26, 105, 20);
        this.dc_dateNouvelleEcheance.setMinSelectableDate(new Date());
        final GregorianCalendar cal = (GregorianCalendar)Calendar.getInstance();
        cal.add(1, 1);
        this.dc_dateNouvelleEcheance.setDate(cal.getTime());
        this.contentPane.add(this.dc_dateNouvelleEcheance);
        final JButton btn_annuler = new JButton("Annuler");
        btn_annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final FenetreContratMaintenance fenetreContratMaintenance = new FenetreContratMaintenance(unContrat);
                fenetreContratMaintenance.setVisible(true);
                FenetreRenouvellement.this.dispose();
            }
        });
        btn_annuler.setBounds(65, 58, 98, 26);
        this.contentPane.add(btn_annuler);
        final JButton btn_valider = new JButton("Valider");
        btn_valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (FenetreRenouvellement.this.dc_dateNouvelleEcheance.getDate() != null) {
                    final SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
                    final String strDate = formatDate.format(FenetreRenouvellement.this.dc_dateNouvelleEcheance.getDate());
                    final int jour = Integer.parseInt(strDate.substring(0, 2));
                    final int mois = Integer.parseInt(strDate.substring(3, 5));
                    final int annee = Integer.parseInt(strDate.substring(6, 10));
                    final DateTp nouvelleDateEcheance = new DateTp(annee, mois, jour);
                    if (nouvelleDateEcheance.difference(unContrat.getDateEcheance()) > 0L) {
                        unContrat.setDateEcheance(nouvelleDateEcheance);
                        pSQL.RangerDansBase(unContrat);
                        final FenetreContratMaintenance fenetreContratMaintenance = new FenetreContratMaintenance(unContrat);
                        fenetreContratMaintenance.setVisible(true);
                        FenetreRenouvellement.this.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Veuillez inserer une date post\u00e9rieur \u00e0 " + unContrat.getDateEcheance().afficheDate(), "Erreur", 0);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Recherche invalide !", "Erreur de saisie", 0);
                }
            }
        });
        btn_valider.setBounds(196, 58, 98, 26);
        this.contentPane.add(btn_valider);
    }
}
