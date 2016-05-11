/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.ProduitSafwene;
import Handlers.ProduitHandlerSafwene;
import java.io.DataInputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author Safwene
 */
public class ProduitListSafwene extends Form implements CommandListener, Runnable{

    private Command commandBack;
    
    private ProduitSafwene[] produits;
    private List listProduit;
    
    
    
    
    public ProduitListSafwene(){
        super ("List des produits");
        this.prepareForm();
    }
    public void prepareForm(){
        this.commandBack = new Command("Back", commandBack.SCREEN, 0);
        this.listProduit = new List("list Produits", listProduit.IMPLICIT);
        this.listProduit.addCommand(this.commandBack);
        this.listProduit.setCommandListener(this);
        Thread th = new Thread(this);
        th.start();
   }
    
    
    
    public void commandAction(Command command, Displayable displayable) {
        
        if (command == this.commandBack){
            Midlet.INSTANCE.disp.setCurrent(new ChoixFormSafwene());
        }
        
        else if (command == List.SELECT_COMMAND) {

                    ProduitSafwene produit = new ProduitSafwene();

                    produit.setId(this.produits[this.listProduit.getSelectedIndex()].getId());
                    produit.setReference(this.produits[this.listProduit.getSelectedIndex()].getReference());
                    produit.setNom(this.produits[this.listProduit.getSelectedIndex()].getNom());
                    produit.setType(this.produits[this.listProduit.getSelectedIndex()].getType());
                    produit.setPrix(this.produits[this.listProduit.getSelectedIndex()].getPrix());
                  
                    
                    produit.setIdMarque(this.produits[this.listProduit.getSelectedIndex()].getIdMarque());
                   produit.setTauxReduction(this.produits[this.listProduit.getSelectedIndex()].getTauxReduction());
                    produit.setNombrePoint(this.produits[this.listProduit.getSelectedIndex()].getNombrePoint());
                    produit.setPhoto(this.produits[this.listProduit.getSelectedIndex()].getPhoto());
                    produit.setDescription(this.produits[this.listProduit.getSelectedIndex()].getDescription());
                    produit.setQuantite(this.produits[this.listProduit.getSelectedIndex()].getQuantite());
                    produit.setQuantiteVendu(this.produits[this.listProduit.getSelectedIndex()].getQuantiteVendu());
                    
                    Midlet.INSTANCE.setProduitToDisplay(produit);
                    Midlet.INSTANCE.setAfficheProduit(true);
          
        Midlet.INSTANCE.disp.setCurrent(new ProduitFormSafwene());
                    
        }
        
        
        
    }

    public void run() {
      
        try {
            // this will handle our XML
            ProduitHandlerSafwene produitsHandler = new ProduitHandlerSafwene();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
        
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/scripts_php/GestionProduits.php?operation=affiche");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, produitsHandler);
            // display the result
          
            this.produits = produitsHandler.getProduits();
            if (this.produits.length > 0) {
                for (int i = 0; i < this.produits.length; i++) {
                    this.listProduit.append(produits[i].getNom(), null);

                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        Midlet.INSTANCE.disp.setCurrent(this.listProduit);
    
             
              }
              
    
    
    
    
    
}
