package controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.user;
import model.DbConnection;

public class ControllerRegister {

    public boolean registerUser(user user) {
        Connection con = DbConnection.getConnection();
        String sql = "INSERT INTO usuario(dni, nombre_completo, correo, usuario, contraseña) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getDni());
            ps.setString(2, user.getNombre_completo());
            ps.setString(3, user.getCorreo());
            ps.setString(4, user.getUsuario());
            ps.setString(5,hashContraseña(user.getContraseña()));
            
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }
    
    private String hashContraseña(String password) {
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashedPassword = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }  
}
