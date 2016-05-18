/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Client;
import Entities.Panier;
import Entities.Produit;
import Handlers.ProduitHandler;
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
public class PanierDAO {
    Produit[] Produits;
     public boolean insert(Panier panier){
        try {
            HttpConnection hc = (HttpConnection)Connector.open("http://localhost/phpTunisiaMall/insertpanier.php?idclient="+panier.getClient().getId()+"&idp="+panier.getProduit().getId()+"&quantite="+panier.getQuantite());
          // System.out.println("http://localhost/phpTunisiaMall/insert.php?Nom="+client.getNom()+"&login="+client.getLogin()+"&email="+client.getEmail()+"&prenom="+client.getPrenom()+"&password="+client.getPassword()+"&adresse="+client.getAdresse()+"&sexe="+client.getSexe());
            System.out.println("http://localhost/phpTunisiaMall/insertpanier.php?idclient="+panier.getClient().getId()+"&idp="+panier.getProduit().getId()+"&quantite="+panier.getQuantite());
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
     
     
     
     
     
       
   public Produit[] select(Client client){
       try {
            ProduitHandler produitHandler = new ProduitHandler();
            // get a parser object
            SAXParser SAXparser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/scripts_php/phpTunisiaMall/selectproduitpanier.php?idc="+client.getId());//people.xml est un exemple
            System.out.println("http://localhost/phpTunisiaMall/scripts_php/selectproduitpanier.php?idc="+client.getId());
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            SAXparser.parse(dis, produitHandler);
            // display the result
            Produits= produitHandler.getProduit();
             return Produits;
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
