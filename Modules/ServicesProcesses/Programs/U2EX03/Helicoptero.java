public class Helicoptero extends Thread {


    String nombre;
    int capacidad;
    Cima cima;

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
                espera = (int) (Math.random() * 20 + 10);
                numEscaladores = cima.terminarEscalador();
                sleep(espera);
                System.out.println("El helicoptero " + nombre + "he extraido a " + capacidad + " escaladores en " + espera + " segundos");
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        System.err.println("Helicoptero " + nombre + " ha finalizado");
    }
}
