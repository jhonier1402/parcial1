import java.util.ArrayList;
import java.util.Scanner;

// Clase que maneja el sistema de reservas de vuelos
public class sistemaReserva {

    // Lista de usuarios registrados
    private ArrayList<Usuario> usuarios;

    // Lista de reservas realizadas
    private ArrayList<Reserva> reservas;

    // Constructor: inicializa las listas de usuarios y reservas
    public sistemaReserva() {
        usuarios = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    // Método que muestra los vuelos disponibles (simulados)
    public void consultarVuelos() {
        System.out.println("Vuelos disponibles:");
        System.out.println("1. Bogota - Medellin | 10/06/2025 | 08:00");
        System.out.println("2. Bogota - Cali | 11/06/2025 | 12:30");
    }

    // Registra un nuevo usuario si el correo no está ya registrado
    public boolean registrarUsuario(String correo, String contrasena) {
        int i = 0;
        // Recorre la lista de usuarios para verificar si el correo ya existe
        while (i < usuarios.size()) {
            Usuario u = usuarios.get(i);
            if (u.getCorreo().equalsIgnoreCase(correo)) {
                return false; // Ya existe un usuario con ese correo
            }
            i++;
        }
        // Agrega el nuevo usuario a la lista
        usuarios.add(new Usuario(correo, contrasena));
        return true;
    }

    // Autentica a un usuario a partir de su correo y contraseña
    public Usuario iniciarSesion(String correo, String contrasena) {
        int i = 0;
        // Busca el usuario que coincida con los datos ingresados
        while (i < usuarios.size()) {
            Usuario u = usuarios.get(i);
            if (u.getCorreo().equalsIgnoreCase(correo) && u.getContrasena().equals(contrasena)) {
                return u; // Autenticación exitosa
            }
            i++;
        }
        return null; // Usuario no encontrado o datos incorrectos
    }

    // Permite a un usuario reservar un vuelo ingresando datos por consola
    public void reservarVuelo(Scanner scanner, Usuario usuario) {
        System.out.print("Destino: ");
        String destino = scanner.nextLine();

        System.out.print("Fecha (dd/mm/yyyy): ");
        String fecha = scanner.nextLine();

        System.out.print("Hora (HH:mm): ");
        String hora = scanner.nextLine();

        // Crea una nueva reserva y la agrega a la lista
        Reserva nueva = new Reserva(usuario, destino, fecha, hora);
        reservas.add(nueva);
        System.out.println("Reserva registrada con exito.");
    }

    // Retorna todas las reservas hechas por un usuario específico
    public ArrayList<Reserva> obtenerReservasDe(Usuario usuario) {
        ArrayList<Reserva> resultado = new ArrayList<>();
        int i = 0;
        while (i < reservas.size()) {
            Reserva r = reservas.get(i);
            if (r.getUsuario().equals(usuario)) {
                resultado.add(r);
            }
            i++;
        }
        return resultado;
    }

    // Muestra todas las reservas de un usuario
    public void verReservas(Usuario usuario) {
        ArrayList<Reserva> lista = obtenerReservasDe(usuario);
        int i = 0;
        while (i < lista.size()) {
            Reserva r = lista.get(i);
            r.mostrarReserva(); // Se asume que este método imprime los detalles de la reserva
            i++;
        }
    }
}
