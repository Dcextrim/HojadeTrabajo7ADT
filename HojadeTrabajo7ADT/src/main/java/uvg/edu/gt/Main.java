package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Se construye el diccionario a partir del archivo diccionario.txt
        BinaryTree<String, String> dictionary = Diccionario("diccionario.txt");

        // Se muestra el diccionario ordenado
        System.out.println("Diccionario Ordenado:");
        dictionary.inorderTraversal();

        // Se traduce el texto dado utilizando el diccionario
        // Ruta del archivo con texto en inglés
        String inputText = "TextoenIngles.txt";
        String TextoTraducido = Traduccion(inputText, dictionary);
        System.out.println("\nTexto Traducido:");
        System.out.println(TextoTraducido);
    }

    // Método para construir el diccionario a partir de un archivo
    public static BinaryTree<String, String> Diccionario(String archivo) {
        BinaryTree<String, String> diccionario = new BinaryTree<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.substring(1, line.length() - 1).split(", ");
                String key = parts[0].trim();
                String value = parts[1].trim();
                Association<String, String> association = new Association<>(key, value);
                diccionario.insertar(association);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return diccionario;
    }

    // Método para traducir el texto utilizando el diccionario
    public static String Traduccion(String inputFilePath, BinaryTree<String, String> dictionary) {
        StringBuilder Textotraducido = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] oracion = linea.split("\\s+");
                for (String palabra : oracion) {
                    String palabraTraducida = dictionary.search(palabra.toLowerCase());
                    if (palabraTraducida != null)
                        Textotraducido.append(palabraTraducida).append(" ");
                    else
                        Textotraducido.append("*").append(palabra).append("* ");
                }
                Textotraducido.append("\n"); // Añade nueva línea después de cada línea traducida
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Textotraducido.toString().trim();
    }
}