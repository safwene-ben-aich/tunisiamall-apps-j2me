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
public class Marque {
      private int id;
    private String nom;
    private float seuilAchat;
    private  String photo;
    private Responsable responsable;

    public Marque() {
    }

    public Marque(String nom) {
        this.nom = nom;
    }

    public Marque(String nom, float seuilAchat) {
        this.nom = nom;
        this.seuilAchat = seuilAchat;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public Marque(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getSeuilAchat() {
        return seuilAchat;
    }

    public void setSeuilAchat(float seuilAchat) {
        this.seuilAchat = seuilAchat;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    public String toString() {
        return "Marque{" + "nom=" + nom + ", seuilAchat=" + seuilAchat + '}';
    }

  

    
    
    
    
    
}
