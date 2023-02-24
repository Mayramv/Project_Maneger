/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import util.ConnectionFactory;
/**
 *
 * @author Mayra
 */
public class Main {

    
    public static void main(String[] args) throws SQLException {

      
       
          Connection c = ConnectionFactory.getConnection();
        
        ConnectionFactory.closeConnection(c);
        
        System.out.println("abrindo");
        
    }
    
}
