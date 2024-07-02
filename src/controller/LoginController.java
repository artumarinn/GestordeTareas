/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.DatabaseConnection;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marin
 */
public class LoginController {

    public Usuario validateLogin(String correoUsuario, String contraseña) {
        String query = "SELECT * FROM Usuario WHERE (correo = ? OR nombre_usuario = ?) AND contraseña = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, correoUsuario);
            preparedStatement.setString(2, correoUsuario);
            preparedStatement.setString(3, contraseña);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Usuario(
                        resultSet.getInt("id_usuario"),
                        resultSet.getString("nombre_usuario"),
                        resultSet.getString("nombre_completo"),
                        resultSet.getString("correo"),
                        resultSet.getString("contraseña")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

