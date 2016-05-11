/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.ClientDAO;
import DAO.CommentaireDAO;
import DAO.MarqueDAO;
import DAO.PanierDAO;
import DAO.ProduitDAO;
import Entities.Client;
import Entities.Commentaire;
import Entities.Marque;
import Entities.Panier;
import Entities.Produit;
import java.io.IOException;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemCommandListener;
import javax.microedition.lcdui.Spacer;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author Max
 */
class affichprod extends Form implements CommandListener{
ImageItem ii;
Client client;
Produit leproduit;
int idmarque;
     Command cmdexit= new Command("Back", Command.EXIT,0);
     Command cmdnext= new Command("Next", Command.SCREEN,0);
       Command cmdggmap= new Command("Google map", Command.SCREEN,0);
     Alert alertsuccess=new Alert("Panier", "Ajoutéfféctué avec succée", null, AlertType.CONFIRMATION);
        Alert alertechec=new Alert("Inscription", "Ajout non éfféctué", null, AlertType.ERROR);
      TextField com= new TextField(null,null,50,TextField.ANY);
    public affichprod(String produit, final Produit produit0, final Client client, final int idmarque) {
        super(produit);
       this.client=client;
       this.idmarque=idmarque;
       this.leproduit= produit0;
        Image img =null;
        try {
            String nomphoto=produit0.getPhoto();
            nomphoto="/".concat(nomphoto);
            System.out.println("phoooooooooooooooto"+nomphoto);
            img =Image.createImage(nomphoto);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
       ii = new ImageItem("", img, ImageItem.LAYOUT_CENTER, "not found");
       append(ii);
       StringItem siref= new StringItem("Reference :", produit0.getReference());
       siref.setLayout(StringItem.LAYOUT_LEFT);
       StringItem sinom= new StringItem(produit0.getNom(), null);
       sinom.setLayout(StringItem.LAYOUT_CENTER);
       StringItem siprix= new StringItem("Prix:", String.valueOf(produit0.getPrix()));
       siprix.setLayout(StringItem.LAYOUT_LEFT);
       StringItem sitype= new StringItem("Type :", produit0.getType());
       sitype.setLayout(StringItem.LAYOUT_LEFT);
       Marque[] marques = new MarqueDAO().select();
       String nom = null;
       for (int i = 0; i < marques.length; i++){
       if (marques[i].getId()==produit0.getMarque().getId()){
       nom=marques[i].getNom();
       }
       }
       StringItem simarque= new StringItem("Marque:", nom);
       simarque.setLayout(StringItem.LAYOUT_LEFT);
        append(sinom);
        append(siprix);
        append(siref);
            append(sitype);
            append(simarque);
        addCommand(cmdexit);
        addCommand(cmdnext);
        setCommandListener(this);
        
        

        
        
        
        
        append (new Spacer(15, 15));
        append(com);
        
        
        
        StringItem buttonajoutcom = new StringItem("", "Ajouter un commentaire", Item.BUTTON);
       buttonajoutcom.setLayout(StringItem.LAYOUT_CENTER);
Command buttonCommandajoutcom = new Command("Ajouter  un commentaire", Command.ITEM, 1);

buttonajoutcom.setDefaultCommand(buttonCommandajoutcom);
buttonajoutcom.setItemCommandListener(new ItemCommandListener() {
public void commandAction(Command c, Item item) {
System.out.println("Button was clicked");

    Client[] cli= new ClientDAO().select(client);
      
    System.out.println("theeeee cliennnnnnt"+cli[0]);
    Produit p=new Produit();
    p.setId(leproduit.getId());
    Commentaire commentaire= new Commentaire(cli[0], p, com.getString());


    System.out.println(commentaire);
boolean a=new CommentaireDAO().insert(commentaire);
if (a==true){
Midlet.INSTANCE.disp.setCurrent(alertsuccess, new affichprod("Produit", produit0, client,idmarque));

}
else {
Midlet.INSTANCE.disp.setCurrent(alertechec, new ListProduits(client,idmarque));

}
}
});
append(buttonajoutcom);
        
        
        
        append (new Spacer(15, 15));
       StringItem button = new StringItem("", "Ajouter a mon panier", Item.BUTTON);
       button.setLayout(StringItem.LAYOUT_CENTER);
Command buttonCommand = new Command("Ajouter a mon panier", Command.ITEM, 1);

button.setDefaultCommand(buttonCommand);
button.setItemCommandListener(new ItemCommandListener() {
public void commandAction(Command c, Item item) {
System.out.println("Button was clicked");

    Client[] cli= new ClientDAO().select(client);
      
    System.out.println("theeeee cliennnnnnt"+cli[0]);
    Produit p=new Produit();
    p.setId(leproduit.getId());
Panier panier= new Panier(cli[0],p,1);

    System.out.println(panier);
boolean a=new PanierDAO().insert(panier);
if (a==true){
Midlet.INSTANCE.disp.setCurrent(alertsuccess, new affichprod("Produit", produit0, client, idmarque));

}
else {
Midlet.INSTANCE.disp.setCurrent(alertechec, new ListProduits(client,idmarque));

}
}
});
append(button);




        
           append (new Spacer(15, 15));
       StringItem buttoncom = new StringItem("", "Afficher les commentaires", Item.BUTTON);
       buttoncom.setLayout(StringItem.LAYOUT_CENTER);
Command buttonCommandcom = new Command("Afficher les commentaires", Command.ITEM, 1);

buttoncom.setDefaultCommand(buttonCommandcom);
buttoncom.setItemCommandListener(new ItemCommandListener() {
public void commandAction(Command c, Item item) {
System.out.println("Button was clicked");

    
    Produit p=new Produit();
    p.setId(leproduit.getId());

    Commentaire[] commentaires = new CommentaireDAO().select(p);
        if (commentaires.length > 0) {
            for (int i = 0; i < commentaires.length; i++) {
                append(new StringItem(commentaires[i].getClient().getLogin(), commentaires[i].getDescription()));
            }
        }
}
});
append(buttoncom);
        addCommand(cmdggmap);








    }

    
    
    
    
    
    
    
    
    
    
    
    public void commandAction(Command c, Displayable d) {
        Midlet.INSTANCE.disp.setCurrent(new ListProduits(client,idmarque));
        if (c==cmdggmap){
        Midlet.INSTANCE.disp.setCurrent(new GoogleMapsPathCanvas(Midlet.INSTANCE, d, client,idmarque));
        
        }
    }
    
}
