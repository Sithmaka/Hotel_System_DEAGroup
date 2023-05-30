package HM.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    public static Connection getCon() throws SQLException, ClassNotFoundException{
        
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/HMS";
            return DriverManager.getConnection(url, "root", "");
    }
    
}
