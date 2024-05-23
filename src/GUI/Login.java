package GUI;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    boolean hidetext = true;
    String url = "jdbc:mariadb://localhost:3306/carrental";
    String sqluser = "root";
    String sqlpass = "";
    
    public Login() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/pics/quickielogo.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new keeptoo.KGradientPanel();
        logopanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        loginbtn = new com.k33ptoo.components.KButton();
        hide = new javax.swing.JLabel();
        password = new GUI.FPasswordField();
        username = new GUI.FTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        mainpanel.setForeground(new java.awt.Color(255, 255, 255));
        mainpanel.setkEndColor(new java.awt.Color(153, 153, 255));
        mainpanel.setkStartColor(new java.awt.Color(255, 255, 255));

        logopanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel1.setText("Employee ID");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel2.setText("Password");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("Welcome! Let's login.");

        loginbtn.setText("Login");
        loginbtn.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        loginbtn.setkBackGroundColor(new java.awt.Color(255, 255, 255));
        loginbtn.setkEndColor(new java.awt.Color(102, 102, 255));
        loginbtn.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        loginbtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        loginbtn.setkHoverStartColor(new java.awt.Color(102, 102, 255));
        loginbtn.setkIndicatorColor(new java.awt.Color(255, 153, 153));
        loginbtn.setkSelectedColor(new java.awt.Color(102, 102, 255));
        loginbtn.setkStartColor(new java.awt.Color(255, 153, 153));
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });

        hide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/close-eye.png"))); // NOI18N
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hideMouseClicked(evt);
            }
        });

        password.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        username.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel3.setText("Are you an admin?");
        jLabel3.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel5.setText("Click here.");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout logopanelLayout = new javax.swing.GroupLayout(logopanel);
        logopanel.setLayout(logopanelLayout);
        logopanelLayout.setHorizontalGroup(
            logopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logopanelLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(logopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addGroup(logopanelLayout.createSequentialGroup()
                        .addGroup(logopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(logopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, logopanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hide)))
                .addGap(27, 27, 27))
        );
        logopanelLayout.setVerticalGroup(
            logopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logopanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(logopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logopanelLayout.createSequentialGroup()
                        .addComponent(hide)
                        .addGap(12, 12, 12)))
                .addGap(47, 47, 47)
                .addComponent(loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(logopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(33, 33, 33))
        );

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/quick lgo.png"))); // NOI18N

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addComponent(logopanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logopanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void hideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMouseClicked
        if (hidetext == true) {
            hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/visible.png")));
            password.setEchoChar((char) 0);
            hidetext = false;
        } else {
            hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/close-eye.png")));
            password.setEchoChar('\u2022');
            hidetext = true;
        }
    }//GEN-LAST:event_hideMouseClicked

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
        try {
            int user = Integer.parseInt(username.getText());
            String pass = password.getText();        

            if (pass.isBlank()) {
                JOptionPane.showMessageDialog(this, "Password is required.");
                return;
            }
            
            Connection con = DriverManager.getConnection(url, sqluser, sqlpass);
            String checkEmployee = "SELECT * FROM employees WHERE id = ? AND password = ?";
            PreparedStatement checkPs = con.prepareStatement(checkEmployee);
            checkPs.setInt(1, user);
            checkPs.setString(2, pass);
            ResultSet rs = checkPs.executeQuery();
            if (rs.next()) {
                int employeeId = rs.getInt("id");
                String employeeFname = rs.getString("fname");
                String employeeLname = rs.getString("lname");
                String employeeName = employeeFname +" "+ employeeLname;
                Session.setLoggedInEmployee(employeeId, employeeName);

                Dashboard d = new Dashboard();
                dispose();
                JOptionPane.showMessageDialog(this, "Login successfully.");
                d.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Account doesn't exist.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid ID.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Something went wrong. Please try again.");
        }
    }//GEN-LAST:event_loginbtnActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        LoginAdmin a = new LoginAdmin();
        dispose();
        a.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    public static void main(String args[]) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hide;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private com.k33ptoo.components.KButton loginbtn;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel logopanel;
    private keeptoo.KGradientPanel mainpanel;
    private GUI.FPasswordField password;
    private GUI.FTextField username;
    // End of variables declaration//GEN-END:variables
}
