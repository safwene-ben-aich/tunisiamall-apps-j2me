/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import DAO.ClientDAO;
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
public class ListProduits extends List implements CommandListener,Runnable{

    Command cmdExit = new Command("Back", Command.BACK, 0);
      Command cmdres = new Command("Consulter mes reservations", Command.SCREEN, 0);
      Command cmdmail = new Command("Envoyer un mail", Command.SCREEN, 0);
      Command cmdlistmarquescartes = new Command("Visualiser mes cartes fidelité", Command.SCREEN, 0);
Client client;
int idmarque;
    public ListProduits(Client client, int idmarque) {
        super("Liste Produits", List.IMPLICIT);
       this.client=client;
       this.idmarque=idmarque;
        addCommand(cmdExit);
        setCommandListener(this);
        addCommand(cmdres);
        addCommand(cmdmail);
        addCommand(cmdlistmarquescartes);
        Thread th = new Thread(this);
        th.start();
        
    }

   
    
  
    public void commandAction(Command c, Displayable d) {
        if (c == cmdExit) {
         Midlet.INSTANCE.disp.setCurrent( new ListMarques(client));
        }
        
          if (c == List.SELECT_COMMAND) {
        Produit[] produits = new ProduitDAO().select(idmarque);
            Produit produit=produits[this.getSelectedIndex()];
            Midlet.INSTANCE.disp.setCurrent(new affichprod("produit",produit,client,idmarque));

        }
        if (c== cmdres){
    Client[] cli= new ClientDAO().select(client);
      
    System.out.println("theeeee cliennnnnnt"+cli[0]);
    Midlet.INSTANCE.disp.setCurrent(new listReservations(cli[0],idmarque));
    
    }
        if (c==cmdmail){
        Midlet.INSTANCE.disp.setCurrent(new Mail("Mail",client));
        }
        if (c== cmdlistmarquescartes){
        
          Midlet.INSTANCE.disp.setCurrent(new ListeMarquescartes(client));
        
        }
        
    }

    public void run() {
        
        Produit[] produits = new ProduitDAO().select(idmarque);
        if (produits.length > 0) {
            for (int i = 0; i < produits.length; i++) {
               Image Img = null;
                try {
                    String nomphoto=produits[i].getPhoto();
                    nomphoto="/".concat(nomphoto);
                    Img = Image.createImage(nomphoto);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                append(produits[i].getNom(), null);
            }
        }
    }
}
