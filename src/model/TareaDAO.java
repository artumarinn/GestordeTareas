/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TareaDAO {
    private Connection conn;

    public TareaDAO(Connection conn) {
        this.conn = conn;
    }

    public void agregarTarea(Tarea tarea) throws SQLException {
        String sql = "INSERT INTO tareas (nombre, descripcion, estado, responsable, fecha_limite, prioridad) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tarea.getNombre());
            pstmt.setString(2, tarea.getDescripcion());
            pstmt.setString(3, tarea.getEstado());
            pstmt.setString(4, tarea.getResponsable());
            pstmt.setDate(5, new java.sql.Date(tarea.getFechaLimite().getTime()));
            pstmt.setString(6, tarea.getPrioridad());
            pstmt.executeUpdate();
        }
    }

    public List<Tarea> obtenerTareas() throws SQLException {
        List<Tarea> tareas = new ArrayList<>();
        String sql = "SELECT * FROM tareas";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Tarea tarea = new Tarea();
                tarea.setId(rs.getInt("id"));
                tarea.setNombre(rs.getString("nombre"));
                tarea.setDescripcion(rs.getString("descripcion"));
                tarea.setEstado(rs.getString("estado"));
                tarea.setResponsable(rs.getString("responsable"));
                tarea.setFechaLimite(rs.getDate("fecha_limite"));
                tarea.setPrioridad(rs.getString("prioridad"));
                tareas.add(tarea);
            }
        }
        return tareas;
    }

    // Métodos para actualizar y eliminar tareas
}

