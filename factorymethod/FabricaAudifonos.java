package factorymethod;

import productos.Audifonos;
import productos.Producto;

import java.util.HashMap;
import java.util.Map;

public class FabricaAudifonos implements FabricaProducto {

    @Override
    public Producto crearProducto(String marca, String modelo, Double precio, Map<String, String> especificaciones) {
        Map<String, String> specs = new HashMap<>();
        specs.put("Tipo", "Over-Ear");
        specs.put("Conexion", "Bluetooth 5.0");
        specs.put("Bateria", "20 horas");
        specs.put("CancelacionRuido", "Activa");

        if (especificaciones != null && !especificaciones.isEmpty()) {
            specs.putAll(especificaciones); // permite sobrescribir
        }

        String marcaFinal = (marca == null || marca.isEmpty()) ? "Genérica" : marca;
        String modeloFinal = (modelo == null || modelo.isEmpty()) ? "Audifonos-Base" : modelo;
        double precioFinal = (precio == null || precio <= 0) ? 250.0 : precio;

        return new Audifonos(marcaFinal, null, modeloFinal, precioFinal, specs);
    }
}
