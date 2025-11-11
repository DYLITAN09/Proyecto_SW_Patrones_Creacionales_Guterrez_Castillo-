package decorator;

import productos.Producto;

/**
 * Adaptador que envuelve un Producto existente para hacerlo compatible
 * con el patrón Decorator.
 * 
 * Esta clase permite que los productos del inventario (Computadora, Teléfono,
 * etc.)
 * puedan ser decorados con extras adicionales sin modificar su estructura
 * original.
 * 
 * @author Dylan Gutierrez y Camilo Castillo
 */
public class ProductoDecorable implements IProducto {

    /**
     * Referencia al producto original del inventario
     */
    private final Producto producto;

    /**
     * Constructor que recibe un producto del inventario
     * 
     * @param producto El producto a envolver para poder decorarlo
     */
    public ProductoDecorable(Producto producto) {
        this.producto = producto;
    }

    /**
     * Obtiene la descripción del producto base
     * 
     * @return Descripción formada por: Tipo + Marca + Modelo
     */
    @Override
    public String getDescripcion() {
        return producto.getTipo() + " " + producto.getMarca() + " " + producto.getModelo();
    }

    /**
     * Obtiene el precio base del producto
     * 
     * @return El precio actual del producto
     */
    @Override
    public double getPrecio() {
        return producto.getPrecio();
    }
}