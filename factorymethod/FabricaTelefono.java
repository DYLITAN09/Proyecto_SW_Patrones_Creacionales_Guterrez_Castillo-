package factorymethod;

import productos.Producto;
import productos.Telefono;

import java.util.HashMap;
import java.util.Map;

/**
 * Fabricante concreto (Factory Method) para Telefonos.
 * Aquí definimos cómo crear un telefono básico (sin línea), por lo tanto se
 * manda null.
 * Para familias por línea usa Abstract Factory (fabricaabstracta).
 */
public class FabricaTelefono implements FabricaProducto {

    @Override
    public Producto crearProducto(String marca, String modelo, Double precio, Map<String, String> especificaciones) {
        Map<String, String> specs = new HashMap<>();
        specs.put("Pantalla", "6.1\"");
        specs.put("Batería", "3500mAh");
        specs.put("Cámara", "12MP");

        if (especificaciones != null && !especificaciones.isEmpty()) {
            specs.putAll(especificaciones); // ← ESTO DEBE SOBRESCRIBIR
        }

        String marcaFinal = (marca == null || marca.isEmpty()) ? "Genérica" : marca;
        String modeloFinal = (modelo == null || modelo.isEmpty()) ? "Tel-Base" : modelo;
        double precioFinal = (precio == null || precio <= 0) ? 500.0 : precio;

        return new Telefono(marcaFinal, null, modeloFinal, precioFinal, specs);
    }
}
