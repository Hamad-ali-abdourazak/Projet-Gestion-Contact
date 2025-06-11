/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet_Gestion_Contacts;

import java.sql.SQLException;

/**
 *
 * @author bilar
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        Dbservice db=new Dbservice();
        db.getConnection();
        
        ContactDao cdao=new ContactDao();
        
        Contact c=new Contact();
        c.setNom("ali");
        c.setPrenom("said");
        c.setEmail("@gmail.com");
        c.setFiliere("GI");
        
        c.setAdresse("Q34");
        c.setTelephone("66778899");
        cdao.AjouterContact(c);
 
      

        // TODO code application logic here
    }
    
}
