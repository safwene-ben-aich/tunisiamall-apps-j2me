/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author dali
 */

import Entities.Client;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author wissem
 */
public class Mail extends Form implements CommandListener, Runnable {

    HttpConnection hm;
    DataInputStream dt;
    int ch;
    Display disp;
    Client client;
    Form f1 = new Form("Envoi Mail");
    TextField tfadr = new TextField("Adresse Destinataire: ", "@", 70, TextField.ANY);
    TextField tfsujet = new TextField("Sujet : ", "", 20, TextField.ANY);
        TextField tfpwd = new TextField("pwd : ", "", 20, TextField.ANY);

    TextField tftxt = new TextField("Message : ", "", 20, TextField.ANY);

    Command Envoyer= new Command("Envoyer", Command.SCREEN, 0);
    Command back= new Command("Back", Command.SCREEN, 1);

   

  
     
//    public Mail(String title,Display disp) {
//        
//        
//        
//        
//    }

    public Mail(String title,Client client) {
         super(title);
         this.client=client;
        append(tfadr);
                append(tfpwd);

        append(tfsujet);
        append(tftxt);
        addCommand(Envoyer);
        addCommand(back);
        setCommandListener(this);
        Thread th = new Thread(this);
            th.start();
            
      

        }

    public void commandAction(Command c, Displayable d) {
        if(c==Envoyer){
           
            String url2 = "http://localhost/essaiM/mailchams.php?mailee="+ tfadr.getString()+"&pwd=" + tfpwd.getString() + "&sujet=" + tfsujet.getString() + "&message=" + tftxt.getString();
try {
hm = (HttpConnection) Connector.openInputStream(url2);
   } catch (IOException ex) {
                ex.printStackTrace();
            }
            
    }
         
        if(c==back){
                    Midlet.INSTANCE.disp.setCurrent(new ChoixClientCanvas(client));
  
                }
    }
    public void run() {
         
     
    

        }
}
