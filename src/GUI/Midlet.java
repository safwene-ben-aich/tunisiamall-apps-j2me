/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Client;
import Entities.ProduitSafwene;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;
import utils.PlayerManager;

/**
 * @author Max
 */
public class Midlet extends MIDlet {

    public Display disp = Display.getDisplay(this);
    private boolean  afficheProduit;
    private ProduitSafwene produitToDisplay = null;
        Client c= new Client();

    
    public Midlet(){
        this.afficheProduit=false;
    }

    public static Midlet INSTANCE=null;
    public void startApp() {
        INSTANCE = this;
     //  disp.setCurrent(new Splash("Tunisia Mall"));
       disp.setCurrent(new Authentification("Authentification"));
       // disp.setCurrent(new InscriptionClient("Inscription"));
//        c.setLogin("1111");
//         disp.setCurrent(new ListeMarquescartes(c));
       playMedia();
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    /**
     * @return the afficheProduit
     */
    public boolean isAfficheProduit() {
        return afficheProduit;
    }

    /**
     * @param afficheProduit the afficheProduit to set
     */
    public void setAfficheProduit(boolean afficheProduit) {
        this.afficheProduit = afficheProduit;
    }

    /**
     * @return the produitToDisplay
     */
    public ProduitSafwene getProduitToDisplay() {
        return produitToDisplay;
    }

    /**
     * @param produitToDisplay the produitToDisplay to set
     */
    public void setProduitToDisplay(ProduitSafwene produitToDisplay) {
        this.produitToDisplay = produitToDisplay;
    }
    
     public void playMedia()
    {
        String locator = "http://localhost/Mobile/Kalimba.mp3";
        PlayerManager playManager=new PlayerManager(locator);
        Thread runner=new Thread(playManager);
        runner.start();
    }
    
}
