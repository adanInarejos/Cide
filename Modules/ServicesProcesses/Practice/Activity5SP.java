import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Activity5SP {
    
    public static void main(String[] args) throws IOException {

    boolean bandera = false;

    /* Algoritmo de la bandera, el bucle pedira al usuario si desea obtener
    un numero aleatorio o terminar la ejecucion, mienstras el usuario no
    teclee la palabra fin el bucle no se detendra.*/
    while(bandera == false){
    // Se pide al usuario si desea generar u numero o terminar la ejecucion.
    Scanner sc = new Scanner(System.in);
    System.out.println("Pulse cualquier tecla para generar un numero o fin para finalizar:");
    String texto = sc.nextLine();

    // Si teclea fin la ejecucion termina.
    if (texto.equals("fin")){
        bandera = true;
    } 
    // si no teclea fin se lanza el proceso hijo que devuelve un numero aleatorio.
    else{
        // Se lanza el hijo
        Process RT1 = Runtime.getRuntime().exec("java Activity5_2SP");
        // Se recoge el resultado y se muestra en pantalla.
        BufferedReader rd = new BufferedReader(new InputStreamReader(RT1.getInputStream()));
        int num = Integer.valueOf(rd.readLine());
        System.out.println(num);
        rd.close();
    }
    
    }



    }
}
