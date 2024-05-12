package Controller;

import Model.BookingModel;
import Model.GuestInputModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Zyron
 */
public class GuestInputController {
    private GuestInputModel model;
    private BookingModel Bmodel;
    public GuestInputController() {
        this.model = new GuestInputModel(); 
        this.Bmodel = new BookingModel();
    }  

public void signUp(String prefix, String firstname, String lastname, String suffix, String phonenumber, String emailaddress) {
    if (firstname.isEmpty() || lastname.isEmpty() || phonenumber.isEmpty() || emailaddress.isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "All these fields are required");
        return;
    }

    int guestId = Bmodel.addGuest(); // Get the actual guest ID from the model
    if (guestId != 0) { // Check if the guest ID is valid
        model.signUp(guestId, prefix, firstname, lastname, suffix, phonenumber, emailaddress);
        JOptionPane.showMessageDialog(new JFrame(), "Sent into database");
    } else {
        JOptionPane.showMessageDialog(new JFrame(), "Failed to add guest. Please try again.");
    }
}

    
}
