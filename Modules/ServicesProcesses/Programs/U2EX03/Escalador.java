public class Escalador extends Thread {

    // Atributos, el id es el identificador del escalador
    int id;
    Cima cima;
    
    // COnstructor, se indican el id y la cima en la que se encuntra
    public Escalador(int id, Cima cima){
        this.id = id;
        this.cima = cima;
    }

    // Metodo de ejcucion se anade el escalador a la cima
    public void run(){
        try {
            cima.anadirEscalador(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
