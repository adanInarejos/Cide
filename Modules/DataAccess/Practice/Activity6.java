import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Activity6 {

    // Inicializamos el archivo.
    static File file = new File("Test.txt");

    // Metodo de escritura, este pide como parametros la ruta del archivo y el texto que desea escribir
    public void escribir(String path, String texto) throws IOException{
        // Inicias el flujo instanciando el FileWriter, escribe el texto y cuerra el flujo
        FileWriter wr = new FileWriter(path + file);
        wr.write(texto);
        wr.close();
    }

    // Metodo para leer pasando las minusculas a mayusculas y viceversa.
    public void leer(String path) throws IOException{
        // Instancia el fileReader con la ruta y el archivo.
        FileReader rd = new FileReader(path + file);
        int valor = rd.read();
        // Leer caracter a caracter, si es mayuscula lo castea a minuscula y viceversa
        while(valor!=-1){
            if ((valor>=65) && (valor<=90) ){    
                System.out.print(Character.toLowerCase((char) valor));
            } else if ((valor>=97) && (valor<=122) ){    
                System.out.print(Character.toUpperCase((char) valor));
            } else {
                System.out.print((char) valor);
            }
            valor = rd.read();
        }
        // Cierra el flujo
        rd.close();
    }

    public static void main(String[] args) throws IOException {
        Activity6 A = new Activity6();
        Scanner sc = new Scanner(System.in);
        // Se pide por teclado la ruta y el texto y se inical el metodo de escritura y lectura.
        System.out.println("Introduzca la ruta en la que desea crear el archivo");
        String path = sc.nextLine();
        System.out.println("Introduzca el texto que desa escribir");
        String texto = sc.nextLine();
        A.escribir(path, texto);
        A.leer(path);
    }
}
