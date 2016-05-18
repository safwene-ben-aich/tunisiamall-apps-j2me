/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Client;
import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 *
 * @author Safwene
 */
public class ChoixResponsableCanvas  extends Canvas implements CommandListener{
    
    
    private int screenWidth; 
    private int screenHeigth;
    
    private int xStartBackgroundPosition;
    private int yStartBackgroundPosition;
    
    private Image imageBackground;
    
    private String[][] matrixOfImages;
    
    private int numberOfImageX;
    private int numberOfImageY;
    
    private int i;
    private int j;
    
    private Client client;
    
    private Command commandBack;
    
    
    public ChoixResponsableCanvas ()
    {
            
            this.screenWidth = this.getWidth();
            this.screenHeigth = this.getHeight();
            this.xStartBackgroundPosition = 0;
            this.yStartBackgroundPosition = 0;
            
            this.numberOfImageX = 2;
            this.numberOfImageY = 2;
            
            
            this.matrixOfImages = new String[this.numberOfImageX][this.numberOfImageY];
            
            this.matrixOfImages[0][0] = "res1.jpg";
            this.matrixOfImages[0][1] = "res2.jpg";
            this.matrixOfImages[1][0] = "res3.jpg";
            this.matrixOfImages[1][1] = "res4.jpg";
           
            this.i = 0;
            this.j = 0;
            
            
         
 
            this.client = client;
            this.commandBack = new Command("Back", Command.SCREEN, 0);
            this.addCommand(this.commandBack);
            this.setCommandListener(this);
    
    
    }
    
    
     public void keyPressed(int code){
        int keyPressed = this.getGameAction(code);
        
        switch (keyPressed){
              case RIGHT : 
                  if (j==1){
                      j=0;
                  }
                  else {
                  j++;
                  }
               break;
                
            case LEFT : 
                if (j==0){
                      j=1;
                  }
                  else {
                  j--;
                  }
               
              
                  
                  
                break;
                 case DOWN : 
                     if (i==0){
                         i++;
                     }
                     else {
                         i=0;
                     }
                     
                     
                     break;
                
                     
            case UP :
                    if (i==1){
                        i--;
                    }
                    else {
                        i=1;
                    }
                
                break;
            case FIRE :
                        if (this.matrixOfImages[i][j].equals("res1.jpg")){
                                Midlet.INSTANCE.disp.setCurrent(new ProduitFormSafwene("Ajouter un produit"));
                        }
                        else if (this.matrixOfImages[i][j].equals("res2.jpg")){
                                Midlet.INSTANCE.disp.setCurrent(new ProduitListSafwene());
                        }
                        else if (this.matrixOfImages[i][j].equals("res3.jpg")){
                                 Midlet.INSTANCE.disp.setCurrent(new MemoryCanvasCanvas());
                        }
                        else if (this.matrixOfImages[i][j].equals("res4.jpg")){
                                
                            
                                 Midlet.INSTANCE.disp.setCurrent(new BarGraphCanvas());
                        }
                        
                        
                
                
                
                break;
                
        }
  
        repaint();
    }
    
    protected void paint(Graphics graphics) {
        try {
            this.imageBackground = Image.createImage("/img/"+this.matrixOfImages[i][j]);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(this.matrixOfImages[i][j]);
        graphics.drawImage(this.imageBackground, this.xStartBackgroundPosition, this.yStartBackgroundPosition, 0);
    }

    public void commandAction(Command command, Displayable displayable) {
    
        if (command == this.commandBack){
             Midlet.INSTANCE.disp.setCurrent(new Authentification("Authentification"));
        }
        
    
    
    }

    
}
