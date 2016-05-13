/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Entities.Comment;
import Entities.Produit;
import Handlers.CommentHandler;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
/**
 *
 * @author Max
 */
public class ThreadDAO {
 Thread[] threads;
     public  boolean select(int idp){
       try {
          
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/phpTunisiaMall/selectidthread.php?idp="+idp);//people.xml est un exemple
           System.out.println("http://localhost/phpTunisiaMall/selectidthread.php?idp="+idp);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
           StringBuffer sb = new StringBuffer();
           int ch;
            while ((ch = dis.read())!=-1) {
                sb.append((char)ch); 
           
            }
             // System.out.println("resultaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaat"+sb.toString().trim());
            if (sb.toString().trim().equals("success")) {
                return true;
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
   }
  
     
     
      public boolean update(int idp){
        try {
            HttpConnection hc = (HttpConnection)Connector.open("http://localhost/phpTunisiaMall/updatethread.php?idp="+idp);
          // System.out.println("http://localhost/phpTunisiaMall/insert.php?Nom="+client.getNom()+"&login="+client.getLogin()+"&email="+client.getEmail()+"&prenom="+client.getPrenom()+"&password="+client.getPassword()+"&adresse="+client.getAdresse()+"&sexe="+client.getSexe());
            System.out.println("http://localhost/phpTunisiaMall/updatethread.php?idp="+idp);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
           StringBuffer sb = new StringBuffer();
           int ch;
            while ((ch = dis.read())!=-1) {
                sb.append((char)ch); 
           
            }
             // System.out.println("resultaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaat"+sb.toString().trim());
            if (sb.toString().trim().equals("success")) {
                return true;
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
     public boolean add(int id){
        try {
             String permalink= "http://localhost/TunisiaMallLebes/web/app_dev.php/produits/".concat(Integer.toString(id));
            HttpConnection hc = (HttpConnection)Connector.open("http://localhost/phpTunisiaMall/addthread.php?id="+id+"&permalink="+permalink);
          // System.out.println("http://localhost/phpTunisiaMall/insert.php?Nom="+client.getNom()+"&login="+client.getLogin()+"&email="+client.getEmail()+"&prenom="+client.getPrenom()+"&password="+client.getPassword()+"&adresse="+client.getAdresse()+"&sexe="+client.getSexe());
            System.out.println("http://localhost/phpTunisiaMall/addthread.php?id="+id+"&permalink="+permalink);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
           StringBuffer sb = new StringBuffer();
           int ch;
            while ((ch = dis.read())!=-1) {
                sb.append((char)ch); 
           
            }
             // System.out.println("resultaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaat"+sb.toString().trim());
            if (sb.toString().trim().equals("success")) {
                return true;
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
     
     
     
}
