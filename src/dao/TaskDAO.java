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
    
    DbConnection conectar = new DbConnection();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        List<task>datos=new ArrayList<>();
        String sql="select * from task";
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                task t = new task();
                t.setId(rs.getInt(1));
                t.setNombre(rs.getString(2));
                t.setDescripcion(rs.getString(3));
                t.setEstado(rs.getString(4));
                t.setResponsable(rs.getString(5));
                t.setFechaLimite(rs.getString(6));
                t.setPrioridad(rs.getString(7));
                datos.add(t);    
            }
        } catch (Exception e) {
        }
    return datos;
    }
    
    public void addTask(task Task) {
        String sql = "INSERT INTO task (nombre, descripcion, estado, responsable, fecha_limite, prioridad) VALUES (?, ?, ?, ?, ?, ?)";
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