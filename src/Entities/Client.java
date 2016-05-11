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
public class Client extends User {
  
    private String nom;
    private String prenom;
    private String email;
    private String role;
    private int etat;
    private String sexe;
    private String Adresse;
    private byte[] bytesImage;
    public Client() {
    }

    public Client(String login) {
        super(login);
    }

    public Client(String nom, String prenom, String email, String role,int etat, String sexe, int id, String login, String password) {
        super(id, login, password);
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.role = role;
        this.etat = etat;
        this.sexe = sexe;
    }

    public Client(String login,String nom, String prenom, String email,String Adresse,int etat) {
        super(login);
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.etat = etat;
        this.Adresse = Adresse;
    }

    public Client(String nom, String prenom, String email, String sexe, String Adresse, int id, String login, String password) {
        super(id, login, password);
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
        this.Adresse = Adresse;
    }

    public Client(String nom, String prenom, String email, String sexe, String Adresse, String login, String password) {
        super( login, password);
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
        this.Adresse = Adresse;
    }

    public Client(int id) {
        super(id);
    }

    public Client(String nom, String prenom, String email, String sexe, int id, String login, String password) {
        super(id, login, password);
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
    }

    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public byte[] getBytesImage() {
        return bytesImage;
    }

    public void setBytesImage(byte[] bytesImage) {
        this.bytesImage = bytesImage;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

  
   
    public String toString() {
        return "Client{" +super.toString()+ "nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", role=" + role + ", etat=" + etat + ", sexe=" + sexe + '}';
    }
    
    
}
