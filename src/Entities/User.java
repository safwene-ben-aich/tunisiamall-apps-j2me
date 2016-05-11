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
public class User {
      private int id;
     private String login;
    private String password;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String login) {
        this.login = login;
    }

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public String toString() {
        return "User{" + "id=" + id + ", login=" + login + ", password=" + password + '}';
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

 
    public int hashCode() {
        int hash = 3;
        return hash;
    }


    
    
    
}
