public class Helicoptero extends Thread {


    // Atributos del helicoptero
    String nombre;
    int capacidad;
    Cima cima;
    int recogidos;

    // En el constructor se indica el nombre y capacidad de el helicoptero y se indica la cima
    public Helicoptero(String nombre, Cima cima, int capacidad){
        this.cima=cima;
        this.nombre=nombre;
        this.capacidad = capacidad;
    }
    
    // Metodo de ejecucion
    public void run(){
        int numEscaladores;
        while (cima.hayEscaladoresPendientes()){
            try {
                // Se recogen a los escaladores
                numEscaladores = cima.terminarEscalador(this);
                // Se muestra un mensaje indicando que el helicoptero a recogido a los escaladores
                System.out.println("El helicoptero " + nombre + " ha extraido a " + recogidos + " escaladores");
                recogidos = 0;
            } catch (Exception e) {
                // Si la cima esta vacia se muestra un aviso por pantalla
                System.out.println("El helicoptero " + nombre + " ha extraido a " + recogidos + " debido a que la cima ya esta vacia");
            }
        }
        // Mensaje para indicar que el hilo a finalizado
        System.out.println("Helicoptero " + nombre + " ha finalizado");
    }

    // Metodo para contabilizar los escaladores recogidos en cada tanda
    public void SumarEscalador(){
        recogidos++;
    }

    // Metodo que devuelve que capacidad tiene el helicoptero
    public int getCapacidad() {
        return capacidad;
    }
}
