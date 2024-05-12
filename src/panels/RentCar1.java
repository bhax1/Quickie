package panels;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

public class RentCar1 extends javax.swing.JPanel {

    String url = "jdbc:mariadb://localhost:3306/carrental";
    String sqluser = "root";
    String sqlpass = "12345";

    public RentCar1() {
        initComponents();
    }

    public void populateComboBox() {
        Set<String> existingBrands = new HashSet<>();
        Set<String> existingColors = new HashSet<>();
        try (Connection con = DriverManager.getConnection(url, sqluser, sqlpass)) {
            String query = "SELECT * FROM cars";

            try (PreparedStatement statement = con.prepareStatement(query); ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    String brand = rs.getString("brand");
                    String color = rs.getString("color");
                    
                    if (!existingBrands.contains(brand)) {
                        brandComboBox.addItem(brand);
                        existingBrands.add(brand);
                    }
                    if (!existingColors.contains(color)) {
                        colorcb.addItem(color);
                        existingColors.add(color);
                    }
                }
                
                con.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "An error has occurred. Failed to display categories.");
        }
    }

    private void populateModelsForBrand(String selectedBrand) {
        modelComboBox.removeAllItems();
        try (Connection conn = DriverManager.getConnection(url, sqluser, sqlpass)){   
            String sql = "SELECT model FROM cars WHERE brand = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, selectedBrand);
                
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        String model = rs.getString("model");
                        modelComboBox.addItem(model);
                    }
                }
            }
            conn.close();
        } catch (SQLException ex) {
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        brandComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        modelComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        colorcb = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(java.awt.Color.white);

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Brand:");

        brandComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        brandComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        brandComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                brandComboBoxItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Model:");

        modelComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Color:");

        colorcb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        colorcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brandComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorcb, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(345, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(brandComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colorcb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void brandComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_brandComboBoxItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            String selectedBrand = (String) brandComboBox.getSelectedItem();
            populateModelsForBrand(selectedBrand);
        }
    }//GEN-LAST:event_brandComboBoxItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> brandComboBox;
    private javax.swing.JComboBox<String> colorcb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JComboBox<String> modelComboBox;
    // End of variables declaration//GEN-END:variables
}
