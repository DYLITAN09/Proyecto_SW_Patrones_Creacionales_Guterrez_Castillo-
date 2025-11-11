package decorator;

public class EmbalajePremium extends ProductoDecorator {
    public EmbalajePremium(IProducto producto) {
        super(producto);
    }

    @Override
    public String getDescripcion() {
        return producto.getDescripcion() + " + Embalaje Premium";
    }

    @Override
    public double getPrecio() {
        return producto.getPrecio() + 50.0;
    }
}
