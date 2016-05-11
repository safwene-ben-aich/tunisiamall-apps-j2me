/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Entities.Client;
import Entities.Commentaire;
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
public class CommentaireHandler extends DefaultHandler {
    private Vector commentaireVector;

    public CommentaireHandler() {
        commentaireVector = new Vector();
    }

    public Commentaire[] getCommentaire() {
      Commentaire[] commentaireTab = new Commentaire[commentaireVector.size()];
        commentaireVector.copyInto(commentaireTab);
        return commentaireTab;
    }

    String selectedBalise = "";
    Commentaire seclectedCommentaire;

    public void startElement(String string, String string1, String qName, Attributes atrbts) throws SAXException {
        if (qName.equals("Commentaire")) {
            seclectedCommentaire= new Commentaire();
        } else if (qName.equals("login")) {
            selectedBalise = "login";
        } else if (qName.equals("commentaire")) {
            selectedBalise = "commentaire";
        } 
    }

    public void endElement(String string, String string1, String qName) throws SAXException {
        if (qName.equals("Commentaire")) {

                commentaireVector.addElement(seclectedCommentaire);
            seclectedCommentaire = null;
        } else if (qName.equals("login")) {
            selectedBalise = "";
        } else if (qName.equals("commentaire")) {
            selectedBalise = "";
        } 
    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (seclectedCommentaire != null) {
            if (selectedBalise.equals("login")) {
                Client c=new Client();
               seclectedCommentaire.setClient(c);
               seclectedCommentaire.getClient().setLogin(new String(chars, i, i1));
              
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("commentaire")) {
                seclectedCommentaire.setDescription(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
            
        }
    }
}
