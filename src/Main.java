import java.util.Scanner;

public class Main {

    // Paso 2: Declaramos arreglos globales para usuarios
    static final int MAX_USUARIOS = 50; // Máximo número de usuarios

    static String[] correos = new String[MAX_USUARIOS];     // Arreglo para guardar correos
    static String[] contraseñas = new String[MAX_USUARIOS]; // Arreglo para guardar contraseñas
    static int totalUsuarios = 0; // Lleva la cuenta de cuántos usuarios se han registrado

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creamos el lector de datos desde teclado
        boolean salir = false; // Variable para controlar la salida del programa

        while (!salir) {
            System.out.println("--- SISTEMA DE RESERVA DE VUELOS --- ");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.println("Registrarse");
            }
            if (opcion == 2) {
                System.out.println("inicio de sesión");
            }
            if (opcion == 3) {
                System.out.println("saliendo");
            } else {
                System.out.println("Opcion no valida");
            }
        }
        scanner.close();
    }
    public static void registrarUsuario(Scanner scanner) {
        System.out.println("Ingrese su correo: ");//pedimos su correo
        String correo = scanner.nextLine();

        int i = 0;
        boolean yaExiste = false;
        while (i < totalUsuarios) {
            if (correo.equals(correos[i])) {
                yaExiste = true;
                break;
            }
            i++;
        }
        if (yaExiste) {
            System.out.println("El correo ya existe");
            return;
        }
        System.out.println("cree una contraseña");
        String contraseña = scanner.nextLine();

        correos[totalUsuarios] = correo;
        contraseñas[totalUsuarios] = contraseña;
        totalUsuarios++;

        System.out.println("Usuario registrado correctamente.");
    }

    }




