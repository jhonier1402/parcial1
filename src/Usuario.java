// Clase que representa a un usuario del sistema
public class Usuario {
    // Atributos privados: correo y contraseña del usuario
    private String correo;
    private String contrasena;

    // Constructor: inicializa el correo y la contraseña del usuario
    public Usuario(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    // Método getter: devuelve el correo del usuario
    public String getCorreo() {
        return correo;
    }

    // Método getter: devuelve la contraseña del usuario
    public String getContrasena() {
        return contrasena;
    }

    // Método setter: permite cambiar el correo del usuario
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Método setter: permite cambiar la contraseña del usuario
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}

