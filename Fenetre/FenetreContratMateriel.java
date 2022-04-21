// 
// Decompiled by Procyon v0.5.36
// 

package Fenetre;

import java.util.Iterator;
import Objet.Materiel;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import Objet.ContratMaintenance;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class FenetreContratMateriel extends JFrame
{
    private JPanel contentPane;
    private JScrollPane scrollPane_1;
    private JTable table;
    
    public FenetreContratMateriel(final ContratMaintenance unContrat) {
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 871, 374);
        this.setLocationRelativeTo(null);
        (this.contentPane = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        final int nbMateriels = unContrat.getLesMaterielsAssures().size();
        final JLabel lbl_nbMateriel = new JLabel("Nombre de mat\u00e9riel(s) assur\u00e9(s) par le contrat n°" + unContrat.getNumContrat() + " : " + nbMateriels);
        lbl_nbMateriel.setBounds(35, 24, 389, 14);
        this.contentPane.add(lbl_nbMateriel);
        (this.scrollPane_1 = new JScrollPane()).setBounds(12, 69, 831, 250);
        this.contentPane.add(this.scrollPane_1);
        (this.table = new JTable() {
            @Override
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        }).setSelectionMode(0);
        this.table.setBackground(Color.WHITE);
        this.table.setModel(new DefaultTableModel(new Object[0][], new String[] { "Num\u00e9ro S\u00e9rie", "Date de vente", "Date d'installation", "Prix de vente", "Emplacement", "R\u00e9f\u00e9rence Type" }) {
            Class[] columnTypes = { String.class, String.class, String.class, Object.class, String.class, String.class, String.class, String.class };
            
            @Override
            public Class getColumnClass(final int columnIndex) {
                return this.columnTypes[columnIndex];
            }
        });
        this.table.getColumnModel().getColumn(0).setPreferredWidth(92);
        this.table.getColumnModel().getColumn(1).setPreferredWidth(94);
        this.table.getColumnModel().getColumn(2).setPreferredWidth(112);
        this.table.getColumnModel().getColumn(3).setPreferredWidth(82);
        this.table.getColumnModel().getColumn(4).setPreferredWidth(91);
        this.table.getColumnModel().getColumn(5).setPreferredWidth(94);
        this.scrollPane_1.setViewportView(this.table);
        final DefaultTableModel model = (DefaultTableModel)this.table.getModel();
        for (final Materiel m : unContrat.getLesMaterielsAssures()) {
            model.addRow(new Object[] { m.getNumSerie(), m.getDateVente().afficheDate(), m.getDateInstallation().afficheDate(), m.getPrixVente(), m.getEmplacement(), m.getLeType().getReferenceInterne() });
        }
    }
}
