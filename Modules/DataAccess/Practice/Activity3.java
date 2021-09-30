import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Activitie3 {

    public static void main(String[] args) throws IOException {
        // Inicializamos el FileReader y el fichero que se desea crear, en este punto se inicia el flujo.
        File file = new File("exampleReader.txt");
        FileReader reader = new FileReader(file);
        // se lee el primer caracter del archivo y se crea un bucle para que siga leyendo mientras no se acabe el archivo.
        int stop = reader.read();
        String texto = "";
        while(stop!=-1){
            // Se utiliza esta condicion para almacenar todos aquellos caracteres que no sean espacios.
            if (stop!=32){
                texto = texto + (char) stop;
            }
            stop=reader.read();
        }
        // Se muestra por pantalla el resultado y se cierra el flujo.
        System.out.println(texto);
        reader.close();
    }
    
}
