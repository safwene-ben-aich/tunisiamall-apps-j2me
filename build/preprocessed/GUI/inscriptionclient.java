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
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author Safwene
 */
public class InscriptionClient extends Form implements CommandListener,Runnable{

    private TextField textFieldCIN;
    private TextField textFieldNom;
    private TextField textFieldPrenom;
    private TextField textFieldPassword;
    private TextField textFieldConfirmPassword;
    private TextField textFieldQrcode;
    private TextField textFieldTelephone;
    private TextField textFieldAdresse;
    private TextField textFieldUsername;
    private TextField textFieldEmail;
    private ChoiceGroup choiceGroupSexe;
    
    private Alert alert;
   
    private Command commandRetour;
    private Command commandInscription;
    
    private HttpConnection hc;
    private DataInputStream dis;
    private StringBuffer sb ;
    private String url="http://localhost/scripts_php/GestionClients.php?"; 
    
    
    
    public InscriptionClient(String title) {
        super(title);
        this.prepareFormInscriptionClient();
    }
    
    
    
    public boolean verifChampsInscriptionClient(){
      if (this.textFieldNom.getString().equals(""))
          return false;
      if (this.textFieldPrenom.getString().equals(""))
          return false;
      if (this.textFieldCIN.getString().equals(""))
          return false;
      if (this.choiceGroupSexe.getSelectedIndex()==-1)
          return false;
      if (this.textFieldAdresse.getString().equals(""))
          return false;
      if (this.textFieldEmail.getString().equals(""))
          return false;
      if (this.textFieldTelephone.getString().equals(""))
          return false;
      if (this.textFieldQrcode.getString().equals(""))
          return false;
      if (this.textFieldUsername.getString().equals(""))
          return false;
      if (this.textFieldPassword.getString().equals(""))
          return false;
      if (this.textFieldConfirmPassword.getString().equals(""))
          return false;
      if (!this.textFieldPassword.getString().equals(this.textFieldConfirmPassword.getString()))
          return false;  
                        return true;
    }
    
    public void prepareFormInscriptionClient(){
       
        this.textFieldNom = new TextField("Nom", null, 50, TextField.ANY);
        this.textFieldPrenom = new TextField("Prenom", null, 50, TextField.ANY);
        this.textFieldCIN = new TextField("CIN", null, 50, TextField.ANY);
        this.choiceGroupSexe = new ChoiceGroup("Sexe", ChoiceGroup.EXCLUSIVE);
        this.choiceGroupSexe.append("Homme", null);
        this.choiceGroupSexe.append("Femme", null);
        this.textFieldAdresse = new TextField("Adresse", null, 200, TextField.ANY);
        this.textFieldEmail = new TextField("Email", null, 50, TextField.EMAILADDR);
        this.textFieldTelephone = new TextField("Telephone", null, 50, TextField.PHONENUMBER);
        this.textFieldQrcode = new TextField("QRcode", null, 50, TextField.ANY);
        this.textFieldUsername = new TextField("Username", null, 50, TextField.ANY);
        this.textFieldPassword = new TextField("Password", null, 50, TextField.ANY);
        this.textFieldConfirmPassword = new TextField("Confirm Password", null, 50, TextField.ANY);
        
        this.commandRetour = new Command("Retour", Command.SCREEN, 1);
        this.commandInscription = new Command("Inscription", Command.SCREEN, 1);
        
        this.append(this.textFieldNom);
        this.append(this.textFieldPrenom);
        this.append(this.textFieldCIN);
        this.append(this.choiceGroupSexe);
        this.append(this.textFieldAdresse);
        this.append(this.textFieldEmail);
        this.append(this.textFieldTelephone);
        this.append(this.textFieldQrcode);
        this.append(this.textFieldUsername);
        this.append(this.textFieldPassword);
        this.append(this.textFieldConfirmPassword);
        
        
        this.addCommand(this.commandRetour);
        this.addCommand(this.commandInscription);
        
       this.setCommandListener(this);
        
    }
    
    
    
    

    public void commandAction(Command command, Displayable displayable) {
    
        if (command == this.commandRetour){
            Midlet.INSTANCE.disp.setCurrent(new Authentification("Authentification"));
        }
        else if (command == this.commandInscription){
                
            if (!this.verifChampsInscriptionClient()){
                this.alert = new Alert("Champs non-valide");
                this.alert.setTitle("Verifier les champs");
                this.alert.setTimeout(1000);
                this.alert.setType(AlertType.ERROR);
                Midlet.INSTANCE.disp.setCurrent(this.alert);
            }
            else {
                 Thread th = new Thread(this);
                 th.start();
            }
                
        
        
        } 
        
        
        
        
        
    
    
    }

    public void run() {
    
        try {
            System.out.println(this.url+"nom="+this.textFieldNom.getString()+""
                    + "&prenom="+this.textFieldPrenom.getString()+ "&cin="+this.textFieldCIN.getString()+ "&sexe="+this.choiceGroupSexe.getString(this.choiceGroupSexe.getSelectedIndex())
            + "&adresse="+this.textFieldAdresse.getString()+ "&email="+this.textFieldEmail.getString()+ "&telephone="+this.textFieldTelephone.getString()
            + "&qrcode="+this.textFieldQrcode.getString()+ "&username="+this.textFieldUsername.getString()+ "&password="+this.textFieldPassword.getString());   
            this.hc=(HttpConnection)Connector.open(this.url+"nom="+this.textFieldNom.getString()+""
                    + "&prenom="+this.textFieldPrenom.getString()+ "&cin="+this.textFieldCIN.getString()+ "&sexe="+this.choiceGroupSexe.getString(this.choiceGroupSexe.getSelectedIndex())
            + "&adresse="+this.textFieldAdresse.getString()+ "&email="+this.textFieldEmail.getString()+ "&telephone="+this.textFieldTelephone.getString()
            + "&qrcode="+this.textFieldQrcode.getString()+ "&username="+this.textFieldUsername.getString()+ "&password="+this.textFieldPassword.getString());
            this.dis=this.hc.openDataInputStream();
            int ascii;
            this.sb =new StringBuffer();
            while( (ascii=this.dis.read()) != -1 ){
                this.sb.append((char)ascii);
            }
            if (!sb.toString().equals("false")){
                
                
                
                Client client= new Client();
client.setAdresse(textFieldAdresse.getString());
client.setEmail(textFieldEmail.getString());
client.setLogin(textFieldUsername.getString());
client.setNom(textFieldNom.getString());
client.setPrenom(textFieldPrenom.getString());

client.setSexe(choiceGroupSexe.getString(choiceGroupSexe.getSelectedIndex()));
    System.out.println("clientttttttttttt"+client);
                
                
                
                
//                this.alert = new Alert("Inscription validé");
//                this.alert.setTitle("Inscription validé");
//                this.alert.setTimeout(1000);
//                this.alert.setType(AlertType.INFO);
//                
//                Midlet.INSTANCE.disp.setCurrent(this.alert);
                      Alert alertsuccess=new Alert("Inscription", "Inscription éfféctuée avec succée", null, AlertType.CONFIRMATION);
                
                
                Midlet.INSTANCE.disp.setCurrent(alertsuccess, new ListMarques(client));

            }
            else {
                  this.alert = new Alert("Inscription non validé");
                this.alert.setTitle("Inscription non validé");
                this.alert.setTimeout(1000);
                this.alert.setType(AlertType.ERROR);
                Midlet.INSTANCE.disp.setCurrent(this.alert);
            }
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
}
