package uvg.edu.gt;

/**
 * Clase que representa un árbol binario de búsqueda.
 * @param <LlaveArbol> Tipo de la clave.
 * @param <ValorArbol> Tipo del valor.
 */
class BinaryTree<LlaveArbol extends Comparable<LlaveArbol>, ValorArbol> {
    Node<LlaveArbol, ValorArbol> root;

    /**
     * Constructor para crear un nuevo árbol binario.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Método para insertar una asociación en el árbol.
     * @param association La asociación a insertar.
     */
    public void insertar(Association<LlaveArbol, ValorArbol> association) {
        root = insertRecursive(root, association);
    }

    // Método privado recursivo para insertar una asociación en el árbol
    private Node<LlaveArbol, ValorArbol> insertRecursive(Node<LlaveArbol, ValorArbol> root, Association<LlaveArbol, ValorArbol> association) {
        // Si el nodo actual es nulo, se crea un nuevo nodo con la asociación
        if (root == null) {
            root = new Node<>(association);
            return root;
        }
        // Si la clave de la asociación es menor que la clave del nodo actual se inserta la asociación en el subárbol izquierdo
        if (association.key.compareTo(root.data.key) < 0)
            root.left = insertRecursive(root.left, association);
        // Si la clave de la asociación es mayor que la clave del nodo actual, se inserta la asociación en el subárbol derecho
        else if (association.key.compareTo(root.data.key) > 0)
            root.right = insertRecursive(root.right, association);

        return root;
    }

    /**
     * Método para realizar un recorrido en orden del árbol.
     */
    public void inorderTraversal() {
        inorderTraversalRecursive(root);
    }

    private void inorderTraversalRecursive(Node<LlaveArbol, ValorArbol> root) {
        if (root != null) {
            inorderTraversalRecursive(root.left);
            System.out.println("(" + root.data.key + ", " + root.data.value + ")");
            inorderTraversalRecursive(root.right);
        }
    }

    /**
     * Método para buscar un valor asociado a una clave en el árbol.
     * @param key La clave a buscar.
     * @return El valor asociado a la clave, o null si la clave no está presente en el árbol.
     */
    public ValorArbol search(LlaveArbol key) {
        return searchRecursive(root, key);
    }

    private ValorArbol searchRecursive(Node<LlaveArbol, ValorArbol> root, LlaveArbol key) {
        if (root == null || root.data.key.equals(key))
            return root != null ? root.data.value : null;

        if (key.compareTo(root.data.key) < 0)
            return searchRecursive(root.left, key);
        else
            return searchRecursive(root.right, key);
    }
}