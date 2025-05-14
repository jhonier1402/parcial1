import java.util.Scanner;

public class Main {
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
}



