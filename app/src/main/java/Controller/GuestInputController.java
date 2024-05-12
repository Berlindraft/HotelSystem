/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.GuestInputModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Zyron
 */
public class GuestInputController {
    private GuestInputModel model;
    
    public GuestInputController() {
        this.model = new GuestInputModel(); 
    }  

    public void signUp(String prefix, String firstname, String lastname, String suffix, String phonenumber, String emailaddress) {
        if (firstname.isEmpty() || lastname.isEmpty() || phonenumber.isEmpty() || emailaddress.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "All these fields are required");
            return;
        }

        model.signUp(0, prefix, firstname, lastname, suffix,  phonenumber, emailaddress);
        JOptionPane.showMessageDialog(new JFrame(), "Sent into database");
    }
    
}
