/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.gestionusuarios;

/**
 *
 * @author eibaneza
 */
public class User {
    private String name;
    private String email;
    private String password;
    
    private String securityQuestion;
    private String securityAnswer;
    
    
    
    public User (String name, String email, String pass){
        this.name = name;
        this.email = email;
        this.password = pass;
    }
    
    public String getEmail(){
        return this.email;
    }
    public String getName(){
        return this.name;
    }
    public String getPassword(){
        return this.password;
    }
    
    public String getSecurityQuestion() {
        return securityQuestion;
    }
    public String getSecurityAnswer() {
        return securityAnswer;
    }

    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setyName(String name){
        this.name = name;
    }   
    public void setPassword (String pass){
        this.password = pass;
    }   
    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }
    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }
    
    
}
