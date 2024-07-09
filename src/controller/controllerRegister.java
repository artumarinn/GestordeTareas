package controller;

import model.user;
import model.conn_db;

public class controllerRegister {
    
    // declaracion de objeto de la conexion de la bd
    private conn_db database;
    
    // Inicializar objeto de conexion a la base de datos
    public controllerRegister() {
        this.database = new conn_db();
    }
    
    // metodo para registrar nuevo usuario
    public boolean registrarUsuario(String dni, String nombreCompleto, String contraseña) {
        user nuevoUsuario = new user(dni, nombreCompleto, contraseña);
        return database.registrarUsuario(nuevoUsuario);
    }
    
    
}
