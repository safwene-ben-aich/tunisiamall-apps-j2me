/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Entities.CarteFidelite;
import Entities.Marque;
import Entities.Responsable;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Fatma
 */
public class CarteFideliteHandler extends DefaultHandler {
    private Vector cartefideliteVector;

    public CarteFideliteHandler() {
        cartefideliteVector = new Vector();
    }

    public CarteFidelite[] getCarte() {
        CarteFidelite[] cartefideliteTab = new CarteFidelite[cartefideliteVector.size()];
        cartefideliteVector.copyInto(cartefideliteTab);
        return cartefideliteTab;
    }

    String selectedBalise = "";
    CarteFidelite seclectedCarte;

    public void startElement(String string, String string1, String qName, Attributes atrbts) throws SAXException {
        if (qName.equals("Carte")) {
            seclectedCarte = new CarteFidelite();
        } else if (qName.equals("NOMBRE_POINT")) {
            selectedBalise = "NOMBRE_POINT";
        } else if (qName.equals("ID_MARQUE")) {
            selectedBalise = "ID_MARQUE";
        } else if (qName.equals("NOM")) {
            selectedBalise = "NOM";
        } 
    }

    public void endElement(String string, String string1, String qName) throws SAXException {
        if (qName.equals("Carte")) {

            cartefideliteVector.addElement(seclectedCarte);
            seclectedCarte= null;
        } else if (qName.equals("NOMBRE_POINT")) {
            selectedBalise = "";
        } else if (qName.equals("ID_MARQUE")) {
            selectedBalise = "";
        } else if (qName.equals("NOM")) {
            selectedBalise = "";
        } 
        
        
    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (seclectedCarte != null) {
            if (selectedBalise.equals("NOMBRE_POINT")) {
                seclectedCarte.setNbPoint(Integer.parseInt(new String(chars, i, i1)));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("ID_MARQUE")) {
                Marque marque= new Marque();
                seclectedCarte.setMarque(marque);
                seclectedCarte.getMarque().setId(Integer.parseInt(new String(chars, i, i1)));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("NOM")) {
                Marque marque= new Marque();
                seclectedCarte.setMarque(marque);
                seclectedCarte.getMarque().setNom(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
            
        }
    }
}
