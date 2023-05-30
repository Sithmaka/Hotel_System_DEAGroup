package HM.Model.Users;


public class Admin extends User{
      
    public Admin() {
    }

    public Admin(String usermail, String password) {
        super(usermail, password);
    }

    public Admin(int id, String usermail, String password) {
        super(id, usermail, password);
    }
    
    
}
