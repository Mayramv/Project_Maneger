package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Mayra
 */
public class ConnectionFactory {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:/project_manager?useTimezone=true&serverTimezone=UTC";
    public static final String USER = "root";
     public static final String PASS = "123456";
     
   
     
     public static Connection getConnection (){
    try{
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL,USER,PASS);
        
     } catch(Exception ex){
         throw new RuntimeException("erro na conexao com o banco de dados",ex);
         }
         
}
     
     public static void closeConnection(Connection connection){
         try {
             if(connection != null){
                 connection.close();
             }
         } catch (Exception ex) {
             
              throw new RuntimeException("erro ao fechar a conexao com o banco de dados",ex); 
         }
     }
      public static void closeConnection(Connection connection, PreparedStatement statement){
         try {
             if(connection != null){
                 connection.close();
             }
             if (statement != null){
                 statement.close();
             }
         } catch (Exception ex) {
             throw new RuntimeException("erro ao fechar a conexao com o banco de dados",ex); 
         }
     }
       public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet){
         try {
             if(connection != null){
                 connection.close();
             }
             if (statement != null){
                 statement.close();
             }
             if (resultSet != null){
                 resultSet.close();
             }
         } catch (Exception ex) {
             throw new RuntimeException("erro ao fechar a conexao com o banco de dados",ex); 
         }
     }
     }
