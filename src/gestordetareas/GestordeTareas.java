/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestordetareas;

import controller.LoginController;
import controller.RegisterController;
import controller.TareaController;
import view.LoginView;
import view.RegisterView;

/**
 *
 * @author marin
 */
public class GestordeTareas {
    
    public static void main(String[] args) {
        
        RegisterView registerView = new RegisterView();
        RegisterController registerController = new RegisterController(registerView);
       
        registerView.setVisible(true);
           
    }
    
}

