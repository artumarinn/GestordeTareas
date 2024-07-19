/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;


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
}
