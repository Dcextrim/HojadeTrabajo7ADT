package uvg.edu.gt;

/**
 * Clase que representa una asociación entre una clave y un valor.
 * @param <Llave> Tipo de la clave.
 * @param <Valor> Tipo del valor.
 */
class Association<Llave, Valor> {
    Llave key;
    Valor value;

    /**
     * Constructor para crear una nueva asociación.
     * @param key Clave de la asociación.
     * @param value Valor de la asociación.
     */
    public Association(Llave key, Valor value) {
        this.key = key;
        this.value = value;
    }
}