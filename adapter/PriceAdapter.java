package adapter;

/**
 * Adaptador que convierte precios desde USD (del sistema externo)
 * a COP, o desde un valor interno (ingresado por usuario).
 */
public class PriceAdapter implements PriceProvider {

    private final ExternalPriceSystem externalSystem;
    private static final double TASA_CAMBIO = 4100.0; // USD → COP

    public PriceAdapter(ExternalPriceSystem externalSystem) {
        this.externalSystem = externalSystem;
    }

    @Override
    public double getPrice(String productName) {
        double precioUSD = externalSystem.getPriceInUSD(productName);
        double precioCOP = precioUSD * TASA_CAMBIO;
        System.out.println(" (Adapter) Precio externo en USD: $" + precioUSD);
        System.out.println(" (Adapter) Convertido a COP: $" + precioCOP);
        return precioCOP;
    }

    // Convierte un precio ya existente (del usuario) de USD a COP
    public double convertirDesdeUsuario(double precioActual) {
        System.out.println(" (Adapter) Convirtiendo precio actual del producto de USD a COP");
        return precioActual * TASA_CAMBIO;
    }
}
