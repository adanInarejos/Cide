import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Mayusculas {

    static Scanner sc;

public static void main(String[] args) throws IOException, InterruptedException {
    // se crea un escaner para pedir al usuario el texto a procesar.
    sc = new Scanner(System.in);
    System.out.println("Introduzca el texto:");
    String texto = sc.nextLine();

    // Se lanza un proceso java.
    Process RT1 = Runtime.getRuntime().exec("java MayusculasChild");

    // Se le pasa al processo el texto que ha de procesar.
    OutputStream os = RT1.getOutputStream();
    OutputStreamWriter osw = new OutputStreamWriter(os);
    PrintWriter pw = new PrintWriter(osw);
    pw.print(texto);
    pw.close();

    // Se recoge el resultado del proceso y se muestra por pantalla.
    BufferedReader reader = new BufferedReader(new InputStreamReader(RT1.getInputStream()));
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
    reader.close();
}
}
