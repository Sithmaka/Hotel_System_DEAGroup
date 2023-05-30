package HM.Model.Users;

public class User {
    
    public int id;
    public String username;
    public String usermail;
    public String password;
    public String role;


    public User() {
    }
    
    public User(int id) {
        this.id = id;
    }
    
    public User(String usermail, String password) {
        this.usermail = usermail;
        this.password = password;
    }
    
    public User(String username, String usermail, String password) {
        this.username = username;
        this.usermail = usermail;
        this.password = password;
    }
    
    public User(int id, String usermail, String password){
        this.id = id;
        this.usermail = usermail;
        this.password = password;
    }

    public User(String username, String usermail, String password, String role) {
        this.username = username;
        this.usermail = usermail;
        this.password = password;
        this.role = role;
    }
    

    public User(int id, String username, String usermail, String password) {
        this.id = id;
        this.username = username;
        this.usermail = usermail;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
