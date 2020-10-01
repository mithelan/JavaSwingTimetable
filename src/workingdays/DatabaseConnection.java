/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package workingdays;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author M.ANJANAN
 */
 class DbConnection {
     public static void databaseConnection(String query){
         try{
           Class.forName("com.mysql.jdbc.Driver");
           
            Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

           Statement st = conn.createStatement();
          st.execute(query);
        
      
        }
        catch(Exception e ){
            JOptionPane.showMessageDialog(null,e);
        }
    }
     
      public static void deleteQuery(String query){
         try{
           Class.forName("com.mysql.jdbc.Driver");
           
           Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

           Statement st = conn.createStatement();
      st.executeUpdate(query);
        
      
        }
        catch(Exception e ){
            JOptionPane.showMessageDialog(null,e);
        }
    }
     public static ResultSet selectQuery(String query){
         ResultSet results =null;
         try{
           Class.forName("com.mysql.jdbc.Driver");
           
     Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12367729","sql12367729","zWmfRFXCpe");

        Statement statement = conn.createStatement();
 
       results = statement.executeQuery(query);
     
      
        }
        catch(Exception e ){
            JOptionPane.showMessageDialog(null,e);
        }
         return results;}
    
}
