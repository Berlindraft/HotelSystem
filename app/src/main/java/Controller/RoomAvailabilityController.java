/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.RoomAvailabilityModel;
import Utils.RoomData;
import Utils.RoomTypeSelectionListener;
import View.RoomAvailability;
import java.awt.Color;
import java.util.List;

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
    System.out.println("Room Type Selected: " + roomType);
    List<Integer> roomNumbers = model.getRoomNumbersFromType(roomType);
    for (int roomNumber : roomNumbers) {
        RoomData roomData = model.retrieveRoomData(roomNumber);
        Color color = getColorForStatus(roomData.status, roomData.count);
        mainColorView.setColor(roomNumber, color);
        System.out.println(roomNumber  + " - " +  roomData.status + " for " + roomData.count + " people");
    }
    System.out.println("Room Availability updated");
}


       
public int getRoomNumberFromType(String roomType) {
    RoomAvailabilityModel model = new RoomAvailabilityModel(); 
    List<Integer> roomNumbers = model.getRoomNumbersFromType(roomType);
    if (!roomNumbers.isEmpty()) {
        return roomNumbers.get(0);
    } else {
        return -1;
    }
}

    public Color getColorForStatus(String status, int roomCount) {
        switch (status) {
            case "Available":
                if (roomCount == 1) {
                    return new Color(144, 238, 144); 
                } else if (roomCount == 2) {
                    return new Color(0, 128, 0);    
                } else if (roomCount == 4) {
                    return new Color(0, 100, 0);   
                }
                break;
            case "Occupied":
                if (roomCount == 1) {
                    return new Color(255, 102, 102);
                } else if (roomCount == 2) {
                    return new Color(255, 0, 0);  
                } else if (roomCount == 4) {
                    return new Color(204, 0, 0);     
                }
                break;
            case "Reserved":
                if (roomCount == 1) {
                    return new Color(255, 255, 153); 
                } else if (roomCount == 2) {
                    return new Color(255, 255, 51);
                } else if (roomCount == 4) {
                    return new Color(204, 204, 0); 
                }
                break;
            default:
                return Color.GRAY; // Default for undefined status
        }
        return Color.GRAY; // Safe fallback if no conditions are met
    }

}
