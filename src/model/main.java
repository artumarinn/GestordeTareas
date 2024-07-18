package model;

import model.task;
import view.taskManager;
import controller.TaskController;

public class main {
    public static void main(String[] args) {
        task model = new task(0, "");
        taskManager view = new taskManager();
        TaskController controller = new TaskController(model, view);
        
        view.setVisible(true);
    }
}
