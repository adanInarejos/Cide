public class Helicoptero extends Thread {


    String nombre;
    int capacidad;
    Cima cima;
    int recogidos;

    public Helicoptero(String nombre, Cima cima, int capacidad){
        this.cima=cima;
        this.nombre=nombre;
        this.capacidad = capacidad;
    }
    

    public void run(){
        int espera;
        int numEscaladores;
        // Cambiar
        while (cima.hayEscaladoresPendientes()){
            try {
                espera = (int) (Math.random() * 2000 + 1000);
                numEscaladores = cima.terminarEscalador(this);
                sleep(espera);
                System.out.println("El helicoptero " + nombre + " ha extraido a " + recogidos + " escaladores en " + espera + " segundos");
                recogidos = 0;
            } catch (Exception e) {
                System.out.println("El helicoptero " + nombre + " ha extraido a " + recogidos + " debido a que la cima ya esta vacia");
            }
        }
        System.err.println("Helicoptero " + nombre + " ha finalizado");
    }

    public void SumarEscalador(){
        recogidos++;
    }

    public int getCapacidad() {
        return capacidad;
    }
}
