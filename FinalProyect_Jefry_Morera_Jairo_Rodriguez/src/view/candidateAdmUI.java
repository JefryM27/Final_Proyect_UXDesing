/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.CtrlCandidate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JLabel;
import model.ImageRenderer;

public class candidateAdmUI extends javax.swing.JFrame {

    CtrlCandidate ctc = new CtrlCandidate();
    private File selectedImageFile;

    public candidateAdmUI() {
        initComponents();
        ctc.initUI(lblImage); // Primero configura la interfaz
        ctc.loadCandidatesData(tblCandidate); // Luego carga los datos en la tabla
        this.setLocationRelativeTo(null);
        this.setResizable(false);

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
        txtIdNumberCandidate = new javax.swing.JTextField();
        txtAgeCandidate = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        txtCandidateName = new javax.swing.JTextField();
        txtPoliticCandidate = new javax.swing.JTextField();
        btnDeleteCandidate = new javax.swing.JButton();
        btnAddCandidate = new javax.swing.JButton();
        btnEditCandidate = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();
        btnExaminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNameCandidate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Administrador de Candidatos:");
        txtNameCandidate.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        jLabel2.setText("Edad:");
        txtNameCandidate.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel3.setText("Imagen:");
        txtNameCandidate.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jLabel4.setText("Nombre:");
        txtNameCandidate.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel5.setText("Número de Cédula:");
        txtNameCandidate.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel6.setText("Partido Politico:");
        txtNameCandidate.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, -1));

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

        txtIdNumberCandidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdNumberCandidateActionPerformed(evt);
            }
        });
        txtNameCandidate.add(txtIdNumberCandidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 160, -1));

        txtAgeCandidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeCandidateActionPerformed(evt);
            }
        });
        txtNameCandidate.add(txtAgeCandidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 160, -1));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        txtNameCandidate.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 160, -1));

        txtCandidateName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCandidateNameActionPerformed(evt);
            }
        });
        txtNameCandidate.add(txtCandidateName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 160, -1));

        txtPoliticCandidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPoliticCandidateActionPerformed(evt);
            }
        });
        txtNameCandidate.add(txtPoliticCandidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 160, -1));

        btnDeleteCandidate.setText("Eliminar");
        btnDeleteCandidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCandidateActionPerformed(evt);
            }
        });
        txtNameCandidate.add(btnDeleteCandidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 200, -1, -1));

        btnAddCandidate.setText("Agregar");
        btnAddCandidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCandidateActionPerformed(evt);
            }
        });
        txtNameCandidate.add(btnAddCandidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 80, -1, -1));

        btnEditCandidate.setText("Editar");
        btnEditCandidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCandidateActionPerformed(evt);
            }
        });
        txtNameCandidate.add(btnEditCandidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 140, -1, -1));

        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtNameCandidate.add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 180, 130));

        btnExaminar.setText("Examinar");
        btnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarActionPerformed(evt);
            }
        });
        txtNameCandidate.add(btnExaminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, -1, -1));

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

    private void txtIdNumberCandidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdNumberCandidateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdNumberCandidateActionPerformed

    private void txtAgeCandidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeCandidateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeCandidateActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void txtCandidateNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCandidateNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCandidateNameActionPerformed

    private void txtPoliticCandidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPoliticCandidateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPoliticCandidateActionPerformed

    private void btnAddCandidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCandidateActionPerformed
        this.ctc.addCandidate(txtCandidateName, txtIdNumberCandidate, txtAgeCandidate, txtPoliticCandidate, selectedImageFile);
        this.ctc.loadCandidatesData(tblCandidate);
    }//GEN-LAST:event_btnAddCandidateActionPerformed

    private void btnEditCandidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCandidateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditCandidateActionPerformed

    private void btnDeleteCandidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCandidateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteCandidateActionPerformed

    private void btnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarActionPerformed
        this.ctc.examinarImagen();
        selectedImageFile = ctc.getSelectedImageFile();
    }//GEN-LAST:event_btnExaminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCandidate;
    private javax.swing.JButton btnDeleteCandidate;
    private javax.swing.JButton btnEditCandidate;
    private javax.swing.JButton btnExaminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTable tblCandidate;
    private javax.swing.JTextField txtAgeCandidate;
    private javax.swing.JTextField txtCandidateName;
    private javax.swing.JTextField txtIdNumberCandidate;
    private javax.swing.JPanel txtNameCandidate;
    private javax.swing.JTextField txtPoliticCandidate;
    // End of variables declaration//GEN-END:variables
}
