package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuestInputModel {
    private BookingModel model;

    public void signUp(String prefix, String firstname, String lastname, String suffix, String phonenumber, String emailaddress) {
        int guestId = getLastInsertedGuestId(); // Retrieve the last inserted guestId

        if (guestId != -1) {
            try (Connection con = DatabaseConnection.getConnection()) {
                String queryUpdate = "UPDATE guestdb SET prefixName=?, firstName=?, lastName=?, suffixName=?, contactNumber=?, email=? WHERE guestId=?";
                try (PreparedStatement stmtUpdate = con.prepareStatement(queryUpdate)) {
                    stmtUpdate.setString(1, prefix);
                    stmtUpdate.setString(2, firstname);
                    stmtUpdate.setString(3, lastname);
                    stmtUpdate.setString(4, suffix);
                    stmtUpdate.setString(5, phonenumber);
                    stmtUpdate.setString(6, emailaddress);
                    stmtUpdate.setInt(7, guestId);
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
        String[] dates = new String[2]; // Array to store check-in and check-out dates
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
    
    
    
}
