import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

public class Cima { 
    // Atributos: escaladores sera la lista de escaladores que hay en la cima
    Semaphore semaphore;
    PriorityQueue<Integer> escaladores;

    // Constructor, se inicializan el semaforo y la lista de escaladores
    public Cima(){
        semaphore = new Semaphore(1);
        escaladores = new PriorityQueue<Integer>();
    }

    // Metodo para anadir escaladores a la cimaS
    public void anadirEscalador(Integer idEscalador) throws InterruptedException{
        try {
            semaphore.acquire();
            escaladores.add(idEscalador);
            semaphore.release();   
        } catch (Exception e) {
            //TODO: handle exception
        }
    
    }

    // Eeste metodo indica si hay aun o no escaladores por recoger
    public boolean hayEscaladoresPendientes(){
        if (escaladores.size()>0){
            return true;
        } else {
            return false;
        }
    }

    // Metodo para recoger los escaladores
    public int terminarEscalador(Helicoptero helicoptero) throws Exception{
        Integer escalador=0;
        // Si hay escaladores pendientes recogera el maximo de escaladores que quepan en el helicoptero
        if (hayEscaladoresPendientes()){
            // Se adquiere el semaforo
            semaphore.acquire();
            for (int i = 0; i < helicoptero.getCapacidad(); i++) {
                // Se recoge un escalador de la lista
                escalador = escaladores.poll(); 
                // Si no quedan escaladores se lanza una excepcion
                if (escalador == null){
                    throw new Exception("No quedan escaladores en la cima");
                }  
                // Se suma uno a los escaladores he hay en el helicptero
                helicoptero.SumarEscalador();
            }
            // Se libera el semaforo
            semaphore.release();
        }
        // Se devulve el escalador
        return escalador;
    }
    


}
