/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;
import Entities.Client;
import Entities.Comment;

import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author Max
 */
public class CommentHandler extends DefaultHandler  {
      private Vector commentVector;

    public CommentHandler() {
        commentVector = new Vector();
    }

    public Comment[] getComment() {
      Comment[] commentaireTab = new Comment[commentVector.size()];
        commentVector.copyInto(commentaireTab);
        return commentaireTab;
    }

    String selectedBalise = "";
    Comment seclectedCommentaire;

    public void startElement(String string, String string1, String qName, Attributes atrbts) throws SAXException {
        if (qName.equals("Comment")) {
            seclectedCommentaire= new Comment();
        } else if (qName.equals("username")) {
            selectedBalise = "username";
        } else if (qName.equals("body")) {
            selectedBalise = "body";
        } 
    }

    public void endElement(String string, String string1, String qName) throws SAXException {
        if (qName.equals("Comment")) {

                commentVector.addElement(seclectedCommentaire);
            seclectedCommentaire = null;
        } else if (qName.equals("username")) {
            selectedBalise = "";
        } else if (qName.equals("body")) {
            selectedBalise = "";
        } 
    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (seclectedCommentaire != null) {
            if (selectedBalise.equals("username")) {
                Client c=new Client();
               seclectedCommentaire.setAuthor(c);
               seclectedCommentaire.getAuthor().setLogin(new String(chars, i, i1));
              
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("body")) {
                seclectedCommentaire.setBody(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
            
        }
    }
    
}
