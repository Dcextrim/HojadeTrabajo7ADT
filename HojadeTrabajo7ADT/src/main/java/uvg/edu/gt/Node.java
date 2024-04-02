package uvg.edu.gt;

/**
 * Clase que representa un nodo de un árbol binario.
 * @param <LlaveNodo> Tipo de la clave.
 * @param <ValorNodo> Tipo del valor.
 */
class Node<LlaveNodo extends Comparable<LlaveNodo>, ValorNodo> {
    Association<LlaveNodo, ValorNodo> data;
    Node<LlaveNodo, ValorNodo> left, right;

    /**
     * Constructor para crear un nuevo nodo con datos.
     * @param data Datos asociados con el nodo.
     */
    public Node(Association<LlaveNodo, ValorNodo> data) {
        this.data = data;
        left = right = null;
    }
}
