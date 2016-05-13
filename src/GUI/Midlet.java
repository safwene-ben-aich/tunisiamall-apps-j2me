/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.ProduitSafwene;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

/**
 * @author Max
 */
public class Midlet extends MIDlet {

    public Display disp = Display.getDisplay(this);
    private boolean  afficheProduit;
    private ProduitSafwene produitToDisplay = null;
    
    
    public Midlet(){
        this.afficheProduit=false;
    }

    public static Midlet INSTANCE=null;
    public void startApp() {
        INSTANCE = this;
     //  disp.setCurrent(new Splash("Tunisia Mall"));
       disp.setCurrent(new Authentification("Authentification"));
       // disp.setCurrent(new InscriptionClient("Inscription"));
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
}
