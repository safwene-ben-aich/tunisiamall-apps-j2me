/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.CarteFidelite;
import Entities.Client;
import Entities.Marque;
import Handlers.CarteFideliteHandler;
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
public class CarteFideliteDAO {
     CarteFidelite[] cartes;
    public CarteFidelite[] selectMarqueCarte(Client client,Marque marque){
       try {
            CarteFideliteHandler CarteFideliteHandler = new CarteFideliteHandler();
            // get a parser object
            SAXParser SAXparser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/pidev/selectcarte.php?login="+client.getLogin()+"&marque="+marque.getId());//people.xml est un exemple
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            SAXparser.parse(dis, CarteFideliteHandler);
            // display the result
            cartes= CarteFideliteHandler.getCarte();
             return cartes;
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
