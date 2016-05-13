/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Marque;
import Entities.Produit;
import Handlers.MarqueHandler;
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
 * @author Fatma
 */
public class ProduitDAO {
    
     
   Produit[] Produits;
    
    
    
   
//   public Produit[] select(){
//       try {
//            ProduitHandler produitHandler = new ProduitHandler();
//            // get a parser object
//            SAXParser SAXparser = SAXParserFactory.newInstance().newSAXParser();
//            // get an InputStream from somewhere (could be HttpConnection, for example)
//            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/phpTunisiaMall/selectProduit.php");//people.xml est un exemple
//            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
//            SAXparser.parse(dis, produitHandler);
//            // display the result
//            Produits= produitHandler.getProduit();
//             return Produits;
//        } catch (ParserConfigurationException ex) {
//            ex.printStackTrace();
//        } catch (SAXException ex) {
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//
//             return null;
//   }
//    
//    
   public Produit[] select(int idmarque){
       try {
            ProduitHandler produitHandler = new ProduitHandler();
            // get a parser object
            SAXParser SAXparser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/phpTunisiaMall/selectProduit.php?idm="+idmarque);//people.xml est un exemple
            System.out.println("http://localhost/phpTunisiaMall/selectProduit.php?idm="+idmarque);
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
