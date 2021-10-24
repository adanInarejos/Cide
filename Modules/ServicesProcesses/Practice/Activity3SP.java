import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class Activity3SP {

    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            // Se inicia el procesos y se intancia el fileWriter
            Process RT = Runtime.getRuntime().exec("bash -c ls");
            FileWriter wr = new FileWriter("hola.txt");

            // Se instancia un bufered reader que leera el resultado de la ejecucion del proceso
            BufferedReader rd = new BufferedReader(new InputStreamReader(RT.getInputStream()));

            // A medida que lee va escribiendolo en el fichero nuevo
            String l = null;
            while ((l = rd.readLine()) != null) {
                wr.write(l);
            }
            wr.close();

            // Se verifica que el programa a acabado de forma correcta.
            int exitValue = RT.waitFor();
            System.out.println("Exit code: " + exitValue);
        } catch (Exception e) {
            // Mensaje de problema.
            System.out.println("Porfabor inserte un comando valido ");
        }

    }
}
