package Handlers;

import Entities.ProduitSafwene;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Safwene
 */
public class ProduitHandlerSafwene extends DefaultHandler{
        
        private Vector produits;
        private ProduitSafwene currentProduit;
       
        
        String idTag = "close";
        String referencesTag = "close";
        String idMarqueTag  = "close";
        String nomTag = "close";
        String typeTag = "close";
        String prixTag = "close";
        String tauxReductionTag = "close";
        String nombrePointsTag = "close";
        String photoTag = "close";
        String descriptionTag = "close";
        String quantiteTag  = "close";
        String quantiteVenduTag = "close";
        
    public ProduitHandlerSafwene(){
        this.produits = new Vector();
       
    }
    
    public ProduitSafwene[] getProduits(){
        ProduitSafwene[] produits = new ProduitSafwene[this.produits.size()];
        this.produits.copyInto(produits);
        return produits;
    }
    
     public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("PRODUITS")) {
            if (this.currentProduit != null) {
                throw new IllegalStateException("already processing a produits");
            }
           this.currentProduit = new ProduitSafwene();
        }
       
        else if (qName.equals("ID")) {
            this.idTag = "open";
        }
        
        else if (qName.equals("REFERENCE")) {
            this.referencesTag = "open";
        }
        
        else if (qName.equals("ID_MARQUE")) {
            this.idMarqueTag = "open";
        }
        else if (qName.equals("NOM")){
            this.nomTag = "open";
        }
        else if (qName.equals("TYPE")){
            this.typeTag = "open";
        }
        else if (qName.equals("PRIX")){
            this.prixTag = "open";
        }
        else if (qName.equals("TAUX_REDUCTION")){
            this.tauxReductionTag = "open";
        }
        else if (qName.equals("NOMBRE_POINT")){
            this.nombrePointsTag = "open";
        }
        else if (qName.equals("PHOTO")){
            this.photoTag = "open";
        }
        else if (qName.equals("DESCRIPTION")){
            this.descriptionTag = "open";
        }
        else if (qName.equals("QUANTITE")){
            this.quantiteTag = "open";
        }
        else if (qName.equals("QUANTITE_VENDU")){
            this.quantiteVenduTag = "open";
        }
    }
     
     public void endElement(String uri, String localName, String qName) throws SAXException {
     
        if (qName.equals("PRODUITS")) {
            // we are no longer processing a <reg.../> tag
            this.produits.addElement(this.currentProduit);
            this.currentProduit = null;
        }
           else if (qName.equals("ID")) {
            this.idTag = "close";
        }
        
        else if (qName.equals("REFERENCE")) {
            this.referencesTag = "close";
        }
        
        else if (qName.equals("ID_MARQUE")) {
            this.idMarqueTag = "close";
        }
        else if (qName.equals("NOM")){
            this.nomTag = "close";
        }
        else if (qName.equals("TYPE")){
            this.typeTag = "close";
        }
        else if (qName.equals("PRIX")){
            this.prixTag = "close";
        }
        else if (qName.equals("TAUX_REDUCTION")){
            this.tauxReductionTag = "close";
        }
        else if (qName.equals("NOMBRE_POINT")){
            this.nombrePointsTag = "close";
        }
        else if (qName.equals("PHOTO")){
            this.photoTag = "close";
        }
        else if (qName.equals("DESCRIPTION")){
            this.descriptionTag = "close";
        }
        else if (qName.equals("QUANTITE")){
            this.quantiteTag = "close";
        }
        else if (qName.equals("QUANTITE_VENDU")){
            this.quantiteVenduTag = "close";
        }
    
     }
     
      public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (this.currentProduit != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (this.idTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                this.currentProduit.setId(Integer.parseInt(id));
            }
            if (this.referencesTag.equals("open")){
                String reference = new String(ch,start,length).trim();
                this.currentProduit.setReference(reference);
            }
            if (this.idMarqueTag.equals("open")){
                String idMarque = new String(ch,start,length).trim();
                this.currentProduit.setIdMarque(Integer.parseInt(idMarque));
            }
            if (this.nomTag.equals("open")){
                String nom = new String(ch,start,length).trim();
                this.currentProduit.setNom(nom);
            }
            if (this.typeTag.equals("open")){
                String type = new String(ch,start,length).trim();
                this.currentProduit.setType(type);
            }
            if (this.prixTag.equals("open")){
                String prix = new String(ch,start,length).trim();
                this.currentProduit.setPrix(Float.parseFloat(prix));
            }
            if (this.tauxReductionTag.equals("open")){
                String tauxReduction = new String(ch,start,length).trim();
                this.currentProduit.setTauxReduction(Float.parseFloat(tauxReduction));
            }
            if (this.nombrePointsTag.equals("open")){
                String nombrePoints = new String(ch,start,length).trim();
                this.currentProduit.setNombrePoint(Integer.parseInt(nombrePoints));
            }
            if (this.photoTag.equals("open")){
                String photo = new String(ch,start,length).trim();
                this.currentProduit.setPhoto(photo);
            }
            if (this.descriptionTag.equals("open")){
                String description = new String(ch,start,length).trim();
                this.currentProduit.setDescription(description);
            }
            if (this.quantiteTag.equals("open")){
                String quantite = new String(ch,start,length).trim();
                this.currentProduit.setQuantite(Integer.parseInt(quantite));
            }
            if (this.quantiteVenduTag.equals("open")){
                String quantiteVendu = new String(ch,start,length).trim();
                this.currentProduit.setQuantiteVendu(Integer.parseInt(quantiteVendu));
            }
            
            
            
            
            
            
            
            
            
            
        }
    }
   
    
    
}
