package test;

import adapter.*;

/**
 * Clase de prueba para validar la implementación del patrón Adapter
 * 
 * Prueba:
 * 1. El sistema externo (ExternalPriceSystem) que devuelve precios en USD
 * 2. El adaptador (PriceAdapter) que convierte USD a COP
 * 3. La interfaz PriceProvider que abstrae la conversión
 * 
 * @author Dylan Gutierrez y Camilo Castillo
 */
public class TestAdapter {

    private static final double TASA_CAMBIO_ESPERADA = 4100.0;
    private static final String SEPARADOR = "========================================";

    public static void main(String[] args) {
        System.out.println("\n" + SEPARADOR);
        System.out.println("   PRUEBA DEL PATRÓN ADAPTER");
        System.out.println(SEPARADOR + "\n");

        // Contador de pruebas
        int pruebasExitosas = 0;
        int pruebasTotales = 0;

        // PRUEBA 1: Sistema externo funciona correctamente
        pruebasTotales++;
        if (probarSistemaExterno()) {
            pruebasExitosas++;
        }

        // PRUEBA 2: Adapter convierte correctamente USD a COP
        pruebasTotales++;
        if (probarConversionAdapter()) {
            pruebasExitosas++;
        }

        // PRUEBA 3: Adapter funciona a través de la interfaz PriceProvider
        pruebasTotales++;
        if (probarPolimorfismo()) {
            pruebasExitosas++;
        }

        // PRUEBA 4: Comparar precios de todos los productos
        pruebasTotales++;
        if (probarTodosLosProductos()) {
            pruebasExitosas++;
        }

        // PRUEBA 5: Método extra convertirDesdeUsuario (funcionalidad adicional)
        pruebasTotales++;
        if (probarConversionUsuario()) {
            pruebasExitosas++;
        }

        // RESUMEN FINAL
        System.out.println("\n" + SEPARADOR);
        System.out.println("   RESUMEN DE PRUEBAS");
        System.out.println(SEPARADOR);
        System.out.println("Pruebas exitosas: " + pruebasExitosas + "/" + pruebasTotales);

        if (pruebasExitosas == pruebasTotales) {
            System.out.println("TODAS LAS PRUEBAS PASARON");
            System.out.println("EL PATRÓN ADAPTER ESTÁ CORRECTAMENTE IMPLEMENTADO");
        } else {
            System.out.println("ALGUNAS PRUEBAS FALLARON");
        }
        System.out.println(SEPARADOR + "\n");
    }

    /**
     * PRUEBA 1: Verificar que el sistema externo devuelve precios en USD
     */
    private static boolean probarSistemaExterno() {
        System.out.println("PRUEBA 1: Sistema Externo (Adapter)");
        System.out.println("------------------------------------");

        try {
            ExternalPriceSystem sistemaExterno = new ExternalPriceSystem();

            double precioComputadora = sistemaExterno.getPriceInUSD("computadora");
            double precioTelefono = sistemaExterno.getPriceInUSD("telefono");

            System.out.println("Precio Computadora en USD: $" + precioComputadora);
            System.out.println("Precio Teléfono en USD: $" + precioTelefono);

            boolean exito = precioComputadora == 1500.0 && precioTelefono == 900.0;

            if (exito) {
                System.out.println("Sistema externo funciona CORRECTAMENTE\n");
            } else {
                System.out.println("ERROR: Los precios no coinciden\n");
            }

            return exito;

        } catch (Exception e) {
            System.out.println("ERROR al probar sistema externo: " + e.getMessage() + "\n");
            return false;
        }
    }

    /**
     * PRUEBA 2: Verificar que el Adapter convierte correctamente USD a COP
     */
    private static boolean probarConversionAdapter() {
        System.out.println("PRUEBA 2: Conversión USD a COP (Adapter)");
        System.out.println("------------------------------------");

        try {
            ExternalPriceSystem sistemaExterno = new ExternalPriceSystem();
            PriceAdapter adapter = new PriceAdapter(sistemaExterno);

            String producto = "computadora";
            double precioUSD = sistemaExterno.getPriceInUSD(producto);
            double precioCOP = adapter.getPrice(producto);
            double precioEsperado = precioUSD * TASA_CAMBIO_ESPERADA;

            System.out.println("\nVerificación:");
            System.out.println("  Precio USD: $" + precioUSD);
            System.out.println("  Precio COP (esperado): $" + precioEsperado);
            System.out.println("  Precio COP (obtenido): $" + precioCOP);

            boolean exito = Math.abs(precioCOP - precioEsperado) < 0.01;

            if (exito) {
                System.out.println("Conversión CORRECTA\n");
            } else {
                System.out.println("ERROR: La conversión no es correcta\n");
            }

            return exito;

        } catch (Exception e) {
            System.out.println("ERROR al probar conversión: " + e.getMessage() + "\n");
            return false;
        }
    }

    /**
     * PRUEBA 3: Verificar que el Adapter funciona a través de la interfaz
     * (Polimorfismo - esencia del patrón Adapter)
     */
    private static boolean probarPolimorfismo() {
        System.out.println("PRUEBA 3: Polimorfismo (PriceProvider)");
        System.out.println("------------------------------------");

        try {
            // El cliente solo conoce la interfaz PriceProvider
            PriceProvider proveedor = new PriceAdapter(new ExternalPriceSystem());

            System.out.println("Usando la interfaz PriceProvider:");
            double precio = proveedor.getPrice("telefono");
            double precioEsperado = 900.0 * TASA_CAMBIO_ESPERADA;

            System.out.println("\nPrecio obtenido: $" + precio);
            System.out.println("Precio esperado: $" + precioEsperado);

            boolean exito = Math.abs(precio - precioEsperado) < 0.01;

            if (exito) {
                System.out.println("El Adapter funciona CORRECTAMENTE a través de la interfaz");
                System.out.println(" Esto demuestra el desacoplamiento del patrón\n");
            } else {
                System.out.println("ERROR en el polimorfismo\n");
            }

            return exito;

        } catch (Exception e) {
            System.out.println("ERROR al probar polimorfismo: " + e.getMessage() + "\n");
            return false;
        }
    }

    /**
     * PRUEBA 4: Probar todos los tipos de productos
     */
    private static boolean probarTodosLosProductos() {
        System.out.println("PRUEBA 4: Todos los Productos");
        System.out.println("------------------------------------");

        try {
            PriceProvider proveedor = new PriceAdapter(new ExternalPriceSystem());
            String[] productos = { "computadora", "telefono", "tableta", "audifonos" };
            double[] preciosUSDEsperados = { 1500.0, 900.0, 700.0, 250.0 };

            boolean todosCorrectos = true;

            System.out.println("Producto          | USD      | COP          | ¿Correcto?");
            System.out.println("------------------|----------|--------------|------------");

            for (int i = 0; i < productos.length; i++) {
                double precioCOP = proveedor.getPrice(productos[i]);
                double precioEsperado = preciosUSDEsperados[i] * TASA_CAMBIO_ESPERADA;
                boolean correcto = Math.abs(precioCOP - precioEsperado) < 0.01;

                System.out.printf("%-17s | $%-7.2f | $%-11.2f | %s%n",
                        productos[i].substring(0, 1).toUpperCase() + productos[i].substring(1),
                        preciosUSDEsperados[i],
                        precioCOP,
                        correcto ? "CORRECTO" : "ERROR");

                if (!correcto) {
                    todosCorrectos = false;
                }
            }

            System.out.println();
            if (todosCorrectos) {
                System.out.println("Todos los productos se convierten CORRECTAMENTE\n");
            } else {
                System.out.println("Algunos productos tienen ERRORES de conversión\n");
            }

            return todosCorrectos;

        } catch (Exception e) {
            System.out.println("ERROR al probar productos: " + e.getMessage() + "\n");
            return false;
        }
    }

    /**
     * PRUEBA 5: Probar método adicional convertirDesdeUsuario
     * (No es parte del patrón Adapter, pero es funcionalidad extra)
     */
    private static boolean probarConversionUsuario() {
        System.out.println("PRUEBA 5: Método Extra (convertirDesdeUsuario)");
        System.out.println("------------------------------------");

        try {
            PriceAdapter adapter = new PriceAdapter(new ExternalPriceSystem());

            double precioUsuario = 500.0; // USD
            double precioConvertido = adapter.convertirDesdeUsuario(precioUsuario);
            double precioEsperado = precioUsuario * TASA_CAMBIO_ESPERADA;

            System.out.println("Precio ingresado (USD): $" + precioUsuario);
            System.out.println("Precio convertido (COP): $" + precioConvertido);
            System.out.println("Precio esperado (COP): $" + precioEsperado);

            boolean exito = Math.abs(precioConvertido - precioEsperado) < 0.01;

            if (exito) {
                System.out.println("Método adicional funciona CORRECTAMENTE");
                System.out.println("NOTA: Este método es funcionalidad extra, no parte del patrón\n");
            } else {
                System.out.println("ERROR en el método convertirDesdeUsuario\n");
            }

            return exito;

        } catch (Exception e) {
            System.out.println("ERROR al probar conversión de usuario: " + e.getMessage() + "\n");
            return false;
        }
    }
}
