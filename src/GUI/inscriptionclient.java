/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.ClientDAO;
import DAO.MarqueDAO;
import Entities.Client;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemCommandListener;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;

/**
 *
 * @author Max
 */
class inscriptionclient extends Form {

    Ticker ticker= new Ticker("welcome to Tunisia Mall! ");
 Command cmdnext = new Command("next", Command.SCREEN, 0);
    Command cmdexit = new Command("exit", Command.EXIT, 0);
      TextField Nom= new TextField("Nom : ",null,14,TextField.ANY);
        TextField Login= new TextField("Login : ",null,14,TextField.ANY);
          TextField Password= new TextField("Password : ",null,14,TextField.PASSWORD);
      TextField Prenom= new TextField("Prenom : ",null,14,TextField.ANY);
       TextField Email= new TextField("Email : ",null,30,TextField.ANY);
        TextField Adresse= new TextField("Adresse : ",null,70,TextField.ANY);
        ChoiceGroup ch= new ChoiceGroup("Sexe", ChoiceGroup.EXCLUSIVE);
        Alert alertsuccess=new Alert("Inscription", "Inscription éfféctuée avec succée", null, AlertType.CONFIRMATION);
        Alert alertechec=new Alert("Inscription", "Inscription échouée", null, AlertType.ERROR);
    public inscriptionclient(String tunisia_Mall) {
        super(tunisia_Mall);
        setTicker(ticker);
         append(Nom);
         append(Prenom);
         append(Login);
         append(Password);
        
         append(Email);
         append(Adresse);
         ch.append("Femme", null);
         ch.append("Homme", null);
        append(ch);
           StringItem button = new StringItem("", "S'inscrire", Item.BUTTON);
       button.setLayout(StringItem.LAYOUT_CENTER);
Command buttonCommand = new Command("Button command", Command.ITEM, 1);

button.setDefaultCommand(buttonCommand);
button.setItemCommandListener(new ItemCommandListener() {
public void commandAction(Command c, Item item) {
Client client= new Client();
client.setAdresse(Adresse.getString());
client.setEmail(Email.getString());
client.setLogin(Login.getString());
client.setNom(Nom.getString());
client.setPrenom(Prenom.getString());
client.setPassword(Password.getString());
client.setSexe(ch.getString(ch.getSelectedIndex()));
    System.out.println("clientttttttttttt"+client);
boolean a=new ClientDAO().insert(client);
if (a==true){
Midlet.INSTANCE.disp.setCurrent(alertsuccess, new ListMarques(client));

}
else {
Midlet.INSTANCE.disp.setCurrent(alertechec, new inscriptionclient("Tunisia Mall"));

}
}
});
append(button);
    }

   
    
}
