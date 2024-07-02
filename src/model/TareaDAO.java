/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marin
 */
public class TareaDAO {
    public void agregarTarea(Tarea tarea) throws SQLException {
        String sql = "INSERT INTO Tareas (id_materia, id_usuario, titulo, descripcion, fecha_limite) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, tarea.getIdMateria());
            stmt.setInt(2, tarea.getIdUsuario());
            stmt.setString(3, tarea.getTitulo());
            stmt.setString(4, tarea.getDescripcion());
            stmt.setDate(5, tarea.getFechaLimite());
            stmt.executeUpdate();
        }
    }

    public List<Tarea> obtenerTareas() throws SQLException {
        List<Tarea> tareas = new ArrayList<>();
        String sql = "SELECT * FROM Tareas";
        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Tarea tarea = new Tarea();
                tarea.setId(rs.getInt("id_tareas"));
                tarea.setIdMateria(rs.getInt("id_materia"));
                tarea.setIdUsuario(rs.getInt("id_usuario"));
                tarea.setTitulo(rs.getString("titulo"));
                tarea.setDescripcion(rs.getString("descripcion"));
                tarea.setFechaLimite(rs.getDate("fecha_limite"));
                tareas.add(tarea);
            }
        }
        return tareas;
    }
}

