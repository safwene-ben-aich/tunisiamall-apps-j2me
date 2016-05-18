/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Client;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author Safwene
 */
public class Authentification extends Form implements CommandListener,Runnable{

    private Command commandExit;
    private Command commandLogin;
    private Command commandInscription;
    private TextField textFieldUsername;
    private TextField textFieldPassword;
    
    private HttpConnection hc;
    private DataInputStream dis;
    private StringBuffer sb ;
    private String url="http://localhost/scripts_php/authentification.php?"; 
    
    private Alert alert;
    
    
    
    
    public Authentification(String title) {
        super("Authentification");
        this.prepareFormAuthentification();
        
    }
    
    public void prepareFormAuthentification()
    {   
        this.commandExit = new Command("Exit", Command.EXIT, 0);
        this.commandLogin = new Command("Login", Command.SCREEN, 0);
        this.commandInscription = new Command("Inscription", Command.SCREEN, 1);
        this.textFieldUsername = new TextField("Username ", null, 50 , TextField.ANY);
        this.textFieldPassword = new TextField("Password", null, 50, TextField.PASSWORD);
        
        
        
        
        this.append(this.textFieldUsername);
        this.append(this.textFieldPassword);
        
        this.addCommand(this.commandExit);
        this.addCommand(this.commandLogin);
        this.addCommand(this.commandInscription);
        
        this.setCommandListener(this);
    }
    
    
    
    public boolean verifChampsAuthentification()
    {
        if (this.textFieldUsername.getString().equals(""))
            return false;
        else if (this.textFieldPassword.getString().equals(""))
            return false;
        
        return true;
    }
    
    

    public void commandAction(Command command, Displayable displayable) {
   
                if (command == this.commandExit){
                    Midlet.INSTANCE.destroyApp(false);
                    Midlet.INSTANCE.notifyDestroyed();
                }
                else if (command == this.commandLogin){
                    if (!this.verifChampsAuthentification()){
                        this.alert = new Alert("Alert Authentification");
                        this.alert.setTitle("Veuillez renseigner Les champs");
                        this.alert.setTimeout(1000);
                        this.alert.setType(AlertType.ERROR);
                        Midlet.INSTANCE.disp.setCurrent(this.alert);
                           
                    }
                    else {
                        Thread th = new Thread(this);
                        th.start();
                      }
                }
                else if (command == this.commandInscription){
                     Midlet.INSTANCE.disp.setCurrent(new InscriptionClient("Inscription Client"));
                            
           
                    
                    
                }
    
    
    }

    public void run() {
          
    
        try {
            this.hc=(HttpConnection)Connector.open(this.url+"username="+this.textFieldUsername.getString()+""
                    + "&password="+this.textFieldPassword.getString());
            
            System.out.println(this.url+"username="+this.textFieldUsername.getString()+""
                    + "&password="+this.textFieldPassword.getString());
            this.dis=this.hc.openDataInputStream();
            int ascii;
            this.sb =new StringBuffer();
            while( (ascii=this.dis.read()) != -1 ){
                this.sb.append((char)ascii);
            }
            if (!sb.toString().equals("false")){
                     if (sb.toString().equals("RESPONSABLE")){
                          //Récupération marque
                          this.hc=(HttpConnection)Connector.open("http://localhost/scripts_php/utils_responsable.php?username="+this.textFieldUsername.getString());
                          this.dis=this.hc.openDataInputStream();
                          this.sb =new StringBuffer();
                          while( (ascii=this.dis.read()) != -1 ){
                                this.sb.append((char)ascii);
                                            }
                          Midlet.INSTANCE.setIdMarqueResponsable(Integer.parseInt(this.sb.toString()));
                          Midlet.INSTANCE.disp.setCurrent(new ChoixResponsableCanvas());
                        }
                     else if (sb.toString().equals("CLIENT")){
                     
                        Client client= new Client();
                    client.setLogin(textFieldUsername.getString());
                        Midlet.INSTANCE.disp.setCurrent(new ChoixClientCanvas(client));
                     }
                     
                     
            }
            else{
                this.alert = new Alert("Alert Authentification");
                        this.alert.setTitle("NON ! ");
                        this.alert.setTimeout(1000);
                        this.alert.setType(AlertType.INFO);
                        Midlet.INSTANCE.disp.setCurrent(this.alert);
            }
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    
    
    
    
    }
    }

