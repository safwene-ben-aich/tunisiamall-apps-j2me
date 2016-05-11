/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import DAO.MarqueDAO;
import DAO.ProduitDAO;
import Entities.Client;
 import Entities.Marque;
import Entities.Produit;
import java.io.IOException;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.List;

/**
 *
 * @author dali
 */
public class ListMarques extends List implements CommandListener,Runnable{

    Client client;
    Command cmdExit = new Command("Exit", Command.EXIT, 0);
        StringBuffer sb;
    public ListMarques(Client client) {
        super("Liste Marques", List.IMPLICIT);
       this.client=client;
        addCommand(cmdExit);
        setCommandListener(this);
        Thread th = new Thread(this);
        th.start();
        
    }

   
    
  
    public void commandAction(Command c, Displayable d) {
        if (c == cmdExit) {
            Midlet.INSTANCE.notifyDestroyed();
        }
          if (c == List.SELECT_COMMAND) {
        Marque[] marques = new MarqueDAO().select();
            Marque marque=marques[this.getSelectedIndex()];
            Midlet.INSTANCE.disp.setCurrent(new ListProduits(client,marque.getId()));

        }
       //Midlet.INSTANCE.disp.setCurrent(alertsuccess, new ListProduits(client));
        
    }

    public void run() {
        Marque[] marques = new MarqueDAO().select();
        if (marques.length > 0) {
            for (int i = 0; i < marques.length; i++) {
                Image im = null;
                try {
                    im = Image.createImage("/img/microsoft.png");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                append(marques[i].getNom(), im);
            }
        }
    }
    
}


