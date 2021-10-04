import javax.annotation.processing.ProcessingEnvironment;
import java.io.IOException;

public class Activity5 {


    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            // Se inicia el proceso.
            Process RT = Runtime.getRuntime().exec(args[0]);
            // Se destruye el proceso.
            RT.destroy();
            // Se verifica que el programa a acabado de forma correcta.
            int exitValue = RT.waitFor();
            System.out.println("Exit code: " + exitValue);
        } catch (Exception e) {
            // Mensaje de problema.
            System.out.println("Porfabor inserte un comando valido ");
        }

    }
}
