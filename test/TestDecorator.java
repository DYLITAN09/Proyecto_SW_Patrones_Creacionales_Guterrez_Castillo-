package test;

import decorator.*;
import productos.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase de prueba para demostrar el funcionamiento del patrón Decorator
 * aplicado a productos del sistema de gestión.
 * 
 * Esta clase muestra:
 * - Decoración simple (un solo decorador)
 * - Decoración múltiple (varios decoradores apilados)
 * - Cálculo dinámico de precios y descripciones
 * 
 * @author Dylan Gutierrez y Camilo Castillo
 */
public class TestDecorator {

    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("  PRUEBA DEL PATRÓN DECORATOR");
        System.out.println("===========================================\n");

        // ===== PRUEBA 1: Decorador Simple =====
        pruebaDecoradorSimple();

        System.out.println("\n-------------------------------------------\n");

        // ===== PRUEBA 2: Múltiples Decoradores =====
        pruebaMultiplesDecoradores();

        System.out.println("\n-------------------------------------------\n");

        // ===== PRUEBA 3: Diferentes Combinaciones =====
        pruebaDiferentesCombinaciones();

        System.out.println("\n-------------------------------------------\n");

        // ===== PRUEBA 4: Producto Complejo con Especificaciones =====
        pruebaProductoComplejo();

        System.out.println("\n===========================================");
        System.out.println("  PRUEBAS COMPLETADAS EXITOSAMENTE");
        System.out.println("===========================================");
    }

    /**
     * Prueba 1: Aplicar un solo decorador a un producto
     */
    private static void pruebaDecoradorSimple() {
        System.out.println(">>> PRUEBA 1: Decorador Simple <<<\n");

        // Crear producto base directamente
        Map<String, String> specs = new HashMap<>();
        specs.put("RAM", "16GB");
        specs.put("CPU", "Intel i7");

        Producto laptop = new Computadora("Dell", "Estándar", "Inspiron 15", 2500.0, specs);

        System.out.println("--- Producto Original ---");
        laptop.mostrarInfo();

        // Envolver con ProductoDecorable
        IProducto productoDecorable = new ProductoDecorable(laptop);

        System.out.println("\n--- Con Garantía Extendida ---");
        IProducto conGarantia = new GarantiaExtendida(productoDecorable);
        System.out.println("Descripción: " + conGarantia.getDescripcion());
        System.out.println("Precio: $" + conGarantia.getPrecio());
        System.out.println("Incremento: $" + (conGarantia.getPrecio() - laptop.getPrecio()));
    }

    /**
     * Prueba 2: Apilar múltiples decoradores sobre el mismo producto
     */
    private static void pruebaMultiplesDecoradores() {
        System.out.println(">>> PRUEBA 2: Múltiples Decoradores Apilados <<<\n");

        // Crear producto base directamente
        Map<String, String> specs = new HashMap<>();
        specs.put("Pantalla", "6.8 pulgadas");
        specs.put("Cámara", "200MP");

        Producto telefono = new Telefono("Samsung", "Premium", "Galaxy S23", 3500.0, specs);

        System.out.println("--- Producto Original ---");
        telefono.mostrarInfo();

        // Aplicar decoradores secuencialmente
        IProducto productoDecorable = new ProductoDecorable(telefono);

        System.out.println("\n--- Aplicando Decoradores ---");

        IProducto paso1 = new GarantiaExtendida(productoDecorable);
        System.out.println("1. Con Garantía Extendida:");
        System.out.println("   Descripción: " + paso1.getDescripcion());
        System.out.println("   Precio: $" + paso1.getPrecio());

        IProducto paso2 = new EmbalajePremium(paso1);
        System.out.println("\n2. + Embalaje Premium:");
        System.out.println("   Descripción: " + paso2.getDescripcion());
        System.out.println("   Precio: $" + paso2.getPrecio());

        IProducto paso3 = new SeguroRobo(paso2);
        System.out.println("\n3. + Seguro contra Robo:");
        System.out.println("   Descripción: " + paso3.getDescripcion());
        System.out.println("   Precio: $" + paso3.getPrecio());

        System.out.println("\n--- Resumen Final ---");
        System.out.println("Precio original: $" + telefono.getPrecio());
        System.out.println("Precio con todos los extras: $" + paso3.getPrecio());
        System.out.println("Incremento total: $" + (paso3.getPrecio() - telefono.getPrecio()));
    }

    /**
     * Prueba 3: Diferentes combinaciones de decoradores
     */
    private static void pruebaDiferentesCombinaciones() {
        System.out.println(">>> PRUEBA 3: Diferentes Combinaciones <<<\n");

        // Crear producto base directamente
        Map<String, String> specs = new HashMap<>();
        specs.put("Pantalla", "12.9 pulgadas");
        specs.put("Almacenamiento", "256GB");

        Producto tableta = new Tableta("Apple", "Premium", "iPad Pro", 4000.0, specs);

        System.out.println("--- Producto Base ---");
        System.out.println("Tipo: " + tableta.getTipo());
        System.out.println("Modelo: " + tableta.getModelo());
        System.out.println("Precio: $" + tableta.getPrecio());

        IProducto base = new ProductoDecorable(tableta);

        // Combinación 1: Solo Garantía + Embalaje
        System.out.println("\n--- Combinación 1: Garantía + Embalaje ---");
        IProducto combo1 = new EmbalajePremium(new GarantiaExtendida(base));
        System.out.println("Descripción: " + combo1.getDescripcion());
        System.out.println("Precio: $" + combo1.getPrecio());

        // Combinación 2: Solo Seguro + Embalaje
        System.out.println("\n--- Combinación 2: Seguro + Embalaje ---");
        IProducto combo2 = new EmbalajePremium(new SeguroRobo(base));
        System.out.println("Descripción: " + combo2.getDescripcion());
        System.out.println("Precio: $" + combo2.getPrecio());

        // Combinación 3: Solo Garantía + Seguro
        System.out.println("\n--- Combinación 3: Garantía + Seguro ---");
        IProducto combo3 = new SeguroRobo(new GarantiaExtendida(base));
        System.out.println("Descripción: " + combo3.getDescripcion());
        System.out.println("Precio: $" + combo3.getPrecio());
    }

    /**
     * Prueba 4: Producto con especificaciones técnicas decorado
     */
    private static void pruebaProductoComplejo() {
        System.out.println(">>> PRUEBA 4: Producto Complejo con Especificaciones <<<\n");

        // Crear producto con especificaciones
        Map<String, String> specs = new HashMap<>();
        specs.put("RAM", "32GB DDR5");
        specs.put("CPU", "Intel i9-13900K");
        specs.put("Almacenamiento", "2TB NVMe SSD");
        specs.put("GPU", "NVIDIA RTX 4090");

        Producto pcGaming = new Computadora("ASUS", "Gaming", "ROG Strix G15", 8000.0, specs);

        System.out.println("--- Producto Gaming Original ---");
        pcGaming.mostrarInfo();

        // Aplicar todos los decoradores
        IProducto productoDecorable = new ProductoDecorable(pcGaming);
        IProducto productoCompleto = new SeguroRobo(
                new EmbalajePremium(
                        new GarantiaExtendida(productoDecorable)));

        System.out.println("\n--- Producto con Todos los Extras ---");
        System.out.println("Descripción: " + productoCompleto.getDescripcion());
        System.out.println("Precio final: $" + productoCompleto.getPrecio());
        System.out.println("\n--- Desglose de Extras ---");
        System.out.println("Garantía Extendida: +$150");
        System.out.println("Embalaje Premium: +$50");
        System.out.println("Seguro contra Robo: +$200");
        System.out.println("Total extras: +$400");
        System.out.println("\nVerificación: $" + pcGaming.getPrecio() + " + $400 = $" + productoCompleto.getPrecio());
    }
}