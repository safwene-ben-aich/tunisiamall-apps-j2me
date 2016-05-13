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
public class Thread {
    private int id;
    private String permalink;
    private int is_commentable;
    private int num_comments;
    private String last_comment_at;

    public Thread(int id, String permalink, int is_commentable, int num_comments) {
        this.id = id;
        this.permalink = permalink;
        this.is_commentable = is_commentable;
        this.num_comments = num_comments;
       
 
    }

    public Thread(int id) {
        this.id = id;
    }

    public Thread() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public int getIs_commentable() {
        return is_commentable;
    }

    public void setIs_commentable(int is_commentable) {
        this.is_commentable = is_commentable;
    }

    public int getNum_comments() {
        return num_comments;
    }

    public void setNum_comments(int num_comments) {
        this.num_comments = num_comments;
    }

    public String getLast_comment_at() {
        return last_comment_at;
    }

    public void setLast_comment_at(String last_comment_at) {
        this.last_comment_at = last_comment_at;
    }

   
    public String toString() {
        return "Thread{" + "id=" + id + ", permalink=" + permalink + ", is_commentable=" + is_commentable + ", num_comments=" + num_comments + ", last_comment_at=" + last_comment_at + '}';
    }

    
    
}
