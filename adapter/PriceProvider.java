package adapter;

/**
 * Interfaz estándar que la aplicación espera usar
 * para obtener precios.
 */
public interface PriceProvider {
    double getPrice(String productName);
}
