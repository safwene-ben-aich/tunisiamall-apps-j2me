/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Entities.Client;
import Entities.Comment;
import Entities.Commentaire;
import Entities.Panier;
import Entities.Produit;
import Handlers.ClientHandler;
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
public class CommentDAO {
   Comment[] comments;
     public  Comment[] select(Produit produit){
       try {
           CommentHandler commentHandler = new CommentHandler();
            // get a parser object
            SAXParser SAXparser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/phpTunisiaMall/selectcommentaires.php?idp="+produit.getId());//people.xml est un exemple
           System.out.println("http://localhost/phpTunisiaMall/selectcommentaires.php?idp="+produit.getId());
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            SAXparser.parse(dis, commentHandler);
            // display the result
            comments= commentHandler.getComment();
       
             return comments;
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

             return null;
   }
     
     
     
       public boolean insert(Comment comment){
        try {
            HttpConnection hc = (HttpConnection)Connector.open("http://localhost/phpTunisiaMall/insertcommentaire.php?idclient="+comment.getAuthor().getId()+"&id="+comment.getThread().getId()+"&commentaire="+comment.getBody());
          // System.out.println("http://localhost/phpTunisiaMall/insert.php?Nom="+client.getNom()+"&login="+client.getLogin()+"&email="+client.getEmail()+"&prenom="+client.getPrenom()+"&password="+client.getPassword()+"&adresse="+client.getAdresse()+"&sexe="+client.getSexe());
            System.out.println("http://localhost/phpTunisiaMall/insertcommentaire.php?idclient="+comment.getAuthor().getId()+"&idp="+comment.getThread().getId()+"&commentaire="+comment.getBody());
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
