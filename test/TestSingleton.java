package test;

import singleton.ConfiguracionGlobal;

public class TestSingleton {
    public static void main(String[] args) {
        System.out.println("=== Test Singleton ===");

        // Obtener la instancia por primera vez
        ConfiguracionGlobal config1 = ConfiguracionGlobal.getInstancia();
        config1.mostrarConfiguracion();

        // Modificar configuración
        config1.setModoDebug(true);
        config1.setEntorno("Desarrollo");
        config1.setIdioma("Ingles");

        System.out.println("\nConfiguración después de cambios:");
        config1.mostrarConfiguracion();

        // Obtener otra instancia
        ConfiguracionGlobal config2 = ConfiguracionGlobal.getInstancia();

        System.out.println("\nVerificando que ambas referencias apuntan a la misma instancia:");
        if (config1 == config2) {
            System.out.println("CORRECTO: config1 y config2 son la misma instancia");
        } else {
            System.out.println("ERROR: config1 y config2 NO son la misma instancia");
        }

        System.out.println("\nConfiguración desde config2:");
        config2.mostrarConfiguracion();
    }
}