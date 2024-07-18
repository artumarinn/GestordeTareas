/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Tarea;

public class TaskController {
    private Connection connect() {
        // Conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/tu_base_de_datos";
        String user = "tu_usuario";
        String password = "tu_contraseña";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void addTask(Tarea task) {
        String sql = "INSERT INTO tareas (nombre, descripcion, estado, responsable, fecha_limite, prioridad) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, task.getNombre());
            pstmt.setString(2, task.getDescripcion());
            pstmt.setString(3, task.getEstado());
            pstmt.setString(4, task.getResponsable());
            pstmt.setDate(5, new java.sql.Date(task.getFechaLimite().getTime()));
            pstmt.setString(6, task.getPrioridad());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Tarea> getTasks() {
        List<Tarea> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tareas";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Tarea task = new Tarea(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("estado"),
                        rs.getString("responsable"),
                        rs.getDate("fecha_limite"),
                        rs.getString("prioridad")
                );
                tasks.add(task);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return tasks;
    }

    public void updateTask(Tarea task) {
        String sql = "UPDATE tareas SET nombre = ?, descripcion = ?, estado = ?, responsable = ?, fecha_limite = ?, prioridad = ? WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, task.getNombre());
            pstmt.setString(2, task.getDescripcion());
            pstmt.setString(3, task.getEstado());
            pstmt.setString(4, task.getResponsable());
            pstmt.setDate(5, new java.sql.Date(task.getFechaLimite().getTime()));
            pstmt.setString(6, task.getPrioridad());
            pstmt.setInt(7, task.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteTask(int taskId) {
        String sql = "DELETE FROM tareas WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, taskId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
