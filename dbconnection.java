
import java.sql.*;

public class dbconnection {
    static final String url="jdbc:mysql://localhost:3306/flames";
    static final String uname="root";
    static final String pass="1234";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, uname, pass);
    }
}
