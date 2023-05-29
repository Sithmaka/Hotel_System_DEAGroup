package HM.Model.Users;

public class Reception extends User{

    public Reception() {
    }

    public Reception(int id) {
        super(id);
    }

    public Reception(String usermail, String password) {
        super(usermail, password);
    }
    
    public Reception(int id, String usermail, String password) {
        super(id, usermail, password);
    }
    
}
