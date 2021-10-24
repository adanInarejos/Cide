import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Activity5DA extends JFrame {

    static Activity5DA a = new Activity5DA();

    /* Este metodo convina los dos ficheros en un solo, el nuevo fichero que se genera
    tendra como nombre la combinacion de los nombres de los dos ficheros*/
    public void combinarFicheros(File path1, File path2, String path3) throws Exception{
        /* se asigna a un string el nombre del primer archivo sin su extension
         para postreiormente combinar los nombres.*/
        String nombre = path1.getName().substring(0, path1.getName().length()-4);
        File file = new File(path3 + nombre+path2.getName());
        /*Si el fichero ya existe se lanzara un mensaje al usuario para que pueda elegir
        si quiere sobreescribir o no*/
        if (file.exists()){
           int SN =  JOptionPane.showConfirmDialog(this, "El fichero ya existe desea sobreescribir", "Sobrescribir", JOptionPane.YES_NO_OPTION);
           if (SN==0){
            FileWriter wr = new FileWriter(file);
            String a = this.copiarFichero(path1);
            String b = this.copiarFichero(path2);
            wr.write(a + b);
            wr.close();
           } else {
               throw new Exception("Se eligio no sobreescribir");
           }
           // COpia el contenido de los ficheros en uno nuevo.
        } else{
            FileWriter wr = new FileWriter(file);
            String a = this.copiarFichero(path1);
            String b = this.copiarFichero(path2);
            wr.write(a + b);
            wr.close();
        }
        
    }

    // Metodo para copiar el contenido de un fichero.
    public String copiarFichero(File path) throws IOException{
        FileReader rd = new FileReader(path);
        int valor = rd.read();
        String texto="";
        while(valor!=-1){
            texto = texto + (char) valor;
            valor = rd.read();
        }
        rd.close();
        return texto;
    }
    
    // Pedira al usuario que introduzca las distintas rutas y lanzara el metodo combinarFicheros.
    public static void main(String[] args) throws IOException {
        try {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la ruta de los dos archivos y la ruta final: ");
        File path1 = new File(sc.nextLine());
        File path2 = new File(sc.nextLine());
        String path3 = new String(sc.nextLine());

        a.combinarFicheros(path1, path2, path3);
        a.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            a.dispose();
        }
    
    }
}
