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
import javax.swing.table.DefaultTableModel;
import model.DbConnection;
import model.task;
import view.taskManager;
/**
 *
 * @author marin
 */

public class TaskController {
    private task model;
    private taskManager view;

    public TaskController(task model, taskManager view) {
        this.model = model;
        this.view = view;
        initController();
    }

    private void initController() {
        view.getBtnAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarTask();
            }
        });
    }

    private void agregarTask() {
        String nombre = view.getTxtNombre().getText().trim();

        if (!nombre.isEmpty()) {
            DefaultTableModel tableModel = (DefaultTableModel) view.getJTable1().getModel();
            tableModel.addRow(new Object[]{null, nombre});
            view.getTxtNombre().setText("");

            try (Connection conn = DbConnection.getConnection()) {
                String sql = "INSERT INTO tareas (nombre) VALUES (?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, nombre);
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(view, "Nombre agregado a la base de datos.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(view, "Error al agregar el nombre a la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(view, "El campo de nombre está vacío", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

