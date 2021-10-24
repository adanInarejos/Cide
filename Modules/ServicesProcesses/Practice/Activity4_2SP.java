import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* Esta clase leera el archivo y hara un conteo de cuentas letras "x"
 hay en el fichero que se le pase, siendo x la letra que se le pase como parametro.*/
public class Activity4_2SP {
    public static void main(String[] args) throws IOException {
        // Se pasa a char la letra que se pase por parametro.
        char argum = args[0].charAt(0);
        // Se lee el fichero de inicip a fin y se hace el conteo.
        BufferedReader br = new BufferedReader(new FileReader("Ejemplo.txt"));
        int hola = br.read();
        int contador = 0;
        while (hola!=-1){
            if (((char) hola)==argum || (char) hola == Character.toUpperCase(argum)){
                contador++;
            }
            hola = br.read();
        }
        br.close();
        System.out.println(contador);
    }
}
