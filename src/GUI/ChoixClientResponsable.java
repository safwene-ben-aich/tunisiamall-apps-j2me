/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

/**
 *
 * @author Safwene
 */
public class ChoixClientResponsable extends Form implements CommandListener{
    
    private Command commandExit;
    private Command commandClient;
    private Command commandResponsable;
    private String  stringToDisplay;
    
    
    public ChoixClientResponsable(){
        super("Choix entre Client/Responsable");
        
        this.commandExit = new Command("Exit", Command.EXIT, 0);
        this.commandClient = new Command("Client", Command.SCREEN, 1);
        this.commandResponsable = new Command("Responsable", Command.SCREEN,1);
    
        this.stringToDisplay = "Veuillez choisir entre Client et Responsable d'enseigne !";
        
        this.addCommand(this.commandExit);
        this.addCommand(this.commandClient);
        this.addCommand(this.commandResponsable);
        
        this.append(this.stringToDisplay);
        
        
        this.setCommandListener(this);
    }

    public void commandAction(Command command, Displayable displayable) {
        
        if (command == this.commandExit){
            Midlet.INSTANCE.destroyApp(false);
            Midlet.INSTANCE.notifyDestroyed();
        }
        else if (command == this.commandClient){
            Midlet.INSTANCE.disp.setCurrent(new Splash("Tunisia Mall"));
        }
        else if (command == this.commandResponsable){
            Midlet.INSTANCE.disp.setCurrent(new ChoixFormSafwene());
        }
        
        
        
    
        
    }
    
    
    
    
    
    
    
    
}
