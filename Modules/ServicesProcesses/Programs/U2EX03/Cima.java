import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

public class Cima {
    Semaphore semaphore;
    PriorityQueue<Integer> escaladores;

    public Cima(){
        semaphore = new Semaphore(1);
        escaladores = new PriorityQueue<Integer>();
    }

    public void anadirEscaladores(Integer numeroEscaladores){
        semaphore.acquire();
        escaladores.add(numeroEscaladores);
        semaphore.release();
    }

    public boolean hayEscaladoresPendientes(){
        if (escaladores.size()>0){
            return true;
        } else {
            return false;
        }
    }

    public int terminarEscalador(){
        int coche=0;
        if (hayEscaladoresPendientes()){
            semaphore.acquire();
            coche = escaladores.poll();
            semaphore.release();
        }
        return coche;
    }


}
