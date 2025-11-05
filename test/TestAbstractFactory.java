package test;

import fabricaabstracta.*;
import productos.*;

public class TestAbstractFactory {

    public static void main(String[] args) {

        System.out.println("=== PRUEBA DE ABSTRACT FACTORY ===\n");

        probarFabrica(new FabricaLineaEconomica(), "ECONÓMICA");
        probarFabrica(new FabricaLineaEstandar(), "ESTÁNDAR");
        probarFabrica(new FabricaLineaPremium(), "PREMIUM");
    }

    private static void probarFabrica(FabricaLinea fabrica, String nombreLinea) {
        System.out.println("========================================");
        System.out.println("Creando productos de la línea " + nombreLinea);
        System.out.println("========================================");

        Computadora comp = fabrica.crearComputadora();
        Telefono tel = fabrica.crearTelefono();
        Tableta tab = fabrica.crearTableta();

        System.out.println("\n>> Computadora creada:");
        comp.mostrarInfo();

        System.out.println("\n>> Teléfono creado:");
        tel.mostrarInfo();

        System.out.println("\n>> Tableta creada:");
        tab.mostrarInfo();

        System.out.println("\n----------------------------------------\n");
    }
}
