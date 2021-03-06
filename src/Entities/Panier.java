/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;



/**
 *
 * @author Kaouther
 */
public class Panier {
    private int id;
    private Client client;
    private Produit produit;
    private int quantite;

    public Panier() {
    }

    public Panier(int id, Client client, Produit produit, int quantite) {
        this.id = id;
        this.client = client;
        this.produit = produit;
        this.quantite = quantite;
    }

    public Panier(Client client, Produit produit, int quantite) {
        this.client = client;
        this.produit = produit;
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }


 

   
    public String toString() {
        return "Panier{" + "id=" + id + ", client=" + client + ", produit=" + produit + ", quantite=" + quantite + '}';
    }
    
    
    
}
