import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Activity4SP {
    public static void main(String[] args) throws IOException, InterruptedException {

        try {

            // Se ejeucutan los cinco processos, una para cada vocal.
        Process RT1 = Runtime.getRuntime().exec("java hijo a");
        Process RT2 = Runtime.getRuntime().exec("java hijo e");
        Process RT3 = Runtime.getRuntime().exec("java hijo i");
        Process RT4 = Runtime.getRuntime().exec("java hijo o");
        Process RT5 = Runtime.getRuntime().exec("java hijo u");



        // Se instancia un bufered reader pro cada proceso hijo que leera el resultado de la ejecucion del proceso.
        BufferedReader rd1 = new BufferedReader(new InputStreamReader(RT1.getInputStream()));
        BufferedReader rd2 = new BufferedReader(new InputStreamReader(RT2.getInputStream()));
        BufferedReader rd3 = new BufferedReader(new InputStreamReader(RT3.getInputStream()));
        BufferedReader rd4 = new BufferedReader(new InputStreamReader(RT4.getInputStream()));
        BufferedReader rd5 = new BufferedReader(new InputStreamReader(RT5.getInputStream()));
        
        // Se leen los resultados
        int aes = Integer.valueOf(rd1.readLine());
        int ees = Integer.valueOf(rd2.readLine());
        int ies = Integer.valueOf(rd3.readLine());
        int oes = Integer.valueOf(rd4.readLine());
        int ues = Integer.valueOf(rd5.readLine());
            
        // Se suman los resultados para calcular el total.
        int total = (aes + ees + ies + oes + ues);

        // Se escribe el total en un fichero.
        FileWriter wr = new FileWriter("resultado.txt");
        wr.write(String.valueOf(total));
        wr.close();
            
        // Se comprueba que los procesos finalizen correctamente
        int exitValue = RT1.waitFor();
        System.out.println("Exit code: " + exitValue);
        
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
