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
public class Produit {
    private String reference;
    private int id;
    private String Nom;
    private String type ;
    private String photo;
    private String description;
    private int nombre_point;
    private float taux_reduction;
    private float prix;
    private int quantite;
    private int quantite_vendue;
   private Marque marque;

    public Produit() {
    }

    public Produit(int id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getQuantite_vendue() {
        return quantite_vendue;
    }

    public void setQuantite_vendue(int quantite_vendue) {
        this.quantite_vendue = quantite_vendue;
    }

    public Produit(String reference, String Nom) {
        this.reference = reference;
        this.Nom = Nom;
    }

    public Produit( String Nom, String photo, float prix, int id, float taux_reduction,String reference) {
        this.id = id;
        this.Nom = Nom;
        this.photo = photo;
        this.taux_reduction = taux_reduction;
        this.prix = prix;
        this.reference=reference;
    }

    public Produit(String reference, String Nom, String type, String photo, String description, int nombre_point, float taux_reduction, Marque marque) {
        this.reference = reference;
        this.Nom = Nom;
        this.type = type;
        this.photo = photo;
        this.description = description;
        this.nombre_point = nombre_point;
        this.taux_reduction = taux_reduction;
        this.marque = marque;
    }

    public Produit(String reference, String Nom, String type, String photo, String description, Marque marque,float prix) {
        this.reference = reference;
        this.Nom = Nom;
        this.type = type;
        this.photo = photo;
        this.description = description;
        this.marque = marque;
        this.prix=prix;
    }

    
    
    
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getNombre_point() {
        return nombre_point;
    }

    public void setNombre_point(int nombre_point) {
        this.nombre_point = nombre_point;
    }

    public float getTaux_reduction() {
        return taux_reduction;
    }

    public void setTaux_reduction(float taux_reduction) {
        this.taux_reduction = taux_reduction;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

  
    public String toString() {
        return "Produit{" + "reference=" + reference + ", id=" + id + ", Nom=" + Nom + ", type=" + type + ", photo=" + photo + ", description=" + description + ", nombre_point=" + nombre_point + ", taux_reduction=" + taux_reduction + ", prix=" + prix + ", marque=" + marque + '}';
    }

   

   
    
}
