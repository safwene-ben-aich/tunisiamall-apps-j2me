/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Entities.Client;
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
public class ClientHandler extends DefaultHandler {
    private Vector clientVector;

    public ClientHandler() {
        clientVector = new Vector();
    }

    public Client[] getClient() {
      Client[] clientTab = new Client[clientVector.size()];
        clientVector.copyInto(clientTab);
        return clientTab;
    }

    String selectedBalise = "";
    Client seclectedClient;

    public void startElement(String string, String string1, String qName, Attributes atrbts) throws SAXException {
        if (qName.equals("Client")) {
            seclectedClient = new Client();
        } else if (qName.equals("ID")) {
            selectedBalise = "ID";
        } else if (qName.equals("LOGIN")) {
            selectedBalise = "LOGIN";
        } 
    }

    public void endElement(String string, String string1, String qName) throws SAXException {
        if (qName.equals("Client")) {

                clientVector.addElement(seclectedClient);
            seclectedClient = null;
        } else if (qName.equals("ID")) {
            selectedBalise = "";
        } else if (qName.equals("LOGIN")) {
            selectedBalise = "";
        } 
    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (seclectedClient != null) {
            if (selectedBalise.equals("ID")) {
                seclectedClient.setId(Integer.parseInt(new String(chars, i, i1)));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("LOGIN")) {
                seclectedClient.setLogin(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
            
        }
    }
}
