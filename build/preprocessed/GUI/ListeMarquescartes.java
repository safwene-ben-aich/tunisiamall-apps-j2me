/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import DAO.CarteFideliteDAO;
import DAO.MarqueDAO;
import Entities.CarteFidelite;
import Entities.Client;
 import Entities.Marque;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.List;

/**
 *
 * @author dali
 */
public class ListeMarquescartes extends List implements CommandListener,Runnable{

    Command cmdExit = new Command("Exit", Command.EXIT, 0);
 Client client ;
 
    public ListeMarquescartes(Client client) {
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
        if (c==List.SELECT_COMMAND){
//            Client client=new Client();
//         client.setLogin("1111");
            Marque[] marques= new MarqueDAO().selectMarqueCarte(client);
            Marque marque=marques[this.getSelectedIndex()];
//      client.setLogin("1111");
        Midlet.INSTANCE.disp.setCurrent(new ListeCartesFidelite(client,marque));
        
        
        }
    }

    public void run() {
        client.setLogin("1111");
        Marque[] marques = new MarqueDAO().selectMarqueCarte(client);
        if (marques.length > 0) {
            for (int i = 0; i < marques.length; i++) {
                append(marques[i].getNom(), null);
            }
        }
    }
}
