/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import DAO.ClientDAO;
import DAO.PanierDAO;
import DAO.ProduitDAO;
import Entities.Client;
import Entities.Panier;
import Entities.Produit;
import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemCommandListener;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.StringItem;
/**
 *
 * @author Max
 */
class listReservations  extends Form implements CommandListener,Runnable, ItemCommandListener{
Image Img = null;
StringItem sinom=new StringItem("Nom", null);
   Command cmdExit = new Command("Back", Command.EXIT, 0);
      //Command cmdres = new Command("Consulter mes reservations", Command.SCREEN, 0);
Client client;
int idmarque;
    public listReservations(Client client) {
        super("Liste Reservations");
       this.client=client;
       
        addCommand(cmdExit);
        setCommandListener(this);
        Thread th = new Thread(this);
        th.start();
        
    }
   
    
  
    public void commandAction(Command c, Displayable d) {
        if (c == cmdExit) {
            Midlet.INSTANCE.disp.setCurrent(new ChoixClientCanvas(client));
        }
        
         
        
    }
    public void run() {
        Client[] cli= new ClientDAO().select(client);
      
    System.out.println("theeeee cliennnnnnt"+cli[0]);
      Produit[] produits= new PanierDAO().select(cli[0]);
        if (produits.length > 0) {
            for (int i = 0; i < produits.length; i++) {
              
                
                
             
                
               
                try {
                    String nomphoto=produits[i].getPhoto();
                    nomphoto="/".concat(nomphoto);
                    Img = Image.createImage(nomphoto);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                append(Img);
                 sinom.setText(produits[i].getNom());
                   
//                   append(sinom);
//                    append(produits[i].getReference());
            }
        }
    }
    public void commandAction(Command c, Item item) {
            Client[] cli= new ClientDAO().select(client);
           Produit[] produits= new PanierDAO().select(cli[0]); 
        if (item== sinom){
            System.out.println(sinom.getText());
        
        }
    
    }
    
}