/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet_Gestion_Contacts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bilar
 */
public class Dbservice {
    
      
    private static String url ="jdbc:mysql://localhost:3306/gestion_contacts";
    private static String username="root";
    private static String password="";

    public Dbservice() {
    }

   
    
    
    
    public static Connection getConnection() throws ClassNotFoundException , SQLException{
        Connection connection=null;
        connection=DriverManager.getConnection(url,username,password);
        System.out.println("connection etablie avec succès!");
        return connection;
        
    }
    
}
