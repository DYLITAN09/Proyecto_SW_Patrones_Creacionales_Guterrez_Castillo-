package productos;

public class Tableta extends Producto {

    public Tableta() {
        this.tipo = "Tableta";
    }

    public Tableta(String linea, String modelo, double precio, java.util.Map<String, String> specs) {
        super("Tableta", linea, modelo, precio);
        if (specs != null)
            this.especificaciones.putAll(specs);
    }

    private Tableta(Tableta otra) {
        this.tipo = otra.tipo;
        this.linea = otra.linea;
        this.modelo = otra.modelo;
        this.precio = otra.precio;
        this.especificaciones = new java.util.HashMap<>(otra.especificaciones);
    }

    @Override
    public Producto clonar() {
        return new Tableta(this);
    }
}