/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;



/**
 *
 * @author dali
 */
public class Responsable {
    private int Id;
    private String cin ;
    private String nom ;
    private String prenom ;
    private String login ;
    private String password ;
    private String mail ;
    private String adresse ;
    private String telephone ;
    private String role="RESPONSABLE";
    private int Etat;

    public Responsable(int Id, String cin, String nom, String prenom, String login, String password, String mail, String adresse, String telephone, int Etat) {
        this.Id = Id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.adresse = adresse;
        this.telephone = telephone;
        this.Etat = Etat;
    }

    public Responsable() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getEtat() {
        return Etat;
    }

    public void setEtat(int Etat) {
        this.Etat = Etat;
    }

    
    public String toString() {
        return "Responsable{" + "Id=" + Id + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password=" + password + ", mail=" + mail + ", adresse=" + adresse + ", telephone=" + telephone + ", role=" + role + ", Etat=" + Etat + '}';
    }

   
  
    
    
    
    
    
}



