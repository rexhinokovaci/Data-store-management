
package compap;

import java.sql.*;
import javax.swing.JOptionPane;


public class Compap {

Connection conn;    
    
    
    public static Connection ConnectDb () {
       
        try {
            Class.forName ("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db22", "root", "1234");
            
            return con;       
        } // end of try 
        catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
            return null;
        }//end of catch
        
        
    } // end of method

} // end of compap class
