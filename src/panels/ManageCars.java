package panels;

import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.sql.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class ManageCars extends javax.swing.JPanel {

    String url = "jdbc:mariadb://localhost:3306/carrental";
    String sqluser = "root";
    String sqlpass = "12345";
    File selectedFile;

    public ManageCars() {
        initComponents();
    }

    private static boolean isImageSizeValid(File imageFile) {
        try {
            BufferedImage img = ImageIO.read(imageFile);
            int width = img.getWidth();
            int height = img.getHeight();
            return (width <= 300 && height <= 200);
        } catch (IOException e) {
        }
        return false;
    }

    public void populateTable() {
        DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
        tmodel.setRowCount(0);

        String query = "SELECT * FROM cars";

        try (Connection con = DriverManager.getConnection(url, sqluser, sqlpass);
             PreparedStatement statement = con.prepareStatement(query);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String brands = rs.getString("brand");
                String models = rs.getString("model");
                int yearmodels = rs.getInt("yearmodel");
                String fuelTypes = rs.getString("fueltype");
                String colors = rs.getString("color");
                String plateNos = rs.getString("platenumber");
                BigDecimal prices = rs.getBigDecimal("price");

                byte[] picture = rs.getBytes("picture");

                tmodel.addRow(new Object[]{id, brands, models, yearmodels, fuelTypes, colors, plateNos, prices, picture});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "An error has occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid price format: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unexpected error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void clear() {
        brand.setText("");
        color.setText("");
        model.setText("");
        yearmodel.setText("");
        fueltype.setText("");
        plateno.setText("");
        price.setText("");
        imageLabel.setIcon(null);
        table.clearSelection();
        selectedFile = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infopanel = new javax.swing.JPanel();
        imagepanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        addCar = new javax.swing.JButton();
        removeCar = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        updateCar = new javax.swing.JButton();
        selectimagebtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblbrand = new javax.swing.JLabel();
        brand = new javax.swing.JTextField();
        color = new javax.swing.JTextField();
        lblcolor = new javax.swing.JLabel();
        model = new javax.swing.JTextField();
        lblmodel = new javax.swing.JLabel();
        lblfueltype = new javax.swing.JLabel();
        fueltype = new javax.swing.JTextField();
        plateno = new javax.swing.JTextField();
        lblplate = new javax.swing.JLabel();
        lblprice = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        lblcarID1 = new javax.swing.JLabel();
        searchID = new javax.swing.JTextField();
        searchbtn = new javax.swing.JButton();
        lblprice1 = new javax.swing.JLabel();
        yearmodel = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 555));

        infopanel.setBackground(new java.awt.Color(204, 204, 204));

        imagepanel.setBackground(new java.awt.Color(255, 255, 255));
        imagepanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagepanel.setPreferredSize(new java.awt.Dimension(300, 200));

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout imagepanelLayout = new javax.swing.GroupLayout(imagepanel);
        imagepanel.setLayout(imagepanelLayout);
        imagepanelLayout.setHorizontalGroup(
            imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );
        imagepanelLayout.setVerticalGroup(
            imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addCar.setText("Add Car");
        addCar.setFocusPainted(false);
        addCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCarActionPerformed(evt);
            }
        });

        removeCar.setText("Remove Car");
        removeCar.setFocusPainted(false);
        removeCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCarActionPerformed(evt);
            }
        });

        clearbtn.setText("Clear");
        clearbtn.setFocusPainted(false);
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });

        updateCar.setText("Update Car");
        updateCar.setFocusPainted(false);
        updateCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCarActionPerformed(evt);
            }
        });

        selectimagebtn.setText("Select Image");
        selectimagebtn.setFocusPainted(false);
        selectimagebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectimagebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout infopanelLayout = new javax.swing.GroupLayout(infopanel);
        infopanel.setLayout(infopanelLayout);
        infopanelLayout.setHorizontalGroup(
            infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infopanelLayout.createSequentialGroup()
                .addGroup(infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infopanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addCar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateCar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeCar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(clearbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectimagebtn)))
                    .addGroup(infopanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(imagepanel, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        infopanelLayout.setVerticalGroup(
            infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infopanelLayout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(imagepanel, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addGroup(infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearbtn))
                .addGap(18, 18, 18)
                .addGroup(infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateCar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectimagebtn))
                .addGap(18, 18, 18)
                .addComponent(removeCar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Car ID", "Brand", "Model", "Year Model", "Fuel Type", "Color", "Plate Number", "Price", "Picture"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Byte.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setFocusable(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(6).setResizable(false);
            table.getColumnModel().getColumn(7).setResizable(false);
            table.getColumnModel().getColumn(8).setMinWidth(0);
            table.getColumnModel().getColumn(8).setPreferredWidth(0);
            table.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        lblbrand.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblbrand.setText("Brand");

        lblcolor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblcolor.setText("Color");

        lblmodel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblmodel.setText("Model");

        lblfueltype.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblfueltype.setText("Fuel Type");

        lblplate.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblplate.setText("Plate No.");

        lblprice.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblprice.setText("Price");

        lblcarID1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblcarID1.setText("Search Car ID:");

        searchbtn.setText("Search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        lblprice1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblprice1.setText("Year Model");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblbrand)
                    .addComponent(lblmodel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblfueltype, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcolor))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(brand)
                    .addComponent(model)
                    .addComponent(fueltype)
                    .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblplate)
                    .addComponent(lblprice1)
                    .addComponent(lblprice, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcarID1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(plateno, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(searchID, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchbtn))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(yearmodel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                .addComponent(price, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(22, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblbrand)
                                .addComponent(brand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblmodel)
                                    .addComponent(lblprice1)
                                    .addComponent(yearmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblfueltype)
                            .addComponent(fueltype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblprice)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblplate)
                        .addComponent(plateno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcolor)
                    .addComponent(lblcarID1)
                    .addComponent(searchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(infopanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(33, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(infopanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectimagebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectimagebtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileFilter imageFilter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(imageFilter);

        int returnValue = fileChooser.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();

            if (isImageSizeValid(selectedFile)) {
                try {
                    BufferedImage img = ImageIO.read(selectedFile);
                    ImageIcon imageIcon = new ImageIcon(img);
                    imageLabel.setIcon(imageIcon);

                    JOptionPane.showMessageDialog(this, "Image has been selected.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error loading image.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Image size exceeds 300x200 pixels. Please select a smaller image.");
            }
        }
    }//GEN-LAST:event_selectimagebtnActionPerformed

    private void addCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCarActionPerformed
        String brandText = brand.getText();
        String modelText = model.getText();
        String yearmodelText = yearmodel.getText();
        String fuelTypeText = fueltype.getText();
        String colorText = color.getText();
        String platenoText = plateno.getText();
        String priceText = price.getText();

        if (brandText.isBlank() || modelText.isBlank() || yearmodelText.isBlank() || colorText.isBlank() || fuelTypeText.isBlank() || platenoText.isBlank() || priceText.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please enter all fields.");
        } else if (selectedFile == null) {
            JOptionPane.showMessageDialog(this, "Please select an image first before proceeding.");
        } else {
            try (Connection con = DriverManager.getConnection(url, sqluser, sqlpass)) {
                int yearmodels = Integer.parseInt(yearmodelText);
                
                String insertQuery = "INSERT INTO cars (brand, model, yearmodel, fueltype, color, platenumber, price, picture) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(insertQuery);

                ps.setString(1, brandText);
                ps.setString(2, modelText);
                ps.setInt(3, yearmodels);
                ps.setString(4, fuelTypeText);
                ps.setString(5, colorText);
                ps.setString(6, platenoText);
                ps.setBigDecimal(7, new BigDecimal(priceText));

                FileInputStream fis = new FileInputStream(selectedFile);
                ps.setBinaryStream(8, fis);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Car added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    populateTable();
                    clear();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to add car.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                ps.close();
                fis.close();
                con.close();

            } catch (SQLException | IOException ex) {
                JOptionPane.showMessageDialog(this, "Database error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ne) {
                JOptionPane.showMessageDialog(this, "Invalid price.");
            }
        }
    }//GEN-LAST:event_addCarActionPerformed

    private void removeCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCarActionPerformed
        DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "No row is selected", "Select row", JOptionPane.ERROR_MESSAGE);
        } else {
            int carid = (int) tmodel.getValueAt(row, 0);
            try {
                Connection con = DriverManager.getConnection(url, sqluser, sqlpass);
                String query = "DELETE FROM cars WHERE id = ?";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1, carid);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    clear();
                    tmodel.removeRow(row);
                    populateTable();
                    JOptionPane.showMessageDialog(this,
                            "Car removed successfully.", null,
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Failed to remove car.", null,
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "An error has occurred.");
            }
        }
    }//GEN-LAST:event_removeCarActionPerformed

    private void updateCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCarActionPerformed
        int row = table.getSelectedRow();
        DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "No row is selected", "Select row", JOptionPane.ERROR_MESSAGE);
        } else {
            String brandText = brand.getText();
            String modelText = model.getText();
            String yearmodelText = yearmodel.getText();
            String fuelTypeText = fueltype.getText();
            String colorText = color.getText();
            String platenoText = plateno.getText();
            String priceText = price.getText();
            byte[] imageData = (byte[]) tmodel.getValueAt(row, 8);
            String id = tmodel.getValueAt(row, 0).toString();

            if (brandText.isBlank() || modelText.isBlank() || yearmodelText.isBlank() || colorText.isBlank() || fuelTypeText.isBlank() || platenoText.isBlank() || priceText.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please enter all fields.");
            } else {
                try {
                    int yearmodels = Integer.parseInt(yearmodelText);
                    int carid = Integer.parseInt(id);

                    try (Connection con = DriverManager.getConnection(url, sqluser, sqlpass)) {
                        String query = "UPDATE cars SET brand = ?, model = ?, yearmodel = ?, fueltype = ?, color = ?, platenumber = ?, price = ?, picture = ? WHERE id = ?";
                        try (PreparedStatement ps = con.prepareStatement(query)) {
                            ps.setString(1, brandText);
                            ps.setString(2, modelText);
                            ps.setInt(3, yearmodels);
                            ps.setString(4, fuelTypeText);
                            ps.setString(5, colorText);
                            ps.setString(6, platenoText);
                            ps.setBigDecimal(7, new BigDecimal(priceText));
                            
                            if (selectedFile != null) {
                                try (FileInputStream fis = new FileInputStream(selectedFile)) {
                                    ps.setBinaryStream(8, fis);
                                }
                            } else {
                                try (ByteArrayInputStream bais = new ByteArrayInputStream(imageData)) {
                                    ps.setBinaryStream(8, bais, imageData.length);
                                }
                            }
                            ps.setInt(9, carid);
                            
                            int rowsUpdated = ps.executeUpdate();
                            if (rowsUpdated > 0) {
                                populateTable();
                                clear();
                                JOptionPane.showMessageDialog(this, "Car updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(this, "Failed to update car.", "Error", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "An error has occurred in database.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ne) {
                    JOptionPane.showMessageDialog(this, "Year Model is invalid.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Image not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_updateCarActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        try {
            int row = table.getSelectedRow();
            DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
            brand.setText(tmodel.getValueAt(row, 1).toString());
            model.setText(tmodel.getValueAt(row, 2).toString());
            yearmodel.setText(tmodel.getValueAt(row, 3).toString());
            fueltype.setText(tmodel.getValueAt(row, 4).toString());
            color.setText(tmodel.getValueAt(row, 5).toString());
            plateno.setText(tmodel.getValueAt(row, 6).toString());
            price.setText(tmodel.getValueAt(row, 7).toString());
            
            byte[] imageData = (byte[]) tmodel.getValueAt(row, 8);
            BufferedImage originalImage = getImageFromByteArray(imageData);
            ImageIcon imageIcon = new ImageIcon(originalImage);
            imageLabel.setIcon(imageIcon);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Database error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tableMouseClicked

    private static BufferedImage getImageFromByteArray(byte[] imageData) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
        return ImageIO.read(bis);
    }
    
    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        clear();
    }//GEN-LAST:event_clearbtnActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        String searchIDText = searchID.getText();
        try {
            int searchIDs = Integer.parseInt(searchIDText);
            DefaultTableModel tmodel = (DefaultTableModel) table.getModel();

            int rowCount = tmodel.getRowCount();
            boolean found = false;
            for (int i = 0; i < rowCount; i++) {
                int id = (int) tmodel.getValueAt(i, 0);

                if (id == searchIDs) {
                    table.setRowSelectionInterval(i, i);
                    brand.setText(tmodel.getValueAt(i, 1).toString());
                    model.setText(tmodel.getValueAt(i, 2).toString());
                    yearmodel.setText(tmodel.getValueAt(i, 3).toString());
                    fueltype.setText(tmodel.getValueAt(i, 4).toString());
                    color.setText(tmodel.getValueAt(i, 5).toString());
                    plateno.setText(tmodel.getValueAt(i, 6).toString());
                    price.setText(tmodel.getValueAt(i, 7).toString());

                    byte[] imageData = (byte[]) tmodel.getValueAt(i, 8);
                    BufferedImage originalImage = getImageFromByteArray(imageData);

                    ImageIcon imageIcon = new ImageIcon(originalImage);
                    imageLabel.setIcon(imageIcon);

                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "ID not found in the table.", "Not Found", JOptionPane.WARNING_MESSAGE);
                clear();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid integer ID.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error loading image: " + ex.getMessage(), "Image Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchbtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCar;
    private javax.swing.JTextField brand;
    private javax.swing.JButton clearbtn;
    private javax.swing.JTextField color;
    private javax.swing.JTextField fueltype;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel imagepanel;
    private javax.swing.JPanel infopanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblbrand;
    private javax.swing.JLabel lblcarID1;
    private javax.swing.JLabel lblcolor;
    private javax.swing.JLabel lblfueltype;
    private javax.swing.JLabel lblmodel;
    private javax.swing.JLabel lblplate;
    private javax.swing.JLabel lblprice;
    private javax.swing.JLabel lblprice1;
    private javax.swing.JTextField model;
    private javax.swing.JTextField plateno;
    private javax.swing.JTextField price;
    private javax.swing.JButton removeCar;
    private javax.swing.JTextField searchID;
    private javax.swing.JButton searchbtn;
    private javax.swing.JButton selectimagebtn;
    private javax.swing.JTable table;
    private javax.swing.JButton updateCar;
    private javax.swing.JTextField yearmodel;
    // End of variables declaration//GEN-END:variables
}
