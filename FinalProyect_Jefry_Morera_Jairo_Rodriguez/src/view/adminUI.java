/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.CtrlCandidate;
import controller.CtrlVoter;
import java.io.File;

public class adminUI extends javax.swing.JFrame {

    CtrlCandidate ctc = new CtrlCandidate();
    CtrlVoter ctv = new CtrlVoter();
    private File selectedImageFile;

    public adminUI() {
        initComponents();
        ctc.initUI(lblImage); // Primero configura la interfaz
        ctc.loadCandidatesData(tblCandidate); // Luego carga los datos en la tabla
        this.ctv.loadVoterData(tblAdm);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdNumberCandidate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPoliticCandidate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCandidateName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCandidate = new javax.swing.JTable();
        txtAgeCandidate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        btnExaminar = new javax.swing.JButton();
        btnAddCandidate = new javax.swing.JButton();
        btnEditCandidate = new javax.swing.JButton();
        btnDeleteCandidate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIdNumber = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTelephone = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        btnAddAdm = new javax.swing.JButton();
        btnEditAdm = new javax.swing.JButton();
        btnDeleteAdm = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAdm = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Administrador de Candidatos:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        jLabel5.setText("Número de Cédula:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txtIdNumberCandidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdNumberCandidateActionPerformed(evt);
            }
        });
        jPanel1.add(txtIdNumberCandidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 160, -1));

        jLabel6.setText("Partido Politico:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, -1));

        txtPoliticCandidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPoliticCandidateActionPerformed(evt);
            }
        });
        jPanel1.add(txtPoliticCandidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 160, -1));

        jLabel4.setText("Nombre:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        txtCandidateName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCandidateNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtCandidateName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 160, -1));

        jLabel2.setText("Edad:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 1040, 340));

        txtAgeCandidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeCandidateActionPerformed(evt);
            }
        });
        jPanel1.add(txtAgeCandidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 160, -1));

        jLabel3.setText("Imagen:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 180, 130));

        btnExaminar.setText("Examinar");
        btnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnExaminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, -1, -1));

        btnAddCandidate.setText("Agregar");
        btnAddCandidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCandidateActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddCandidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 80, -1, -1));

        btnEditCandidate.setText("Editar");
        btnEditCandidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCandidateActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditCandidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 140, -1, -1));

        btnDeleteCandidate.setText("Eliminar");
        btnDeleteCandidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCandidateActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeleteCandidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 200, -1, -1));

        jTabbedPane1.addTab("Candidatos", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Administrator de Votantes:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, -1));

        jLabel8.setText("Número de Cedula:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));
        jPanel2.add(txtIdNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 180, -1));

        jLabel9.setText("Nombre:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        jPanel2.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 180, -1));

        jLabel10.setText("Correo Electrónico:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, -1));
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 180, -1));

        jLabel11.setText("Numero Telefonico:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, -1, -1));
        jPanel2.add(txtTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 180, -1));

        jLabel12.setText("Edad:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, -1, -1));
        jPanel2.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, 70, -1));

        btnAddAdm.setText("Agregar");
        btnAddAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAdmActionPerformed(evt);
            }
        });
        jPanel2.add(btnAddAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 70, -1, -1));

        btnEditAdm.setText("Editar");
        btnEditAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAdmActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 150, -1, -1));

        btnDeleteAdm.setText("Eliminar");
        btnDeleteAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAdmActionPerformed(evt);
            }
        });
        jPanel2.add(btnDeleteAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 220, -1, -1));

        tblAdm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID:", "Cedula", "Nombre", "Edad", "Correo Electronico", "Telefono"
            }
        ));
        tblAdm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAdmMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblAdm);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 1130, 360));

        jTabbedPane1.addTab("Votantes", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdNumberCandidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdNumberCandidateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdNumberCandidateActionPerformed

    private void txtPoliticCandidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPoliticCandidateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPoliticCandidateActionPerformed

    private void txtCandidateNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCandidateNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCandidateNameActionPerformed

    private void txtAgeCandidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeCandidateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeCandidateActionPerformed

    private void btnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarActionPerformed
        this.ctc.examinarImagen();
        selectedImageFile = ctc.getSelectedImageFile();
    }//GEN-LAST:event_btnExaminarActionPerformed

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

    private void btnAddAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAdmActionPerformed
        this.ctv.addVoter(txtName, txtIdNumber, txtAge, txtEmail, txtTelephone);
        this.ctv.clearFields(txtName, txtIdNumber, txtAge, txtEmail, txtTelephone);
        this.ctv.loadVoterData(tblAdm);
    }//GEN-LAST:event_btnAddAdmActionPerformed

    private void btnEditAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAdmActionPerformed
        this.ctv.updateVoter(txtName, txtIdNumber, txtAge, txtEmail, txtTelephone);
        this.ctv.clearFields(txtName, txtIdNumber, txtAge, txtEmail, txtTelephone);
        this.ctv.loadVoterData(tblAdm);
    }//GEN-LAST:event_btnEditAdmActionPerformed

    private void btnDeleteAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAdmActionPerformed
        this.ctv.deleteVoter();
        this.ctv.clearFields(txtName, txtIdNumber, txtAge, txtEmail, txtTelephone);
        this.ctv.loadVoterData(tblAdm);
    }//GEN-LAST:event_btnDeleteAdmActionPerformed

    private void tblAdmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAdmMouseClicked
        this.ctv.selectedRow(tblAdm, txtName, txtIdNumber, txtAge, txtEmail, txtTelephone);
    }//GEN-LAST:event_tblAdmMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAdm;
    private javax.swing.JButton btnAddCandidate;
    private javax.swing.JButton btnDeleteAdm;
    private javax.swing.JButton btnDeleteCandidate;
    private javax.swing.JButton btnEditAdm;
    private javax.swing.JButton btnEditCandidate;
    private javax.swing.JButton btnExaminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTable tblAdm;
    private javax.swing.JTable tblCandidate;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtAgeCandidate;
    private javax.swing.JTextField txtCandidateName;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdNumber;
    private javax.swing.JTextField txtIdNumberCandidate;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPoliticCandidate;
    private javax.swing.JTextField txtTelephone;
    // End of variables declaration//GEN-END:variables
}
