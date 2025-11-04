package factorymethod;

import productos.Producto;
import productos.Tableta;

import java.util.HashMap;
import java.util.Map;

public class FabricaTableta implements FabricaProducto {

    @Override
    public Producto crearProducto(String modelo) {
        Map<String, String> specs = new HashMap<>();
        specs.put("Pantalla", "10.1\"");
        specs.put("RAM", "4GB");
        specs.put("Almacenamiento", "128GB");
        double precio = 300.0;
        return new Tableta("Generica", modelo != null ? modelo : "Tab-Base", precio, specs);
    }
}