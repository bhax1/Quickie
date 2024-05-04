package GUI;

import java.awt.Toolkit;
import panels.ManageCars;
import panels.DashboardPanel;
import panels.ManageEmployees;
import panels.ManageOwners;
import panels.ReturnCar;

public class DashboardAdmin extends javax.swing.JFrame {

    public DashboardAdmin() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/pics/quickielogo.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        roundedPanel1 = new GUI.RoundedPanel();
        dashboardbtn = new javax.swing.JButton();
        managecar = new javax.swing.JButton();
        manageEmployees = new javax.swing.JButton();
        logoutbtn = new com.k33ptoo.components.KButton();
        tabbedPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 0, 0));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/quickie.png"))); // NOI18N

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel1.setOpaque(false);

        dashboardbtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dashboardbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/dashboard.png"))); // NOI18N
        dashboardbtn.setText("Dashboard");
        dashboardbtn.setBorder(null);
        dashboardbtn.setFocusPainted(false);
        dashboardbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        dashboardbtn.setOpaque(true);
        dashboardbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardbtnActionPerformed(evt);
            }
        });

        managecar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        managecar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/project.png"))); // NOI18N
        managecar.setText("Manage Cars");
        managecar.setBorder(null);
        managecar.setFocusPainted(false);
        managecar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        managecar.setOpaque(true);
        managecar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managecarActionPerformed(evt);
            }
        });

        manageEmployees.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        manageEmployees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/teamwork.png"))); // NOI18N
        manageEmployees.setText("Manage Employees");
        manageEmployees.setBorder(null);
        manageEmployees.setFocusPainted(false);
        manageEmployees.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        manageEmployees.setOpaque(true);
        manageEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(managecar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(dashboardbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageEmployees, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(dashboardbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(manageEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(managecar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );

        logoutbtn.setText("Logout");
        logoutbtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        logoutbtn.setkBackGroundColor(new java.awt.Color(255, 255, 255));
        logoutbtn.setkEndColor(new java.awt.Color(0, 0, 0));
        logoutbtn.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        logoutbtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        logoutbtn.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        logoutbtn.setkSelectedColor(new java.awt.Color(0, 0, 0));
        logoutbtn.setkStartColor(new java.awt.Color(255, 255, 255));
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(logoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(logoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jPanel1.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 630));

        tabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        tabbedPane.setFocusable(false);
        jPanel1.add(tabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 1000, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void managecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managecarActionPerformed
        ManageCars m = new ManageCars();
        tabbedPane.removeAll();
        m.populateTable();
        tabbedPane.add(m);
                
    }//GEN-LAST:event_managecarActionPerformed

    private void dashboardbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardbtnActionPerformed
        DashboardPanel m = new DashboardPanel();
        tabbedPane.removeAll();
        tabbedPane.add(m);
    }//GEN-LAST:event_dashboardbtnActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ReturnCar m = new ReturnCar();
        tabbedPane.removeAll();
        tabbedPane.add(m);
    }//GEN-LAST:event_formWindowOpened

    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtnActionPerformed
        
    }//GEN-LAST:event_logoutbtnActionPerformed

    private void manageEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeesActionPerformed
        ManageEmployees m = new ManageEmployees();
        m.populateTable();
        tabbedPane.removeAll();
        tabbedPane.add(m);
    }//GEN-LAST:event_manageEmployeesActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> { 
            new DashboardAdmin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dashboardbtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KButton logoutbtn;
    private javax.swing.JButton manageEmployees;
    private javax.swing.JButton managecar;
    private GUI.RoundedPanel roundedPanel1;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}