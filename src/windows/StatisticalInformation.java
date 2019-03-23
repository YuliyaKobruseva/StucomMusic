/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import SwingTools.SwingTools;
import controller.Manager;
import exceptions.ManagerException;
import javax.swing.JOptionPane;

/**
 *
 * @author Yuli
 */
public class StatisticalInformation extends javax.swing.JDialog {

    /**
     * Creates new form StatisticalInformation
     *
     * @param parent
     * @param modal
     */
    public StatisticalInformation(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        SwingTools.getSwingTools().setIcon(this, null);
        try {
            quantity.setText(String.valueOf(Manager.getManager().allScores().size()));
            SwingTools.getSwingTools().createTable(tableGenre, "genre");
            SwingTools.getSwingTools().createTable(tableInstrument, "instrument");
            SwingTools.getSwingTools().createTable(tableLevel, "level");
        } catch (ManagerException ex) {
            JOptionPane.showMessageDialog(this, "" + ex.getMessage(), "Message", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        labelTotalScores = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableGenre = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableLevel = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableInstrument = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setFont(new java.awt.Font("Adobe Arabic", 1, 16)); // NOI18N
        setForeground(new java.awt.Color(51, 51, 51));

        title.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Statistical Information");

        labelTotalScores.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        labelTotalScores.setText("Total Scores");

        quantity.setEditable(false);
        quantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        quantity.setForeground(new java.awt.Color(51, 51, 51));
        quantity.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quantity scores of each genre");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quantity scores of each instrument");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quantity scores of each level of difficulty");

        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(240, 240, 240));

        tableGenre.setBackground(new java.awt.Color(240, 240, 240));
        tableGenre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tableGenre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tableGenre.setGridColor(new java.awt.Color(240, 240, 240));
        tableGenre.setRowHeight(30);
        tableGenre.setRowMargin(3);
        tableGenre.setSelectionBackground(new java.awt.Color(240, 240, 240));
        tableGenre.setSelectionForeground(new java.awt.Color(240, 240, 240));
        jScrollPane2.setViewportView(tableGenre);

        jScrollPane3.setBorder(null);

        tableLevel.setBackground(new java.awt.Color(240, 240, 240));
        tableLevel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tableLevel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tableLevel.setGridColor(new java.awt.Color(240, 240, 240));
        tableLevel.setRowHeight(30);
        tableLevel.setRowMargin(3);
        tableLevel.setSelectionBackground(new java.awt.Color(240, 240, 240));
        tableLevel.setSelectionForeground(new java.awt.Color(240, 240, 240));
        jScrollPane3.setViewportView(tableLevel);

        jScrollPane4.setBorder(null);

        tableInstrument.setBackground(new java.awt.Color(240, 240, 240));
        tableInstrument.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tableInstrument.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tableInstrument.setGridColor(new java.awt.Color(240, 240, 240));
        tableInstrument.setRowHeight(30);
        tableInstrument.setRowMargin(3);
        jScrollPane4.setViewportView(tableInstrument);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(labelTotalScores, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                                .addComponent(jScrollPane2)))))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTotalScores, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelTotalScores;
    private javax.swing.JTextField quantity;
    private javax.swing.JTable tableGenre;
    private javax.swing.JTable tableInstrument;
    private javax.swing.JTable tableLevel;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
