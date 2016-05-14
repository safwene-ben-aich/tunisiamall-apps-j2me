/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import javax.microedition.lcdui.*;
/**
 *
 * @author Safwene
 */
public class ChoixFormSafwene extends Form implements CommandListener{
    
    private Command commandExit;
    private Command commandAjouterProduit;
    private Command commandGererProduit;
    private Command commandJouer;
    private StringItem stringItem;
    
    

    
    public ChoixFormSafwene(){
        super("Choix d'opération");
        prepareForm();
        
     
        Midlet.INSTANCE.setProduitToDisplay(null);
        Midlet.INSTANCE.setAfficheProduit(false);
    
    }
    
    public void prepareForm(){
        this.commandExit = new Command("Exit", Command.EXIT, 0);
        this.commandAjouterProduit = new Command("Ajouter", Command.SCREEN, 1);
        this.commandGererProduit = new Command("Gerer Produit", Command.SCREEN ,1);
        this.commandJouer = new Command("Jouer ?", Command.SCREEN, 1);
        this.stringItem = new StringItem("", "Veuillez choisir une opération ! ");
    
        this.addCommand(this.commandExit);
        this.addCommand(this.commandAjouterProduit);
        this.addCommand(this.commandGererProduit);
        this.addCommand(this.commandJouer);
        
        this.append(this.stringItem);
        
        this.setCommandListener(this);

    }
    
    
    public void commandAction (Command command, Displayable displayable){
    
        if (command == this.commandExit){
            Midlet.INSTANCE.destroyApp(false);
            Midlet.INSTANCE.notifyDestroyed();
        }
        
        else if (command == this.commandAjouterProduit){
            Midlet.INSTANCE.disp.setCurrent(new ProduitFormSafwene("Ajouter un produit"));
        }
        
        else if (command == this.commandGererProduit){
            Midlet.INSTANCE.disp.setCurrent(new ProduitListSafwene());
        }
        
        else if (command == this.commandJouer){
            Midlet.INSTANCE.disp.setCurrent(new MemoryCanvasCanvas());
        }
        
    }
    
    
    
    
    
    
    
}
