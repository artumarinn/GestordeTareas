package model;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

// definir atributos 
public class conn_db {
    String db = "gestor_de_tareas";
    String url = "jdbc:mysql://localhost:3306/" + db; // URL incluye el nombre de la base de datos
    String user = "root";
    String password = "marin";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;
    public conn_db() {
    }
    
    // metodo para la conexion de la bd
    public Connection conectar() {
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url, user, password); // Método corregido
            System.out.println("Se conecto a la BD " + db);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(conn_db.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en la conexion a la BD " + db);
        }
        
        return cx;
    }
    
     // metodo para desconectar de la bd
    public void desconectar() {
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(conn_db.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        conn_db conexion = new conn_db();
        conexion.conectar();
    }
}
