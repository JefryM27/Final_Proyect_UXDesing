
package view;

import controller.*;
import model.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class voterUI extends javax.swing.JFrame {

    CtrlCandidate ctc = new CtrlCandidate();
    voterDAO voterDAO = new voterDAO();
    resultDAO resultDAO = new resultDAO();
    private int selectedCandidateId = -1;

    public voterUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        ctc.loadCandidatesDataVoter(tblCandidates);

    }
    //This method retrieves the ID of the selected candidate from the JTable.
    public int getSelectedCandidateId() {
        int selectedRow = tblCandidates.getSelectedRow();
        if (selectedRow != -1) {
            return Integer.parseInt(tblCandidates.getValueAt(selectedRow, 0).toString());
        }
        return -1; // If no row is selected
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCandidates = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnVote = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtIdNumber = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblCandidates.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Partido Politico", "Imagen"
            }
        ));
        jScrollPane1.setViewportView(tblCandidates);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 520, 450));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Por favor seleccione un candidato y luego presione el boton");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Candidatos");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        btnVote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/voting-box.png"))); // NOI18N
        btnVote.setBorderPainted(false);
        btnVote.setContentAreaFilled(false);
        btnVote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoteActionPerformed(evt);
            }
        });
        jPanel1.add(btnVote, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 70, 70));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cedula:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        txtIdNumber.setBackground(new java.awt.Color(204, 255, 255));
        txtIdNumber.setBorder(null);
        jPanel1.add(txtIdNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 150, 20));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 160, 10));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/exit.png"))); // NOI18N
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setDefaultCapable(false);
        btnExit.setFocusPainted(false);
        btnExit.setFocusable(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 50, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //This method is invoked when the "Vote" button is clicked
    private void btnVoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoteActionPerformed
        selectedCandidateId = getSelectedCandidateId();
        if (selectedCandidateId != -1) { //  Checks if the candidate ID is valid
            String idNumber = txtIdNumber.getText(); // Gets the voter ID from the JTextField
            if (voterDAO.authenticateVoter(idNumber)) { // Authenticates the voter
                if (!voterDAO.hasVoted(idNumber)) { // Checks if the voter has not voted yet
                    // Registers the vote in the database
                    result newResult = new result(voterDAO.getVoterId(idNumber), selectedCandidateId);
                    resultDAO.createResult(newResult); //  Method to register the vote in the "results" table
                    voterDAO.markAsVoted(idNumber); // Marks the voter as having voted
                    JOptionPane.showMessageDialog(null, "¡Su voto ha sido registrado correctamente!");
                    JOptionPane.showMessageDialog(null, "¡Gracias por su voto!");
                    loginGeneral lg = new loginGeneral();
                    lg.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "¡Usted ya ha votado!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El votante no está registrado o ingresó un ID incorrecto.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un candidato para votar.");
        }
    }//GEN-LAST:event_btnVoteActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        loginGeneral lg = new loginGeneral();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnVote;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblCandidates;
    private javax.swing.JTextField txtIdNumber;
    // End of variables declaration//GEN-END:variables
}
