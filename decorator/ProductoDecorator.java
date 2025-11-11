package decorator;

public abstract class ProductoDecorator implements IProducto {
    protected final IProducto producto;

    public ProductoDecorator(IProducto producto) {
        this.producto = producto;
    }

    @Override
    public String getDescripcion() {
        return producto.getDescripcion();
    }

    @Override
    public double getPrecio() {
        return producto.getPrecio();
    }
}
