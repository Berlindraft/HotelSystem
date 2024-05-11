package Model;

import static Model.DatabaseConnection.getConnection;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Zyron
 */

public class BookingModel {
    
     public int retrieveAdultCount() {
        int adultCount = 0;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM guestcat")) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                adultCount = resultSet.getInt("adults");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adultCount;
    }
     
     public int retrieveChildrenCount() {
        int childrenCount = 0;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM guestcat")) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                childrenCount = resultSet.getInt("children");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return childrenCount;
    }
     
     public void updateAdultCount(int newAdultCount) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE guestcat SET adults = ?")) {
            statement.setInt(1, newAdultCount);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void updateChildrenCount(int newChildrenCount) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE guestcat SET children = ?")) {
            statement.setInt(1, newChildrenCount);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
     
      public void addGuest() {
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO guestdb (firstName, lastName, prefixName, suffixName, contactNumber, email, address) "
           + "VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("New guest record created successfully");
                } else {
                    System.out.println("Failed to create new guest record");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addRoom() {
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO roomdb (roomNumber, roomType, roomStatus, roomUpdate) "
           + "VALUES ('0', 'Lounge', 'Available', 'Clean')";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("New room record created successfully");
                } else {
                    System.out.println("Failed to create new room record");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void addPayment(int bookingId) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO paymentdb (bookingId, paymentDate, paymentAmount, paymentMethod) "
                       + "VALUES (?, NULL, NULL, NULL)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, bookingId);

                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("New payment record created successfully");
                } else {
                    System.out.println("Failed to create new payment record");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
public void addBooking(int guestId, int roomNumber, Date checkinDate, Date checkoutDate, int adults, int children, double paymentAmount, Date paymentDate, String paymentMethod) {
    try (Connection connection = getConnection()) { 
        String sql = "INSERT INTO newbookingdb (guestId, roomNumber, checkinDate, checkoutDate, adults, children, paymentAmount, paymentDate, paymentMethod) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            java.sql.Date sqlCheckinDate = new java.sql.Date(checkinDate.getTime());
            java.sql.Date sqlCheckoutDate = new java.sql.Date(checkoutDate.getTime());
            java.sql.Date sqlPaymentDate = new java.sql.Date(paymentDate.getTime());
            
            statement.setInt(1, guestId);
            statement.setInt(2, roomNumber);
            statement.setDate(3, sqlCheckinDate);
            statement.setDate(4, sqlCheckoutDate);            
            statement.setInt(5, adults);
            statement.setInt(6, children);
            statement.setDouble(7, paymentAmount);
            statement.setDate(8, sqlPaymentDate);
            statement.setString(9, paymentMethod);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("New booking created successfully");
            } else {
                System.out.println("Failed to create new booking");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}






public void subtractBooking(int bookingToRemove) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM bookingdb WHERE booking = ?")) {
            statement.setInt(1, bookingToRemove);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void checkInDateMethod(java.util.Date selectedDate) {
         try (Connection connection = getConnection()) {
             String sql = "INSERT INTO testdb (checkinDate) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setDate(1, new java.sql.Date(selectedDate.getTime()));
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Date added to the database successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add date to the database");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while adding date to the database");
        }
        
    }

public String retrieveStatus(int roomNumber) {
    String status = ""; // Initialize with an empty string
    // Query the database to retrieve the status for the given roomNumber
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement("SELECT roomStatus FROM roomdb WHERE roomNumber = ?");
    ) {
        statement.setInt(1, roomNumber);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                status = resultSet.getString("roomStatus");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return status;
}

public String retrieveRoomStatus(int roomNumber, String roomType) {
    String status = "";
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement("SELECT roomStatus FROM roomdb WHERE roomNumber = ? AND roomType = ?");
    ) {
        statement.setInt(1, roomNumber);
        statement.setString(2, roomType);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                status = resultSet.getString("roomStatus");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return status;
}




    
    
    
    
    
    
    
    

//fini
    }
     
     

