public class Escalador extends Thread {

    int id;
    Cima cima;
    
    public Escalador(int id, Cima cima){
        this.id = id;
        this.cima = cima;
    }

    public void run(){
        try {
            cima.anadirEscalador(id);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
