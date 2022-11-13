/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.gestionusuarios;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author eibaneza
 */
public class Menu {
    
    public Menu () {

    }
    public void mainMenu(ArrayList<User> users){
        System.out.println("*******************************************************************************************");
        System.out.println("*********************************** Menú Principal ****************************************");
        System.out.println("1. Agregar Usuario");
        System.out.println("2. Iniciar Sesión");
       System.out.println("Por favor introduzca la opción que desee realizar:");
        int option = Integer.parseInt(keyboardListener());
        switch (option){
            case 1:
                this.addUser(users);
            case 2:
                this.loginMenu();
        }
        
    }
    
    public void loginMenu (){
        String name;
        String pass;
        System.out.println("Por favor introduzca su nombre de usuario:");
        name = keyboardListener();
        System.out.println("Por favor introduzca la contraseña:");
        pass = keyboardListener();
        
        
        int option = Integer.parseInt(keyboardListener());
    }
    
    public String keyboardListener (){
        Scanner input = new Scanner(System.in);
        String option = input.nextLine();
        return option;
    }
    
    public void addUser(ArrayList<User> users){
        String name;
        String email;
        String password;
        
        System.out.println("*******************************************************************************************");
        Scanner input = new Scanner(System.in);
        String option;
        boolean repeated;
        do {
            System.out.println("Por favor introduzca el nombre del nuevo usuario");
            option = input.nextLine();
            
            repeated = this.searchRepeated(option, users);
            if (repeated){
                System.out.println("ya existe un usuario con ese nombre por favor ");
            }
        } while (repeated);
        name = option;
        System.out.println("Nombre de usuario confirmado, por favor introduzca su email");
        option = input.nextLine();
        email = option;
        System.out.println("Por favor introduzca la contraseña del nuevo usuario");
        option = input.nextLine();
        password = option;
        
        users.add(new User(name,password, email));     
        System.out.println("Usuario creado satisfactoriamente");
        this.mainMenu(users);
    }
    
    
    public boolean searchRepeated(String name, ArrayList<User> users){
        boolean repeated = false;
        for (int i=0; i<users.size() && !repeated; i++){
            if (users.get(i).getName().equalsIgnoreCase(name))
                repeated = true;
        }
        return repeated;
    }
    
}
