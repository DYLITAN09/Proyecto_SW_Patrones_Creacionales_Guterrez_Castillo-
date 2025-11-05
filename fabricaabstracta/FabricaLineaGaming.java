package fabricaabstracta;

import productos.*;
import java.util.HashMap;
import java.util.Map;

public class FabricaLineaGaming implements FabricaLinea {

    @Override
    public Computadora crearComputadora() {
        Map<String, String> specs = new HashMap<>();
        specs.put("CPU", "Intel i9-14900K");
        specs.put("RAM", "64GB DDR5");
        specs.put("GPU", "NVIDIA RTX 4090");
        specs.put("Almacenamiento", "2TB SSD NVMe");
        specs.put("Refrigeración", "Líquida RGB");

        return new Computadora("Aorus", "Gaming", "Ultra G9", 3500.0, specs);
    }

    @Override
    public Telefono crearTelefono() {
        Map<String, String> specs = new HashMap<>();
        specs.put("Pantalla", "6.8\" AMOLED 165Hz");
        specs.put("Procesador", "Snapdragon 8 Gen 3");
        specs.put("RAM", "18GB");
        specs.put("Batería", "6000mAh");
        specs.put("Sonido", "Estéreo Dolby Atmos");

        return new Telefono("Asus ROG", "Gaming", "Phone 9 Ultimate", 1600.0, specs);
    }

    @Override
    public Tableta crearTableta() {
        Map<String, String> specs = new HashMap<>();
        specs.put("Pantalla", "14.5\" MiniLED 144Hz");
        specs.put("Procesador", "Snapdragon 8+ Gen 1");
        specs.put("RAM", "16GB");
        specs.put("Almacenamiento", "512GB");
        specs.put("GPU", "Adreno Elite Gaming");

        return new Tableta("Lenovo Legion", "Gaming", "Y900", 1100.0, specs);
    }

    @Override
    public Audifonos crearAudifonos() {
        Map<String, String> specs = new HashMap<>();
        specs.put("Tipo", "Over-Ear");
        specs.put("Conectividad", "Wireless 2.4GHz");
        specs.put("Cancelación de ruido", "Activa (ANC)");
        specs.put("Iluminación", "RGB personalizable");
        specs.put("Duración de batería", "100 horas");

        return new Audifonos("Razer", "Gaming", "BlackShark V3 Pro", 300.0, specs);
    }
}
