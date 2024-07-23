/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dao.TaskDAO;
import model.task;
import view.taskManager;

/**
 *
 * @author marin
 */
public class TaskController implements ActionListener {
    
    TaskDAO dao = new TaskDAO();
    task t = new task();
    taskManager vista = new taskManager();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public TaskController(taskManager v) {
        this.vista = vista;
        this.vista.btnListar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnListar) {
            listar(vista.tabla);
        }
    }
    
    public void listar(JTable tabla) {
        modelo=(DefaultTableModel)tabla.getModel();    
        List<task>lista=dao.listar();
        Object[]object=new Object[7];
        for (int i = 0; i < lista.size(); i++) {
            object[0]=lista.get(i).getId();
            object[1]=lista.get(i).getNombre();
            object[2]=lista.get(i).getDescripcion();
            object[3]=lista.get(i).getEstado();
            object[4]=lista.get(i).getResponsable();
            object[5]=lista.get(i).getFechaLimite();
            object[6]=lista.get(i).getPrioridad();
            modelo.addRow(object);
        }
        vista.tabla.setModel(modelo);
    }
}
