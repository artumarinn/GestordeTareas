/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestordetareas;

import controller.RegisterController;
import view.RegisterView;

/**
 *
 * @author marin
 */
public class GestordeTareas {
    
    public static void main(String[] args) {
        RegisterView view = new RegisterView();
        RegisterController controller = new RegisterController(view);
        view.setVisible(true);
    }
    
    
}
