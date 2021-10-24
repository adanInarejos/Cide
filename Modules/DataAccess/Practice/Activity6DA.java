import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Activity6DA {
    private ArrayList<Integer> numeros = new ArrayList<Integer>();

    // Este metodo genera un array con los primeros 100 numeros pares.
    public void generarArray(ArrayList array){
        int numero = 0;
        while (numero<=199){
            // Si el resto de la division entre dos da cero significa que el numero es par.
            if ((numero%2)==0){
                array.add(numero);
            }
            numero++;
        }
    }

    public static void main(String[] args) throws IOException {
        FileWriter wr = new FileWriter("hola.txt");
        Activity6DA A = new Activity6DA();
        //Generamos el array.
        A.generarArray(A.numeros);
        //Volcamos el array en el fichero.
        for (int i = 0; i < A.numeros.size(); i++) {
            wr.write((A.numeros.get(i)).toString() + "\n");
        
        }
        wr.close();


    }
    
}



