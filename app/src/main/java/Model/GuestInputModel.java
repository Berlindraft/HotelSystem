/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.BookingModel;
/**
 *
 * @author Zyron
 */
public class GuestInputModel {
private BookingModel model;

public void signUp(int guestId, String prefix, String firstname, String lastname, String suffix, String phonenumber, String emailaddress) {
    //int guestId = addGuest();
    // If guestId is not -1 (indicating successful insertion), proceed with updating guest details
    if (guestId != -1) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String queryUpdate = "UPDATE guestdb SET firstName=?, lastName=?, prefixName=?, suffixName=?, contactNumber=?, email=? WHERE guestId=?";
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


    
}
