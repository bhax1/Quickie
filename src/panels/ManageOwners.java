package panels;

import GUI.Dashboard;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.sql.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class ManageOwners extends javax.swing.JPanel {

    String url = "jdbc:mariadb://localhost:3306/carrental";
    String sqluser = "root";
    String sqlpass = "12345";
    String picts;
    File selectedFile;

    public ManageOwners() {
        initComponents();
    }

    private static boolean isImageSizeValid(File imageFile) {
        try {
            BufferedImage img = ImageIO.read(imageFile);
            int width = img.getWidth();
            int height = img.getHeight();
            return (width <= 600 && height <= 600); // Check against maximum 600x600 size
        } catch (IOException e) {
        }
        return false;
    }
    
    private static Image scaleImage(BufferedImage img, int targetWidth, int targetHeight) {
        int originalWidth = img.getWidth();
        int originalHeight = img.getHeight();
        double scaleFactor = Math.min((double) targetWidth / originalWidth, (double) targetHeight / originalHeight);

        int scaledWidth = (int) (originalWidth * scaleFactor);
        int scaledHeight = (int) (originalHeight * scaleFactor);

        Image scaledImage = img.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        BufferedImage bufferedImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(scaledImage, 0, 0, null);
        g2d.dispose();

        return bufferedImage;
    }

    private static void copyImageToPackage(File selectedImage) {
        try {
            String destinationDirectory = "src/owners/";

            File destDir = new File(destinationDirectory);
            if (!destDir.exists()) {
                destDir.mkdirs();
            }

            String destinationFilePath = destinationDirectory + selectedImage.getName();

            Files.copy(selectedImage.toPath(), new File(destinationFilePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
        }
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        try (Connection con = DriverManager.getConnection(url, sqluser, sqlpass)) {
            String query = "SELECT * FROM owners";

            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("fname");
                String lastname = rs.getString("lname");
                String contactno = rs.getString("contact");
                String emails = rs.getString("email");
                String addresss = rs.getString("address");
                String picture = rs.getString("picture");

                model.addRow(new Object[]{id, firstname, lastname, contactno, emails, addresss, picture});
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "An error has occurred.");
        }
    }

    public void deletepic(String pic) {
        String picfile = "src/owners/" + pic;
        File fileToDelete = new File(picfile);
        if (fileToDelete.exists()) {
            if (fileToDelete.delete()) {
            }
        }
    }

    public void clear() {
        fname.setText("");
        lname.setText("");
        contact.setText("");
        email.setText("");
        address.setText("");
        imageLabel.setIcon(null);
        table.clearSelection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infopanel = new javax.swing.JPanel();
        imagepanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        addOwner = new javax.swing.JButton();
        removeOwner = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        updateOwner = new javax.swing.JButton();
        selectimagebtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        fnamelabel = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        lnamelabel = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();
        contactlabel = new javax.swing.JLabel();
        emaillabel = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        addresslabel = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        searchID = new javax.swing.JTextField();
        searchlabel = new javax.swing.JLabel();
        searchbtn = new javax.swing.JButton();

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
                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );

        addOwner.setText("Add Owner");
        addOwner.setFocusPainted(false);
        addOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOwnerActionPerformed(evt);
            }
        });

        removeOwner.setText("Remove Owner");
        removeOwner.setFocusPainted(false);
        removeOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeOwnerActionPerformed(evt);
            }
        });

        clearbtn.setText("Clear");
        clearbtn.setFocusPainted(false);
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });

        updateOwner.setText("Update Owner");
        updateOwner.setFocusPainted(false);
        updateOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateOwnerActionPerformed(evt);
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
                        .addGap(17, 17, 17)
                        .addComponent(imagepanel, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infopanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(clearbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectimagebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        infopanelLayout.setVerticalGroup(
            infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infopanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(imagepanel, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearbtn))
                .addGap(18, 18, 18)
                .addGroup(infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectimagebtn))
                .addGap(18, 18, 18)
                .addComponent(removeOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Owner ID", "Firstname", "Lastname", "Contact No.", "Email", "Address", "Pic"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

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
            table.getColumnModel().getColumn(6).setMinWidth(0);
            table.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        fnamelabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        fnamelabel.setText("Firstname");

        lnamelabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lnamelabel.setText("Lastname");

        contactlabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        contactlabel.setText("Contact No.");

        emaillabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        emaillabel.setText("Email");

        addresslabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        addresslabel.setText("Address");

        searchlabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        searchlabel.setText("Search Employee ID:");

        searchbtn.setText("Search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(fnamelabel)
                            .addGap(28, 28, 28))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(contactlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addresslabel)
                            .addComponent(emaillabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fname)
                    .addComponent(contact, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(address)
                    .addComponent(email))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchID, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchbtn))
                    .addComponent(searchlabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lnamelabel)
                        .addGap(18, 18, 18)
                        .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contactlabel)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fnamelabel)
                        .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lnamelabel)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addresslabel)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(searchlabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emaillabel)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(infopanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(infopanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
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

                    // Scale the image to fit within a 300x300 panel while preserving aspect ratio
                    ImageIcon imageIcon = new ImageIcon(scaleImage(img, 300, 300));
                    imageLabel.setIcon(imageIcon);

                    JOptionPane.showMessageDialog(this, "Image has been selected.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error loading image.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Image size exceeds 600x600 pixels. Please select a smaller image.");
            }
        }
    }//GEN-LAST:event_selectimagebtnActionPerformed

    private void addOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOwnerActionPerformed
        String fnameStr = fname.getText();
        String lnameStr = lname.getText();
        String contactStr = contact.getText();
        String emailStr = email.getText();
        String addressStr = address.getText();
        
        if (fnameStr.isBlank() || lnameStr.isBlank() || contactStr.isBlank() || emailStr.isBlank() || addressStr.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please enter all fields.");
        } else if (selectedFile == null) {
            JOptionPane.showMessageDialog(this, "Please select an image first before proceeding.");
        } else {
            try {
                Connection con = DriverManager.getConnection(url, sqluser, sqlpass);
                String checkEmailQuery = "SELECT id FROM owners WHERE email = ?";
                try (PreparedStatement checkPs = con.prepareStatement(checkEmailQuery)) {
                    checkPs.setString(1, emailStr);
                    ResultSet rs = checkPs.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "Email already registered. Please use a different email address.");
                    } else {
                        String insertQuery = "INSERT INTO owners (fname, lname, contact, email, address, picture) VALUES (?, ?, ?, ?, ?, ?)";
                        try (PreparedStatement ps = con.prepareStatement(insertQuery)) {
                            ps.setString(1, fnameStr);
                            ps.setString(2, lnameStr);
                            ps.setString(3, contactStr);
                            ps.setString(4, emailStr);
                            ps.setString(5, addressStr);
                            ps.setString(6, selectedFile.getName());

                            int rowsAffected = ps.executeUpdate();
                            if (rowsAffected > 0) {
                                copyImageToPackage(selectedFile);
                                JOptionPane.showMessageDialog(this, "Owner added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                                populateTable();
                                clear();
                            } else {
                                JOptionPane.showMessageDialog(this, "Failed to add Owner.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Database error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_addOwnerActionPerformed

    private void removeOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeOwnerActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "No row is selected", "Select row", JOptionPane.ERROR_MESSAGE);
        } else {
            int employeeid = (int) model.getValueAt(row, 0);
            String pic = (String) model.getValueAt(row, 6);
            try {
                deletepic(pic);

                Connection con = DriverManager.getConnection(url, sqluser, sqlpass);
                String query = "DELETE FROM owners WHERE id = ?";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1, employeeid);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    clear();
                    model.removeRow(row);
                    deletepic(pic);
                    populateTable();
                    JOptionPane.showMessageDialog(this,
                            "Owner removed successfully.", null,
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Failed to remove Owner.", null,
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "An error has occurred.");
            }
        }
    }//GEN-LAST:event_removeOwnerActionPerformed

    private void updateOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateOwnerActionPerformed
        int row = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "No row is selected", "Select row", JOptionPane.ERROR_MESSAGE);
        } else {
            String fnameStr = fname.getText();
            String lnameStr = lname.getText();
            String contactStr = contact.getText();
            String emailStr = email.getText();
            String addressStr = address.getText();
            String id = model.getValueAt(row, 0).toString();

            if (fnameStr.isBlank() || lnameStr.isBlank() || contactStr.isBlank() || emailStr.isBlank() || addressStr.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please enter all fields.");
            } else {
                try {
                    int employeeid = Integer.parseInt(id);
                    if (picts != null) {
                        picts = selectedFile.getName();
                    }

                    Connection con = DriverManager.getConnection(url, sqluser, sqlpass);
                    String query = "UPDATE owners SET fname = ?, lname = ?, contact = ?, email = ?, address = ?, picture = ? WHERE id = ?";
                    PreparedStatement statement = con.prepareStatement(query);

                    statement.setString(1, fnameStr);
                    statement.setString(2, lnameStr);
                    statement.setString(3, contactStr);
                    statement.setString(4, emailStr);
                    statement.setString(5, addressStr);
                    statement.setString(6, picts);
                    statement.setInt(7, employeeid);

                    int rowsUpdated = statement.executeUpdate();
                    if (rowsUpdated > 0) {
                        copyImageToPackage(selectedFile);
                        populateTable();
                        clear();
                        JOptionPane.showMessageDialog(this, "Owner updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to update Owner.", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }

                    statement.close();
                    con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "An error has occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_updateOwnerActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        try {
            int row = table.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            fname.setText(model.getValueAt(row, 1).toString());
            lname.setText(model.getValueAt(row, 2).toString());
            contact.setText(model.getValueAt(row, 3).toString());
            email.setText(model.getValueAt(row, 4).toString());
            address.setText(model.getValueAt(row, 5).toString());
            String fileName = model.getValueAt(row, 6).toString();
            picts = fileName;
            URL imageURL = Dashboard.class.getResource("/owners/" + fileName);
            if (imageURL == null) {
                throw new IOException("Resource not found: " + fileName);
            }
            BufferedImage img = ImageIO.read(imageURL);
            ImageIcon imageIcon = new ImageIcon(scaleImage(img, 300, 300));

            imageLabel.setIcon(imageIcon);

            selectedFile = new File(imageURL.getPath());
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_tableMouseClicked

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        clear();
    }//GEN-LAST:event_clearbtnActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        String searchIDText = searchID.getText();
        try {
            int searchID = Integer.parseInt(searchIDText);
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            int rowCount = model.getRowCount();
            boolean found = false;
            for (int i = 0; i < rowCount; i++) {
                int id = (int) model.getValueAt(i, 0); // Assuming ID is in the first column (index 0)

                if (id == searchID) {
                    String fnameValue = model.getValueAt(i, 1).toString();
                    String lnameValue = model.getValueAt(i, 2).toString();
                    String contactValue = model.getValueAt(i, 3).toString();
                    String emailValue = model.getValueAt(i, 4).toString();
                    String addressValue = model.getValueAt(i, 5).toString();
                    String fileNameValue = model.getValueAt(i, 6).toString();

                    fname.setText(fnameValue);
                    lname.setText(lnameValue);
                    contact.setText(contactValue);
                    email.setText(emailValue);
                    address.setText(addressValue);

                    picts = fileNameValue;
                    URL imageURL = Dashboard.class.getResource("/owners/" + fileNameValue);
                    if (imageURL == null) {
                        throw new IOException("Resource not found: " + fileNameValue);
                    }
                    BufferedImage img = ImageIO.read(imageURL);
                    ImageIcon imageIcon = new ImageIcon(scaleImage(img, 300, 300));
                    imageLabel.setIcon(imageIcon);

                    selectedFile = new File(imageURL.getPath());

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
    private javax.swing.JButton addOwner;
    private javax.swing.JTextField address;
    private javax.swing.JLabel addresslabel;
    private javax.swing.JButton clearbtn;
    private javax.swing.JTextField contact;
    private javax.swing.JLabel contactlabel;
    private javax.swing.JTextField email;
    private javax.swing.JLabel emaillabel;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel fnamelabel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel imagepanel;
    private javax.swing.JPanel infopanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lname;
    private javax.swing.JLabel lnamelabel;
    private javax.swing.JButton removeOwner;
    private javax.swing.JTextField searchID;
    private javax.swing.JButton searchbtn;
    private javax.swing.JLabel searchlabel;
    private javax.swing.JButton selectimagebtn;
    private javax.swing.JTable table;
    private javax.swing.JButton updateOwner;
    // End of variables declaration//GEN-END:variables
}
