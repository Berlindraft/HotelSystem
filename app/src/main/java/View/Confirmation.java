/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Model.ConfirmationModel;
import Utils.EmailSender;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Zyron
 */
public class Confirmation extends javax.swing.JPanel {
private static ConfirmationModel model;
private static EmailSender emailSender;
    public Confirmation() {
        initComponents();
        this.model = new ConfirmationModel();
        this.emailSender = new EmailSender("hoteldayuhan@gmail.com", "rajg fifw hngh fnvf");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jLabel10.setText("jLabel10");

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("CONFIRM BOOKING");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("BOOKING ID #");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("ROOM DESCRIPTION");

        jLabel3.setText("ROOM TYPE");

        jLabel4.setText("ROOM NAME");

        jLabel5.setText("ROOM DESCRIPTION");

        jLabel6.setText("CHECK IN DATE");

        jLabel7.setText("CHECK OUT DATE");

        jLabel8.setText("NO. OF DAYS STAY");

        jLabel9.setText("ADDITIONAL OPTIONS");

        jLabel11.setText("GUEST NAME");

        jLabel12.setText("GUEST NUMBER");

        jLabel13.setText("GUEST EMAIL");

        jLabel14.setText("ROOM NUMBER");

        jLabel15.setText("PAYMENT AMOUNT");

        jLabel16.setText("PAYMENT METHOD");

        jCheckBox1.setText("AGREE WITH THE PRIVACY TERMS ");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("AGREE WITH THE BOOKING CONDITIONS");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("GUEST ID #");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("GUEST INFORMATION");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("BOOKING INFORMATION");

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(63, 63, 63)
                        .addComponent(jLabel17))
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel18)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(104, 104, 104)
                                            .addComponent(jLabel14)))
                                    .addGap(106, 106, 106))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel19)
                                    .addGap(267, 267, 267)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)
                                .addComponent(jLabel15)
                                .addComponent(jLabel16)))))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel12))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel13)))
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                        .addGap(18, 18, 18))))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!jCheckBox1.isSelected() || !jCheckBox2.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please agree to all terms before confirming the booking.", "Terms Agreement Required", JOptionPane.ERROR_MESSAGE);
            return;
        }

        updateAllInformation(); 
        String htmlContent = generateHtmlContent(); 

        try {
            int guestid = model.getLastInsertedGuestId();
            String email = model.getGuestEmail(guestid);
            emailSender.sendEmail(email, "Booking Confirmation", htmlContent);  
            JOptionPane.showMessageDialog(this, "Booking confirmed and email sent successfully!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(this, "Failed to send confirmation email.", "Email Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    Management management = (Management) SwingUtilities.getWindowAncestor(this);
    management.getjPanel11().removeAll();
    Payment payment = new Payment();
    management.getjPanel11().add(payment);
    management.getjPanel11().revalidate();
    management.getjPanel11().repaint();
    System.out.println("previous panel");
    }//GEN-LAST:event_jButton2ActionPerformed

private String generateHtmlContent() {
    try {
        int bookingId = model.getLastInsertedBookingId();
        int guestId = model.getLastInsertedGuestId();

        int roomNumber = model.getRoomNumber();
        String roomType = model.getRoomType(roomNumber);
        String roomName = model.getRoomNameByType(roomType);
        String roomDescription = model.getRoomDescriptionByType(roomType);

        String firstname = model.getGuestFirstName(guestId);
        String lastname = model.getGuestLastName(guestId);
        String fullname = firstname + " " + lastname; // Ensure names are properly spaced
        String email = model.getGuestEmail(guestId);

        int paymentId = model.getLastPaymentId();
        double paymentamount = model.getPaymentAmount(paymentId);

        String[] checkInOutDates = model.retrieveCheckInOutDates(bookingId);
        String checkInDate = checkInOutDates[0];
        String checkOutDate = checkInOutDates[1];

        jLabel6.setText("Check-in Date: " + checkInDate);
        jLabel7.setText("Check-out Date: " + checkOutDate);

        long numberOfDays = calculateNumberOfDays(checkInDate, checkOutDate);
        jLabel8.setText("No. of days stay: " + numberOfDays);
        List<String> addOns = model.getAddOnOptions(bookingId);
        String addOnText = String.join(", ", addOns);
        if (addOnText.isEmpty()) {
            addOnText = "No additional options selected.";
        }

        return String.format("""
            <!DOCTYPE html>
            <html lang="en">
            <head>
            <meta charset="UTF-8">
            <title>Booking Confirmation</title>
            </head>
            <body style="font-family: Arial, sans-serif; color: #333;">
            <div style="max-width: 600px; margin: auto; border: 1px solid #ccc; padding: 20px; border-radius: 5px; background: #f9f9f9;">
                <h1 style="color: #0264d6; text-align: center;">Booking Confirmation</h1>
                <p style="font-size: 16px; text-align: center;">Thank you for booking with us, <strong>%s</strong>! Here are the details of your booking:</p>

                <table style="width: 100%%; border-collapse: collapse; margin-top: 20px;">
                    <tr style="background-color: #0264d6; color: white;">
                        <th style="padding: 10px; border: 1px solid #ddd;">Booking</th>
                        <th style="padding: 10px; border: 1px solid #ddd;">Details</th>
                    </tr>
                    <tr>
                        <td style="padding: 10px; border: 1px solid #ddd;">Booking ID</td>
                        <td style="padding: 10px; border: 1px solid #ddd;">%d</td>
                    </tr>
                    <tr>
                        <td style="padding: 10px; border: 1px solid #ddd;">Guest ID</td>
                        <td style="padding: 10px; border: 1px solid #ddd;">%d</td>
                    </tr>
                    <tr>
                        <td style="padding: 10px; border: 1px solid #ddd;">Room Type</td>
                        <td style="padding: 10px; border: 1px solid #ddd;">%s</td>
                    </tr>
                    <tr>
                        <td style="padding: 10px; border: 1px solid #ddd;">Room Name</td>
                        <td style="padding: 10px; border: 1px solid #ddd;">%s</td>
                    </tr>
                    <tr>
                        <td style="padding: 10px; border: 1px solid #ddd;">Check-in Date</td>
                        <td style="padding: 10px; border: 1px solid #ddd;">%s</td>
                    </tr>
                    <tr>
                        <td style="padding: 10px; border: 1px solid #ddd;">Check-out Date</td>
                        <td style="padding: 10px; border: 1px solid #ddd;">%s</td>
                    </tr>
                    <tr>
                        <td style="padding: 10px; border: 1px solid #ddd;">Payment Amount</td>
                        <td style="padding: 10px; border: 1px solid #ddd;">$%.2f</td>
                    </tr>
                </table>

                <p style="text-align: center; font-size: 16px; margin-top: 20px;">If you have any questions or need further assistance, please do not hesitate to contact us.</p>

                <div style="text-align: center; margin-top: 20px;">
                    <a style="padding: 10px 20px; color: white; background-color: #0264d6; text-decoration: none; border-radius: 5px;">xraymundzyron@gmail.com</a>
                </div>
            </div>
            </body>
            </html>
            """, fullname, bookingId, guestId, roomType, roomName, checkInDate, checkOutDate, paymentamount);
    } catch (Exception e) {
        e.printStackTrace();
        return "Error generating booking confirmation.";
    }
}


    private void updateAllInformation() {
        updateBookingGuestId();
        updateRoomDescription();
        updateGuestInformation();
        updatePaymentInformation();
        updateBookingInformation();
        displayAddOns();
    }
    
    public void setupCheckboxListeners() {
    jCheckBox1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            checkAndEnableConfirmButton();
        }
    });

    jCheckBox2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            checkAndEnableConfirmButton();
        }
    });
}
public void checkAndEnableConfirmButton() {
    if (jCheckBox1.isSelected() && jCheckBox2.isSelected()) {
        jButton1.setEnabled(true);
    } else {
        jButton1.setEnabled(false); 
    }
}

public void displayRoomNumber() {
    int roomNumber = model.getRoomNumber();
    jLabel14.setText("Room Number: " + roomNumber);
}

public void updateBookingGuestId() {
    int bookingId = model.getLastInsertedBookingId();
    int guestId = model.getLastInsertedGuestId();
    jLabel1.setText("BOOKING ID: " + bookingId);
    jLabel17.setText("GUEST ID: " + guestId);
}

public void updateRoomDescription() {
    int roomNumber = model.getRoomNumber();
    String roomType = model.getRoomType(roomNumber);
    String roomName = model.getRoomNameByType(roomType);
    String roomDescription = model.getRoomDescriptionByType(roomType);
    
    jLabel3.setText("Room Type: " + roomType);
    jLabel4.setText("Room Name: " + roomName);
    jLabel5.setText("Room Description: " + roomDescription);
}

public void updateGuestInformation() {
    int guestId = model.getLastInsertedGuestId();
    String firstname = model.getGuestFirstName(guestId);
    String lastname = model.getGuestLastName(guestId);
    String contact = model.getGuestNumber(guestId);
    String email = model.getGuestEmail(guestId);
    jLabel11.setText("Guest Name: " + firstname + " " + lastname);
    jLabel12.setText("Guest Number: " + contact);
    jLabel13.setText("Guest Email: " + email);
}

public void updatePaymentInformation() {
    
    int paymentId = model.getLastPaymentId();
    int guestId = model.getLastInsertedGuestId();
    double paymentamount = model.getPaymentAmount(paymentId);
    String paymentmethod = model.getPaymentMethod(paymentId);
    jLabel15.setText("Payment Amount: " + paymentamount);
    jLabel16.setText("Payment Method: " + paymentmethod);
}

public void updateBookingInformation() {
   
    int bookingId = model.getLastInsertedBookingId();
    String[] checkInOutDates = model.retrieveCheckInOutDates(bookingId);
    String checkInDate = checkInOutDates[0];
    String checkOutDate = checkInOutDates[1];

    jLabel6.setText("Check-in Date: " + checkInDate);
    jLabel7.setText("Check-out Date: " + checkOutDate); 
    
    long numberOfDays = calculateNumberOfDays(checkInDate, checkOutDate);
    jLabel8.setText("No. of days stay: " + numberOfDays); 

}

public long calculateNumberOfDays(String checkInDate, String checkOutDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate checkIn = LocalDate.parse(checkInDate, formatter);
        LocalDate checkOut = LocalDate.parse(checkOutDate, formatter);

        // Calculate the number of days between the two dates
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

public void displayAddOns() {
    int bookingId = model.getLastInsertedBookingId();
    List<String> addOns = model.getAddOnOptions(bookingId);
    String addOnText = String.join(", ", addOns); 
    if (addOnText.isEmpty()) {
        addOnText = "No additional options selected.";
    }
    jLabel9.setText(addOnText); 
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
