import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBClass{
    public Connection Connect(){
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String user = "root";
            String passvord = "skeuSnfg48bN-httr";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, passvord);
            return conn;
        } catch (ClassNotFoundException | SQLException ex){
            Logger.getLogger(DBClass.class.getName()).log(Level.SEVERE, null, ex);
        }

        return  null;
    }

}