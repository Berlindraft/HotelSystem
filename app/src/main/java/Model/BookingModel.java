package Model;

import static Model.DatabaseConnection.getConnection;
import java.sql.*;
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
            // Handle the exception gracefully, e.g., log it or display an error message to the user
            e.printStackTrace();
        }
        return adultCount;
    }
     
     public void updateAdultCount(int newAdultCount) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE guestcat SET adults = ?")) {
            // Update the specific row in the guestcat table
            statement.setInt(1, newAdultCount);
            statement.executeUpdate();
        } catch (SQLException e) {
            // Handle the exception gracefully
            e.printStackTrace();
        }
    }
     
     
      public void addGuest() {
        try (Connection connection = getConnection()) {
            // SQL query to insert a new row with incremented guestId and default values for other columns
            String sql = "INSERT INTO guestdb (firstName, lastName, prefixName, suffixName, contactNumber, email, address) "
           + "VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL)";


            
            // Create a prepared statement
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Execute the SQL query
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

    // Method to insert a new room with incremented id and default values
    public void addRoom() {
        try (Connection connection = getConnection()) {
            // SQL query to insert a new row with incremented roomId and default values for other columns
            String sql = "INSERT INTO roomdb (roomNumber, roomType, roomStatus, roomUpdate) "
           + "VALUES ('0', 'Lounge', 'Available', 'Clean')";

            
            // Create a prepared statement
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Execute the SQL query
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
            // SQL query to insert a new row into the paymentdb table with NULL values for paymentDate, paymentAmount, and paymentMethod
            String sql = "INSERT INTO paymentdb (bookingId, paymentDate, paymentAmount, paymentMethod) "
                       + "VALUES (?, NULL, NULL, NULL)";

            // Create a prepared statement
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Set the value for the bookingId parameter
                statement.setInt(1, bookingId);

                // Execute the SQL query
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
     
     public void addBooking() {
    try (Connection connection = getConnection()) {
            // SQL query to insert a new row with foreign key guestId and roomNumber
//            String sql = "INSERT INTO testdb (guestId, roomNumber, checkinDate, checkoutDate) "
//           + "SELECT (SELECT IFNULL(MAX(guestId), 0) FROM guestdb), "
//           + "(SELECT IFNULL(MAX(roomNumber), 0) FROM roomdb), "
//           + "'0000-00-00', '0000-00-00', '0'";
            String sql = "INSERT INTO testdb (guestId, roomNumber, checkinDate, checkoutDate) "
                   + "VALUES (NULL, NULL, NULL, NULL)";

            
            // Create a prepared statement
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Execute the SQL query
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
            // Handle the exception gracefully
            e.printStackTrace();
        }
    }



    }
     
     

