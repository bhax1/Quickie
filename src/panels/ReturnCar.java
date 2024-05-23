package panels;

import GUI.Session;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.text.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ReturnCar extends javax.swing.JPanel {

    String url = "jdbc:mariadb://localhost:3306/carrental";
    String sqluser = "root";
    String sqlpass = "";
    
    boolean transactIDFound = false;
    
    String employeeFname = null;
    String employeeLname = null;
    String clientFname = null;
    String clientLname = null;
    int carID = 0;
    int penalty = 0;
    int paymentInt = 0;
    
    public ReturnCar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        receipt = new javax.swing.JFrame();
        jScrollPane4 = new javax.swing.JScrollPane();
        textarea1 = new javax.swing.JTextArea();
        printreceipt = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        lblbrand2 = new javax.swing.JLabel();
        transactIDText = new javax.swing.JTextField();
        findtransactID = new javax.swing.JButton();
        returncar = new javax.swing.JButton();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        lblbrand1 = new javax.swing.JLabel();
        lblclient = new javax.swing.JLabel();
        lblemployee = new javax.swing.JLabel();
        lblcar = new javax.swing.JLabel();
        lblborrow = new javax.swing.JLabel();
        lblreturn = new javax.swing.JLabel();
        lbltransact = new javax.swing.JLabel();
        lblfee = new javax.swing.JLabel();
        lblpay = new javax.swing.JLabel();
        lblprice1 = new javax.swing.JLabel();
        lblprice2 = new javax.swing.JLabel();
        paymenttext = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        penaltytext = new javax.swing.JLabel();

        receipt.setBackground(new java.awt.Color(204, 204, 255));
        receipt.setResizable(false);
        receipt.setSize(new java.awt.Dimension(350, 500));
        receipt.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textarea1.setEditable(false);
        textarea1.setBackground(new java.awt.Color(255, 255, 255));
        textarea1.setColumns(20);
        textarea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textarea1.setRows(5);
        textarea1.setText("                   RETURN RECEIPT SLIP\n-----------------------------------------------\nClient Name:\nEmployee\n\nDate: \nTime: \n\nItems:\n- Car Rental:\n- Total:\n\nPayment Details:\n- Amount Paid: \n\n-----------------------------------------------\n                       Quickie Car Rental\n              Thank you for your business!");
        jScrollPane4.setViewportView(textarea1);

        receipt.getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 14, 299, 369));

        printreceipt.setText("Print");
        printreceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printreceiptActionPerformed(evt);
            }
        });
        receipt.getContentPane().add(printreceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 401, 120, 36));

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 204, 255));

        lblbrand2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblbrand2.setText("Enter Transaction ID:");

        findtransactID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        findtransactID.setText("Find Transaction ID");
        findtransactID.setFocusPainted(false);
        findtransactID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findtransactIDActionPerformed(evt);
            }
        });

        returncar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        returncar.setText("Return Car");
        returncar.setFocusPainted(false);
        returncar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returncarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(lblbrand2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(transactIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(returncar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(findtransactID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblbrand2)
                    .addComponent(transactIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(findtransactID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(returncar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 360, 340));

        kGradientPanel2.setkEndColor(new java.awt.Color(255, 204, 255));
        kGradientPanel2.setkGradientFocus(200);
        kGradientPanel2.setkStartColor(new java.awt.Color(204, 204, 255));

        lblbrand1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblbrand1.setText("Transaction Details");

        lblclient.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblclient.setText("Client:");

        lblemployee.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblemployee.setText("Employee ID:");

        lblcar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcar.setText("Car ID:");

        lblborrow.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblborrow.setText("Borrow Date:");

        lblreturn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblreturn.setText("Return Date:");

        lbltransact.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbltransact.setText("Transaction Date:");

        lblfee.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblfee.setText("Total Fee:");

        lblpay.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblpay.setText("Paid:");

        lblprice1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblprice1.setText("Penalty Fee (Late Per Hour ₱100):");

        lblprice2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblprice2.setText("Payment:");

        paymenttext.setText("0");
        paymenttext.setFocusable(false);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        penaltytext.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        penaltytext.setText("0.00");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(lblbrand1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblprice2)
                                    .addComponent(lblprice1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(paymenttext, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(penaltytext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel2Layout.createSequentialGroup()
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblpay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblfee, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblemployee, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                    .addComponent(lblcar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblclient, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblreturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbltransact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblborrow, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(25, 25, 25))))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblbrand1)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblclient)
                    .addComponent(lblborrow))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblemployee)
                    .addComponent(lblreturn))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcar)
                    .addComponent(lbltransact))
                .addGap(18, 18, 18)
                .addComponent(lblfee)
                .addGap(18, 18, 18)
                .addComponent(lblpay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprice1)
                    .addComponent(penaltytext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprice2)
                    .addComponent(paymenttext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 580, 340));
    }// </editor-fold>//GEN-END:initComponents

    private void findtransactIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findtransactIDActionPerformed
        String transactID = transactIDText.getText();
        if (transactID.isBlank()) {
            transactIDText.setText("");
        } else {
            try {
                int transactionId = Integer.parseInt(transactID);
                try (Connection connection = DriverManager.getConnection(url, sqluser, sqlpass)) {
                    String sql = "SELECT t.*, c.fname AS client_fname, c.lname AS client_lname, e.fname AS employee_fname, e.lname AS employee_lname " +
                                 "FROM transactions t " +
                                 "LEFT JOIN clients c ON t.client_id = c.id " +
                                 "LEFT JOIN employees e ON t.employee_id = e.id " +
                                 "WHERE t.id = ?";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setInt(1, transactionId);
                        try (ResultSet resultSet = statement.executeQuery()) {
                            if (resultSet.next()) {
                                carID = resultSet.getInt("car_id");
                                String carId = String.valueOf(carID);
                                String borrowDate = resultSet.getString("borrow_date");
                                String returnDate = resultSet.getString("return_date");
                                BigDecimal totalFee = resultSet.getBigDecimal("total_fee");
                                BigDecimal payment = resultSet.getBigDecimal("pay");
                                String transactDate = resultSet.getString("transact_date");
                                String status = resultSet.getString("status");
                                clientFname = resultSet.getString("client_fname");
                                clientLname = resultSet.getString("client_lname");
                                employeeFname = resultSet.getString("employee_fname");
                                employeeLname = resultSet.getString("employee_lname");

                                if (!status.equals("BORROWED")) {
                                    JOptionPane.showMessageDialog(null, "This transaction is already completed.", "Status Mismatch", JOptionPane.WARNING_MESSAGE);
                                    return;
                                }

                                lblcar.setText("Car ID: " + carId);
                                lblclient.setText("Client: " + clientFname + " " + clientLname);
                                lblemployee.setText("Employee: " + employeeFname + " " + employeeLname);
                                lblborrow.setText("Borrow Date: " + borrowDate);
                                lblreturn.setText("Return Date: " + returnDate);
                                lblfee.setText("Total Fee: " + totalFee.toString());
                                lblpay.setText("Paid: " + payment.toString());
                                lbltransact.setText("Transaction Date: " + transactDate);

                                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                Date expectedReturn = format.parse(returnDate);
                                Date actualReturn = new Date();
                                if (actualReturn.after(expectedReturn)) {
                                    long diffInMillies = actualReturn.getTime() - expectedReturn.getTime();
                                    long diffInHours = TimeUnit.MILLISECONDS.toHours(diffInMillies);
                                    BigDecimal penalty = BigDecimal.valueOf(diffInHours * 100);
                                    penaltytext.setText(penalty.toString());

                                    if (penalty.compareTo(BigDecimal.ZERO) > 0) {
                                        paymenttext.setEditable(true);
                                    } else {
                                        paymenttext.setEditable(false);
                                    }
                                } else {
                                    penaltytext.setText("0");
                                    paymenttext.setEditable(false);
                                }

                                transactIDFound = true;
                            } else {
                                JOptionPane.showMessageDialog(null, "Transaction ID not found.", "Not Found", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    }
                } catch (SQLException | ParseException e) {
                    JOptionPane.showMessageDialog(null, "An error occurred while processing the transaction.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Transaction ID format.", "Format Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_findtransactIDActionPerformed

    private void returncarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returncarActionPerformed
        boolean proceed = false;
        String payment = paymenttext.getText();
        String transactID = transactIDText.getText();

        System.out.println(penaltytext.getText());

        try {
            penalty = Integer.parseInt(penaltytext.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid penalty amount.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!transactIDFound) {
            JOptionPane.showMessageDialog(null, "No transaction has been selected.", "Empty", JOptionPane.WARNING_MESSAGE);
        } else {       
            try {
                paymentInt = Integer.parseInt(payment);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid payment amount.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (penalty != 0 && paymentInt >= penalty) {
                proceed = true;
            } else if (penalty == 0 && paymentInt == 0) {
                proceed = true;
            }

            if (proceed) {
                try (Connection con = DriverManager.getConnection(url, sqluser, sqlpass)) {
                    con.setAutoCommit(false);

                    String checkQuery = "SELECT COUNT(*) FROM return_transactions WHERE transact_id = ?";
                    try (PreparedStatement checkPs = con.prepareStatement(checkQuery)) {
                        checkPs.setInt(1, Integer.parseInt(transactID));
                        ResultSet rs = checkPs.executeQuery();
                        if (rs.next() && rs.getInt(1) > 0) {
                            JOptionPane.showMessageDialog(this, "This transaction has already been processed.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy hh:mm a");
                    String formattedDate = dateFormat.format(new Date());

                    String receiptContent = "RETURN RECEIPT SLIP\n" +
                        "-----------------------------------------------\n" +
                        "Client Name: " + clientFname + " " + clientLname + "\n" +
                        "Employee: " + Session.getLoggedInEmployeeName() + "\n\n" +
                        "Date: " + formattedDate + "\n\n" +
                        "Items:\n" +
                        "- Car ID: " + carID + "\n" +
                        "- Total Penalty: " + penalty + "\n\n" +
                        "Payment Details:\n" +
                        "- Amount Paid: " + payment + "\n\n" +
                        "-----------------------------------------------\n" +
                        "                       Quickie Car Rental\n" +
                        "              Thank you for your business!";

                    textarea1.setText(receiptContent);
                    receipt.setLocationRelativeTo(null);
                    receipt.setVisible(true);
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Payment does not cover the penalty.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_returncarActionPerformed

    private void printreceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printreceiptActionPerformed
        int loggedInEmployeeId = Session.getLoggedInEmployeeId();
        String transactID = transactIDText.getText();
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, sqluser, sqlpass);
            con.setAutoCommit(false);

            String insertQuery = "INSERT INTO return_transactions (employeeid, transact_id, excess_fee, pay, transact_date) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, loggedInEmployeeId);
                ps.setInt(2, Integer.parseInt(transactID));
                ps.setBigDecimal(3, new BigDecimal(penalty));
                ps.setBigDecimal(4, new BigDecimal(paymentInt));
                ps.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));

                int rowsInserted = ps.executeUpdate();
                if (rowsInserted > 0) {
                    ResultSet generatedKeys = ps.getGeneratedKeys();
                    int returntransactionId = 0;
                    if (generatedKeys.next()) {
                        returntransactionId = generatedKeys.getInt(1);
                    }

                    // Prepare the update query for transactions
                    String updateQuery = "UPDATE transactions SET status = ? WHERE id = ?";
                    try (PreparedStatement pss = con.prepareStatement(updateQuery)) {
                        pss.setString(1, "RETURNED");
                        pss.setInt(2, Integer.parseInt(transactID));
                        int rowsUpdated = pss.executeUpdate();
                        if (rowsUpdated > 0) {
                            JOptionPane.showMessageDialog(this, "Car returned successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "Failed to update transaction.", "Error", JOptionPane.ERROR_MESSAGE);
                            con.rollback();
                            return;
                        }
                    }

                    SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy hh:mm a");
                    String formattedDate = dateFormat.format(new Date());
                    
                    // Generate receipt contents
                    String receiptContents = "                   RETURN RECEIPT SLIP\n" +
                        "-----------------------------------------------\n" +
                        "Return Transaction ID: " + returntransactionId + "\n" +
                        "Client Name: " + clientFname + " " + clientLname + "\n" +
                        "Employee: " + Session.getLoggedInEmployeeName() + "\n\n" +
                        "Date: " + formattedDate + "\n\n" +
                        "Items:\n" +
                        "- Car ID: " + carID + "\n" +
                        "- Total Penalty: " + penalty + "\n\n" +
                        "Payment Details:\n" +
                        "- Amount Paid: " + paymentInt + "\n\n" +
                        "-----------------------------------------------\n" +
                        "                       Quickie Car Rental\n" +
                        "              Thank you for your business!";

                    textarea1.setText(receiptContents);

                    // Create and save the receipt as an image
                    BufferedImage image = new BufferedImage(textarea1.getWidth(), textarea1.getHeight(), BufferedImage.TYPE_INT_RGB);
                    Graphics2D g2d = image.createGraphics();
                    textarea1.printAll(g2d);
                    g2d.dispose();

                    String fileName = "returntransactionID=" + returntransactionId + ".png";
                    String filePath = System.getProperty("user.home") + "/Downloads/" + fileName;
                    File output = new File(filePath);
                    ImageIO.write(image, "png", output);

                    receipt.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Transaction Completed", "Success", JOptionPane.INFORMATION_MESSAGE);

                    con.commit();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to insert return transaction.", "Error", JOptionPane.ERROR_MESSAGE);
                    con.rollback();
                }
            }
        } catch (SQLException | IOException ex) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException e) {
                    Logger.getLogger(ReturnCar.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            Logger.getLogger(ReturnCar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printreceiptActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton findtransactID;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lblborrow;
    private javax.swing.JLabel lblbrand1;
    private javax.swing.JLabel lblbrand2;
    private javax.swing.JLabel lblcar;
    private javax.swing.JLabel lblclient;
    private javax.swing.JLabel lblemployee;
    private javax.swing.JLabel lblfee;
    private javax.swing.JLabel lblpay;
    private javax.swing.JLabel lblprice1;
    private javax.swing.JLabel lblprice2;
    private javax.swing.JLabel lblreturn;
    private javax.swing.JLabel lbltransact;
    private javax.swing.JTextField paymenttext;
    private javax.swing.JLabel penaltytext;
    private javax.swing.JButton printreceipt;
    private javax.swing.JFrame receipt;
    private javax.swing.JButton returncar;
    private javax.swing.JTextArea textarea1;
    private javax.swing.JTextField transactIDText;
    // End of variables declaration//GEN-END:variables
}
