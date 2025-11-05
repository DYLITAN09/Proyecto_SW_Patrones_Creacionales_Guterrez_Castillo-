package productos;

import java.util.HashMap;
import java.util.Map;

/**
 * Producto concreto: Audifonos
 * Implemento el método clonar() del patrón Prototype
 */
public class Audifonos extends Producto {

    public Audifonos() {
        this.tipo = "Audifonos";
    }

    public Audifonos(String marca, String linea, String modelo, double precio, Map<String, String> specs) {
        super("Audifonos", linea, marca, modelo, precio);
        if (specs != null)
            this.especificaciones.putAll(specs);
    }

    /**
     * Constructor privado de copia para implementar el patrón Prototype.
     * Realiza una copia profunda (deep copy) de todos los atributos.
     * 
     * @param otros La instancia de Audifonos a clonar
     */
    private Audifonos(Audifonos otros) {
        this.tipo = otros.tipo;
        this.linea = otros.linea;
        this.marca = otros.marca;
        this.modelo = otros.modelo;
        this.precio = otros.precio;
        // Deep copy del Map de especificaciones
        this.especificaciones = new HashMap<>(otros.especificaciones);
    }

    /**
     * Implementación del patrón Prototype.
     * Crea una copia profunda e independiente de estos Audifonos.
     * 
     * @return Nueva instancia de Audifonos con los mismos valores
     * @throws IllegalStateException si los audifonos no pueden clonarse
     */
    @Override
    public Producto clonar() {
        if (!puedeClonarse()) {
            throw new IllegalStateException(
                    "Los audifonos no pueden clonarse: datos incompletos");
        }
        return new Audifonos(this);
    }

    /**
     * Valida que los audifonos tengan especificaciones mínimas para ser clonados.
     * Además de las validaciones base, verifica que tenga especificaciones
     * técnicas.
     * 
     * @return true si cumple todas las validaciones
     */
    @Override
    public boolean puedeClonarse() {
        return super.puedeClonarse()
                && especificaciones != null
                && !especificaciones.isEmpty();
    }
}