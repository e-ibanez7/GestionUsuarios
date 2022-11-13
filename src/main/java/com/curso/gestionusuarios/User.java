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
    
    public void modifyEmail(String email){
        this.email = email;
    }
    
    public void modifyName(String name){
        this.name = name;
    }   
    public void modifyPassword (String pass){
        this.password = pass;
    }   
}
