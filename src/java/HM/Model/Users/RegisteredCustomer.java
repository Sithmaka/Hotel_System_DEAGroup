package HM.Model.Users;

public class RegisteredCustomer extends User{

    
    
    public RegisteredCustomer(String username, String usermail, String password) {
        super(username, usermail, password);
    }

    public RegisteredCustomer(String username, String usermail, String password, String role) {
        super(username, usermail, password, role);
    }
        
    
}
