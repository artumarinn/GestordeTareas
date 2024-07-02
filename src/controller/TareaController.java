
package controller;

import model.Tarea;
import model.TareaDAO;
import java.sql.SQLException;
import java.util.List;

public class TareaController {
    private TareaDAO tareaDAO;

    public TareaController() {
        this.tareaDAO = new TareaDAO();
    }

    public void agregarTarea(Tarea tarea) throws SQLException {
        tareaDAO.agregarTarea(tarea);
    }

    public List<Tarea> obtenerTareas() throws SQLException {
        return tareaDAO.obtenerTareas();
    }
}
