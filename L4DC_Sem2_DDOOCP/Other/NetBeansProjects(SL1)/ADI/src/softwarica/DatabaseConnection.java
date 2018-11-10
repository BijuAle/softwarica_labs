
package softwarica;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.pkcs11.Secmod;

public class DatabaseConnection {
    
    private final String DB_NAME="adi";
    private final String USERNAME="root";
    private final String PASSWORD="";
    private final String DB_URL="jdbc:mysql://localhost:3306/"+DB_NAME;
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    
    public DatabaseConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected to Database");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ResultSet select(String sql){
        try {
            st= conn.createStatement();
            rs= st.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        
    }
    
    
    public static void main(String[] args) {
        try {
            DatabaseConnection myclass=   new DatabaseConnection();
            String sql="select * from student";
            ResultSet data= myclass.select(sql);
            
            while(data.next()){
                
                System.out.println(data.getString(1));
                System.out.println(data.getString(2));
                System.out.println(data.getString(3));
            }  
        } catch (SQLException ex) {
            System.out.println("Error getting data");
            ex.printStackTrace();
        }
     
    }
    
    
    
}
