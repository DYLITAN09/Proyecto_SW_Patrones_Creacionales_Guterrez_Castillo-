package decorator;

public class GarantiaExtendida extends ProductoDecorator {
    public GarantiaExtendida(IProducto producto) {
        super(producto);
    }

    @Override
    public String getDescripcion() {
        return producto.getDescripcion() + " + Garantía extendida";
    }

    @Override
    public double getPrecio() {
        return producto.getPrecio() + 150.0;
    }
}
