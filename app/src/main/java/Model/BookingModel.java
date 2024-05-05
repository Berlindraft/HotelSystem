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
     
    public void addBooking(int adults, int children, Date checkinDate, Date checkoutDate) {
    try (Connection connection = getConnection()) {
        String sql = "INSERT INTO testdb (guestId, roomNumber, adults, children, checkinDate, checkoutDate) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int guestId = 1; 
            int roomNumber = 101;
            
            statement.setInt(1, guestId);
            statement.setInt(2, roomNumber);
            statement.setInt(3, adults);
            statement.setInt(4, children);
            
            java.sql.Date sqlCheckinDate = new java.sql.Date(checkinDate.getTime());
            java.sql.Date sqlCheckoutDate = new java.sql.Date(checkoutDate.getTime());
            
            statement.setDate(5, sqlCheckinDate);
            statement.setDate(6, sqlCheckoutDate);
            
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



    }
     
     

