
package hotel.wizard.dbconnection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBHandler {

    Connection dbconnection;
    
    public Connection getConnection() throws SQLException{
        
        String dbdriver = "com.msyql.jdbc.Driver";
        String dbhost = "jdbc:mysql://localhost:3306/hotel";
        String dbuser = "root";
        String dbpass = "123456";
        
        try {
            Class.forName(dbdriver);
        } catch (ClassNotFoundException e) {
        }
        
        try {
            dbconnection = (Connection) DriverManager.getConnection(dbhost, dbuser, dbpass);
            System.out.println("Koneksi Berhasil");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return dbconnection;
    }
    
}
