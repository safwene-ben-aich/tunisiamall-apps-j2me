/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Client;
import Entities.Marque;
import Handlers.ClientHandler;
import Handlers.MarqueHandler;
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
 * @author Fatma
 */
public class ClientDAO {
    
       Client[] Clients;
    
     public boolean insert(Client client){
        try {
            HttpConnection hc = (HttpConnection)Connector.open("http://localhost/phpTunisiaMall/insert.php?Nom="+client.getNom()+"&login="+client.getLogin()+"&email="+client.getEmail()+"&prenom="+client.getPrenom()+"&password="+client.getPassword()+"&adresse="+client.getAdresse()+"&sexe="+client.getSexe());
            System.out.println("http://localhost/phpTunisiaMall/insert.php?Nom="+client.getNom()+"&login="+client.getLogin()+"&email="+client.getEmail()+"&prenom="+client.getPrenom()+"&password="+client.getPassword()+"&adresse="+client.getAdresse()+"&sexe="+client.getSexe());
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
           StringBuffer sb = new StringBuffer();
           int ch;
            while ((ch = dis.read())!=-1) {
                sb.append((char)ch);                
            }
            if (sb.toString().trim().equals("success")) {
                return true;
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
     
     public  Client[] select(Client client){
       try {
           ClientHandler clientHandler = new ClientHandler();
            // get a parser object
            SAXParser SAXparser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/scripts_php/phpTunisiaMall/selectclient.php?login="+client.getLogin());//people.xml est un exemple
           System.out.println("http://localhost/scripts_php/phpTunisiaMall/selectclient.php?login="+client.getLogin());
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            SAXparser.parse(dis, clientHandler);
            // display the result
            Clients= clientHandler.getClient();
            System.out.println("L'ID du CLIENT = "+this.Clients[0].getId());
             return Clients;
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

             return null;
   }
    
    
}
