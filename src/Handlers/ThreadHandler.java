/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Entities.Client;
import Entities.Comment;
import Entities.Thread;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author Max
 */
public class ThreadHandler extends DefaultHandler  {
      private Vector threadVector;

    public ThreadHandler() {
        threadVector = new Vector();
    }

    public Thread[] getComment() {
      Thread[] threadTab = new Thread[threadVector.size()];
        threadVector.copyInto(threadTab);
        return threadTab;
    }

    String selectedBalise = "";
    Thread seclectedThread;

    public void startElement(String string, String string1, String qName, Attributes atrbts) throws SAXException {
        if (qName.equals("Thread")) {
            seclectedThread= new Thread();
        } else if (qName.equals("id")) {
            selectedBalise = "id";
        } else if (qName.equals("num_comments")) {
            selectedBalise = "num_comments";
        } 
    }

    public void endElement(String string, String string1, String qName) throws SAXException {
        if (qName.equals("Thread")) {

                threadVector.addElement(seclectedThread);
           seclectedThread= null;
        } else if (qName.equals("id")) {
            selectedBalise = "";
        } else if (qName.equals("num_comments")) {
            selectedBalise = "";
        } 
    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (seclectedThread!= null) {
            if (selectedBalise.equals("id")) {
               
              
               seclectedThread.setId(Integer.parseInt(new String(chars, i, i1)));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("num_comments")) {
                 seclectedThread.setId(Integer.parseInt(new String(chars, i, i1)));
                System.out.println(new String(chars, i, i1));
            }
            
        }
    }
    
}
