/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

public class loginGeneral extends javax.swing.JFrame {

    public loginGeneral() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnVoter = new javax.swing.JButton();
        btnAdministrator = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Elija una opcion:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Bienvenido");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));

        btnVoter.setText("Votante");
        btnVoter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoterActionPerformed(evt);
            }
        });
        jPanel1.add(btnVoter, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 120, -1));

        btnAdministrator.setText("Administración");
        btnAdministrator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministratorActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdministrator, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/371858444_745401040967216_1559791306627805276_n.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-160, 0, 610, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdministratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministratorActionPerformed
        LoginAdmin adm = new LoginAdmin();
        adm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdministratorActionPerformed

    private void btnVoterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoterActionPerformed
        voterUI vui = new voterUI();
        vui.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrator;
    private javax.swing.JButton btnVoter;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
