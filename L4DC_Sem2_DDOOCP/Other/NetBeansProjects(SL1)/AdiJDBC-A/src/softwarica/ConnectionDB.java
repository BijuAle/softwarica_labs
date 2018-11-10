
package softwarica;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pawan
 */
public class ConnectionDB {
    
    private final String DB_NAME="adi";
    private final String USERNAME="root";
    private final String PASSWORD="";
    private final String DB_URL="jdbc:mysql://localhost:3306/"+DB_NAME;
    private Connection conn;
    private ResultSet rs;
    private Statement st;
     
    
    public ConnectionDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn =  DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connection success");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            System.out.println("Connection failed");
        }
        
    }
    
    public ResultSet select(String sql){
        try {
            st= conn.createStatement();
            rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
           return null;
        }
    }
    
    public boolean iud(String sql){
        try {
            st= conn.createStatement();
            int res = st.executeUpdate(sql);
            return res>0;
        } catch (SQLException ex) {
            ex.printStackTrace();
           return false;
        }
    }
   
    
    
}
