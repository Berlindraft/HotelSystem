package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuestInputModel {
    private BookingModel model;

    public void signUp(String fullname, String phonenumber, String emailaddress) {
        int guestId = getLastInsertedGuestId(); 

        if (guestId != -1) {
            try (Connection con = DatabaseConnection.getConnection()) {
                String queryUpdate = "UPDATE guestdb SET  fullName=?, contactNumber=?, email=? WHERE guestId=?";
                try (PreparedStatement stmtUpdate = con.prepareStatement(queryUpdate)) {
                    stmtUpdate.setString(1, fullname);
                    stmtUpdate.setString(2, phonenumber);
                    stmtUpdate.setString(3, emailaddress);
                    stmtUpdate.setInt(4, guestId);
                    int rowsAffected = stmtUpdate.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Guest data updated successfully");
                    } else {
                        System.out.println("Failed to update guest data");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminDatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Failed to insert new guest record.");
        }
    }

    public int getLastInsertedGuestId() {
        int lastGuestId = -1;
        try (Connection con = DatabaseConnection.getConnection()) {
            String query = "SELECT MAX(guestId) AS lastId FROM guestdb";
            try (PreparedStatement stmt = con.prepareStatement(query)) {
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    lastGuestId = rs.getInt("lastId");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestInputModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastGuestId;
    }
    
        public String[] retrieveCheckInOutDates(int guestId) {
        String[] dates = new String[2]; 
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT checkinDate, checkoutDate FROM newbookingdb WHERE guestId = ?")) {
            statement.setInt(1, guestId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                dates[0] = resultSet.getString("checkinDate");
                dates[1] = resultSet.getString("checkoutDate");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dates;
    }
        
        public int getRoomNumberForBooking(int bookingId) {
    int roomNumber = -1;
    try (Connection con = DatabaseConnection.getConnection()) {
        String query = "SELECT roomNumber FROM newbookingdb WHERE bookingId = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, bookingId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                roomNumber = rs.getInt("roomNumber");
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(RoomAvailabilityModel.class.getName()).log(Level.SEVERE, null, ex);
    }
    return roomNumber;
}
        
        
        
        public String getRoomType(int roomNumber) {
        String roomType = "";
        try (Connection con = DatabaseConnection.getConnection()) {
            String query = "SELECT roomType FROM roomdb WHERE roomNumber = ?";
            try (PreparedStatement stmt = con.prepareStatement(query)) {
                stmt.setInt(1, roomNumber);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    roomType = rs.getString("roomType");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomAvailabilityModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roomType;
    }
        
    public int getLastInsertedBookingId() {
        int lastBookingId = -1;
        try (Connection con = DatabaseConnection.getConnection()) {
            String query = "SELECT MAX(bookingId) AS lastId FROM newbookingdb";
            try (PreparedStatement stmt = con.prepareStatement(query)) {
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    lastBookingId = rs.getInt("lastId");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestInputModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastBookingId;
    }
    public int getLastInsertedPaymentId() {
        int paymentId = -1;
        try (Connection con = DatabaseConnection.getConnection()) {
            String query = "SELECT MAX(paymentId) AS lastId FROM paymentdb";
            try (PreparedStatement stmt = con.prepareStatement(query)) {
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    paymentId = rs.getInt("lastId");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuestInputModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paymentId;
    }
    public void updateOption1(int bookingId, String status) {
    String query = "UPDATE newbookingdb SET AddOption1 = ? WHERE bookingId = ?";

    try (Connection con = DatabaseConnection.getConnection();
         PreparedStatement stmt = con.prepareStatement(query)) {

        stmt.setString(1, status);
        stmt.setInt(2, bookingId);

        stmt.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(BookingModel.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    public void updateOption2(int bookingId, String status) {
    String query = "UPDATE newbookingdb SET AddOption2 = ? WHERE bookingId = ?";

    try (Connection con = DatabaseConnection.getConnection();
         PreparedStatement stmt = con.prepareStatement(query)) {

        stmt.setString(1, status);
        stmt.setInt(2, bookingId);

        stmt.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(BookingModel.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    public void updateOption3(int bookingId, String status) {
    String query = "UPDATE newbookingdb SET AddOption3 = ? WHERE bookingId = ?";

    try (Connection con = DatabaseConnection.getConnection();
         PreparedStatement stmt = con.prepareStatement(query)) {

        stmt.setString(1, status);
        stmt.setInt(2, bookingId);

        stmt.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(BookingModel.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
    public void updatePaymentTotal(int paymentId, double paymentTotal) {
    String query = "UPDATE paymentdb SET paymentAmount = ? WHERE paymentId = ?";

    try (Connection con = DatabaseConnection.getConnection();
         PreparedStatement stmt = con.prepareStatement(query)) {

        stmt.setDouble(1, paymentTotal);
        stmt.setInt(2, paymentId);

        stmt.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(BookingModel.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
   public int getRoomCapacity(int roomNumber) {
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement("SELECT roomCapacity FROM roomdb WHERE roomNumber = ?")) {
        statement.setInt(1, roomNumber);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("roomCapacity");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return 0;  
}
 
    public int getNumberOfSeniors(int bookingId) {
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement("SELECT discounted FROM newbookingdb WHERE bookingId = ?")) {
        statement.setInt(1, bookingId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("discounted"); 
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return 0; 
}


    
        public void gcashInformation(String paymentMethod, String gcashnumber, String gcashname, String paymentDate) {
        int paymentid = getLastInsertedPaymentId(); 

        if (paymentid != -1) {
            try (Connection con = DatabaseConnection.getConnection()) {
                String queryUpdate = "UPDATE paymentdb SET gcashNumber=?, gcashName=?, paymentDate=?, paymentMethod=? WHERE paymentId=?";
                try (PreparedStatement stmtUpdate = con.prepareStatement(queryUpdate)) {
                    stmtUpdate.setString(1, gcashnumber);
                    stmtUpdate.setString(2, gcashname);
                    
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                LocalDate localDate = LocalDate.parse(paymentDate, formatter);
                stmtUpdate.setDate(3, java.sql.Date.valueOf(localDate));
                    stmtUpdate.setString(4, paymentMethod);
                    stmtUpdate.setInt(5, paymentid);
                    int rowsAffected = stmtUpdate.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("updated successfully");
                    } else {
                        System.out.println("Failed to update guest data");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminDatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Failed to insert new guest record.");
        }
    }
        public void cashReceived(String paymentMethod,int cashreceived, String paymentDate) {
        int paymentid = getLastInsertedPaymentId(); 

        if (paymentid != -1) {
            try (Connection con = DatabaseConnection.getConnection()) {
                String queryUpdate = "UPDATE paymentdb SET cashReceived=?, paymentDate=?, paymentMethod=? WHERE paymentId=?";
                try (PreparedStatement stmtUpdate = con.prepareStatement(queryUpdate)) {
                    stmtUpdate.setInt(1, cashreceived);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                LocalDate localDate = LocalDate.parse(paymentDate, formatter);
                stmtUpdate.setDate(2, java.sql.Date.valueOf(localDate));
                stmtUpdate.setString(3, paymentMethod);
                stmtUpdate.setInt(4, paymentid);
                    
                    
                    int rowsAffected = stmtUpdate.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("updated successfully");
                    } else {
                        System.out.println("Failed to update guest data");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminDatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Failed to insert new guest record.");
        }
    }
        
        
public void processPayment(int paymentId, String paymentDate, String paymentMethod, String gcashNumber, String gcashName, int cashReceived) {
    String query = "UPDATE paymentdb SET paymentDate = ?, paymentMethod = ?, gcashNumber = ?, gcashName = ?, cashReceived = ? WHERE paymentId = ?";

    try (Connection con = DatabaseConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(query)) {

        pst.setString(1, paymentDate);
        pst.setString(2, paymentMethod);
        pst.setString(3, gcashNumber);
        pst.setString(4, gcashName);
        pst.setInt(5, cashReceived);
        pst.setInt(6, paymentId);  

        int result = pst.executeUpdate();
        if (result > 0) {
            System.out.println("Payment information updated successfully for paymentId: " + paymentId);
        } else {
            System.out.println("Failed to update payment information or no record found with paymentId: " + paymentId);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error connecting to the database or executing the update query");
    }
}
    public double getPaymentAmount(int paymentId) {
        String query = "SELECT paymentAmount FROM paymentdb WHERE paymentId = ?";
        double paymentAmount = 0.0; 

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, paymentId); 

            ResultSet rs = stmt.executeQuery(); 
            if (rs.next()) { 
                paymentAmount = rs.getDouble("paymentAmount"); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return paymentAmount; 
    }
    
        
}
