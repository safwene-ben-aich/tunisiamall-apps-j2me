/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Entities.Client;
import java.io.IOException;
import java.util.Random;
import javax.microedition.amms.SoundSource3D;
import javax.microedition.lcdui.*;
/**
 *
 * @author Safwene
 */
public class ChoixClientCanvas extends Canvas implements CommandListener{

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
    
    
    public ChoixClientCanvas (Client client)
    {
            
            try {
                this.imageBackground = Image.createImage("/img/client_n.jpg");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            this.screenWidth = this.getWidth();
            this.screenHeigth = this.getHeight();
            this.xStartBackgroundPosition = 0;
            this.yStartBackgroundPosition = 0;
            
            this.numberOfImageX = 2;
            this.numberOfImageY = 3;
            
            
            this.matrixOfImages = new String[this.numberOfImageX][this.numberOfImageY];
            
            this.matrixOfImages[0][0] = "c1.jpg";
            this.matrixOfImages[0][2] = "c2.jpg";
            this.matrixOfImages[1][0] = "c3.jpg";
            this.matrixOfImages[1][1] = "c4.jpg";
            this.matrixOfImages[1][2] = "c5.jpg";
           
            this.i = 0;
            this.j = 0;
            
            
            for (int i = 0; i < this.numberOfImageX ; i++) {
                for (int j = 0; j < this.numberOfImageY; j++) {
                    System.out.print(this.matrixOfImages[i][j]);
               }
                    System.out.println("");
        }
 
            this.client = client;
            this.commandBack = new Command("Back", Command.SCREEN, 0);
            this.addCommand(this.commandBack);
            this.setCommandListener(this);
    
    
    }
    
    
     public void keyPressed(int code){
        int keyPressed = this.getGameAction(code);
        
        switch (keyPressed){
              case RIGHT : 
              if (i==0){
                if (j!=0){
                  if (j==2){
                      j=0;
                  }
                  else {
                  j++;
                  }
                }
                else {
                    j=2;
                }
              }
              
              else {
                  if (j==2){
                      j=0;
                  }
                  else{
                      j++;
                  }
                  
              }
              
                  
                    break;
                
            case LEFT : 
              if (i==0){
                if (j!=2){
                  if (j==0){
                      j=2;
                  }
                  else {
                  j--;
                  }
                }
                else {
                    j=0;
                }
              }
              
              else {
                  if (j==0){
                      j=2;
                  }
                  else {
                      j--;
                  }
                  
                  
              }
              
                  
                  
                break;
                 case DOWN : 
                if (j!=1){
                     if (i==0){
                         i++;
                     }
                     else {
                         i=0;
                     }
                }
                     
                     
                     
                     break;
                
                     
            case UP :
                if (j!=1){
                    if (i==1){
                        i--;
                    }
                    else {
                        i=1;
                    }
                }
                
                break;
            case FIRE :
                
                        if (this.matrixOfImages[i][j].equals("c1.jpg")){
                            Midlet.INSTANCE.disp.setCurrent(new listReservations(this.client));
                        }
                        else if (this.matrixOfImages[i][j].equals("c2.jpg")){
                             Midlet.INSTANCE.disp.setCurrent(new ListMarques(this.client));
                        }
                        else if (this.matrixOfImages[i][j].equals("c3.jpg")){
                             Midlet.INSTANCE.disp.setCurrent(new GoogleMapsPathCanvas(Midlet.INSTANCE, this, this.client));
                        }
                        else if (this.matrixOfImages[i][j].equals("c4.jpg")){
                             Midlet.INSTANCE.disp.setCurrent(new ListeMarquescartes(this.client));
                        }
                        else if (this.matrixOfImages[i][j].equals("c5.jpg")){
                            Midlet.INSTANCE.disp.setCurrent(new Mail("Mail",client));
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
