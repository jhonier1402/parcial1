import java.util.Scanner;

// Clase principal del programa
public class Main {
    public static void main(String[] args) {
        // Se crea un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Se crea una instancia del sistema de reserva
        sistemaReserva sistema = new sistemaReserva();

        // Usuario actualmente conectado (null si nadie ha iniciado sesión)
        Usuario usuarioActual = null;

        // Ciclo infinito que muestra el menú hasta que el usuario decida salir
        while (true) {
            System.out.println("----- MENU -----");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesion");
            System.out.println("3. Consultar vuelos");
            System.out.println("4. Reservar vuelo");
            System.out.println("5. Ver mis reservas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            String opcion = scanner.nextLine();

            // Se evalúa la opción ingresada por el usuario
            switch (opcion) {
                case "1":
                    // Registrar un nuevo usuario
                    registrarUsuario(scanner, sistema);
                    break;
                case "2":
                    // Iniciar sesión
                    usuarioActual = iniciarSesion(scanner, sistema);
                    break;
                case "3":
                    // Consultar vuelos disponibles
                    sistema.consultarVuelos();
                    break;
                case "4":
                    // Reservar un vuelo (solo si hay un usuario autenticado)
                    if (usuarioActual != null) {
                        sistema.reservarVuelo(scanner, usuarioActual);
                    } else {
                        System.out.println("Debe iniciar sesion primero.");
                    }
                    break;
                case "5":
                    // Ver reservas del usuario actual (si está autenticado)
                    if (usuarioActual != null) {
                        sistema.verReservas(usuarioActual);
                    } else {
                        System.out.println("Debe iniciar sesion primero.");
                    }
                    break;
                case "6":
                    // Salir del programa
                    System.out.println("Hasta luego");
                    scanner.close();
                    return;
                default:
                    // Opción inválida
                    System.out.println("Opcion invalida.");
            }
        }
    }

    // Método para registrar un nuevo usuario
    public static void registrarUsuario(Scanner scanner, sistemaReserva sistema) {
        System.out.print("Ingrese su correo: ");
        String correo = scanner.nextLine();
        System.out.print("Cree una contrasena: ");
        String contrasena = scanner.nextLine();

        // Intenta registrar al usuario
        boolean registrado = sistema.registrarUsuario(correo, contrasena);
        if (registrado) {
            System.out.println("Usuario registrado correctamente.");
        } else {
            System.out.println("El correo ya esta registrado o es invalido.");
        }
    }

    // Método para iniciar sesión
    public static Usuario iniciarSesion(Scanner scanner, sistemaReserva sistema) {
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        System.out.print("Contrasena: ");
        String contrasena = scanner.nextLine();

        // Intenta autenticar al usuario
        Usuario usuario = sistema.iniciarSesion(correo, contrasena);
        if (usuario != null) {
            System.out.println("Inicio de sesion exitoso.");
            return usuario;
        } else {
            System.out.println("Correo o contrasena incorrectos.");
            return null;
        }
    }
}
