package factorymethod;

import productos.Computadora;
import productos.Producto;

import java.util.HashMap;
import java.util.Map;

/**
 * Fabricante concreto (Factory Method) para Computadora.
 * Aquí definimos cómo crear una Computadora básica (sin línea).
 * Para familias por línea usa Abstract Factory (fabricaabstracta).
 */
public class FabricaComputadora implements FabricaProducto {

    @Override
    public Producto crearProducto(String modelo) {
        Map<String, String> specs = new HashMap<>();
        specs.put("CPU", "Intel i5");
        specs.put("RAM", "8GB");
        specs.put("Almacenamiento", "512GB SSD");
        double precio = 800.0;
        return new Computadora("Generica", modelo != null ? modelo : "Comp-Base", precio, specs);
    }
}