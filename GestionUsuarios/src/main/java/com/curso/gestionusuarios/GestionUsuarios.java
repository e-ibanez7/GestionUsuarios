/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.curso.gestionusuarios;

import java.util.ArrayList;

/**
 *
 * @author eibaneza
 */
public class GestionUsuarios {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("juan", "juan@juan.com", "asdf"));
        users.add(new User("mierdon", "mierdon@juan.com", "12345"));
        users.add(new User("juan2", "juan2@juan2.com", "1234"));
   
        users.size();
        
        Menu m = new Menu();
        m.mainMenu(users);

       //User user1 = new User ('juan', 'juan@juan.com', 'asdf');
        
        
        
        
    }
}
