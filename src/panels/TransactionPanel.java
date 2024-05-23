package panels;

import GUI.Dashboard;
import GUI.Session;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class TransactionPanel extends javax.swing.JPanel {

    private final String url = "jdbc:mariadb://localhost:3306/carrental";
    private final String sqluser = "root";
    private final String sqlpass = "";
    
    private Date borrowDate;
    private Date returnDate;
    private final int carID;
    private final BigDecimal pricing;
    private BigDecimal totalFee;

    public TransactionPanel(int carid, String brand, String model, int year, String fuelType, String color, BigDecimal price, byte[] image) throws IOException {
        initComponents();
        carID = carid;
        pricing = price;
        BufferedImage originalImage = getImageFromByteArray(image);
        ImageIcon imageIcon = new ImageIcon(resizeImage(originalImage, 300, 200));
        imageLabel.setIcon(imageIcon);
        lblbrand.setText(String.format("<html><b>Brand:</b> %s</html>", brand));
        lblmodel.setText(String.format("<html><b>Model:</b> %s</html>", model));
        lblfueltype.setText(String.format("<html><b>Fuel Type:</b> %s</html>", fuelType));
        lblcolor.setText(String.format("<html><b>Color:</b> %s</html>", color));
        lblyearmodel.setText(String.format("<html><b>Year Model:</b> %d</html>", year));
        lblprice.setText(String.format("<html><b>Daily Price:</b> %s</html>", price.toString()));
        fetchData(carID);
    }
    
    private void fetchData(int carId) {
        try (Connection connection = DriverManager.getConnection(url, sqluser, sqlpass)) {
            String query = "SELECT borrow_date, return_date FROM transactions WHERE month(borrow_date) = ? AND year(borrow_date) = ? AND car_id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, monthChooser.getMonth() + 1);
            statement.setInt(2, yearChooser.getYear());
            statement.setInt(3, carId);

            ResultSet resultSet = statement.executeQuery();

            StringBuilder resultText = new StringBuilder();
            while (resultSet.next()) {
                String borrowDates = resultSet.getString("borrow_date");
                String returnDates = resultSet.getString("return_date");
                resultText.append("Borrow Date: ").append(borrowDates).append(", Return Date: ").append(returnDates).append("\n");
            }

            textArea.setText(resultText.toString());

        } catch (SQLException e) {
            
        }
    }


    private static BufferedImage getImageFromByteArray(byte[] imageData) throws IOException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(imageData)) {
            return ImageIO.read(bis);
        }
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
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

        receipt = new javax.swing.JFrame();
        jScrollPane4 = new javax.swing.JScrollPane();
        textarea1 = new javax.swing.JTextArea();
        printreceipt = new javax.swing.JButton();
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
        borrowandreturn = new javax.swing.JButton();
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
        clientdetails = new javax.swing.JLabel();
        lbltotalfee = new javax.swing.JLabel();
        paymentlbl = new javax.swing.JLabel();
        payment = new javax.swing.JTextField();
        monthChooser = new com.toedter.calendar.JMonthChooser();
        yearChooser = new com.toedter.calendar.JYearChooser();
        lblborrow1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        receipt.setBackground(new java.awt.Color(204, 204, 255));
        receipt.setResizable(false);
        receipt.setSize(new java.awt.Dimension(350, 500));
        receipt.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textarea1.setEditable(false);
        textarea1.setBackground(new java.awt.Color(255, 255, 255));
        textarea1.setColumns(20);
        textarea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textarea1.setRows(5);
        textarea1.setText("\tRECEIPT SLIP\n-----------------------------------------------\nClient Name:\nEmployee\n\nDate: \nTime: \n\nItems:\n- Car Rental:\n- Total:\n\nPayment Details:\n- Amount Paid: \n\n-----------------------------------------------\n                       Quickie Car Rental\n              Thank you for your business!");
        jScrollPane4.setViewportView(textarea1);

        receipt.getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 14, 299, 369));

        printreceipt.setText("Print");
        receipt.getContentPane().add(printreceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 401, 120, 36));

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1000, 260));
        setPreferredSize(new java.awt.Dimension(1000, 556));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 204, 255));

        imagepanel.setBackground(new java.awt.Color(255, 255, 255));
        imagepanel.setPreferredSize(new java.awt.Dimension(300, 200));

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout imagepanelLayout = new javax.swing.GroupLayout(imagepanel);
        imagepanel.setLayout(imagepanelLayout);
        imagepanelLayout.setHorizontalGroup(
            imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addContainerGap())
        );
        imagepanelLayout.setVerticalGroup(
            imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
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

        borrowandreturn.setText("Borrow & Return Date");
        borrowandreturn.setFocusPainted(false);
        borrowandreturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowandreturnActionPerformed(evt);
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
        proceedbtn.setFocusPainted(false);
        proceedbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedbtnActionPerformed(evt);
            }
        });

        clientdetails.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clientdetails.setText("Client Details");

        lbltotalfee.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbltotalfee.setText("Total Fee:");

        paymentlbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        paymentlbl.setText("Payment");

        monthChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                monthChooserPropertyChange(evt);
            }
        });

        yearChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                yearChooserPropertyChange(evt);
            }
        });

        lblborrow1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblborrow1.setText("Unavailable Booking Dates");

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane2.setViewportView(textArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(clientdetails, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(294, 294, 294))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contactlbl)
                            .addComponent(fnamelbl)
                            .addComponent(lnamelbl)
                            .addComponent(emaillbl))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(proceedbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(paymentlbl, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbltotalfee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblborrow, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblreturn, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(borrowandreturn, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(monthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(yearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblborrow1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(lblborrow)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblborrow1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(yearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblreturn)
                        .addGap(18, 18, 18)
                        .addComponent(borrowandreturn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(clientdetails)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fnamelbl))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lnamelbl)
                                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(paymentlbl)
                                    .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addComponent(lbltotalfee)))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contactlbl)
                            .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emaillbl)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(proceedbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addGap(75, 75, 75))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 640, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void borrowandreturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowandreturnActionPerformed
        Calendar calendar = new GregorianCalendar();
        SpinnerModel spinnerModel = new SpinnerDateModel(calendar.getTime(), null, null, Calendar.HOUR_OF_DAY);
        JSpinner spinner = new JSpinner(spinnerModel);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "MMM dd yyyy hh:mm a");
        spinner.setEditor(editor);

        int option1 = JOptionPane.showOptionDialog(this, spinner, "Choose Borrow Date and Time", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

        if (option1 == JOptionPane.OK_OPTION) {
            borrowDate = (Date) spinner.getValue();
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("MMM dd yyyy hh:mm a");
            String formattedDate1 = dateFormat1.format(borrowDate);

            Calendar borrowCalendar = Calendar.getInstance();
            borrowCalendar.setTime(borrowDate);
            borrowCalendar.add(Calendar.MINUTE, -30);
            borrowDate = borrowCalendar.getTime();

            if (borrowDate.before(calendar.getTime())) {
                JOptionPane.showMessageDialog(this, "Borrow date should be later than current time. At least an hour.", "Invalid Borrow Date", JOptionPane.ERROR_MESSAGE);
            } else {
                lblborrow.setText("Borrow Date: " + formattedDate1);

                Calendar returnCalendar = Calendar.getInstance();
                returnCalendar.setTime(borrowDate);
                returnCalendar.add(Calendar.DAY_OF_YEAR, 2);

                SpinnerModel returnSpinnerModel = new SpinnerDateModel(returnCalendar.getTime(), null, null, Calendar.HOUR_OF_DAY);
                JSpinner returnSpinner = new JSpinner(returnSpinnerModel);
                JSpinner.DateEditor returnEditor = new JSpinner.DateEditor(returnSpinner, "MMM dd yyyy hh:mm a");
                returnSpinner.setEditor(returnEditor);

                int option2 = JOptionPane.showOptionDialog(this, returnSpinner, "Choose Return Date and Time", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (option2 == JOptionPane.OK_OPTION) {
                    returnDate = (Date) returnSpinner.getValue();
                    SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMM dd yyyy hh:mm a");
                    String formattedDate2 = dateFormat2.format(returnDate);

                    if (returnDate.before(borrowDate) || returnDate.equals(borrowDate)) {
                        JOptionPane.showMessageDialog(this, "Return date should be later than borrow date and not the same.", "Invalid Return Date", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (checkExistingBookings(borrowDate, returnDate)) {
                            JOptionPane.showMessageDialog(this, "Chosen date is already booked.", "Booking Conflict", JOptionPane.ERROR_MESSAGE);
                        } else {
                            lblreturn.setText("Return Date: " + formattedDate2);
                            updateTotalFee();
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_borrowandreturnActionPerformed
  
    private boolean checkExistingBookings(Date borrowDate, Date returnDate) {
        try (Connection connection = DriverManager.getConnection(url, sqluser, sqlpass)) {
            String query = "SELECT COUNT(*) FROM transactions WHERE car_id = ? AND ((borrow_date <= ? AND return_date >= ?) OR (borrow_date <= ? AND return_date >= ?))";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, carID);
            statement.setTimestamp(2, new Timestamp(borrowDate.getTime()));
            statement.setTimestamp(3, new Timestamp(returnDate.getTime()));
            statement.setTimestamp(4, new Timestamp(borrowDate.getTime()));
            statement.setTimestamp(5, new Timestamp(returnDate.getTime()));

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
        }
        return false;
    }
    
    private void updateTotalFee() {
        if (borrowDate != null && returnDate != null) {
            long durationMillis = returnDate.getTime() - borrowDate.getTime();
            long durationDays = TimeUnit.MILLISECONDS.toDays(durationMillis);

            totalFee = pricing.multiply(BigDecimal.valueOf(durationDays));
            lbltotalfee.setText("Total Fee: " + totalFee.toString());
        }
    }
    
    private void proceedbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedbtnActionPerformed
        String fnamestr = fname.getText();
        String lnamestr = lname.getText();
        String contactstr = contact.getText();
        String emailstr = email.getText();
        String paymentText = payment.getText();

        try {
            int payInt = Integer.parseInt(paymentText);
            BigDecimal payAmount = new BigDecimal(payInt);

            if (fnamestr.isEmpty() || lnamestr.isEmpty() || contactstr.isEmpty() || emailstr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill out all required fields.", "Incomplete Information", JOptionPane.WARNING_MESSAGE);
            } else if (borrowDate == null || returnDate == null) {
                JOptionPane.showMessageDialog(this, "Please select both Borrow and Return dates.", "Date Selection Required", JOptionPane.WARNING_MESSAGE);
            } else if (payAmount.compareTo(totalFee) < 0) {
                JOptionPane.showMessageDialog(this, "Payment amount is less than the total fee.", "Insufficient Payment", JOptionPane.ERROR_MESSAGE);
            } else {
                int option = JOptionPane.showOptionDialog(this,
                        "Transaction Details:\n" +
                        "First Name: " + fnamestr + "\n" +
                        "Last Name: " + lnamestr + "\n" +
                        "Contact: " + contactstr + "\n" +
                        "Email: " + emailstr + "\n" +
                        "Payment: " + paymentText + "\n" +
                        "\nProceed with the transaction?",
                        "Transaction Confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new String[]{"Proceed", "Cancel"},
                        "Proceed");

                if (option == JOptionPane.NO_OPTION) {
                    return;
                }
 
                SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy hh:mm a");
                String formattedDate = dateFormat.format(new Date());
                
                String receiptContent = "\tRECEIPT SLIP\n" +
                        "-----------------------------------------------\n" +
                        "Client Name: " + fnamestr + " " + lnamestr + "\n" +
                        "Employee: " + Session.getLoggedInEmployeeName() + "\n\n" +
                        "Date: " + formattedDate + "\n\n" +
                        "Items:\n" +
                        "- Car ID: " + carID + "\n" +
                        "- Total: " + totalFee + "\n\n" +
                        "Payment Details:\n" +
                        "- Amount Paid: " + paymentText + "\n\n" +
                        "-----------------------------------------------\n" +
                        "                       Quickie Car Rental\n" +
                        "              Thank you for your business!";

                textarea1.setText(receiptContent);
                receipt.setLocationRelativeTo(null);
                receipt.setVisible(true);

                printreceipt.addActionListener((ActionEvent e) -> {
                    int clientId = 0;
                    try (Connection con = DriverManager.getConnection(url, sqluser, sqlpass)) {
                        con.setAutoCommit(false);

                        int loggedInEmployeeId = Session.getLoggedInEmployeeId();

                        String checkClientQuery = "SELECT id FROM clients WHERE contact = ? OR email = ?";
                        try (PreparedStatement psCheckClient = con.prepareStatement(checkClientQuery)) {
                            psCheckClient.setString(1, contactstr);
                            psCheckClient.setString(2, emailstr);
                            try (ResultSet rs = psCheckClient.executeQuery()) {
                                if (rs.next()) {
                                    clientId = rs.getInt("id");
                                } else {
                                    String insertClientQuery = "INSERT INTO clients (fname, lname, contact, email) VALUES (?, ?, ?, ?)";
                                    try (PreparedStatement psInsertClient = con.prepareStatement(insertClientQuery, Statement.RETURN_GENERATED_KEYS)) {
                                        psInsertClient.setString(1, fnamestr);
                                        psInsertClient.setString(2, lnamestr);
                                        psInsertClient.setString(3, contactstr);
                                        psInsertClient.setString(4, emailstr);
                                        int rowsAffected = psInsertClient.executeUpdate();
                                        if (rowsAffected == 0) {
                                            throw new SQLException("Inserting client failed, no rows affected.");
                                        }
                                        try (ResultSet generatedKeys = psInsertClient.getGeneratedKeys()) {
                                            if (generatedKeys.next()) {
                                                clientId = generatedKeys.getInt(1);
                                            } else {
                                                throw new SQLException("Failed to obtain client ID.");
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        String checkActiveBookingQuery = "SELECT * FROM transactions WHERE client_id = ? AND return_date > NOW()";
                        try (PreparedStatement psCheckActiveBooking = con.prepareStatement(checkActiveBookingQuery)) {
                            psCheckActiveBooking.setInt(1, clientId);
                            try (ResultSet rs = psCheckActiveBooking.executeQuery()) {
                                if (rs.next()) {
                                    JOptionPane.showMessageDialog(this, "Client already has an active booking.", "Booking Error", JOptionPane.ERROR_MESSAGE);
                                    receipt.setVisible(false);
                                    return;
                                }
                            }
                        }

                        String insertTransactionQuery = "INSERT INTO transactions (car_id, client_id, employee_id, borrow_date, return_date, total_fee, pay, transact_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                        try (PreparedStatement psInsertTransaction = con.prepareStatement(insertTransactionQuery, Statement.RETURN_GENERATED_KEYS)) {
                            psInsertTransaction.setInt(1, carID);
                            psInsertTransaction.setInt(2, clientId);
                            psInsertTransaction.setInt(3, loggedInEmployeeId);
                            psInsertTransaction.setTimestamp(4, new java.sql.Timestamp(borrowDate.getTime()));
                            psInsertTransaction.setTimestamp(5, new java.sql.Timestamp(returnDate.getTime()));
                            psInsertTransaction.setBigDecimal(6, totalFee);
                            psInsertTransaction.setBigDecimal(7, payAmount);
                            psInsertTransaction.setTimestamp(8, new java.sql.Timestamp(System.currentTimeMillis()));

                            int affectedRows = psInsertTransaction.executeUpdate();
                            if (affectedRows == 0) {
                                throw new SQLException("Creating transaction failed, no rows affected.");
                            }

                            try (ResultSet generatedKeys = psInsertTransaction.getGeneratedKeys()) {
                                if (generatedKeys.next()) {
                                    int transactionId = generatedKeys.getInt(1);
                                    
                                    String receiptContents = "\tRECEIPT SLIP\n" +
                                            "-----------------------------------------------\n" +
                                            "Transaction ID: " +transactionId+ "\n" +
                                            "Client Name: " + fnamestr + " " + lnamestr + "\n" +
                                            "Employee: " + Session.getLoggedInEmployeeName() + "\n\n" +
                                            "Date: " + formattedDate + "\n\n" +
                                            "Items:\n" +
                                            "- Car ID: " + carID + "\n" +
                                            "- Total: " + totalFee + "\n\n" +
                                            "Payment Details:\n" +
                                            "- Amount Paid: " + paymentText + "\n\n" +
                                            "-----------------------------------------------\n" +
                                            "                       Quickie Car Rental\n" +
                                            "              Thank you for your business!";

                                    textarea1.setText(receiptContents);

                                    BufferedImage image = new BufferedImage(textarea1.getWidth(), textarea1.getHeight(), BufferedImage.TYPE_INT_RGB);

                                    Graphics2D g2d = image.createGraphics();
                                    textarea1.printAll(g2d);
                                    g2d.dispose();

                                    String fileName = "transactionID=" + transactionId + ".png";
                                    String filePath = System.getProperty("user.home") + "/Downloads/" + fileName;
                                    File output = new File(filePath);
                                    ImageIO.write(image, "png", output);

                                    receipt.setVisible(false);
                                    JOptionPane.showMessageDialog(null, "Transaction Completed", "Success", JOptionPane.INFORMATION_MESSAGE);

                                    con.commit();
                                } else {
                                    throw new SQLException("Creating transaction failed, no ID obtained.");
                                }
                            }
                        }

                    } catch (SQLException es) {
                        JOptionPane.showMessageDialog(null, "Transaction failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(TransactionPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    receipt.setVisible(false);

                    Dashboard dashboard = (Dashboard) SwingUtilities.getWindowAncestor(this);
                    if (dashboard != null) {
                        dashboard.getTabbedPane().removeAll();

                        RentCar rent = new RentCar();
                        dashboard.getTabbedPane().add("", rent);
                        dashboard.getTabbedPane().setSelectedComponent(rent);
                    }
                });
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for payment.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_proceedbtnActionPerformed

    private void monthChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_monthChooserPropertyChange
        fetchData(carID);
    }//GEN-LAST:event_monthChooserPropertyChange

    private void yearChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_yearChooserPropertyChange
        fetchData(carID);
    }//GEN-LAST:event_yearChooserPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrowandreturn;
    private javax.swing.JLabel clientdetails;
    private javax.swing.JTextField contact;
    private javax.swing.JLabel contactlbl;
    private javax.swing.JTextField email;
    private javax.swing.JLabel emaillbl;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel fnamelbl;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel imagepanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblborrow;
    private javax.swing.JLabel lblborrow1;
    private javax.swing.JLabel lblbrand;
    private javax.swing.JLabel lblcolor;
    private javax.swing.JLabel lblfueltype;
    private javax.swing.JLabel lblmodel;
    private javax.swing.JLabel lblprice;
    private javax.swing.JLabel lblreturn;
    private javax.swing.JLabel lbltotalfee;
    private javax.swing.JLabel lblyearmodel;
    private javax.swing.JTextField lname;
    private javax.swing.JLabel lnamelbl;
    private com.toedter.calendar.JMonthChooser monthChooser;
    private javax.swing.JTextField payment;
    private javax.swing.JLabel paymentlbl;
    private javax.swing.JButton printreceipt;
    private javax.swing.JToggleButton proceedbtn;
    private javax.swing.JFrame receipt;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextArea textarea1;
    private com.toedter.calendar.JYearChooser yearChooser;
    // End of variables declaration//GEN-END:variables
}