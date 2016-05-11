/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Entities.Marque;
import Entities.Produit;
import Entities.Responsable;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Fatma
 */
public class ProduitHandler extends DefaultHandler {
    private Vector produitVector;

    public ProduitHandler() {
        produitVector = new Vector();
    }

    public Produit[] getProduit() {
        Produit[] produitTab = new Produit[produitVector.size()];
        produitVector.copyInto(produitTab);
        return produitTab;
    }

    String selectedBalise = "";
   Produit seclectedProduit;

    public void startElement(String string, String string1, String qName, Attributes atrbts) throws SAXException {
        if (qName.equals("Produit")) {
            seclectedProduit = new Produit();
        } else if (qName.equals("ID")) {
            selectedBalise = "ID";
        } 
        else if (qName.equals("REFERENCE")) {
            selectedBalise = "REFERENCE";
        } else if (qName.equals("ID_MARQUE")) {
            selectedBalise = "ID_MARQUE";
        } else if (qName.equals("NOM")) {
            selectedBalise = "NOM";
        }
        
          else if (qName.equals("TYPE")) {
            selectedBalise = "TYPE";
        }
          else if (qName.equals("PRIX")) {
            selectedBalise = "PRIX";
        }
        else if (qName.equals("PHOTO")) {
            selectedBalise = "PHOTO";
        }
       
        
    }

    public void endElement(String string, String string1, String qName) throws SAXException {
        if (qName.equals("Produit")) {

            produitVector.addElement(seclectedProduit);
            seclectedProduit = null;
        } else if (qName.equals("ID")) {
            selectedBalise = "";
        } else if (qName.equals("REFERENCE")) {
            selectedBalise = "";
        } else if (qName.equals("ID_MARQUE")) {
            selectedBalise = "";
        } else if (qName.equals("NOM")) {
            selectedBalise = "";
        }
        else if (qName.equals("TYPE")) {
            selectedBalise = "";
        }
         else if (qName.equals("PRIX")) {
            selectedBalise = "";
        }
        
         else if (qName.equals("PHOTO")) {
            selectedBalise = "";
        }
        
    
    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (seclectedProduit != null) {
            if (selectedBalise.equals("ID")) {
                seclectedProduit.setId(Integer.parseInt(new String(chars, i, i1)));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("REFERENCE")) {
                seclectedProduit.setReference(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("ID_MARQUE")) {
                Marque m= new Marque();
                seclectedProduit.setMarque(m);
                seclectedProduit.getMarque().setId(Integer.parseInt(new String(chars, i, i1)));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("NOM")) {
               
                seclectedProduit.setNom(new String(chars, i, i1));
               
                System.out.println(new String(chars, i, i1));
            }
               if (selectedBalise.equals("TYPE")) {
                 seclectedProduit.setType(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
                if (selectedBalise.equals("PRIX")) {
                 seclectedProduit.setPrix(Float.parseFloat(new String(chars, i, i1)));
                System.out.println(new String(chars, i, i1));
            }
               
                if (selectedBalise.equals("PHOTO")) {
                seclectedProduit.setPhoto(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
                 
        }
    }
}
