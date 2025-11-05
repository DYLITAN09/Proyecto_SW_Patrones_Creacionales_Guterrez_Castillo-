package productos;

import java.util.HashMap;
import java.util.Map;

/**
 * Producto concreto: Teléfono
 * Implemento el método clonar() del patrón Prototype
 */
public class Telefono extends Producto {

    public Telefono() {
        this.tipo = "Teléfono";
    }

    public Telefono(String marca, String linea, String modelo, double precio, Map<String, String> specs) {
        super("Teléfono", linea, marca, modelo, precio);
        if (specs != null)
            this.especificaciones.putAll(specs);
    }

    /**
     * Constructor privado de copia para implementar el patrón Prototype.
     * Realiza una copia profunda (deep copy) de todos los atributos.
     * 
     * @param otro La instancia de Telefono a clonar
     */
    private Telefono(Telefono otro) {
        this.tipo = otro.tipo;
        this.linea = otro.linea;
        this.marca = otro.marca;
        this.modelo = otro.modelo;
        this.precio = otro.precio;
        // Deep copy del Map de especificaciones
        this.especificaciones = new HashMap<>(otro.especificaciones);
    }

    /**
     * Implementación del patrón Prototype.
     * Crea una copia profunda e independiente de este Teléfono.
     * 
     * @return Nueva instancia de Telefono con los mismos valores
     * @throws IllegalStateException si el teléfono no puede clonarse
     */
    @Override
    public Producto clonar() {
        if (!puedeClonarse()) {
            throw new IllegalStateException(
                    "El teléfono no puede clonarse: datos incompletos");
        }
        return new Telefono(this);
    }

    /**
     * Valida que el teléfono tenga especificaciones mínimas para ser clonado.
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