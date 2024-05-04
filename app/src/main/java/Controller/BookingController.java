/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.BookingModel;
import View.Booking;
import java.awt.event.ActionEvent;

/**
 *
 * @author Zyron
 */
public class BookingController {
    private BookingModel model;
    private Booking view;
    
        public BookingController(BookingModel model, Booking view) {
        this.model = model;
        this.view = view;

        view.addAddButtonListener(this::handleAddButton);
        view.addSubtractButtonListener(this::handleSubtractButton);
        view.setAdultCount(model.retrieveAdultCount());
    }
        public void handleAddButtonClick(ActionEvent e) {
        int currentValue = view.getAdultCount(); // Get the current value from the view
        int newValue = currentValue + 1; // Increment the value
        view.setAdultCount(newValue); // Update the view with the new value
//        model.addGuest();
//        model.addRoom();
//        model.addPayment(newValue);
        model.addBooking(); // Update the model
    }

    public void handleSubtractButtonClick(ActionEvent e) {
        int currentValue = view.getAdultCount(); // Get the current value from the view
        int newValue = currentValue - 1; // Decrement the value
        view.setAdultCount(newValue); // Update the view with the new value
        model.subtractBooking(newValue); // Update the model
    }

    private void handleSubtractButton(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private void handleAddButton(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
