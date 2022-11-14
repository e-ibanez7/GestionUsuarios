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
    private String nameLogged;
    
    public Menu () {

    }
    
    
    public void mainMenu(ArrayList<User> users){
        int option=0;
        System.out.println("*******************************************************************************************");
        System.out.println("*********************************** Menú Principal ****************************************");
        System.out.println("1. Agregar Usuario");
        System.out.println("2. Iniciar Sesión");
        System.out.println("3. Mostrar datos");        
        System.out.print("Por favor introduzca la opción que desee realizar: ");
        try {
            option = Integer.parseInt(keyboardListener());
            switch (option) {
                case 1 -> this.addUser(users);
                case 2 -> this.loginMenu(users);
                case 3 -> this.showData(users);
                default -> System.exit(0);
            }   
        }
        catch (NumberFormatException e){
            System.out.println("ERROR. Datos introducidos incorrectos. Inténtelo de nuevo");
        }
        finally {
            this.mainMenu(users);
        }
    }
    
    public void loginMenu (ArrayList<User> users){
        boolean loginSuccess = false;
        User loginUser = null;
        int index=0;
        String name;
        String pass;
        
        System.out.print("Por favor introduzca su nombre de usuario:");
        name = keyboardListener();
        System.out.print("Por favor introduzca la contraseña:");
        pass = keyboardListener();
        
        for (int i=0; i<users.size(); i++){
            if (users.get(i).getName().equals(name)){
                if (users.get(i).getPassword().equals(pass)) {
                    loginSuccess = true;
                    loginUser = users.get(i);
                    index = i;
                }
            }
        }
        if (loginSuccess){
            this.userMenu(users, index);
        }
        else {
            System.out.println("ERROR en las credenciales introducidas, volviendo al menú principal");
        }
    }
    
    
    public void userMenu(ArrayList<User> users, int index){
        int option=0;
        System.out.println("*******************************************************************************************");
        System.out.println("*********************************** Menú de Usuarios ***************************************");
        System.out.println("***** Bienvenido: " + users.get(index).getName() + "(" + users.get(index).getEmail() + ")");
        System.out.println("1. Establecer Pregunta de seguridad");
        System.out.println("2. Modificar Email");
        System.out.println("3. Modificar Contraseña");
        System.out.println("4. Log out");
        System.out.print("Por favor introduzca la opción que desee realizar: ");
        try {
            option = Integer.parseInt(keyboardListener());
            switch (option) {
                case 1 -> this.modifySecurityQAMenu(users, index);
                case 2 -> this.modifyEmailMenu(users, index);
                case 3 -> this.modifyPassworrdMenu(users, index);
                case 4 -> this.logOutMenu();
                default -> System.out.println("Opción no disponible, vuelva a intentarlo");
            }
        }
        catch (NumberFormatException e){
            System.out.println("ERROR. Datos introducidos incorrectos. Inténtelo de nuevo");
        }
        finally {
            if (option != 4)
                this.userMenu(users, index);
        }
    }
    
     public void modifySecurityQAMenu(ArrayList<User> users, int index){
        String option;
        System.out.println("***** Menú de Cambio de pregunta de seguridad *****");
        System.out.println("Por favor introduzca la pregunta que desea establecer:");
        option = this.keyboardListener();
        users.get(index).setSecurityQuestion(option);
        System.out.println("Por favor introduzca la respuesta que desea establecer:");
        option = this.keyboardListener();
        users.get(index).setSecurityAnswer(option);
        System.out.println("Pregunta y respuesta de seguridad establecidas correctamente. Volviendo al menú:");
    }
    
    public void modifyEmailMenu(ArrayList<User> users, int index){
        String option;
        System.out.println("***** Menú de Cambio de email *****");
        System.out.println("Por favor introduzca el nuevo email que desea establecer:");
        option = this.keyboardListener();
        users.get(index).setEmail(option);
        System.out.println("Email modificado correctamente. Volviendo al menú:");
    }
    
    public void modifyPassworrdMenu(ArrayList<User> users, int index){
        String option;
        String confirmation;
        System.out.println("***** Menú de Cambio de contraseña *****");
        System.out.println("Por favor introduzca su nueva contraseña");
        option = this.keyboardListener();
        System.out.println("Por favor vuelva a introducirla");
        confirmation = this.keyboardListener();
        if (option.equals(confirmation)) {
            users.get(index).setPassword(option);
            System.out.println("Contraseña modificada correctamente. Volviendo al menú:");
        }
        else {
            System.out.println("Las contraseñas no coinciden. Volviendo al menú:");
        }
    }
    
    public void logOutMenu(){
        
        
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
        users.add(new User(name,email, password));     
        System.out.println("Usuario creado satisfactoriamente");
    }
    
    
    public boolean searchRepeated(String name, ArrayList<User> users){
        boolean repeated = false;
        for (int i=0; i<users.size() && !repeated; i++){
            if (users.get(i).getName().equalsIgnoreCase(name))
                repeated = true;
        }
        return repeated;
    }
    
    public void showData(ArrayList<User> users){
        for (User user: users) {
            System.out.println(user.getName() + "  " + user.getEmail() + "  " + user.getPassword());
        }
    }
}
