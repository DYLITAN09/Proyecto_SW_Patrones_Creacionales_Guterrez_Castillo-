# Entrega de taller: Patrones de Diseño Creacionales — Gutierrez & Castillo

> **Presentación del taller sobre Patrones de Diseño Creacionales**

---

## Resumen

Este repositorio contiene una colección educativa de implementaciones en **Java** de varios **patrones de diseño creacionales**. Está pensado como material de apoyo para un taller/unidad académica: cada patrón está separado en su propio paquete/carpeta con ejemplos de uso, clases principales y una demo ejecutable desde la carpeta `main`.

**Videos de ejemplo / ejecución**

* Video general de ejecución y aspectos importantes: [https://youtu.be/FfPEeNGDoSc](https://youtu.be/FfPEeNGDoSc)
* Video de ejecución para Adapter y Decorator: [https://www.youtube.com/watch?v=E_7OBmv_iPA](https://www.youtube.com/watch?v=E_7OBmv_iPA)

---

## Patrones incluidos (carpetas del repositorio)

El repositorio incluye, como mínimo, las siguientes implementaciones:

* `singleton` — Implementación(es) del patrón Singleton.
* `factorymethod` — Ejemplo(s) de Factory Method.
* `fabricaabstracta` — Implementación de Abstract Factory.
* `prototype` — Implementación del patrón Prototype.
* `adapter` — Implementación del patrón Adapter.
* `decorator` — Implementación del patrón Decorator.
* `productos` — Clases/jerarquía de productos usados por los patrones de fábrica.
* `main` — Clases `main`/demos para ejecutar los ejemplos.
* `test` — Pruebas o clases de demostración adicionales.

---

## Explicación de cada patrón y su función dentro del proyecto

### Singleton

* **Función:** Garantiza que exista una sola instancia de una clase en todo el sistema. En el proyecto se usa para centralizar el acceso a ciertos recursos compartidos, evitando duplicaciones de instancias.
* **Aplicación en el código:** Se implementa una clase con constructor privado y un método estático `getInstance()` que devuelve la instancia única.

### Factory Method

* **Función:** Permite crear objetos sin especificar su clase concreta. Cada subclase define qué tipo de objeto fabrica.
* **Aplicación en el código:** Se usa para crear productos específicos dentro de las líneas de productos. Cada fábrica concreta implementa su propio método de creación.

### Abstract Factory (Fábrica Abstracta)

* **Función:** Crea familias completas de productos relacionados (por ejemplo, distintas líneas o gamas de productos) sin acoplar el código a clases concretas.
* **Aplicación en el código:** Se implementaron distintas fábricas que crean productos pertenecientes a una línea específica. Esto facilita agregar nuevas líneas, como la línea *Gaming*.

### Prototype

* **Función:** Permite crear nuevos objetos copiando otros existentes, en lugar de instanciarlos directamente.
* **Aplicación en el código:** Se usa para clonar productos o configuraciones de productos, evitando la necesidad de construirlos desde cero.

### Adapter

* **Función:** Permite que clases con interfaces incompatibles trabajen juntas, adaptando la interfaz de una clase a la esperada por otra.
* **Aplicación en el código:** Se usa para conectar clases que originalmente no eran compatibles, garantizando que todas las fábricas o productos puedan interactuar de manera uniforme.

### Decorator

* **Función:** Añade responsabilidades o funcionalidades adicionales a objetos en tiempo de ejecución sin modificar su estructura.
* **Aplicación en el código:** Se utiliza para agregar características dinámicamente a los productos, como mejoras o complementos adicionales.

---

## Explicación de las ramas principales

### Rama `feature/nueva-linea-gaming`

En esta rama se implementó una **nueva línea de productos (Gaming)** usando el patrón **Abstract Factory**. Se creó una nueva fábrica encargada de producir esta línea y se añadió un test específico para verificar su correcto funcionamiento.

### Rama `feature/nuevo-producto-audifonos`

En esta rama se implementaron los **audífonos como nuevo producto**, realizando los ajustes necesarios en las fábricas ya existentes para que admitieran este producto. Se aplicó el patrón **Factory Method**, creando la clase `FabricaAudifonos` para manejar este nuevo tipo de producto.

---

## Sección de tests

En la carpeta `test` se realizaron pruebas para **los seis patrones de diseño** implementados. Cada vez que se finalizaba la implementación de un patrón, se ejecutaban los tests correspondientes para verificar su correcto funcionamiento. Esto garantiza que todas las clases cumplan con el comportamiento esperado.

---

## Commits y su función

Cada patrón cuenta con commits que documentan el progreso de su implementación. El formato utilizado es el siguiente:

```
Subo esqueleto de archivos y carpetas para (NOMBRE DEL PATRÓN) -> Aquí se empezó a implementar ese patrón.
(FIN DE NOMBRE DEL PATRÓN) -> Este fue el commit donde se terminó ese patrón en específico.
```

Este formato se repite para cada patrón (`Factory Method`, `Abstract Factory`, `Prototype`, `Adapter`, `Decorator`) de modo que sea claro en qué punto se inició y finalizó la implementación de cada uno.

---

## Autores

**Dylan Sebastian Gutierrez Ramirez**
CC 1012916586

**Camilo Andres Castillo Guardia**
CC 1002245758
