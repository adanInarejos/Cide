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
        // espera sera el tiempo que se tarda en recoger a los escaladores
        int espera;
        int numEscaladores;
        while (cima.hayEscaladoresPendientes()){
            try {
                // La espera sera un numero random entre 10 y 20 segundos
                espera = (int) (Math.random() * 2000 + 1000);
                // Se recogen a los escaladores
                numEscaladores = cima.terminarEscalador(this);
                // El hilo se ponde a dormir
                sleep(espera);
                // Se muestra un mensaje indicando que el helicoptero a recogido a los escaladores
                System.out.println("El helicoptero " + nombre + " ha extraido a " + recogidos + " escaladores en " + espera + " segundos");
                recogidos = 0;
            } catch (Exception e) {
                // Si la cima esta vacia se muestra un aviso por pantalla
                System.out.println("El helicoptero " + nombre + " ha extraido a " + recogidos + " debido a que la cima ya esta vacia");
            }
        }
        // Mensaje para indicar que el hilo a finalizado
        System.err.println("Helicoptero " + nombre + " ha finalizado");
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
