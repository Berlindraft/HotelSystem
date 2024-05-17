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
public class TransactionTableModel {

    public ResultSet fetchTransactionDetails() {
        String query = "SELECT guestId, paymentDate, paymentAmount, paymentMethod FROM paymentdb";
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateTransaction(int guestId, String paymentDate, double paymentAmount, String paymentMethod) {
        String sql = "UPDATE paymentdb SET paymentDate = ?, paymentAmount = ?, paymentMethod = ? WHERE guestId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paymentDate);
            stmt.setDouble(2, paymentAmount);
            stmt.setString(3, paymentMethod);
            stmt.setInt(4, guestId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean clearTransaction(int guestId) {
        String sql = "UPDATE paymentdb SET paymentDate = NULL, paymentAmount = NULL, paymentMethod = NULL WHERE guestId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, guestId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
