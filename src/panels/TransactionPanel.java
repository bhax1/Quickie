package panels;

import GUI.Session;
import com.toedter.calendar.JCalendar;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class TransactionPanel extends javax.swing.JPanel {

    String url = "jdbc:mariadb://localhost:3306/carrental";
    String sqluser = "root";
    String sqlpass = "12345";
    
    private Date borrowDate;
    private Date returnDate;
    
    public TransactionPanel(int carid, String brand, String model, int year, String fuelType, String color, BigDecimal price, byte[] image) throws IOException {
        initComponents();

        BufferedImage originalImage = getImageFromByteArray(image);
        ImageIcon imageIcon = new ImageIcon(resizeImage(originalImage, 300, 200));
        imageLabel.setIcon(imageIcon);
        lblbrand.setText("<html><b>Brand:</b> " + brand + "</html>");
        lblmodel.setText("<html><b>Model:</b> " + model + "</html>");
        lblfueltype.setText("<html><b>Fuel Type:</b> " + fuelType + "</html>");
        lblcolor.setText("<html><b>Color:</b> " + color + "</html>");
        lblyearmodel.setText("<html><b>Year Model:</b> " + year + "</html>");
        lblprice.setText("<html><b>Daily Price:</b> " + price.toString() + "</html>");
    }

    private static BufferedImage getImageFromByteArray(byte[] imageData) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
        return ImageIO.read(bis);
    }
    
    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        if (targetWidth <= 0 || targetHeight <= 0) {
            throw new IllegalArgumentException("Target width and height must be positive values.");
        }

        double aspectRatio = (double) width / height;

        if (width > targetWidth || height > targetHeight) {
            if (aspectRatio > 1) {
                width = targetWidth;
                height = (int) (width / aspectRatio);
            } else {
                height = targetHeight;
                width = (int) (height * aspectRatio);
            }
        } else {
            width = targetWidth;
            height = targetHeight;
        }

        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Resized image dimensions must be non-zero.");
        }

        Image tmp = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return resizedImage;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        imagepanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        lblbrand = new javax.swing.JLabel();
        lblmodel = new javax.swing.JLabel();
        lblfueltype = new javax.swing.JLabel();
        lblcolor = new javax.swing.JLabel();
        lblyearmodel = new javax.swing.JLabel();
        lblprice = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        borrowdate = new javax.swing.JButton();
        returndate = new javax.swing.JButton();
        lblreturn = new javax.swing.JLabel();
        lblborrow = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        fnamelbl = new javax.swing.JLabel();
        lnamelbl = new javax.swing.JLabel();
        contactlbl = new javax.swing.JLabel();
        emaillbl = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        proceedbtn = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        totalfeelbl = new javax.swing.JLabel();
        paymentlbl = new javax.swing.JLabel();
        lname1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1000, 260));
        setPreferredSize(new java.awt.Dimension(1000, 556));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 204, 255));

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

        lblbrand.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblbrand.setText("Brand");

        lblmodel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblmodel.setText("Model");

        lblfueltype.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblfueltype.setText("Fuel Type");

        lblcolor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcolor.setText("Color");

        lblyearmodel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblyearmodel.setText("Year Model");

        lblprice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblprice.setText("Price");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagepanel, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblbrand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblmodel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblfueltype, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblcolor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblyearmodel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblprice, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(imagepanel, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lblbrand)
                .addGap(18, 18, 18)
                .addComponent(lblmodel)
                .addGap(21, 21, 21)
                .addComponent(lblfueltype)
                .addGap(18, 18, 18)
                .addComponent(lblcolor)
                .addGap(18, 18, 18)
                .addComponent(lblyearmodel)
                .addGap(18, 18, 18)
                .addComponent(lblprice)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 560));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        borrowdate.setText("Borrow Date");
        borrowdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowdateActionPerformed(evt);
            }
        });

        returndate.setText("Return Date");
        returndate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returndateActionPerformed(evt);
            }
        });

        lblreturn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblreturn.setText("Return Date:");

        lblborrow.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblborrow.setText("Borrow Date:");

        fnamelbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fnamelbl.setText("Firstname");

        lnamelbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lnamelbl.setText("Lastname");

        contactlbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        contactlbl.setText("Contact No.");

        emaillbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        emaillbl.setText("Email");

        proceedbtn.setText("Proceed Transaction");
        proceedbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedbtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Client Details");

        totalfeelbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalfeelbl.setText("Total Fee");

        paymentlbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        paymentlbl.setText("Payment");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returndate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblreturn, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(borrowdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblborrow, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contactlbl)
                            .addComponent(fnamelbl)
                            .addComponent(lnamelbl)
                            .addComponent(emaillbl))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(proceedbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(paymentlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(totalfeelbl))
                                .addGap(18, 18, 18)
                                .addComponent(lname1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblborrow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(borrowdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblreturn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(returndate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(92, 92, 92)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fnamelbl))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnamelbl)
                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paymentlbl)
                    .addComponent(lname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactlbl)
                    .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalfeelbl))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emaillbl)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(proceedbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 640, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void borrowdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowdateActionPerformed
        // Display JCalendar for Borrow Date
        JCalendar calendar = new JCalendar();
        JOptionPane.showMessageDialog(this, calendar, "Choose Borrow Date", JOptionPane.PLAIN_MESSAGE);

        // Get selected date
        Date selectedDate = calendar.getDate();

        // Format the date to "Thu May 16 2024" format
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");
        String formattedDate = dateFormat.format(selectedDate);
        
        // Update label with formatted date
        lblborrow.setText("Borrow Date: " + formattedDate);
    }//GEN-LAST:event_borrowdateActionPerformed

    private void returndateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returndateActionPerformed
        JCalendar calendar = new JCalendar();
        JOptionPane.showMessageDialog(this, calendar, "Choose Return Date", JOptionPane.PLAIN_MESSAGE);

        Date selectedDate = calendar.getDate();

        if (borrowDate != null && !selectedDate.before(borrowDate) && !selectedDate.equals(borrowDate)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");
            String formattedDate = dateFormat.format(selectedDate);

            lblreturn.setText("Return Date: " + formattedDate);
        } else {
            JOptionPane.showMessageDialog(this, "Return date must be later than borrow date and not the same as borrow date.", "Invalid Return Date", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_returndateActionPerformed

    private void proceedbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedbtnActionPerformed
         String fnamestr = fnamelbl.getText();
         String lnamestr = lnamelbl.getText();
         String contactstr = contactlbl.getName();
         String emailstr = emaillbl.getText();
         
         if (fnamestr.isEmpty() || lnamestr.isEmpty() || contactstr.isEmpty() || emailstr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill out all required fields.", "Incomplete Information", JOptionPane.WARNING_MESSAGE);
        } else if (borrowDate == null || returnDate == null) {
            JOptionPane.showMessageDialog(this, "Please select both Borrow and Return dates.", "Date Selection Required", JOptionPane.WARNING_MESSAGE);
        } else {
            try (Connection con = DriverManager.getConnection(url, sqluser, sqlpass)) {
                int loggedInEmployeeId = Session.getLoggedInEmployeeId();
                String checkQuery = "SELECT INTO clients WHERE contact = ? AND email = ?";
                
                if () {
                    
                } else {
                    // Client id is auto incremented and also a primary key
                    String insertQueryClient = "INSERT INTO clients (fname, lname, contact, email) VALUES (?, ?, ?, ?)";
                    PreparedStatement ps = con.prepareStatement(insertQueryClient);
                    ps.setString(1, fnamestr);
                    ps.setString(2, lnamestr);
                    ps.setString(3, contactstr);
                    ps.setString(4, emailstr);
                    
                    if () {
                        
                    } else {
                        String insertQueryTransactions = "INSERT INTO transactions (carid, clientid, employeeid, borrow_date, return_date, total_fee, pay, transac_date ) VALUES (?, ?, ?, ?)";
                    }
                }
                
            } catch (Exception e) {
                
            }
        }
    }//GEN-LAST:event_proceedbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrowdate;
    private javax.swing.JTextField contact;
    private javax.swing.JLabel contactlbl;
    private javax.swing.JTextField email;
    private javax.swing.JLabel emaillbl;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel fnamelbl;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel imagepanel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblborrow;
    private javax.swing.JLabel lblbrand;
    private javax.swing.JLabel lblcolor;
    private javax.swing.JLabel lblfueltype;
    private javax.swing.JLabel lblmodel;
    private javax.swing.JLabel lblprice;
    private javax.swing.JLabel lblreturn;
    private javax.swing.JLabel lblyearmodel;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField lname1;
    private javax.swing.JLabel lnamelbl;
    private javax.swing.JLabel paymentlbl;
    private javax.swing.JToggleButton proceedbtn;
    private javax.swing.JButton returndate;
    private javax.swing.JLabel totalfeelbl;
    // End of variables declaration//GEN-END:variables
}
