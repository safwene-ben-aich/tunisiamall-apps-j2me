/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Fatma
 */
public class CarteFidelite {
    
    private int nbPoint;
    private float seuil;
    private Client client;
    Marque marque;
    public float getSeuil() {
        return seuil;
    }

    public CarteFidelite() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public CarteFidelite(int nbPoint, float seuil) {
        this.nbPoint = nbPoint;
        this.seuil = seuil;
    }
    public CarteFidelite(int nbPoint) {
        this.nbPoint = nbPoint;
    }

    /**
     * @return the nbPoint
     */
    public int getNbPoint() {
        return nbPoint;
    }

    /**
     * @param nbPoint the nbPoint to set
     */
    public void setNbPoint(int nbPoint) {
        this.nbPoint = nbPoint;
    }

 
    public String toString() {
        return "CarteFidelite{" + "nbPoint=" + nbPoint + '}';
    }
    
    
    
    
  
}
