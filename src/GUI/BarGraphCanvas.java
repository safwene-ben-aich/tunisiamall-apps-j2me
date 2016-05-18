/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.crypto.Cipher;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.*;

/**
 *
 * @author Safwene
 */
public class BarGraphCanvas extends Canvas implements CommandListener{
 
 private int[] dataset1,dataset2;
 private int maxX,maxY,width,height,deltaX,deltaY;
 private Command commandBack;
 
 
 
 public BarGraphCanvas(){
      int [] dataset1 = new int[]{10,30,20,60,70};
 int []dataset2 = new int[]{40,10,70,45,80};
 int maxX = Math.max(dataset1.length,dataset2.length)-1;

 int maxY = 0;
 
 for(int i = 0; i<dataset1.length; i++)
  maxY = Math.max(maxY,dataset1[i]);

 for(int i = 0; i<dataset2.length; i++)
  maxY = Math.max(maxY,dataset2[i]);

  maxY += 10;

  this.dataset1 = dataset1;
  this.dataset2 = dataset2;

  this.maxX = maxX;
  this.maxY = maxY;
 }

 public void paint(Graphics g){

  int barwidth = 4;  
  width = getWidth();
  height = getHeight();

  deltaX = width/(maxX+1);
  
  deltaY = height/maxY;
  
  g.setColor(255,255,255);
  g.fillRect(0,0,width,height);

  g.setColor(0,0,0);
  g.drawLine(0,0,0,height-1);
  g.drawLine(0,height-1,width,height-1);
  int j=0;
  for(int i = 0; j <= maxY; i++,j+=10)
   g.drawString((""+j+""),0,height-(i*deltaY*10+10),Graphics.TOP|Graphics.LEFT);

  for(int i = 0;i < maxX+1; i++){
   //g.drawString((" "+dataset1[i]+""),i*deltaX,height-(deltaY*dataset1[i]),Graphics.TOP|Graphics.LEFT);
   g.drawString((" "+dataset1[i]+""),10+i*deltaX,height-(deltaY*dataset1[i]+10),Graphics.TOP|Graphics.RIGHT);
   g.fillRect(10+i*deltaX,height -deltaY*dataset1[i],barwidth,deltaY*dataset1[i]);
   }
  g.setColor(255,0,0);
  for(int i = 0;i < maxX+1; i++){
   g.drawString((" "+dataset2[i]+""),10+i*deltaX+barwidth,height-(deltaY*dataset2[i]+10),Graphics.TOP|Graphics.LEFT);
   g.fillRect(10+i*deltaX+barwidth,height -deltaY*dataset2[i],barwidth,deltaY*dataset2[i]);
   
   }
  
 }//end of paint method

    public void commandAction(Command c, Displayable d) {
        if (c == this.commandBack){
                    Midlet.INSTANCE.disp.setCurrent(new ChoixResponsableCanvas());
        }
    
    
    
    }


}//end of GraphCanvas

