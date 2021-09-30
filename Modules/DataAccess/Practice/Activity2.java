import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Activitie2 {

    public static void main(String[] args) throws IOException {
        // Inicializamos el FileWritter y el fichero que se desea crear, en este punto se inicia el flujo.
        File file = new File("test.xml");
        FileWriter writter = new FileWriter(file);
        // Escribimos el codigo xml.
        writter.write("<Libros>\n\t<Libro>\n\t\t<Titulo> El Capote </Titulo>\n\t</Libro>\n</Libro>");
        // Se cierra el flujo.
        writter.close();
    }
}
