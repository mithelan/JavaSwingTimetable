/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ASUS
 */
public class ConnectionClass {
     public Connection connection;

    public Connection getConnection(){
        String dbName="spm";
        String userName="root";
        String password="";


        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection=DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }


}
