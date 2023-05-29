/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HM.Model.Users;

/**
 *
 * @author Raffael
 */
public class Customer extends User{

    public Customer() {
    }

    public Customer(int id) {
        super(id);
    }
    

    public Customer(String username, String usermail, String password) {
        super(username, usermail, password);
    }

    public Customer(int id, String username, String usermail, String password) {
        super(id, username, usermail, password);
    }
    
}
