/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.RegisterView;
import model.DatabaseConnection;

/**
 *
 * @author marin
 */
public class RegisterController {
    
    private RegisterView view;
    
    public RegisterController(RegisterView view) {
        this.view = view;
        this.view.addRegisterListener(new RegisterListener());
    }
    
    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.getBtnRegistrar()) {
                String nombreCompleto = view.getTxtNombreCompleto();
                String nombreUsuario = view.getTxtNombreUsuario();
                String correo = view.getTxtCorreo();
                String contraseña = view.getTxtContraseña();
                
                Usuario usuario = new Usuario(0, nombreUsuario, nombreCompleto, correo, contraseña);
                guardarUsuario(usuario);
            }
        }
    }
    
    private void guardarUsuario(Usuario usuario) {
    String query = "INSERT INTO Usuario (nombre_usuario, nombre_completo, correo, contraseña) VALUES (?, ?, ?, ?)";
    
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {
        
        statement.setString(1, usuario.getNombreUsuario());
        statement.setString(2, usuario.getNombreCompleto());
        statement.setString(3, usuario.getCorreo());
        statement.setString(4, usuario.getContraseña());
        
        statement.executeUpdate();
        
        JOptionPane.showMessageDialog(view, "Usuario registrado con éxito.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(view, "Error al registrar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
}


