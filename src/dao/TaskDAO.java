/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.task;
import model.DbConnection;

/**
 *
 * @author marin
 */


public class TaskDAO {
    
    public void addTask(task Task) {
        String sql = "INSERT INTO tareas (nombre, descripcion, estado, responsable, fecha_limite, prioridad) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DbConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, Task.getNombre());
            stmt.setString(2, Task.getDescripcion());
            stmt.setString(3, Task.getEstado());
            stmt.setString(4, Task.getResponsable());
            stmt.setString(5, Task.getFechaLimite());
            stmt.setString(6, Task.getPrioridad());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteTask(int id) {
        String sql = "DELETE FROM tareas WHERE id = ?";
        try (Connection conn = DbConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<task> getAllTasks() {
        List<task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tareas";
        try (Connection conn = DbConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                task Task = new task();
                Task.setId(rs.getInt("id"));
                Task.setNombre(rs.getString("nombre"));
                Task.setDescripcion(rs.getString("descripcion"));
                Task.setEstado(rs.getString("estado"));
                Task.setResponsable(rs.getString("responsable"));
                Task.setFechaLimite(rs.getString("fecha_limite"));
                Task.setPrioridad(rs.getString("prioridad"));
                tasks.add(Task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}