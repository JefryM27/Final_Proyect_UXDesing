/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.*;

public class voterAdmUI extends javax.swing.JFrame {

    CtrlVoter ctv = new CtrlVoter();

    public voterAdmUI() {
        initComponents();
        this.ctv.loadVoterData(tblAdm);
    }

    private void clear() {
        this.txtName.setText("");
        this.txtEmail.setText("");
        this.txtIdNumber.setText("");
        this.txtTelephone.setText("");
        this.txtAge.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTelephone = new javax.swing.JTextField();
        txtIdNumber = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAdm = new javax.swing.JTable();
        btnDeleteAdm = new javax.swing.JButton();
        btnAddAdm = new javax.swing.JButton();
        btnEditAdm = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Administrator de Votantes:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, -1));

        jLabel2.setText("Numero Telefonico:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, -1, -1));

        jLabel3.setText("Número de Cedula:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        jLabel4.setText("Nombre:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel5.setText("Correo Electrónico:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, -1));
        jPanel1.add(txtTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 180, -1));
        jPanel1.add(txtIdNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 180, -1));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 180, -1));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 180, -1));

        tblAdm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID:", "Cédula:", "Nombre:", "Correo Electrónico:", "Número Telefónico:"
            }
        ));
        tblAdm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAdmMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAdm);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 1130, 360));

        btnDeleteAdm.setText("Eliminar");
        btnDeleteAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAdmActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeleteAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 220, -1, -1));

        btnAddAdm.setText("Agregar");
        btnAddAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAdmActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 70, -1, -1));

        btnEditAdm.setText("Editar");
        btnEditAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAdmActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 150, -1, -1));

        jLabel6.setText("Edad:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, -1, -1));
        jPanel1.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAdmActionPerformed
        this.ctv.addVoter(txtName, txtIdNumber, txtAge, txtEmail, txtTelephone);
        this.clear();
        this.ctv.loadVoterData(tblAdm);

    }//GEN-LAST:event_btnAddAdmActionPerformed

    private void btnEditAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAdmActionPerformed
        this.ctv.updateVoter(txtName, txtIdNumber, txtAge, txtEmail, txtTelephone);
        this.clear();
        this.ctv.loadVoterData(tblAdm);
    }//GEN-LAST:event_btnEditAdmActionPerformed

    private void btnDeleteAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAdmActionPerformed
        this.ctv.deleteVoter();
        this.clear();
        this.ctv.loadVoterData(tblAdm);
    }//GEN-LAST:event_btnDeleteAdmActionPerformed

    private void tblAdmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAdmMouseClicked
        this.ctv.selectedRow(tblAdm, txtName, txtIdNumber, txtAge, txtEmail, txtTelephone);
    }//GEN-LAST:event_tblAdmMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAdm;
    private javax.swing.JButton btnDeleteAdm;
    private javax.swing.JButton btnEditAdm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAdm;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdNumber;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTelephone;
    // End of variables declaration//GEN-END:variables
}
