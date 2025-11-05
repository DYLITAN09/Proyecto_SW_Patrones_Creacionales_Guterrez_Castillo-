package test;

import factorymethod.*;
import productos.Producto;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestFactoryMethod {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Test Factory Method ===");

        // Selección de tipo de producto
        System.out.println("Seleccione tipo de producto:");
        System.out.println("1) Computadora");
        System.out.println("2) Teléfono");
        System.out.println("3) Tableta");

        int opcion = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        FabricaProducto fabrica;

        switch (opcion) {
            case 1 -> fabrica = new FabricaComputadora();
            case 2 -> fabrica = new FabricaTelefono();
            case 3 -> fabrica = new FabricaTableta();
            default -> {
                System.out.println("Opción inválida.");
                sc.close();
                return;
            }
        }

        // Solicitar datos al usuario
        System.out.print("Ingrese marca (Enter = Genérica): ");
        String marca = sc.nextLine().trim();

        System.out.print("Ingrese modelo (Enter = modelo por defecto): ");
        String modelo = sc.nextLine().trim();

        System.out.print("Ingrese precio (0 = precio por defecto): ");
        double precio;
        try {
            precio = Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            precio = 0;
        }

        // Preguntar si desea agregar especificaciones personalizadas
        System.out.print("¿Desea agregar especificaciones personalizadas? (s/n): ");
        String respuesta = sc.nextLine().trim().toLowerCase();

        Map<String, String> especificaciones = null;
        if (respuesta.equals("s") || respuesta.equals("si")) {
            especificaciones = new HashMap<>();
            System.out.println("\nIngrese especificaciones (Enter en 'Clave' para terminar):");

            while (true) {
                System.out.print("  Clave: ");
                String clave = sc.nextLine().trim();
                if (clave.isEmpty()) {
                    break;
                }

                System.out.print("  Valor: ");
                String valor = sc.nextLine().trim();

                if (!valor.isEmpty()) {
                    especificaciones.put(clave, valor);
                    System.out.println("  Añadido: " + clave + " = " + valor);
                }
            }
        }

        // Crear producto usando Factory Method
        Producto producto = fabrica.crearProducto(
                marca.isEmpty() ? null : marca,
                modelo.isEmpty() ? null : modelo,
                precio == 0 ? null : precio,
                especificaciones);

        System.out.println("\n--- Producto creado ---");
        producto.mostrarInfo();

        sc.close();
    }
}