package adapter;

/**
 * Simula un sistema externo que provee precios en USD.
 * No se puede modificar esta clase.
 */
public class ExternalPriceSystem {

    public double getPriceInUSD(String productName) {
        // Simulación de precios obtenidos de un sistema externo
        return switch (productName.toLowerCase()) {
            case "computadora" -> 1500.0;
            case "telefono" -> 900.0;
            case "tableta" -> 700.0;
            case "audifonos" -> 250.0;
            default -> 100.0;
        };
    }
}
