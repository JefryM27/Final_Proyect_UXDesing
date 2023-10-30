/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package V;


public class candidateAdmUI extends javax.swing.JFrame {

   
    public candidateAdmUI() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNameCandidate = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCandidate = new javax.swing.JTable();
        txtImageCandidate = new javax.swing.JTextField();
        txtIdNumberCandidate = new javax.swing.JTextField();
        txtAgeCandidate = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        txtPoliticCandidate = new javax.swing.JTextField();
        btnDeleteCandidate = new javax.swing.JButton();
        btnAddCandidate = new javax.swing.JButton();
        btnEditCandidate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNameCandidate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Administrador de Candidatos:");
        txtNameCandidate.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        jLabel2.setText("Edad:");
        txtNameCandidate.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel3.setText("Imagen:");
        txtNameCandidate.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, -1, -1));

        jLabel4.setText("Nombre:");
        txtNameCandidate.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel5.setText("Número de Cédula:");
        txtNameCandidate.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel6.setText("Partido Politico:");
        txtNameCandidate.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        tblCandidate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID:", "Cédula:", "Nombre:", "Edad:", "Partido Político:", "Imágen:"
            }
        ));
        jScrollPane1.setViewportView(tblCandidate);

        txtNameCandidate.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 1040, 340));

        txtImageCandidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImageCandidateActionPerformed(evt);
            }
        });
        txtNameCandidate.add(txtImageCandidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 160, -1));

        txtIdNumberCandidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdNumberCandidateActionPerformed(evt);
            }
        });
        txtNameCandidate.add(txtIdNumberCandidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 160, -1));

        txtAgeCandidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeCandidateActionPerformed(evt);
            }
        });
        txtNameCandidate.add(txtAgeCandidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 160, -1));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        txtNameCandidate.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 160, -1));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        txtNameCandidate.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 160, -1));

        txtPoliticCandidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPoliticCandidateActionPerformed(evt);
            }
        });
        txtNameCandidate.add(txtPoliticCandidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 160, -1));

        btnDeleteCandidate.setText("Eliminar");
        txtNameCandidate.add(btnDeleteCandidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 200, -1, -1));

        btnAddCandidate.setText("Agregar");
        txtNameCandidate.add(btnAddCandidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 80, -1, -1));

        btnEditCandidate.setText("Editar");
        txtNameCandidate.add(btnEditCandidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 140, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNameCandidate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNameCandidate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtImageCandidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImageCandidateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImageCandidateActionPerformed

    private void txtIdNumberCandidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdNumberCandidateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdNumberCandidateActionPerformed

    private void txtAgeCandidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeCandidateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeCandidateActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void txtPoliticCandidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPoliticCandidateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPoliticCandidateActionPerformed
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCandidate;
    private javax.swing.JButton btnDeleteCandidate;
    private javax.swing.JButton btnEditCandidate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable tblCandidate;
    private javax.swing.JTextField txtAgeCandidate;
    private javax.swing.JTextField txtIdNumberCandidate;
    private javax.swing.JTextField txtImageCandidate;
    private javax.swing.JPanel txtNameCandidate;
    private javax.swing.JTextField txtPoliticCandidate;
    // End of variables declaration//GEN-END:variables
}
