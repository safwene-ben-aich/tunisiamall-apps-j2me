/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.util.Random;
import javax.microedition.lcdui.*;
/**
 *
 * @author Safwene
 */
public class MemoryCanvasCanvas extends Canvas {

    
    private int xPositionSelector = 0;
    private int yPositionSelector = 0;
    
    private int widthSelector;
    private int heightSelector;
    
    private int xStartPositionMatrix;
    private int yStartPositionMatrix;
    private int xStopPositionMatrix;
    private int yStopPositionMatrix;
    
    private boolean fire = false;

    
    
    private int rectangeSize;
    
    
    private Image imageQuestion;
    private Image imageHit;
    
    
    private int screenHeight;
    private int screenWeidth;
    
    private String[] tabClothes = {"pull", "pentalon", "sac"};
    
    private String stringWelcome;
    private Command commandExit;
    
    
    
    
    
    public MemoryCanvasCanvas(){
        this.screenWeidth = this.getWidth();
        this.screenHeight = this.getHeight();
  
        this.stringWelcome = "Tenter votre chance,Et gagner\navec nous ! (1 pour retourner)";
        
        this.xStartPositionMatrix = 20;
        this.yStartPositionMatrix = 20;
        this.xStopPositionMatrix = 200;
        this.yStopPositionMatrix = 200;
        
        
        
        
        this.xPositionSelector = this.xStartPositionMatrix ;
        this.yPositionSelector = this.yStartPositionMatrix ;
        
        this.rectangeSize = this.xStopPositionMatrix - this.xStartPositionMatrix; 
        
        
        this.heightSelector = this.rectangeSize / 3;
        this.widthSelector = this.rectangeSize / 3;
        
        
        try {
            this.imageQuestion  = Image.createImage("/img/question_test.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
         try {
            this.imageHit  = Image.createImage("/img/hit.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        System.out.println(this.screenHeight);
        System.out.println(this.screenWeidth);
    
    
    }
    
    
    
        public void keyPressed(int code){
        int keyPressed = this.getGameAction(code);
        
        switch (keyPressed){
            case GAME_A : 
                Midlet.INSTANCE.disp.setCurrent(new ChoixFormSafwene());
                break;
            
            
              case RIGHT : 
                 if (this.xPositionSelector == this.xStartPositionMatrix){
                     this.xPositionSelector = (this.rectangeSize/2);
                 }
                 else if (this.xPositionSelector == (this.rectangeSize/2)){
                     this.xPositionSelector = (this.rectangeSize) - this.xStartPositionMatrix;
                 }
                 else if (this.xPositionSelector == ((this.rectangeSize) - this.xStartPositionMatrix)){
                     this.xPositionSelector = (this.xStartPositionMatrix);
                 }
                  
                break;
                
            case LEFT : 
                  if (this.xPositionSelector == this.xStartPositionMatrix){
                     this.xPositionSelector = (this.rectangeSize) - this.xStartPositionMatrix;
                 }
                 else if (this.xPositionSelector == (this.rectangeSize/2)){
                     this.xPositionSelector = this.xStartPositionMatrix;
                 }
                 else if (this.xPositionSelector == ((this.rectangeSize) - this.xStartPositionMatrix)){
                     
                     this.xPositionSelector = (this.rectangeSize/2);
                 }
                  
                break;
                
            
            case UP : 
                  if (this.yPositionSelector == this.yStartPositionMatrix){
                    this.yPositionSelector = (this.rectangeSize) - this.yStartPositionMatrix;
                    
                }
                else if (this.yPositionSelector == (this.rectangeSize/2)){
                    this.yPositionSelector =  this.yStartPositionMatrix;
                }
                else if (this.yPositionSelector == (this.rectangeSize) - this.yStartPositionMatrix){
                    this.yPositionSelector = (this.rectangeSize/2);
                }
              
                  
                break;
                
            case DOWN : 
      
                if (this.yPositionSelector == this.yStartPositionMatrix){
                    this.yPositionSelector = (this.rectangeSize/2);
                }
                else if (this.yPositionSelector == (this.rectangeSize/2)){
                    this.yPositionSelector = (this.rectangeSize) - this.yStartPositionMatrix;
                }
                else if (this.yPositionSelector == (this.rectangeSize) - this.yStartPositionMatrix){
                    this.yPositionSelector = this.yStartPositionMatrix ;
                }
               break;
            case FIRE :
                this.fire = true;
            break;
           
                
        }
  
        repaint();
    }
    
    
    
    protected void paint(Graphics graphics) {
      
        graphics.setColor(255,255,255); 
        graphics.fillRect(0,0,this.screenWeidth,this.screenHeight);
        
        
        graphics.setColor(0,0,0);
        graphics.drawRect(this.xStartPositionMatrix, this.yStartPositionMatrix, this.xStopPositionMatrix, this.yStopPositionMatrix);
        // Rectangle de 180 (côté)
        graphics.drawLine(this.xStartPositionMatrix + (this.rectangeSize/3), this.yStartPositionMatrix, this.xStartPositionMatrix + (this.rectangeSize/3), this.yStopPositionMatrix + this.xStartPositionMatrix);
        graphics.drawLine((this.xStartPositionMatrix/2) * 3 + (this.rectangeSize/3) * 2, this.yStartPositionMatrix, (this.xStartPositionMatrix/2) * 3 + (this.rectangeSize/3) * 2, this.yStopPositionMatrix + this.xStartPositionMatrix);
        
        graphics.drawLine(this.xStartPositionMatrix, this.yStartPositionMatrix + (this.rectangeSize/3), this.xStopPositionMatrix + this.xStartPositionMatrix, this.yStartPositionMatrix + (this.rectangeSize/3));
        graphics.drawLine(this.xStartPositionMatrix, (this.yStartPositionMatrix/2) * 3 + (this.rectangeSize/3) * 2, this.yStopPositionMatrix + this.yStartPositionMatrix, (this.yStartPositionMatrix/2) * 3 + (this.rectangeSize/3) * 2);
        
        graphics.drawImage(this.imageQuestion,this.xStartPositionMatrix,this.yStartPositionMatrix + (this.xStartPositionMatrix/4) ,0);
        graphics.drawImage(this.imageQuestion,(this.rectangeSize/2),this.yStartPositionMatrix + (this.xStartPositionMatrix/4),0);
        graphics.drawImage(this.imageQuestion,(this.rectangeSize) - this.xStartPositionMatrix ,this.yStartPositionMatrix + (this.xStartPositionMatrix/4),0);
        
        graphics.drawImage(this.imageQuestion,this.xStartPositionMatrix,(this.rectangeSize/2),0);
        graphics.drawImage(this.imageQuestion,(this.rectangeSize/2),(this.rectangeSize/2),0);
        graphics.drawImage(this.imageQuestion,(this.rectangeSize) - this.xStartPositionMatrix,(this.rectangeSize/2),0);  
        
        graphics.drawImage(this.imageQuestion,this.xStartPositionMatrix,(this.rectangeSize) - this.yStartPositionMatrix,0);
        graphics.drawImage(this.imageQuestion,(this.rectangeSize/2),(this.rectangeSize) - this.yStartPositionMatrix,0);
        graphics.drawImage(this.imageQuestion,(this.rectangeSize) - this.xStartPositionMatrix,(this.rectangeSize) - this.yStartPositionMatrix,0);   
      
        
        if (this.fire){
       
            int magicNumber = this.getRandom(0, 3);
            System.out.println(this.tabClothes[magicNumber]);
            try {
                graphics.drawImage(Image.createImage("/img/"+this.tabClothes[magicNumber]+".png"),this.xPositionSelector+3,this.yPositionSelector+2,0);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            graphics.setColor(0,150,0);
            stringWelcome = "Félécitations !, Vous avez gagné\nun "+this.tabClothes[magicNumber];
            
        }
    
        else{
        graphics.drawImage(this.imageHit,this.xPositionSelector+3,this.yPositionSelector+2,0);   
        }
        
        graphics.drawString(this.stringWelcome, 20, 280, 0);
        try { 
            graphics.drawImage(Image.createImage("/img/gift_test.png"), 75, 220, 0);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
      
        
        
    }
    
    
    
    public static int getRandom(int from, int to) {
    if (from < to)
        return from + new Random().nextInt(Math.abs(to - from));
    return from - new Random().nextInt(Math.abs(to - from));
  }

   
    
    
}
