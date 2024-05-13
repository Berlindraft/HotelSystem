package Controller;

import Model.BookingModel;
import Model.GuestInputModel;
import View.Guest;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Zyron
 */
public class GuestInputController {
    private GuestInputModel model;
    private BookingModel Bmodel;
    private Guest view; // Import your actual view class

    public GuestInputController() { // Pass the view object to the constructor
        this.model = new GuestInputModel(); 
        this.Bmodel = new BookingModel();
        this.view = new Guest(); // Assign the view object
        
        int guestId = model.getLastInsertedGuestId(); // Assuming you have a method to get the last inserted guestId
        
        // Check if the sign-up was successful and a valid guestId was returned
        if (guestId != -1) {
            // Assuming you have a method in your model to retrieve check-in and check-out dates
            String[] checkInOutDates = model.retrieveCheckInOutDates(guestId);
            
            // Extract check-in and check-out dates
            String checkInDate = checkInOutDates[0];
            String checkOutDate = checkInOutDates[1];
            
            // Update the labels in the view with the retrieved dates
            view.displayCheckInOutDates(checkInDate, checkOutDate);
            
            JOptionPane.showMessageDialog(new JFrame(), "Sent into database");
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Failed to sign up guest. Please try again.");
        }
        
        
        
    }  

    public void signUp(String prefix, String firstname, String lastname, String suffix, String phonenumber, String emailaddress) {
        if (firstname.isEmpty() || lastname.isEmpty() || phonenumber.isEmpty() || emailaddress.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "All these fields are required");
            return;
        }
//        
//        // Assuming you have a method in your model to sign up the guest and retrieve the guestId
//        int guestId = model.getLastInsertedGuestId(); // Assuming you have a method to get the last inserted guestId
//        
//        // Check if the sign-up was successful and a valid guestId was returned
//        if (guestId != -1) {
//            // Assuming you have a method in your model to retrieve check-in and check-out dates
//            String[] checkInOutDates = model.retrieveCheckInOutDates(guestId);
//            
//            // Extract check-in and check-out dates
//            String checkInDate = checkInOutDates[0];
//            String checkOutDate = checkInOutDates[1];
//            
//            // Update the labels in the view with the retrieved dates
//            view.displayCheckInOutDates(checkInDate, checkOutDate);
//            
//            JOptionPane.showMessageDialog(new JFrame(), "Sent into database");
//        } else {
//            JOptionPane.showMessageDialog(new JFrame(), "Failed to sign up guest. Please try again.");
//        }
    }
}
