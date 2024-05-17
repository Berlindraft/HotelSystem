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
     
     
public int addGuest() {
    int guestId = 0; // Initialize guestId
    try (Connection connection = getConnection()) {
        String sql = "INSERT INTO guestdb (firstName, lastName, prefixName, suffixName, contactNumber, email, address) "
                   + "VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    guestId = generatedKeys.getInt(1); // Get the generated guestId
                }
                System.out.println("New guest record created successfully with guestId: " + guestId);
            } else {
                System.out.println("Failed to create new guest record");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return guestId;
}
public int addRoom() {
    int roomNumber = -1; 

    try (Connection connection = getConnection()) {
        String sql = "SELECT roomNumber FROM roomdb WHERE roomType = 'Lounge'"; 
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    roomNumber = resultSet.getInt("roomNumber"); 
                    System.out.println("Default roomNumber retrieved: " + roomNumber);
                } else {
                    System.out.println("Failed to retrieve default roomNumber");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return roomNumber;
}public int addPayment(int guestId) {
    int paymentId = 0; 
    try (Connection connection = DatabaseConnection.getConnection()) {
        String sql = "INSERT INTO paymentdb (guestId, paymentDate, paymentAmount, paymentMethod, cardNumber, cardExpiration, cardName, cardCvv, gcashNumber, gcashName, cashReceived) "
                   + "VALUES (?, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, guestId); 

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    paymentId = generatedKeys.getInt(1); 
                }
                System.out.println("New payment record created successfully with paymentId: " + paymentId);
            } else {
                System.out.println("Failed to create new payment record");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return paymentId;
}


public void addBooking(int guestId, int paymentId, Date checkinDate, Date checkoutDate, int adults, int children, double paymentAmount, Date paymentDate, String paymentMethod) {
    int roomNumber = addRoom();
    try (Connection connection = getConnection()) { 
        String sql = "INSERT INTO newbookingdb (guestId, paymentId, roomNumber, checkinDate, checkoutDate, adults, children, addOption1, addOption2, addOption3) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            java.sql.Date sqlCheckinDate = new java.sql.Date(checkinDate.getTime());
            java.sql.Date sqlCheckoutDate = new java.sql.Date(checkoutDate.getTime());
            java.sql.Date sqlPaymentDate = new java.sql.Date(paymentDate.getTime());
            
            statement.setInt(1, guestId);
            statement.setInt(2, paymentId);
            statement.setInt(3, roomNumber);
            statement.setDate(4, sqlCheckinDate);
            statement.setDate(5, sqlCheckoutDate);            
            statement.setInt(6, adults);
            statement.setInt(7, children);
            statement.setDouble(8, paymentAmount);
            statement.setDate(9, sqlPaymentDate);
            statement.setString(10, paymentMethod);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("New booking created successfully");
                System.out.println("guest id: " + guestId);
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
    String status = ""; 
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
     
     

