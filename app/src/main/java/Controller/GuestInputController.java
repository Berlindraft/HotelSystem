package Controller;

import Model.BookingModel;
import Model.GuestInputModel;
import View.GuestInput;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Zyron
 */
public class GuestInputController {
    private GuestInputModel model;
    private BookingModel Bmodel;
    private GuestInput view; 

    public GuestInputController() { 
        this.model = new GuestInputModel(); 
        this.Bmodel = new BookingModel();
        
  
    }  
    
    public String[] retrieveCheckInOutDates(int guestId) {
        return model.retrieveCheckInOutDates(guestId);
    }
    

    public void signUp(String fullname, String phonenumber, String emailaddress) {
        if (fullname.isEmpty() || phonenumber.isEmpty() || emailaddress.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "All these fields are required");
        }else{
            model.signUp(fullname, phonenumber, emailaddress);
            JOptionPane.showMessageDialog(new JFrame(), "Sent into database");
        }}
        

}
