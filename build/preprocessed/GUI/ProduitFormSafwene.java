package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Safwene
 */
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.*;





public class ProduitFormSafwene  extends Form implements CommandListener,Runnable{
    
    private Command commandBack;
    
    private Command commandAjouter;
    private Command commandSupprimer;
    private Command commandModifier;
    
    private TextField references;
    private TextField nom;
    private TextField type;
    private TextField prix;
    private TextField tauxReduction;
    private TextField nombrePoint;
    private TextField quantite;
    private TextField   Description;
    private Alert alert;
    private int idMarque;
    
    private HttpConnection hc;
    private DataInputStream dis;
    private StringBuffer sb ;
    private String url="http://localhost/scripts_php/GestionProduits.php?"; 

    private String operation="";
    
    
    
    
    
    
    
    public ProduitFormSafwene(){
        super ("Ajouter un produit");
        this.prepareForm();
        
        
    }
    
    
    
    public void prepareForm(){
        
        this.commandBack = new Command("Back", Command.SCREEN, 0);
       
        
      
        
        
        this.references = new TextField("References : ", null, 50, TextField.ANY);
        this.nom = new TextField("Nom : ", null, 50, TextField.ANY);
        
        this.type = new TextField("Type : ", null, 50, TextField.ANY);
        this.prix = new TextField("Prix : ", null, 50, TextField.ANY);
        this.tauxReduction = new TextField("Taux Reduction : ", null, 50, TextField.ANY);
        this.nombrePoint = new TextField("Nombre point : ", null, 50, TextField.ANY);
        this.quantite = new TextField("Quantité : ", null, 50, TextField.ANY);
        this.Description = new TextField("Description", null, 50, TextField.ANY);
    
        this.idMarque = 1;
        
        
        
        
        this.append(this.references);
        this.append(this.nom);
        this.append(this.type);
        this.append(this.prix);
        this.append(this.tauxReduction);
        this.append(this.nombrePoint);
        this.append(this.quantite);
        this.append(this.Description);
       
          if (Midlet.INSTANCE.isAfficheProduit()){
            this.commandModifier = new Command("Modifier", Command.SCREEN, 0);
            this.commandSupprimer = new Command("Supprimer", Command.SCREEN,0 );
            this.addCommand(this.commandBack);
            this.addCommand(this.commandModifier);
            this.addCommand(this.commandSupprimer);
           
            this.references.setString(Midlet.INSTANCE.getProduitToDisplay().getReference());
            this.nom.setString(Midlet.INSTANCE.getProduitToDisplay().getNom());
            this.type.setString(Midlet.INSTANCE.getProduitToDisplay().getType());
            this.prix.setString(String.valueOf(Midlet.INSTANCE.getProduitToDisplay().getPrix()));
           
            this.tauxReduction.setString(String.valueOf(Midlet.INSTANCE.getProduitToDisplay().getTauxReduction()));
            this.nombrePoint.setString(String.valueOf(Midlet.INSTANCE.getProduitToDisplay().getNombrePoint()));
            this.quantite.setString(String.valueOf(Midlet.INSTANCE.getProduitToDisplay().getQuantite()));
            this.Description.setString(String.valueOf(Midlet.INSTANCE.getProduitToDisplay().getDescription()));
            
            this.references.setConstraints(TextField.UNEDITABLE);
          }
       
        else {
            this.commandAjouter = new Command("Ajouter", Command.SCREEN, 0);
            this.addCommand(this.commandBack);
            this.addCommand(this.commandAjouter);
        }
         
          
        this.setCommandListener(this);
        
    
    }
    
    
    
    // A améliorer !! 
    public boolean verifForm(){
       boolean etat = true;
       
       if (this.references.getString().equals("")){
           etat = false;
       }
       if (this.nom.getString().equals("")){
           etat = false;
       }
       if (this.type.getString().equals("")){
           etat = false;
       }
       if (this.prix.getString().equals("")){
           etat = false;
       }
       if (this.tauxReduction.getString().equals("")){
           etat = false;
       }
       if (this.nombrePoint.getString().equals("")){
           etat = false;
       }
       if (this.quantite.getString().equals("")){
           etat = false;
       }
       if (this.Description.getString().equals("")){
           etat = false;
       }
        return etat;
    }
    
    
    
    
    
    
    public void commandAction (Command command, Displayable displayable){
        
        if (command == this.commandBack ){
            Midlet.INSTANCE.disp.setCurrent(new ChoixFormSafwene());
        }
        else if (command == this.commandAjouter){
            if (!this.verifForm()){
                this.alert = new Alert("");
                this.alert.setTitle("Veuillez renseigner tout les champs");
                this.alert.setTimeout(1000);
                this.alert.setType(AlertType.ERROR);
                Midlet.INSTANCE.disp.setCurrent(this.alert);
            }
            else {
                    this.operation="ajouter";
             Thread th = new Thread(this);
               th.start();
        }
                                            }
        
        else if (command == this.commandModifier){
                if (!verifForm()){
                      this.alert = new Alert("");
                this.alert.setTitle("Veuillez renseigner tout les champs");
                this.alert.setTimeout(1000);
                this.alert.setType(AlertType.ERROR);
                Midlet.INSTANCE.disp.setCurrent(this.alert);
                }
                else {
                    System.out.println("SALUT");
               this.operation="modifier";
               Thread th = new Thread(this);
               th.start();
                }
            
        }
        else if (command == this.commandSupprimer){
                
                
                  this.operation="supprimer";
               Thread th = new Thread(this);
               th.start();
            
            
        }
         
        
        
        
        
        
        
    }

    public void run() {
        
        if (this.operation == "ajouter"){
    try {
                        this.hc=(HttpConnection)Connector.open(this.url+"reference="+this.references.getString()+""
                                + "&nom="+this.nom.getString()+"&type="+this.type.getString()+"&prix="+this.prix.getString()
                                +"&tauxReduction="+this.tauxReduction.getString()+"&nombrePoint="+this.nombrePoint.getString()+"&quantite="+this.quantite.getString()+"&description="+this.Description.getString()+"&idMarque="+this.idMarque+"&operation=ajout");
                     
                    this.dis=this.hc.openDataInputStream();
                    int ascii;
                    this.sb =new StringBuffer();   
                    while( (ascii=this.dis.read()) != -1 ){
                        this.sb.append((char)ascii);
                    }
                    
                      if(sb.toString().equals("Success")){
                          this.alert = new Alert("");
                          this.alert.setTitle("Ajouter avec sucées ! ");
                          this.alert.setTimeout(1000);
                          this.alert.setType(AlertType.INFO);
                          Midlet.INSTANCE.disp.setCurrent(this.alert);
                      }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            
        }
        else if (this.operation == "modifier"){
              try {
                      System.out.println(this.url+"reference="+this.references.getString()+""
                                + "&nom="+this.nom.getString()+"&type="+this.type.getString()+"&prix="+this.prix.getString()
                                +"&tauxReduction="+this.tauxReduction.getString()+"&nombrePoint="+this.nombrePoint.getString()+"&quantite="+this.quantite.getString()+"&description="+this.Description.getString()+"&idMarque="+this.idMarque+"&operation=modifie");
                    
                        this.hc=(HttpConnection)Connector.open(this.url+"reference="+this.references.getString()+""
                                + "&nom="+this.nom.getString()+"&type="+this.type.getString()+"&prix="+this.prix.getString()
                                +"&tauxReduction="+this.tauxReduction.getString()+"&nombrePoint="+this.nombrePoint.getString()+"&quantite="+this.quantite.getString()+"&description="+this.Description.getString()+"&idMarque="+this.idMarque+"&operation=modifie");
                     
                        
                   
                    this.dis=this.hc.openDataInputStream();
                    int ascii;
                    this.sb =new StringBuffer();   
                    while( (ascii=this.dis.read()) != -1 ){
                        this.sb.append((char)ascii);
                    }
                    
                      if(sb.toString().equals("Success")){
                          this.alert = new Alert("");
                          this.alert.setTitle("Modifier avec sucées ! ");
                          this.alert.setTimeout(1000);
                          this.alert.setType(AlertType.INFO);
                          Midlet.INSTANCE.disp.setCurrent(this.alert);
                      }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            
        }
        
         else if (this.operation == "supprimer"){
              try {
                           this.hc=(HttpConnection)Connector.open(this.url+"reference="+this.references.getString()+""
                                + "&nom="+this.nom.getString()+"&type="+this.type.getString()+"&prix="+this.prix.getString()
                                +"&tauxReduction="+this.tauxReduction.getString()+"&nombrePoint="+this.nombrePoint.getString()+"&quantite="+this.quantite.getString()+"&description="+this.Description.getString()+"&idMarque="+this.idMarque+"&operation=supprime");
                     
                        
                   
                    this.dis=this.hc.openDataInputStream();
                    int ascii;
                    this.sb =new StringBuffer();   
                    while( (ascii=this.dis.read()) != -1 ){
                        this.sb.append((char)ascii);
                    }
                    
                      if(sb.toString().equals("Success")){
                          this.alert = new Alert("");
                          this.alert.setTitle("Supprimer avec sucées ! ");
                          this.alert.setTimeout(1000);
                          this.alert.setType(AlertType.INFO);
                          Midlet.INSTANCE.disp.setCurrent(this.alert);
                      }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            
        }
        
    }
    
    
    
    
    
  }
    

