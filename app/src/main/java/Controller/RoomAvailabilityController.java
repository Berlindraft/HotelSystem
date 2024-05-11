/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.RoomAvailabilityModel;
import View.RoomAvailability;
import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import test.sumview;
import test.colorview;
/**
 *
 * @author Zyron
 */
public class RoomAvailabilityController {
    private RoomAvailabilityModel model;
    private RoomAvailability mainColorView;
    
    public RoomAvailabilityController(RoomAvailabilityModel model, RoomAvailability view) {
        this.model = model;
        this.mainColorView = view;
    }


    
    
public void updateColors(String roomType) {
    System.out.println(roomType);
    // Retrieve room numbers with the given room type
    List<Integer> roomNumbers = model.getRoomNumbersFromType(roomType);

    // Update colors for the mainColorView based on retrieved room numbers
    for (int roomNumber : roomNumbers) {
        String roomStatus = model.retrieveRoomStatus(roomNumber);
        Color color = getColorForStatus(roomStatus);
        mainColorView.setColor(roomNumber, color);
        System.out.println(roomNumber);
    }
    System.out.println("updating colors");
}

       
private int getRoomNumberFromType(String roomType) {
    RoomAvailabilityModel model = new RoomAvailabilityModel(); // Create an instance of the colormodel class
    List<Integer> roomNumbers = model.getRoomNumbersFromType(roomType);
    if (!roomNumbers.isEmpty()) {
        // Return the first room number in the list (or choose another strategy if needed)
        return roomNumbers.get(0);
    } else {
        // Room type is invalid, return -1
        return -1;
    }
}
//        private String retrieveRoomStatus(int roomNumber) {
//        // Implement your logic to retrieve room status from model
//        return "Available"; // Sample implementation
//    }

    public Color getColorForStatus(String status) {
        return "Available".equals(status) ? Color.GREEN : Color.RED;
    }

}
