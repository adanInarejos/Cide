import java.security.Key;
import java.util.Scanner;

public class Activity6SP {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String nombre;
        int llegada;
        // Bucle infinito
        while (true){
            // Se pide el nombre y hora de llegada del alumno
            System.out.println("Introduze el nombre del alumno:");
            nombre = sc.nextLine();
            // Si el nombre introducido es fin o no se introduce nada el proceso se detiene
            if (nombre.equals("") || nombre.equals("fin")){
                System.out.println("Saliendo del programa......");
                return;
            }
            System.out.println("Introduce su hora de llegada\n--------------------");
            llegada = Integer.parseInt(sc.nextLine());
            // Si la llegada es antes de las 15h se lanza el hilo 1, si es mas tarde de se lanza el hilo 2
            if (llegada<=15){
                new Activity6SPThread1().start();
                Thread.sleep(2000);
            } else {
                new Activity6SPThread2().start();
                Thread.sleep(2000);
            }
        }
        
    }
    
}
