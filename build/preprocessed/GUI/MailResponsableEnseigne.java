/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;

/**
 *
 * @author Safwene
 */
public class MailResponsableEnseigne {
    
    private HttpConnection hc;
    private DataInputStream dis;
    private StringBuffer sb ;
    private String url="http://localhost/scripts_php/mail_responsable.php?";
    private Alert alert;
    
    public boolean SendMail(String to,String subject,String message,String headers ){
    
        try {
            this.hc=(HttpConnection)Connector.open(this.url+"to="+to+"&subject="+subject+"&message="+message+"&headers="+headers);
            System.out.println(this.url+"to="+to+"&subject="+subject+"&message="+message+"&headers="+headers);
            this.dis=this.hc.openDataInputStream();
            int ascii;
            this.sb =new StringBuffer();
            while( (ascii=this.dis.read()) != -1 ){
                this.sb.append((char)ascii);
            }
            
            if(sb.toString().equals("true")){
                this.alert = new Alert("");
                this.alert.setTitle("Mail envoyé");
                this.alert.setTimeout(1000);
                this.alert.setType(AlertType.INFO);
                Midlet.INSTANCE.disp.setCurrent(this.alert);
                return true;
            }
            else {
                this.alert = new Alert("");
                this.alert.setTitle("Mail non envoyé");
                this.alert.setTimeout(1000);
                this.alert.setType(AlertType.INFO);
                Midlet.INSTANCE.disp.setCurrent(this.alert);
                return false;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            
        }
        return false;
    }
}

    
        
        
    
    