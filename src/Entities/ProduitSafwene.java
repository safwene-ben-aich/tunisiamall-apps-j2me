/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Safwene
 */
public class ProduitSafwene {
        
        private int id;
        private String reference;
        private int idMarque;
        private String nom;
        private String type;
        private float prix;
        private float tauxReduction;
        private int nombrePoint;
        private String photo;
        private String description;
        private int quantite;
        private int quantiteVendu;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @return the idMarque
     */
    public int getIdMarque() {
        return idMarque;
    }

    /**
     * @param idMarque the idMarque to set
     */
    public void setIdMarque(int idMarque) {
        this.idMarque = idMarque;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the prix
     */
    public float getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(float prix) {
        this.prix = prix;
    }

    /**
     * @return the tauxReduction
     */
    public float getTauxReduction() {
        return tauxReduction;
    }

    /**
     * @param tauxReduction the tauxReduction to set
     */
    public void setTauxReduction(float tauxReduction) {
        this.tauxReduction = tauxReduction;
    }

    /**
     * @return the nombrePoint
     */
    public int getNombrePoint() {
        return nombrePoint;
    }

    /**
     * @param nombrePoint the nombrePoint to set
     */
    public void setNombrePoint(int nombrePoint) {
        this.nombrePoint = nombrePoint;
    }

    /**
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * @return the quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * @param quantite the quantite to set
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * @return the quantiteVendu
     */
    public int getQuantiteVendu() {
        return quantiteVendu;
    }

    /**
     * @param quantiteVendu the quantiteVendu to set
     */
    public void setQuantiteVendu(int quantiteVendu) {
        this.quantiteVendu = quantiteVendu;
    }
    
        public ProduitSafwene(){
            
        }
    
    
    public ProduitSafwene(int id, String reference,int idMarque, String nom, String type, float prix, float tauxReduction, int nombrePoint, String photo, String description, int quantite, int quantiteVendu){
       this.id=id;
       this.reference=reference;
       this.idMarque=idMarque;
       this.type = type;
       this.prix = prix;
       this.tauxReduction = tauxReduction;
       this.nombrePoint = nombrePoint;
       this.photo = photo;
       this.description = description;
       this.quantite = quantite;
       this.quantiteVendu = quantiteVendu;
    }
    
 
    
    
}
