/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HM.Model.Rooms;

/**
 *
 * @author Raffael
 */
public class DeluxeRoom extends Room{

    public DeluxeRoom() {
    }

    public DeluxeRoom(int id) {
        super(id);
    }

    public DeluxeRoom(int id, String type, String roomno, String acstatus, String roomstatus) {
        super(id, type, roomno, acstatus, roomstatus);
    }
    
}
