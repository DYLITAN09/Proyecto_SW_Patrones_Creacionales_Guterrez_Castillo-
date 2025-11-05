package productos;

import prototype.Prototype;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase base para productos.
 * Implementa el patrón Prototype mediante la interfaz Prototype<Producto>
 */
public abstract class Producto implements Prototype<Producto> {
    protected String tipo; // Computadora, Telefono, Tableta
    protected String linea; // Premium, Estandar, Economica
    protected String modelo; // nombre del modelo
    protected double precio;
    protected String marca;
    protected Map<String, String> especificaciones = new HashMap<>();
    protected boolean esClon = false;
    protected String prototipoOrigen;

    public Producto() {
    }

    public Producto(String tipo, String linea, String marca, String modelo, double precio) {
        this.tipo = tipo;
        this.linea = linea;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    /**
     * Implementación del patrón Prototype.
     * Cada subclase debe implementar su propia lógica de clonación profunda.
     */
    @Override
    public abstract Producto clonar();

    /**
     * Valida si el producto puede ser clonado de forma segura.
     * Un producto puede clonarse si tiene los datos mínimos necesarios:
     * - Tipo definido y no vacío
     * - Marca definida y no vacía
     * - Modelo definido y no vacío
     * - Precio mayor a 0
     * 
     * @return true si el producto tiene datos válidos para clonación
     */
    @Override
    public boolean puedeClonarse() {
        return tipo != null && !tipo.isEmpty()
                && marca != null && !marca.isEmpty()
                && modelo != null && !modelo.isEmpty()
                && precio > 0;
    }

    // 🔽 Métodos nuevos para identificar clones
    public void marcarComoClon(String idPrototipoOrigen) {
        this.esClon = true;
        this.prototipoOrigen = idPrototipoOrigen;
    }

    public boolean esClon() {
        return esClon;
    }

    public String getPrototipoOrigen() {
        return prototipoOrigen;
    }

    // Getters
    public String getTipo() {
        return tipo;
    }

    public String getLinea() {
        return linea;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public Map<String, String> getEspecificaciones() {
        return especificaciones;
    }

    // Setters
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void mostrarInfo() {
        System.out.println("----- Producto -----");
        System.out.println("Tipo: " + tipo);
        System.out.println("Línea: " + linea);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Precio: $" + precio);
        if (esClon) {
            System.out.println("(Derivado del prototipo: " + prototipoOrigen + ")");
        }
        System.out.println("Especificaciones:");
        for (Map.Entry<String, String> e : especificaciones.entrySet()) {
            System.out.println("  - " + e.getKey() + ": " + e.getValue());
        }
    }
}