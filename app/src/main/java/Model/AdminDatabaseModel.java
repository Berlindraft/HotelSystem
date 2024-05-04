package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminDatabaseModel {
    private Connection con;
    private static final String DB_NAME = "dayuhanzy";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:4306/" + DB_NAME;
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    public AdminDatabaseModel() {
        try {
            con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection Successful");
        } catch (SQLException ex) {
            Logger.getLogger(AdminDatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
            // Handle connection error more gracefully, such as displaying an error message
        }
    }

    public void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS admindb ("
                     + "id INT AUTO_INCREMENT PRIMARY KEY,"
                     + "first_name VARCHAR(255),"
                     + "last_name VARCHAR(255),"
                     + "email VARCHAR(255),"
                     + "phone_number VARCHAR(20),"
                     + "password VARCHAR(255)"
                     + ")";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    }

    public void signUp(String firstName, String lastName, String email, String phoneNumber, String password) {
        String query = "INSERT INTO admindb (first_name, last_name, email, phone_number, password) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, phoneNumber);
            stmt.setString(5, password); 
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    }

    public boolean login(String email, String password) {
        String query = "SELECT * FROM admindb WHERE email = ? AND password = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Return true if the result set is not empty
        } catch (SQLException ex) {
            Logger.getLogger(AdminDatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
            // Handle SQL exception more gracefully
            return false;
        }
    }
}
