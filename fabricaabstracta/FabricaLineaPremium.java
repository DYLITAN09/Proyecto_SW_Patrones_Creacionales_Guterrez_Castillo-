package fabricaabstracta;

import productos.*;
import java.util.HashMap;
import java.util.Map;

public class FabricaLineaPremium implements FabricaLinea {

    @Override
    public Computadora crearComputadora() {
        Map<String, String> specs = new HashMap<>();
        specs.put("CPU", "Intel i9");
        specs.put("RAM", "32GB");
        specs.put("Almacenamiento", "2TB SSD");
        return new Computadora("Alienware", "Premium", "Comp-PRO", 2500.0, specs);
    }

    @Override
    public Telefono crearTelefono() {
        Map<String, String> specs = new HashMap<>();
        specs.put("Pantalla", "6.8\" AMOLED 120Hz");
        specs.put("Bateria", "5000mAh");
        specs.put("Camara", "108MP");
        return new Telefono("Samsung", "Premium", "Galaxy Ultra", 1800.0, specs);
    }

    @Override
    public Tableta crearTableta() {
        Map<String, String> specs = new HashMap<>();
        specs.put("Pantalla", "12.9\" Retina");
        specs.put("RAM", "16GB");
        specs.put("Almacenamiento", "1TB");
        return new Tableta("Apple", "Premium", "iPad Pro", 1500.0, specs);
    }

    @Override
    public Audifonos crearAudifonos() {
        Map<String, String> specs = new HashMap<>();
        specs.put("Tipo", "Over-Ear");
        specs.put("Conexion", "Bluetooth 5.3");
        specs.put("Bateria", "40 horas");
        specs.put("CancelacionRuido", "Activa (ANC)");
        specs.put("Compatibilidad", "Dolby Atmos");
        return new Audifonos("Sony", "Premium", "WH-1000XM5", 500.0, specs);
    }

}
