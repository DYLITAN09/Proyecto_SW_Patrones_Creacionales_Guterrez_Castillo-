package decorator;

public class SeguroRobo extends ProductoDecorator {
    public SeguroRobo(IProducto producto) {
        super(producto);
    }

    @Override
    public String getDescripcion() {
        return producto.getDescripcion() + " + Seguro contra Robo";
    }

    @Override
    public double getPrecio() {
        return producto.getPrecio() + 200.0;
    }
}