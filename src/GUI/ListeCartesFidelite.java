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
public class ListeCartesFidelite extends List implements CommandListener,Runnable{

    Command cmdExit = new Command("Exit", Command.EXIT, 0);
Client client;
Marque marque;
    public ListeCartesFidelite(Client client, Marque marque) {
        super("Detail carte", List.IMPLICIT);
       this.client=client;
       this.marque=marque;
        addCommand(cmdExit);
        setCommandListener(this);
        Thread th = new Thread(this);
        th.start();
        
    }

   
    
  
    public void commandAction(Command c, Displayable d) {
        if (c == cmdExit) {
            Midlet.INSTANCE.notifyDestroyed();
        }
    }

    public void run() {
          CarteFidelite[] cartes= new CarteFideliteDAO().selectMarqueCarte(client, marque);
        if (cartes.length > 0) {
            for (int i = 0; i < cartes.length; i++) {
                append("Nombre de points :"+cartes[i].getNbPoint(), null);
            }
        }
    }
}
