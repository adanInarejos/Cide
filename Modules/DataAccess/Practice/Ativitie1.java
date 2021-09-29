import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ativitie1 {

    public static void main(String[] args) throws IOException {
        // Inicializamos el FileWritter y el fichero que se desea crear, en este punto se inicia el flujo.
        File file = new File("test.xml");
        FileWriter writter = new FileWriter(file);
        // Escribimos el codigo xml.
        writter.write("<Libros><Libro><Titulo> El Capote </Titulo></Libro></Libro>");
        // Se cierra el flujo.
        writter.close();
    }
}