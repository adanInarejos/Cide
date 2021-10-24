import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MayusculasChild {
    public static void main(String[] args) throws IOException {

        // Obtiene el texto a procesar que le pasa el padre.
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader entrada= new BufferedReader (reader);
        String cadena = entrada.readLine();
        
        // Procesa el texto convirtiendolo en mayusculas y se muestra por pantalla.
        System.out.println(cadena.toUpperCase());


    }
    
}
