/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

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
public class MarqueHandler extends DefaultHandler {
    private Vector marqueVector;

    public MarqueHandler() {
        marqueVector = new Vector();
    }

    public Marque[] getMarque() {
        Marque[] marqueTab = new Marque[marqueVector.size()];
        marqueVector.copyInto(marqueTab);
        return marqueTab;
    }

    String selectedBalise = "";
    Marque seclectedMarque;

    public void startElement(String string, String string1, String qName, Attributes atrbts) throws SAXException {
        if (qName.equals("Marque")) {
            seclectedMarque = new Marque();
        } else if (qName.equals("ID")) {
            selectedBalise = "ID";
        } else if (qName.equals("Nom")) {
            selectedBalise = "Nom";
        } else if (qName.equals("seuilAchat")) {
            selectedBalise = "seuilAchat";
        } else if (qName.equals("ID_RESPONSABLE")) {
            selectedBalise = "ID_RESPONSABLE";
        }
//        else if (qName.equals("image_marque")) {
//            selectedBalise = "image_marque";
//        }
    }

    public void endElement(String string, String string1, String qName) throws SAXException {
        if (qName.equals("Marque")) {

            marqueVector.addElement(seclectedMarque);
            seclectedMarque = null;
        } else if (qName.equals("ID")) {
            selectedBalise = "";
        } else if (qName.equals("Nom")) {
            selectedBalise = "";
        } else if (qName.equals("seuilAchat")) {
            selectedBalise = "";
        } else if (qName.equals("ID_RESPONSABLE")) {
            selectedBalise = "";
        }
//        else if (qName.equals("image_marque")) {
//            selectedBalise = "";
//        }
        
    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (seclectedMarque != null) {
            if (selectedBalise.equals("ID")) {
                seclectedMarque.setId(Integer.parseInt(new String(chars, i, i1)));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("Nom")) {
                seclectedMarque.setNom(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("seuilAchat")) {
                seclectedMarque.setSeuilAchat(Float.parseFloat(new String(chars, i, i1)));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("ID_RESPONSABLE")) {
                Responsable r=new Responsable();
                seclectedMarque.setResponsable(r);
                seclectedMarque.getResponsable().setId(Integer.parseInt(new String(chars, i, i1)));
               
                System.out.println(new String(chars, i, i1));
            }
//               if (selectedBalise.equals("image_marque")) {
//                seclectedMarque.setPhoto(new String(chars, i, i1));
//                System.out.println(new String(chars, i, i1));
//            }
        }
    }
}
