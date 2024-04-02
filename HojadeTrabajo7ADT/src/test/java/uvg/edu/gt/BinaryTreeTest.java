package uvg.edu.gt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {

    private BinaryTree<String, String> dictionary;

    @Before
    public void setUp() {
        dictionary = new BinaryTree<>();
    }

    @Test
    public void testInsert() {
        Association<String, String> association1 = new Association<>("dog", "perro");
        Association<String, String> association2 = new Association<>("cat", "gato");
        Association<String, String> association3 = new Association<>("bird", "pájaro");

        dictionary.insertar(association1);
        dictionary.insertar(association2);
        dictionary.insertar(association3);

        // Verificar que las asociaciones se han insertado correctamente
        assertEquals("perro", dictionary.search("dog"));
        assertEquals("gato", dictionary.search("cat"));
        assertEquals("pájaro", dictionary.search("bird"));
    }

    @Test
    public void testSearch() {
        // Insertar algunas asociaciones
        Association<String, String> association1 = new Association<>("dog", "perro");
        Association<String, String> association2 = new Association<>("cat", "gato");
        Association<String, String> association3 = new Association<>("bird", "pájaro");

        dictionary.insertar(association1);
        dictionary.insertar(association2);
        dictionary.insertar(association3);

        // Buscar asociaciones existentes
        assertEquals("perro", dictionary.search("dog"));
        assertEquals("gato", dictionary.search("cat"));
        assertEquals("pájaro", dictionary.search("bird"));

        // Buscar una asociación que no existe
        assertNull(dictionary.search("fish"));
    }
}

