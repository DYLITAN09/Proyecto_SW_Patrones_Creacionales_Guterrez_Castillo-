package productos;

import java.util.HashMap;
import java.util.Map;

/**
 * Producto concreto: Tableta
 * Implemento el método clonar() del patrón Prototype
 */
public class Tableta extends Producto {

    public Tableta() {
        this.tipo = "Tableta";
    }

    public Tableta(String marca, String linea, String modelo, double precio, Map<String, String> specs) {
        super("Tableta", linea, marca, modelo, precio);
        if (specs != null)
            this.especificaciones.putAll(specs);
    }

    /**
     * Constructor privado de copia para implementar el patrón Prototype.
     * Realiza una copia profunda (deep copy) de todos los atributos.
     * 
     * @param otra La instancia de Tableta a clonar
     */
    private Tableta(Tableta otra) {
        this.tipo = otra.tipo;
        this.linea = otra.linea;
        this.marca = otra.marca;
        this.modelo = otra.modelo;
        this.precio = otra.precio;
        // Deep copy del Map de especificaciones
        this.especificaciones = new HashMap<>(otra.especificaciones);
    }

    /**
     * Implementación del patrón Prototype.
     * Crea una copia profunda e independiente de esta Tableta.
     * 
     * @return Nueva instancia de Tableta con los mismos valores
     * @throws IllegalStateException si la tableta no puede clonarse
     */
    @Override
    public Producto clonar() {
        if (!puedeClonarse()) {
            throw new IllegalStateException(
                    "La tableta no puede clonarse: datos incompletos");
        }
        return new Tableta(this);
    }

    /**
     * Valida que la tableta tenga especificaciones mínimas para ser clonada.
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