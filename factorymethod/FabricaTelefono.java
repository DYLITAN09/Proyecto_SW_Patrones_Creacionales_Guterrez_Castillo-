package factorymethod;

import productos.Producto;
import productos.Telefono;

import java.util.HashMap;
import java.util.Map;

public class FabricaTelefono implements FabricaProducto {

    @Override
    public Producto crearProducto(String modelo) {
        Map<String, String> specs = new HashMap<>();
        specs.put("Pantalla", "6.1\"");
        specs.put("Batería", "3500mAh");
        specs.put("Cámara", "12MP");
        double precio = 500.0;
        return new Telefono("Generico", modelo != null ? modelo : "Tel-Base", precio, specs);
    }
}