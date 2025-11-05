package productos;

import java.util.HashMap;
import java.util.Map;

/**
 * Producto concreto: Computadora
 * Implemento el método clonar() del patrón Prototype
 */
public class Computadora extends Producto {

    public Computadora() {
        this.tipo = "Computadora";
    }

    public Computadora(String marca, String linea, String modelo, double precio, Map<String, String> specs) {
        super("Computadora", linea, marca, modelo, precio);
        if (specs != null)
            this.especificaciones.putAll(specs);
    }

    /**
     * Constructor privado de copia para implementar el patrón Prototype.
     * Realiza una copia profunda (deep copy) de todos los atributos.
     * 
     * @param otra La instancia de Computadora a clonar
     */
    private Computadora(Computadora otra) {
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
     * Crea una copia profunda e independiente de esta Computadora.
     * 
     * @return Nueva instancia de Computadora con los mismos valores
     * @throws IllegalStateException si la computadora no puede clonarse
     */
    @Override
    public Producto clonar() {
        if (!puedeClonarse()) {
            throw new IllegalStateException(
                    "La computadora no puede clonarse: datos incompletos");
        }
        return new Computadora(this);
    }

    /**
     * Valida que la computadora tenga especificaciones mínimas para ser clonada.
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