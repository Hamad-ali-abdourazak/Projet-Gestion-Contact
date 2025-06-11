/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet_Gestion_Contacts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author bilar
 */
public class ContactDao {
    private Connection con;
     public void AjouterContact(Contact c) throws ClassNotFoundException, SQLException{
                PreparedStatement pst;
                con=Dbservice.getConnection();
           String query="insert into contact (nom , prenom,email,filiere,adresse,telephone ) values(?,?,?,?,?,?)";
              try{
                  pst=con.prepareStatement(query);
                 pst.setString(1,c.getNom());
                 pst.setString(2, c.getPrenom());
                  pst.setString(3, c.getEmail());
                 pst.setString(4, c.getFiliere());
                 pst.setString(5, c.getAdresse());
                 pst.setString(6, c.getTelephone());

                 pst.executeUpdate();
                 pst.close();
                
                  JOptionPane.showMessageDialog(null, "Contact ajouté avec succès!");
              }catch(Exception ex){
                  ex.printStackTrace();
                  
              }
              finally{
                  con.close();
              }
    
}
     
     
     
         public Contact getOneContact(int id_contact) throws SQLException, ClassNotFoundException{
       PreparedStatement pst;
       con=Dbservice.getConnection();
       
      
       String query="select   nom ,prenom ,adresse from etudiant where id=?";
         Contact  contact =new Contact();
           try {
             
               pst=con.prepareStatement(query);
               pst.setInt(1, id_contact);
               ResultSet rs=pst.executeQuery();
               rs.next();
             
             contact.setNom(rs.getString(1));
             contact.setPrenom(rs.getString(2));
             contact.setEmail(rs.getString(3));
             contact.setFiliere(rs.getString(4));
             contact.setTelephone(rs.getString(5));

           rs.close();
               pst.close(); 
             
               
               
           } catch (SQLException ex) {
         
              System.out.println(ex.getMessage());
           }
            finally{
                 con.close();
                 }
      
           return contact;
                      }

     
     public void DeleteEtudiant(int id_contact) throws SQLException, ClassNotFoundException{
      con=Dbservice.getConnection();
      PreparedStatement pst;
      
      String query ="delete from contact where id=?";
      
      try{
          pst=con.prepareStatement(query);
          pst.setInt(1, id_contact);
          pst.executeUpdate();
          pst.close();
         
          JOptionPane.showMessageDialog(null, "contact supprimé avec succès!");

      } catch(SQLException e){
                e.printStackTrace();   
                  }
      finally{
          con.close();
      }
      }

     
      public List<Object[]> getallContacts() throws ClassNotFoundException, SQLException{
     con=Dbservice.getConnection();
     
     String query="select * from contact";
     PreparedStatement pst;
           ResultSetMetaData meta;
     List <Object[]> Contacts=new ArrayList();
     pst=con.prepareStatement(query);
     ResultSet rs=pst.executeQuery();
     meta=rs.getMetaData();
     while(rs.next()){
       Object[] contact=new Object[meta.getColumnCount()];
       for(int i=0;i<contact.length;i++){
      contact[i]=rs.getObject(i+1);
       }
        Contacts.add(contact);
     }
    
     return Contacts;
 }
     
}
