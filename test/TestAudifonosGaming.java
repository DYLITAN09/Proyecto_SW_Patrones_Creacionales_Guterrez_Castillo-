package test;

import fabricaabstracta.*;
import factorymethod.*;
import productos.Audifonos;
import productos.Producto;

import java.util.HashMap;
import java.util.Map;

public class TestAudifonosGaming {

    public static void main(String[] args) {
        System.out.println("=== TEST: Audífonos - Gaming ===\n");

        // -------------------------------
        // 1. Crear audífonos con Abstract Factory Gaming
        // -------------------------------
        FabricaLinea fabricaGaming = new FabricaLineaGaming();
        Audifonos audifonosGaming = fabricaGaming.crearAudifonos();
        System.out.println("Audífonos Gaming (Abstract Factory):");
        audifonosGaming.mostrarInfo();
        System.out.println("---------------------------------\n");

        // -------------------------------
        // 2. Crear audífonos con Factory Method personalizado
        // -------------------------------
        FabricaProducto fabricaAudifonos = new FabricaAudifonos();
        Map<String, String> specsPersonalizadas = new HashMap<>();
        specsPersonalizadas.put("Iluminación", "RGB Dinámica");
        specsPersonalizadas.put("Cancelación de ruido", "Activa + Pasiva");
        Producto audifonosPersonalizados = fabricaAudifonos.crearProducto(
                "HyperX",
                "Cloud II Gaming",
                200.0,
                specsPersonalizadas);

        System.out.println("Audífonos Personalizados (Factory Method):");
        audifonosPersonalizados.mostrarInfo();
        System.out.println("---------------------------------\n");

        // -------------------------------
        // 3. Probar clonación (Prototype)
        // -------------------------------
        Producto clonAudifonos = audifonosGaming.clonar();
        System.out.println("Clon de Audífonos Gaming (Prototype):");
        clonAudifonos.mostrarInfo();
        System.out.println("---------------------------------\n");

        System.out.println("=== TEST COMPLETADO ===");
    }
}
