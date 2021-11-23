import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

public class Cima {
    Semaphore semaphore;
    PriorityQueue<Integer> escaladores;

    public Cima(){
        semaphore = new Semaphore(1);
        escaladores = new PriorityQueue<Integer>();
    }

    public void anadirEscalador(Integer idEscalador) throws InterruptedException{
        try {
            semaphore.acquire();
            escaladores.add(idEscalador);
            semaphore.release();   
        } catch (Exception e) {
            //TODO: handle exception
        }
    
    }

    public boolean hayEscaladoresPendientes(){
        if (escaladores.size()>0){
            return true;
        } else {
            return false;
        }
    }

    public int terminarEscalador(Helicoptero helicoptero) throws Exception{
        Integer escalador=0;
        if (hayEscaladoresPendientes()){
            semaphore.acquire();
            for (int i = 0; i < helicoptero.getCapacidad(); i++) {
                escalador = escaladores.poll(); 
                if (escalador == null){
                    throw new Exception("No quedan escaladores en la cima");
                }  
                helicoptero.SumarEscalador();
            }
            semaphore.release();
        }
        return escalador;
    }
    


}
