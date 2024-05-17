package panels;

import GUI.Dashboard;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class RentCar extends javax.swing.JPanel {

    String url = "jdbc:mariadb://localhost:3306/carrental";
    String sqluser = "root";
    String sqlpass = "12345";

    public RentCar() {
        initComponents();
        populateCarImages();
    }
    
    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        double aspectRatio = (double) width / height;

        if (width > targetWidth || height > targetHeight) {
            if (aspectRatio > 1) {
                width = targetWidth;
                height = (int) (targetWidth / aspectRatio);
            } else {
                height = targetHeight;
                width = (int) (targetHeight * aspectRatio);
            }
        } else {
            width = targetWidth;
            height = targetHeight;
        }

        Image tmp = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return resizedImage;
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
        Set<String> existingModels = new HashSet<>();
        try (Connection conn = DriverManager.getConnection(url, sqluser, sqlpass)){   
            String sql = "SELECT model FROM cars WHERE brand = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, selectedBrand);
                
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        String model = rs.getString("model");
                        if (!existingModels.contains(model)) {
                            modelComboBox.addItem(model);
                            existingModels.add(model);
                        }
                    }
                }
            }
            conn.close();
        } catch (SQLException ex) {
            
        }
    }
    
    private void populateCarImages() {
        contentPanel.removeAll();

        int columns = 3;
        JPanel gridPanel = new JPanel(new GridLayout(0, columns, 30, 30));
        gridPanel.setBackground(Color.white);

        int targetWidth = 200;
        int targetHeight = 150;
        Dimension panelSize = new Dimension(250, 250);

        try (Connection con = DriverManager.getConnection(url, sqluser, sqlpass)) {
            String query;
            String selectedBrand = (String) brandComboBox.getSelectedItem();
            String selectedModel = (String) modelComboBox.getSelectedItem();
            String selectedColor = (String) colorcb.getSelectedItem(); // Get selected color

            if (selectedBrand.equals("All")) {
                query = "SELECT id, brand, model, yearmodel, fueltype, color, price, picture FROM cars";
            } else {
                query = "SELECT id, brand, model, yearmodel, fueltype, color, price, picture FROM cars WHERE brand = ?";
            }

            try (PreparedStatement statement = con.prepareStatement(query)) {
                if (!selectedBrand.equals("All")) {
                    statement.setString(1, selectedBrand);
                }

                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        int carid = rs.getInt("id");
                        String brand = rs.getString("brand");
                        String model = rs.getString("model");
                        String color = rs.getString("color");

                        if ((selectedBrand.equals("All") || model.equals(selectedModel)) 
                                && (selectedColor.equals("All") || color.equals(selectedColor))) {
                            int yearmodel = rs.getInt("yearmodel");
                            String fueltype = rs.getString("fueltype");
                            BigDecimal price = rs.getBigDecimal("price");
                            byte[] imageData = rs.getBytes("picture");

                            BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
                            if (img != null) {
                                BufferedImage resizedImg = resizeImage(img, targetWidth, targetHeight);
                                JLabel imageLabel = new JLabel(new ImageIcon(resizedImg));
                                JButton rentButton = new JButton("Rent a " + brand + " " + model);

                                rentButton.addActionListener(e -> {
                                    try {
                                        rentCar(carid, brand, model, yearmodel, fueltype, color, price, imageData);
                                    } catch (IOException ex) {
                                        Logger.getLogger(RentCar.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                });

                                JPanel carDetailsPanel = new JPanel(new GridLayout(0, 1));
                                carDetailsPanel.setBackground(Color.white); // Set background color for details panel
                                carDetailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
                                carDetailsPanel.add(new JLabel("<html><b>Brand:</b> " + brand + "</html>"));
                                carDetailsPanel.add(new JLabel("<html><b>Model:</b> " + model + "</html>"));
                                carDetailsPanel.add(new JLabel("<html><b>Year:</b> " + yearmodel + "</html>"));
                                carDetailsPanel.add(new JLabel("<html><b>Fuel Type:</b> " + fueltype + "</html>"));
                                carDetailsPanel.add(new JLabel("<html><b>Color:</b> " + color + "</html>"));
                                carDetailsPanel.add(new JLabel("<html><b>Price:</b> ₱" + price + "</html>"));

                                JPanel carPanel = new JPanel(new BorderLayout());
                                carPanel.setPreferredSize(panelSize);
                                carPanel.setBackground(Color.lightGray);
                                carPanel.setBorder(BorderFactory.createLineBorder(Color.black));
                                carPanel.add(imageLabel, BorderLayout.CENTER);
                                carPanel.add(carDetailsPanel, BorderLayout.NORTH);
                                carPanel.add(rentButton, BorderLayout.SOUTH);

                                gridPanel.add(carPanel);
                            }
                        }
                    }
                }
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to load car images: " + e.getMessage());
        }

        JScrollPane scrollPane = new JScrollPane(gridPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        contentPanel.setLayout(new BorderLayout()); // Set layout for contentPanel
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void rentCar(int carid, String brand, String model, int year, String fuelType, String color, BigDecimal price, byte[] image) throws IOException {
        Dashboard dashboard = (Dashboard) SwingUtilities.getWindowAncestor(this);
        if (dashboard != null) {
            dashboard.getTabbedPane().removeAll(); // Remove all tabs

            // Create and add transaction panel
            TransactionPanel transactionPanel = new TransactionPanel(carid, brand, model, year, fuelType, color, price, image);
            dashboard.getTabbedPane().add("", transactionPanel);
            dashboard.getTabbedPane().setSelectedComponent(transactionPanel);
        }
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
        setPreferredSize(new java.awt.Dimension(1000, 523));

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
        modelComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        modelComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                modelComboBoxItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Color:");

        colorcb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        colorcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        colorcb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                colorcbItemStateChanged(evt);
            }
        });

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollpane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void modelComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_modelComboBoxItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            populateCarImages();
        }
    }//GEN-LAST:event_modelComboBoxItemStateChanged

    private void colorcbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_colorcbItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            populateCarImages();
        }
    }//GEN-LAST:event_colorcbItemStateChanged


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
