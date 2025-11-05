package fabricaabstracta;

import productos.*;

public interface FabricaLinea {
    Computadora crearComputadora();

    Telefono crearTelefono();

    Tableta crearTableta();

    Audifonos crearAudifonos();
}
