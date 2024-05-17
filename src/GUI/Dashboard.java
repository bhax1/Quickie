package GUI;

import java.awt.Toolkit;
import javax.swing.JOptionPane;
import panels.DashboardPanel;
import panels.RentCar;
import panels.ReturnCar;

public class Dashboard extends javax.swing.JFrame {
    
    public Dashboard() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/pics/quickielogo.png")));
    }
    
    public javax.swing.JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        logoutbtn = new com.k33ptoo.components.KButton();
        roundedPanel1 = new GUI.RoundedPanel();
        dashboardbtn = new javax.swing.JButton();
        rentcarbtn = new javax.swing.JButton();
        returncarbtn = new javax.swing.JButton();
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

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 0, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/quickie.png"))); // NOI18N

        logoutbtn.setText("Logout");
        logoutbtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        logoutbtn.setkBackGroundColor(new java.awt.Color(255, 255, 255));
        logoutbtn.setkEndColor(new java.awt.Color(102, 102, 255));
        logoutbtn.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        logoutbtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        logoutbtn.setkHoverStartColor(new java.awt.Color(102, 102, 255));
        logoutbtn.setkIndicatorColor(new java.awt.Color(255, 153, 153));
        logoutbtn.setkSelectedColor(new java.awt.Color(102, 102, 255));
        logoutbtn.setkStartColor(new java.awt.Color(255, 153, 153));
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });

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

        rentcarbtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rentcarbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/car-rental.png"))); // NOI18N
        rentcarbtn.setText("Rent Car");
        rentcarbtn.setBorder(null);
        rentcarbtn.setFocusPainted(false);
        rentcarbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rentcarbtn.setOpaque(true);
        rentcarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentcarbtnActionPerformed(evt);
            }
        });

        returncarbtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        returncarbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/return car.png"))); // NOI18N
        returncarbtn.setText("Return Car");
        returncarbtn.setBorder(null);
        returncarbtn.setFocusPainted(false);
        returncarbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        returncarbtn.setOpaque(true);
        returncarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returncarbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rentcarbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dashboardbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(returncarbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(dashboardbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rentcarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(returncarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );

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
                        .addGap(43, 43, 43)
                        .addComponent(logoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(logoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
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

    private void dashboardbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardbtnActionPerformed
        DashboardPanel m = new DashboardPanel();
        tabbedPane.removeAll();
        tabbedPane.add(m);
    }//GEN-LAST:event_dashboardbtnActionPerformed

    private void rentcarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentcarbtnActionPerformed
        RentCar m = new RentCar();
        tabbedPane.removeAll();
        m.populateComboBox();
        tabbedPane.add(m);
    }//GEN-LAST:event_rentcarbtnActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ReturnCar m = new ReturnCar();
        tabbedPane.removeAll();
        tabbedPane.add(m);
    }//GEN-LAST:event_formWindowOpened

    private void returncarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returncarbtnActionPerformed
        
    }//GEN-LAST:event_returncarbtnActionPerformed

    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtnActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logging Out", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            Session.clearSession();
            this.dispose();
            Login l = new Login();
            l.setVisible(true);
        }
    }//GEN-LAST:event_logoutbtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> { 
            new Dashboard().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dashboardbtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KButton logoutbtn;
    private javax.swing.JButton rentcarbtn;
    private javax.swing.JButton returncarbtn;
    private GUI.RoundedPanel roundedPanel1;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
