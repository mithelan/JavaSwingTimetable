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
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author M.ANJANAN
 */
 class DatabaseConnection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many days u want to add?");
        int numberOfDays = sc.nextInt();
    }
    
    
    public static void databaseConnection(String query){
         try{
           Class.forName("com.mysql.jdbc.Driver");
           
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spm","root","");
 
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery(query);
        
      
        }
        catch(Exception e ){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
}
