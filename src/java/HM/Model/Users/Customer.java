package HM.Model.Users;

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
