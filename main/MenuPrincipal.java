/**
 * Version del menu para probar el patron de Singleton.
 */

package main;

import singleton.ConfiguracionGlobal;
import java.util.Scanner;

public class MenuPrincipal {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== Sistema de Configuración Global (Singleton) ===");
            System.out.println("1. Mostrar y modificar configuración");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> probarSingleton();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void probarSingleton() {
        ConfiguracionGlobal config = ConfiguracionGlobal.getInstancia();
        int opcion;
        do {
            System.out.println("\n=== Configuración Global ===");
            config.mostrarConfiguracion();
            System.out.println("1. Activar/desactivar modo debug");
            System.out.println("2. Cambiar entorno");
            System.out.println("3. Cambiar idioma");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese true para activar o false para desactivar: ");
                    config.setModoDebug(sc.nextBoolean());
                    sc.nextLine();
                }
                case 2 -> {
                    System.out.print("Ingrese el entorno (Producción/Desarrollo/Pruebas): ");
                    config.setEntorno(sc.nextLine());
                }
                case 3 -> {
                    System.out.print("Ingrese idioma (Español/Inglés): ");
                    config.setIdioma(sc.nextLine());
                }
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

}