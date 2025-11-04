package factorymethod;

import productos.Producto;

/**
 * Patrón Factory Method:
 * Define la interfaz del "fabricante" que crea productos.
 */
public interface FabricaProducto {
    Producto crearProducto(String modelo);
}