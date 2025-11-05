package test;

import productos.Producto;
import productos.Computadora;
import prototype.GestorPrototipos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de prueba para el patrón Prototype.
 * Permite registrar, clonar y crear variantes de productos electrónicos.
 */
public class TestPrototype {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Producto> inventario = new ArrayList<>();

    public static void main(String[] args) {
        probarPrototype();
    }

    private static void probarPrototype() {
        GestorPrototipos gestor = new GestorPrototipos();

        int opcion;
        do {
            System.out.println("\n=== GESTOR DE PROTOTIPOS ===");
            System.out.println("1. Registrar producto como prototipo");
            System.out.println("2. Listar prototipos registrados");
            System.out.println("3. Clonar prototipo exacto");
            System.out.println("4. Crear variante personalizada");
            System.out.println("5. Listar clones/variantes creadas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcionMenu();

            switch (opcion) {
                case 1 -> registrarPrototipo(gestor);
                case 2 -> gestor.listarPrototipos();
                case 3 -> clonarPrototipoExacto(gestor);
                case 4 -> crearVariante(gestor);
                case 5 -> listarClones();
                case 0 -> System.out.println("Saliendo del gestor...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    // -------------------------------
    // Registrar un prototipo
    private static void registrarPrototipo(GestorPrototipos gestor) {
        System.out.println("\n--- Registro de nuevo prototipo ---");

        System.out.print("Ingrese tipo de producto (Computadora, Teléfono, Tableta): ");
        String tipo = sc.nextLine().trim();

        System.out.print("Ingrese línea (Premium, Estándar, Económica): ");
        String linea = sc.nextLine().trim();

        System.out.print("Ingrese marca: ");
        String marca = sc.nextLine().trim();

        System.out.print("Ingrese modelo: ");
        String modelo = sc.nextLine().trim();

        System.out.print("Ingrese precio: ");
        double precio = Double.parseDouble(sc.nextLine().trim());

        // Crear una computadora básica usando setters (sin constructor)
        Computadora producto = new Computadora();
        producto.setMarca(marca);
        producto.setModelo(modelo);
        producto.setLinea(linea);
        producto.setPrecio(precio);
        // si el Producto define tipo, también lo seteamos:
        try {
            var tipoField = producto.getClass().getSuperclass().getDeclaredField("tipo");
            tipoField.setAccessible(true);
            tipoField.set(producto, tipo);
        } catch (Exception ignored) {
        }

        // Permitir ingresar especificaciones iniciales
        System.out.println("¿Desea agregar especificaciones? (s/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("s")) {
            while (true) {
                System.out.print("Nombre de especificación (o 'fin' para terminar): ");
                String nombre = sc.nextLine().trim();
                if (nombre.equalsIgnoreCase("fin"))
                    break;

                System.out.print("Valor: ");
                String valor = sc.nextLine().trim();
                producto.getEspecificaciones().put(nombre, valor);
            }
        }

        System.out.print("Ingrese un ID único para este prototipo: ");
        String id = sc.nextLine().trim();

        gestor.registrarPrototipo(id, producto);
        System.out.println(" Prototipo registrado exitosamente.");
    }

    // -------------------------------
    private static void clonarPrototipoExacto(GestorPrototipos gestor) {
        System.out.print("Ingrese el ID del prototipo a clonar: ");
        String id = sc.nextLine().trim();

        try {
            Producto clon = gestor.clonarExacto(id);
            clon.marcarComoClon(id);
            inventario.add(clon);
            System.out.println("\n Clon creado exitosamente:");
            clon.mostrarInfo();
        } catch (Exception e) {
            System.out.println(" Error al clonar: " + e.getMessage());
        }
    }

    // -------------------------------
    private static void crearVariante(GestorPrototipos gestor) {
        System.out.print("Ingrese el ID del prototipo base: ");
        String id = sc.nextLine().trim();

        System.out.print("Nueva marca (Enter para mantener): ");
        String marca = sc.nextLine().trim();

        System.out.print("Nuevo modelo (Enter para mantener): ");
        String modelo = sc.nextLine().trim();

        System.out.print("Nuevo precio (Enter para mantener): ");
        String precioTexto = sc.nextLine().trim();
        Double precio = null;
        if (!precioTexto.isEmpty()) {
            try {
                precio = Double.parseDouble(precioTexto);
            } catch (NumberFormatException e) {
                System.out.println("Precio inválido, se mantiene el original.");
            }
        }

        // Permitir modificar/agregar especificaciones
        Map<String, String> nuevasEspecificaciones = new HashMap<>();
        System.out.print("¿Desea agregar o modificar especificaciones? (s/n): ");
        String respuesta = sc.nextLine().trim();

        if (respuesta.equalsIgnoreCase("s")) {
            while (true) {
                System.out.print("Nombre de especificación (o 'fin' para terminar): ");
                String nombre = sc.nextLine().trim();
                if (nombre.equalsIgnoreCase("fin"))
                    break;

                System.out.print("Valor: ");
                String valor = sc.nextLine().trim();
                nuevasEspecificaciones.put(nombre, valor);
            }
        }

        try {
            Producto variante;
            if (nuevasEspecificaciones.isEmpty()) {
                variante = gestor.crearVariante(id,
                        marca.isEmpty() ? null : marca,
                        modelo.isEmpty() ? null : modelo,
                        precio);
            } else {
                variante = gestor.crearVarianteConEspecificaciones(id,
                        marca.isEmpty() ? null : marca,
                        modelo.isEmpty() ? null : modelo,
                        precio,
                        nuevasEspecificaciones);
            }

            variante.marcarComoClon(id);
            inventario.add(variante);
            System.out.println("\n Variante creada exitosamente:");
            variante.mostrarInfo();
        } catch (Exception e) {
            System.out.println(" Error al crear variante: " + e.getMessage());
        }
    }

    // -------------------------------
    private static void listarClones() {
        if (inventario.isEmpty()) {
            System.out.println("\nNo se han creado clones ni variantes todavía.");
            return;
        }

        System.out.println("\n--- Clones y Variantes Creadas ---");
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println("[" + (i + 1) + "]");
            inventario.get(i).mostrarInfo();
            System.out.println();
        }
    }

    private static int leerOpcionMenu() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
