package factorymethod;

import productos.Producto;
import java.util.Map;

/**
 * Patrón Factory Method:
 * Define la interfaz del "fabricante" que crea productos.
 */
public interface FabricaProducto {
    Producto crearProducto(String marca, String modelo, Double precio, Map<String, String> especificaciones);
}