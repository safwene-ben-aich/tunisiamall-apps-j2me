/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author Fatma
 */
class Splash extends Form implements  CommandListener{
ImageItem ii;
   Command cmdexit= new Command("Exit", Command.EXIT,0);
     Command cmdnext= new Command("Next", Command.SCREEN,0);
         Thread th= new Thread();
      StringItem si= new StringItem("Cliquez sur next", null);
    public Splash(String texte) {
        super(texte);
         Image img =null;
        try {
            img =Image.createImage("/img/SPLASH.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
       ii = new ImageItem("", img, ImageItem.LAYOUT_CENTER, "not found");
       Gauge gaugeItem = new Gauge("cliquez sur next  ...\n", false, Gauge.INDEFINITE, Gauge.CONTINUOUS_RUNNING);
       append(ii);
        
        append(gaugeItem);
 addCommand(cmdexit);
        addCommand(cmdnext);
        
        
              setCommandListener(this); 
 
    }

    public void commandAction(Command c, Displayable d) {
         if (c==cmdexit){
        Midlet.INSTANCE.notifyDestroyed();
        }
        else if (c==cmdnext){
        Midlet.INSTANCE.disp.setCurrent(new InscriptionClient("Tunisia Mall"));
        }
    }


  
    
}
