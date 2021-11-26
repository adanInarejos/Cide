import java.util.PriorityQueue;
public class Cima {

    PriorityQueue<Integer> escaladores;

    public Cima(){
        // lista escaladores
        escaladores = new PriorityQueue<Integer>();
    }

    // Metodo para añadir escaladores a la cima
    public void anadirEscalador(Integer idEscalador) throws InterruptedException{
        try {
            escaladores.add(idEscalador); 
        } catch (Exception e) {
            //TODO: handle exception
        }
    
    }

    // Metodo para comprobar si quedan escaladores en la cima
    public boolean hayEscaladoresPendientes(){
        if (escaladores.size()>0){
            return true;
        } else {
            return false;
        }
    }

    // Este metodo recoge tantos escaladores como capacidad tiene el helicoptero que llega a la cima
    public synchronized int terminarEscalador(Helicoptero helicoptero) throws Exception{
        Integer escalador=0;
        if (hayEscaladoresPendientes()){
            // Este bucle recogera escaladores mienstras haya espacio en el helicoptero
            for (int i = 0; i < helicoptero.getCapacidad(); i++) {
                escalador = escaladores.poll(); 
                // Si el escalador recogido es nulo se lanza una excepcion
                if (escalador == null){
                    throw new Exception("No quedan escaladores en la cima");
                }  
                // Se suma un escalador al helicpotero
                helicoptero.SumarEscalador();
            }
            // Se duerme al proceso entre 10 y 20 segundos para simular lo que tarda el helicpetro en realizar la recoida
            Thread.sleep( (int) (Math.random()*20000) + 10000);
        }
        return escalador;
    }
    


}
