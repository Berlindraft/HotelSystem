/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Model.DatabaseConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.util.Date; 
import java.awt.Color;


/**
 *
 * @author Zyron
 */
public class GuestTable extends javax.swing.JPanel {
private static final String DEFAULT_GUEST_ID = "";
private static final String DEFAULT_FIRST_NAME = "";
private static final String DEFAULT_LAST_NAME = "";

    public GuestTable() {
        initComponents();
        setupListeners(); 
        populateTable();
    }
    
    
    
    
    private void setupListeners() {
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateGuestName();
            }
        });
        jButton2.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                clearSelectedRowData();
            }
        });
        jButton3.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                deleteSelectedRow();
            }
        });

        jTable2.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                updateDatabase((DefaultTableModel) e.getSource(), row, column);
            }
        });
    }
    private void updateDatabase(DefaultTableModel model, int row, int column) {
        String guestId = model.getValueAt(row, 0).toString();
        Object newValue = model.getValueAt(row, column);
        String sql = null;

        try (Connection con = DatabaseConnection.getConnection()) {
            switch (column) {
                case 2: 
                    sql = "UPDATE guestdb SET contactNumber = ? WHERE guestId = ?";
                    break;
                case 3:
                    sql = "UPDATE guestdb SET email = ? WHERE guestId = ?";
                    break;
                case 4:
                    sql = "UPDATE newbookingdb SET roomNumber = ? WHERE guestId = ?";
                    if (newValue != null) {
                        int roomNumber = Integer.parseInt(newValue.toString());
                        String roomType = updateRoomNumberAndFetchRoomType(guestId, roomNumber);
                        model.setValueAt(roomType, row, 5); // Update room type in the table as well
                    }
                    break;
                case 6:
                case 7:
                    if (newValue != null && newValue instanceof java.sql.Date) {
                        updateDateInDatabase(row, column, (java.sql.Date) newValue);
                    }
                    break;
            }

            if (sql != null) {
                try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                    pstmt.setObject(1, newValue);
                    pstmt.setString(2, guestId);
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException ex) {
        }
    }


private void clearSelectedRowData() {
    int selectedRow = jTable2.getSelectedRow();
    if (selectedRow != -1) {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        String guestId = model.getValueAt(selectedRow, 0).toString();

        String roomType = updateRoomNumberAndFetchRoomType(guestId, 0);

        model.setValueAt("", selectedRow, 1);
        model.setValueAt("", selectedRow, 2);
        model.setValueAt("", selectedRow, 3);
        model.setValueAt(0, selectedRow, 4); 
        model.setValueAt(roomType, selectedRow, 5);

        clearGuestDetailsInDatabase(guestId);
    } else {
        JOptionPane.showMessageDialog(this, "No row selected.");
    }
}

private String updateRoomNumberAndFetchRoomType(String guestId, int newRoomNumber) {
    String roomType = "Lounge"; 
    try (Connection con = DatabaseConnection.getConnection()) {
        try (PreparedStatement pstmt = con.prepareStatement("UPDATE newbookingdb SET roomNumber = ? WHERE guestId = ?")) {
            pstmt.setInt(1, newRoomNumber);
            pstmt.setString(2, guestId);
            pstmt.executeUpdate();
        }
        
        try (PreparedStatement pstmt = con.prepareStatement("SELECT roomType FROM roomdb WHERE roomNumber = ?")) {
            pstmt.setInt(1, newRoomNumber);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    roomType = rs.getString("roomType");
                }
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(GuestTable.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error updating room number and fetching room type: " + ex.getMessage());
    }
    return roomType;
}


private void clearGuestDetailsInDatabase(String guestId) {
    try (Connection con = DatabaseConnection.getConnection();
         PreparedStatement pstmt = con.prepareStatement("UPDATE guestdb SET firstName = '', lastName = '', contactNumber = '', email = '' WHERE guestId = ?")) {
        pstmt.setString(1, guestId);
        pstmt.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(GuestTable.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error updating guest details: " + ex.getMessage());
    }
}

private void updateRoomNumberInDatabase(String guestId, int newRoomNumber) {
    try (Connection con = DatabaseConnection.getConnection();
         PreparedStatement pstmt = con.prepareStatement("UPDATE newbookingdb SET roomNumber = ? WHERE guestId = ?")) {
        pstmt.setInt(1, newRoomNumber);
        pstmt.setString(2, guestId);
        pstmt.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(GuestTable.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error updating room number: " + ex.getMessage());
    }
}


 private void deleteSelectedRow() {
     int selectedRow = jTable2.getSelectedRow();
     if (selectedRow != -1) {
         DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
         String guestId = model.getValueAt(selectedRow, 0).toString();  // Get the Guest ID for database deletion

         deleteRowFromDatabase(guestId);

         model.removeRow(selectedRow);
     } else {
         JOptionPane.showMessageDialog(this, "No row selected.");
     }
 }

    private void populateTable() {
        ResultSet rs = fetchGuestsWithBookings();
        if (rs != null) {
            try {
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                model.setRowCount(0); 

                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getInt("guestId"),
                        rs.getString("firstName") + " " + rs.getString("lastName"),
                        rs.getString("contactNumber"),
                        rs.getString("email"),
                        rs.getInt("roomNumber"),
                        rs.getString("roomType"),
                        rs.getString("CheckinDate"),
                        rs.getString("CheckoutDate")
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(GuestTable.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (rs.getStatement() != null && rs.getStatement().getConnection() != null) {
                        rs.getStatement().getConnection().close();
                    }
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GuestTable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private void updateRowInDatabase(String guestId, String firstName, String lastName, String contact, String email, String roomNum, String roomType) {
        Connection con = null;
        PreparedStatement pstmtGuest = null;
        PreparedStatement pstmtBooking = null;
        try {
            con = DatabaseConnection.getConnection();
            String sqlGuest = "UPDATE guestdb SET firstName = ?, lastName = ?, contactNumber = ?, email = ? WHERE guestId = ?";
            pstmtGuest = con.prepareStatement(sqlGuest);
            pstmtGuest.setString(1, firstName);
            pstmtGuest.setString(2, lastName);
            pstmtGuest.setString(3, contact);
            pstmtGuest.setString(4, email);
            pstmtGuest.setInt(5, Integer.parseInt(guestId));
            pstmtGuest.executeUpdate();

            String sqlBooking = "UPDATE newbookingdb, roomdb SET newbookingdb.roomNumber = ?, roomdb.roomType = ? WHERE newbookingdb.guestId = ? AND newbookingdb.roomNumber = roomdb.roomNumber";
            pstmtBooking = con.prepareStatement(sqlBooking);
            pstmtBooking.setInt(1, Integer.parseInt(roomNum));
            pstmtBooking.setString(2, roomType);
            pstmtBooking.setInt(3, Integer.parseInt(guestId));
            pstmtBooking.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(GuestTable.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error updating guest details: " + e.getMessage());
        } finally {
            try {
                if (pstmtGuest != null) pstmtGuest.close();
                if (pstmtBooking != null) pstmtBooking.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(GuestTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


private void deleteRowFromDatabase(String guestId) {
    Connection con = null;
    PreparedStatement pstmtDeleteGuest = null;
    PreparedStatement pstmtUpdateBooking = null;
    try {
        con = DatabaseConnection.getConnection();
        String sqlUpdateBooking = "UPDATE newbookingdb SET roomNumber = NULL WHERE guestId = ?";
        pstmtUpdateBooking = con.prepareStatement(sqlUpdateBooking);
        pstmtUpdateBooking.setInt(1, Integer.parseInt(guestId));
        pstmtUpdateBooking.executeUpdate();

        String sqlDeleteGuest = "DELETE FROM guestdb WHERE guestId = ?";
        pstmtDeleteGuest = con.prepareStatement(sqlDeleteGuest);
        pstmtDeleteGuest.setInt(1, Integer.parseInt(guestId));
        pstmtDeleteGuest.executeUpdate();

    } catch (SQLException e) {
        Logger.getLogger(GuestTable.class.getName()).log(Level.SEVERE, null, e);
        JOptionPane.showMessageDialog(null, "Error deleting guest: " + e.getMessage());
    } finally {
        try {
            if (pstmtDeleteGuest != null) pstmtDeleteGuest.close();
            if (pstmtUpdateBooking != null) pstmtUpdateBooking.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            Logger.getLogger(GuestTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


    public ResultSet fetchGuestsWithBookings() {
        String query = "SELECT g.guestId, g.firstName, g.lastName, g.contactNumber, g.email, b.roomNumber, b.CheckinDate, b.CheckoutDate, r.roomType " +
                       "FROM guestdb g " +
                       "JOIN newbookingdb b ON g.guestId = b.guestId " +
                       "JOIN roomdb r ON b.roomNumber = r.roomNumber";
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error fetching guest and booking data: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    private void updateGuestName() {
        String guestId = guestIdTxt.getText().trim();
        String firstName = firstnameTxt.getText().trim();
        String lastName = lastnameTxt.getText().trim();

        if (guestId.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields before updating.", "Input Required", JOptionPane.WARNING_MESSAGE);
            return; 
        }

        String fullName = firstName + " " + lastName; 
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        boolean found = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).toString().equals(guestId)) {
                model.setValueAt(fullName, i, 1); 
                updateGuestDetailsInDatabase(guestId, firstName, lastName); 
                found = true;
                break;
            }
        }
        if (found) {
            JOptionPane.showMessageDialog(this, "Guest name updated successfully.");
            clearTextFields(); 
        } else {
            JOptionPane.showMessageDialog(this, "Guest ID not found.");
        }
    }

    private void clearTextFields() {
        guestIdTxt.setText("");
        firstnameTxt.setText("");
        lastnameTxt.setText("");
    }

    private void updateGuestDetailsInDatabase(String guestId, String firstName, String lastName) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DatabaseConnection.getConnection();
            String sql = "UPDATE guestdb SET firstName = ?, lastName = ? WHERE guestId = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setInt(3, Integer.parseInt(guestId));

            pstmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(GuestTable.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error updating guest details: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(GuestTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        label20 = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        guestIdTxt = new javax.swing.JTextField();
        firstnameTxt = new javax.swing.JTextField();
        lastnameTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jCalendar2 = new com.toedter.calendar.JCalendar();
        jButton4 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 449));

        jPanel4.setBackground(new java.awt.Color(179, 139, 78));

        label20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label20.setForeground(new java.awt.Color(255, 255, 255));
        label20.setName(""); // NOI18N
        label20.setText("Guest Table");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label20, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Guest ID", "Guest Name", "Contact Number", "Email Address", "Room Number", "Room Type", "Check In ", "Check Out"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setText("Guest ID");

        guestIdTxt.setForeground(new java.awt.Color(51, 51, 51));
        guestIdTxt.setText("Guest ID");
        guestIdTxt.setToolTipText("");
        guestIdTxt.setMargin(new java.awt.Insets(6, 6, 6, 6));
        guestIdTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                guestIdTxtFocusGained(evt);
            }
        });
        guestIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guestIdTxtActionPerformed(evt);
            }
        });

        firstnameTxt.setForeground(new java.awt.Color(51, 51, 51));
        firstnameTxt.setText("Firstname");
        firstnameTxt.setToolTipText("");
        firstnameTxt.setMargin(new java.awt.Insets(6, 6, 6, 6));
        firstnameTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstnameTxtFocusGained(evt);
            }
        });
        firstnameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameTxtActionPerformed(evt);
            }
        });

        lastnameTxt.setForeground(new java.awt.Color(51, 51, 51));
        lastnameTxt.setText("Lastname");
        lastnameTxt.setToolTipText("");
        lastnameTxt.setMargin(new java.awt.Insets(6, 6, 6, 6));
        lastnameTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastnameTxtFocusGained(evt);
            }
        });
        lastnameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameTxtActionPerformed(evt);
            }
        });

        jLabel5.setText("Guest Name");

        jButton3.setBackground(new java.awt.Color(101, 28, 50));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");

        jButton2.setBackground(new java.awt.Color(101, 28, 50));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(101, 28, 50));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Update");

        jButton4.setBackground(new java.awt.Color(101, 28, 50));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("OK");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalendar2, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCalendar2, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(guestIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(firstnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastnameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guestIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int selectedRow = jTable2.getSelectedRow();
        int selectedColumn = jTable2.getSelectedColumn();
        if (selectedRow != -1 && (selectedColumn == 6 || selectedColumn == 7)) {
            java.util.Date selectedDate = jCalendar2.getDate();
            java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
            jTable2.setValueAt(sqlDate.toString(), selectedRow, selectedColumn);
            updateDateInDatabase(selectedRow, selectedColumn, sqlDate);
        } else {
            JOptionPane.showMessageDialog(null, "No row or correct column selected.");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void guestIdTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_guestIdTxtFocusGained
        if(guestIdTxt != null && guestIdTxt.getText().equals("Guest ID"))
        {
            guestIdTxt.setText("");
            guestIdTxt.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_guestIdTxtFocusGained

    private void guestIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guestIdTxtActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_guestIdTxtActionPerformed

    private void firstnameTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstnameTxtFocusGained
        // TODO add your handling code here:
        
        if(firstnameTxt != null && firstnameTxt.getText().equals("Firstname"))
        {
            firstnameTxt.setText("");
            firstnameTxt.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_firstnameTxtFocusGained

    private void firstnameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameTxtActionPerformed

    private void lastnameTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastnameTxtFocusGained
        // TODO add your handling code here:
        
        if(lastnameTxt != null && lastnameTxt.getText().equals("Lastname"))
        {
            lastnameTxt.setText("");
            lastnameTxt.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_lastnameTxtFocusGained

    private void lastnameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameTxtActionPerformed
    private void updateDateInDatabase(int row, int column, java.sql.Date date) {
        String guestId = jTable2.getValueAt(row, 0).toString();
        String columnName = column == 6 ? "CheckinDate" : "CheckoutDate";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement("UPDATE newbookingdb SET " + columnName + " = ? WHERE guestId = ?")) {
            pstmt.setDate(1, date);
            pstmt.setString(2, guestId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GuestTable.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error updating date in the database: " + ex.getMessage());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField firstnameTxt;
    private javax.swing.JTextField guestIdTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JCalendar jCalendar2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private java.awt.Label label20;
    private javax.swing.JTextField lastnameTxt;
    // End of variables declaration//GEN-END:variables
}
