package model;

public class user {
    
    private String dni;
    private String nombre_completo;
    private String correo;
    private String usuario;
    private String contraseña;

    public user(String dni, String nombreCompleto, String correo, String usuario, String contraseña) {
        this.dni = dni;
        this.nombre_completo = nombreCompleto;
        this.correo = correo;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombreCompleto) {
        this.nombre_completo = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}
