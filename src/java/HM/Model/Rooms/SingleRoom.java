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
public class SingleRoom extends Room{

    public SingleRoom() {
    }

    public SingleRoom(int id) {
        super(id);
    }

    public SingleRoom(int id, String type, String roomno, String acstatus, String roomstatus) {
        super(id, type, roomno, acstatus, roomstatus);
    }
    
    
    
}
