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
        
  
    }  
    
    public String[] retrieveCheckInOutDates(int guestId) {
        // Call the corresponding method in the model to retrieve the dates
        return model.retrieveCheckInOutDates(guestId);
    }
    
    


    public void signUp(String prefix, String firstname, String lastname, String suffix, String phonenumber, String emailaddress) {
        if (firstname.isEmpty() || lastname.isEmpty() || phonenumber.isEmpty() || emailaddress.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "All these fields are required");
            return;
        }else{
            JOptionPane.showMessageDialog(new JFrame(), "Sent into database");
        }}
        

}
