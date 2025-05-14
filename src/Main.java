import java.util.Scanner; // Importamos Scanner para leer datos desde teclado

public class Main {
    // Definimos los maximos de usuarios y reservas
    static final int MAX_USUARIOS = 100;
    static final int MAX_RESERVAS = 100;

    // Arreglos para guardar correos y contrasenas de los usuarios
    static String[] correos = new String[MAX_USUARIOS];
    static String[] contrasenas = new String[MAX_USUARIOS];
    static int totalUsuarios = 0;

    // Arreglo para guardar las reservas
    static String[] reservas = new String[MAX_RESERVAS];
    static int totalReservas = 0;

    // Metodo principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creamos el lector
        boolean salir = false; // Variable para controlar la salida del menu

        // Ciclo del menu principal
        while (!salir) {
            System.out.println("--- SISTEMA DE RESERVA DE VUELOS ---");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesion");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opcion: ");

            int opcion = scanner.nextInt(); // Leemos la opcion
            scanner.nextLine(); // Limpiamos el salto de linea

            if (opcion == 1) {
                registrarUsuario(scanner);
            }
            if (opcion == 2) {
                int usuarioIndex = iniciarSesion(scanner);
                if (usuarioIndex != -1) {
                    menuUsuario(scanner, usuarioIndex);
                }
            }
            if (opcion == 3) {
                salir = true;
                System.out.println("Saliendo del sistema...");
            } else {
                System.out.println("Opcion no valida.");
            }
        }

        scanner.close(); // Cerramos el scanner al final del programa
    }

    // Funcion para registrar un usuario
    public static void registrarUsuario(Scanner scanner) {
        String correo;

        // Validar que el correo contenga al menos "@" y "."
        while (true) {
            System.out.print("Ingrese su correo: ");
            correo = scanner.nextLine();

            boolean esCorreoValido = correo.contains("@") && correo.contains(".");
            if (esCorreoValido) {
                break; // Salir del ciclo si es valido
            }

            System.out.println("Correo invalido. Intente nuevamente.");
        }

        int i = 0;
        boolean yaExiste = false;

        // Verificar si ya esta registrado
        while (i < totalUsuarios) {
            if (correos[i].equals(correo)) {
                yaExiste = true;
                break;
            }
            i++;
        }

        if (yaExiste) {
            System.out.println("Ya existe un usuario con ese correo.");
            return;
        }

        // Solicitar contrasena
        System.out.print("Cree una contrasena: ");
        String contrasena = scanner.nextLine();

        // Registrar el usuario
        correos[totalUsuarios] = correo;
        contrasenas[totalUsuarios] = contrasena;
        totalUsuarios++;

        System.out.println("Usuario registrado correctamente.");
    }

    // Funcion para iniciar sesion
    public static int iniciarSesion(Scanner scanner) {
        System.out.println("Correo: ");
        String correo = scanner.nextLine();
        System.out.println("Contrasena: ");
        String contrasena = scanner.nextLine();

        int i = 0;
        while (i < totalUsuarios) {
            if (correos[i].equals(correo) && contrasenas[i].equals(contrasena)) {
                System.out.println("Inicio de sesion exitoso.");
                return i;
            }
            i++;
        }

        System.out.println("Credenciales incorrectas.");
        return -1;
    }

    // Menu que aparece despues de iniciar sesion
    public static void menuUsuario(Scanner scanner, int usuarioIndex) {
        boolean cerrarSesion = false;

        while (!cerrarSesion) {
            System.out.println("--- MENU PRINCIPAL ---");
            System.out.println("1. Consultar vuelos");
            System.out.println("2. Reservar vuelo");
            System.out.println("3. Comprar billete");
            System.out.println("4. Ver mis reservas");
            System.out.println("5. Cerrar sesion");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                mostrarConsultaVuelos(scanner);
            } else if (opcion == 2) {
                reservarVuelo(scanner, usuarioIndex);
            } else if (opcion == 3) {
                comprarBillete(scanner, usuarioIndex);
            } else if (opcion == 4) {
                verReservas(usuarioIndex);
            } else if (opcion == 5) {
                cerrarSesion = true;
            } else {
                System.out.println("Opcion no valida.");
            }
        }
    }

    // Funcion para mostrar informacion de vuelos
    public static void mostrarConsultaVuelos(Scanner scanner) {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- CONSULTA DE VUELOS ---");
            System.out.println("1. Horarios");
            System.out.println("2. Tarifas");
            System.out.println("3. Informacion de vuelos");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.println("Horarios disponibles: ");
                System.out.println("- 08:00 Bogota - Medellin");
                System.out.println("- 14:00 Bogota - Cali");
            } else if (opcion == 2) {
                System.out.println("Tarifas promedio:");
                System.out.println("- Bogota - Medellin: $200000");
                System.out.println("- Bogota - Cali: $180000");
            } else if (opcion == 3) {
                System.out.println("Vuelos directos y con disponibilidad.");
            } else if (opcion == 4) {
                volver = true;
            } else {
                System.out.println("Opcion no valida.");
            }
        }
    }

    // Funcion para reservar un vuelo
    public static void reservarVuelo(Scanner scanner, int usuarioIndex) {
        int asientosDisponibles = MAX_RESERVAS - totalReservas;
        System.out.println("Asientos disponibles: " + asientosDisponibles);

        if (asientosDisponibles <= 0) {
            System.out.println("No hay asientos disponibles.");
            return;
        }

        System.out.print("Ingrese destino: ");
        String destino = scanner.nextLine();
        System.out.print("Ingrese fecha (dd/mm/aaaa): ");
        String fecha = scanner.nextLine();
        System.out.print("Ingrese hora (hh:mm): ");
        String hora = scanner.nextLine();

        String reserva = "Reserva de " + correos[usuarioIndex] + ": " + destino + " - " + fecha + " " + hora;
        reservas[totalReservas] = reserva;
        totalReservas++;

        System.out.println("Reserva realizada con exito.");
    }
    // Funcion para comprar un billete
    public static void comprarBillete(Scanner scanner, int usuarioIndex) {
        System.out.print("¿Tiene una reserva previa? (si/no): ");
        String tieneReserva = scanner.nextLine();

        if (tieneReserva.equalsIgnoreCase("si")) {
            System.out.println("Compra realizada con tarjeta registrada. Billete listo para ser recogido.");
        } else {
            System.out.print("Ingrese destino: ");
            String destino = scanner.nextLine();
            System.out.println("Billete comprado para " + destino + ". Tarjeta registrada.");
        }
    }
    // Funcion para ver las reservas del usuario actual
    public static void verReservas(int usuarioIndex) {
        System.out.println("\n--- TUS RESERVAS ---");
        int i = 0;
        boolean encontrado = false;

        while (i < totalReservas) {
            if (reservas[i].contains(correos[usuarioIndex])) {
                System.out.println("- " + reservas[i]);
                encontrado = true;
            }
            i++;
        }
        if (!encontrado) {
            System.out.println("No tienes reservas registradas.");
        }
    }
}
