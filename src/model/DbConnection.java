package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class DbConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/task_manager";
    private static final String USER = "root";
    private static final String PASSWORD = "marin";

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return con;
    }
    
     public static ResultSet getUserNames() {
        ResultSet rs = null;
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT nombre_completo FROM user");
        } catch (SQLException e) {
            System.out.println("Error al obtener nombres de usuarios: " + e.getMessage());
        }
        return rs;
    }
}
