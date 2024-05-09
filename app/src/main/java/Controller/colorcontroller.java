/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.colormodel;
import java.awt.Color;
import java.util.List;
import test.sumview;
import test.colorview;
/**
 *
 * @author Zyron
 */
public class colorcontroller {
    private colormodel model;
    private colorview roomA;

    public colorcontroller(colormodel model, colorview roomA) {
        this.model = model;
        this.roomA = roomA;
    }

    
    
       public void updateColor(String roomType) {
        // You need to define how roomType maps to roomNumber
        int roomNumber = getRoomNumberFromType(roomType);
        if (roomNumber != -1) {
            String status = model.retrieveRoomStatus(roomNumber);
            Color color;
            if ("Available".equals(status)) {
                color = Color.GREEN;
            } else {
                color = Color.RED;
            }
            roomA.setColor(color);
            System.out.println("Room color updated");
        } else {
            System.out.println("Invalid room type");
        }
    }
       
private int getRoomNumberFromType(String roomType) {
    colormodel model = new colormodel(); // Create an instance of the colormodel class
    List<Integer> roomNumbers = model.getRoomNumbersFromType(roomType);
    if (!roomNumbers.isEmpty()) {
        // Return the first room number in the list (or choose another strategy if needed)
        return roomNumbers.get(0);
    } else {
        // Room type is invalid, return -1
        return -1;
    }
}

}
