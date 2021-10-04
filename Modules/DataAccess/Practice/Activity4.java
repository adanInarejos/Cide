import javax.annotation.processing.ProcessingEnvironment;
import java.io.IOException;

public class Activity4 {


    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            // Se inicia el processo.
            Process PB = new ProcessBuilder(args[0]).start();
            // Se verifica que el programa a acabado de forma correcta.
            int exitValue = PB.waitFor();
            System.out.println("Exit code: " + exitValue);
        } catch (Exception e) {
            // Mensaje de problema.
            System.out.println("Porfabor inserte un comando valido ");
        }

}
}
