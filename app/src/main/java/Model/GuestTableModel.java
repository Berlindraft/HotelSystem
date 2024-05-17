/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.*;
/**
 *
 * @author Zyron
 */
public class GuestTableModel {

    public boolean updateGuest(int guestId, String firstname, String lastname, String contactNumber, String email, int roomnumber, String checkin, String checkout) {
        String sql = "UPDATE guestdb SET firstName = ?, lastName = ?, contactNumber = ?, email = ?, roomNumber=?, checkinDate=?, checkoutDate=?  WHERE guestId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, firstname);
            stmt.setString(2, lastname);
            stmt.setString(3, contactNumber);
            stmt.setString(4, email);
            stmt.setInt(5, roomnumber);
            stmt.setString(6, checkin);
            stmt.setString(7, checkout);
            stmt.setInt(8, guestId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteGuest(int guestId) {
        String sql = "DELETE FROM guestdb WHERE guestId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, guestId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean clearGuestDetails(int guestId) {
        String sql = "UPDATE guestdb SET firstName = NULL, lastName = NULL,  contactNumber = NULL, email = NULL, roomNumber=NULL, checkinDate=NULL, checkoutDate=NULL WHERE guestId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, guestId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
public ResultSet fetchGuestData() {
    String query = "SELECT guestId, firstName, lastName, contactNumber, email FROM guestdb"; 
    try {
        Connection con = DatabaseConnection.getConnection(); 
        PreparedStatement stmt = con.prepareStatement(query);
        return stmt.executeQuery();
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
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


}
