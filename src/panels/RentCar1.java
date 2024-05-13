package panels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.*;

public class RentCar1 extends javax.swing.JPanel {

    String url = "jdbc:mariadb://localhost:3306/carrental";
    String sqluser = "root";
    String sqlpass = "12345";

    public RentCar1() {
        initComponents();
        populateCarImages();
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
    
    private void populateCarImages() {
        contentPanel.removeAll();
        contentPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        try (Connection con = DriverManager.getConnection(url, sqluser, sqlpass)) {
            String query = "SELECT brand, model, picture FROM cars";

            try (PreparedStatement statement = con.prepareStatement(query); ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    String brand = rs.getString("brand");
                    String model = rs.getString("model");
                    byte[] imageData = rs.getBytes("picture");

                    BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
                    JLabel imageLabel = new JLabel(new ImageIcon(img));
                    JButton rentButton = new JButton("Rent a " + brand + " " + model);

                    rentButton.addActionListener(e -> {
                        JOptionPane.showMessageDialog(this, "Renting " + brand + " " + model);
                    });

                    JPanel carPanel = new JPanel(new BorderLayout());
                    carPanel.add(imageLabel, BorderLayout.CENTER);
                    carPanel.add(rentButton, BorderLayout.SOUTH);
                    contentPanel.add(carPanel);
                }
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to load car images.");
        }

        contentPanel.revalidate();
        contentPanel.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        upperpanel = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        brandComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        modelComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        colorcb = new javax.swing.JComboBox<>();
        contentPanel = new javax.swing.JPanel();
        scrollpane = new javax.swing.JScrollPane();

        setBackground(new java.awt.Color(255, 255, 255));

        upperpanel.setkEndColor(new java.awt.Color(255, 204, 255));
        upperpanel.setkStartColor(new java.awt.Color(204, 204, 255));

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

        javax.swing.GroupLayout upperpanelLayout = new javax.swing.GroupLayout(upperpanel);
        upperpanel.setLayout(upperpanelLayout);
        upperpanelLayout.setHorizontalGroup(
            upperpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(upperpanelLayout.createSequentialGroup()
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
                .addContainerGap(1345, Short.MAX_VALUE))
        );
        upperpanelLayout.setVerticalGroup(
            upperpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(upperpanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(upperpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(brandComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colorcb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        contentPanel.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollpane)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollpane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(upperpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(upperpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void brandComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_brandComboBoxItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            String selectedBrand = (String) brandComboBox.getSelectedItem();
            populateModelsForBrand(selectedBrand);
            populateCarImages();
        }
    }//GEN-LAST:event_brandComboBoxItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> brandComboBox;
    private javax.swing.JComboBox<String> colorcb;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> modelComboBox;
    private javax.swing.JScrollPane scrollpane;
    private keeptoo.KGradientPanel upperpanel;
    // End of variables declaration//GEN-END:variables
}
