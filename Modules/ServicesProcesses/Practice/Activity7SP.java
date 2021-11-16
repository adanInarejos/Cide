public class Activity7SP extends Thread {
    public static void main(String[] args) throws InterruptedException {
        // Instanciamos los corredores.
        Activity7SP runner1 = new Activity7SP();
        Activity7SP runner2 = new Activity7SP();
        Activity7SP runner3 = new Activity7SP();


        // Setteamos las prioridades de los corredores
        runner1.setPriority(1);
        runner2.setPriority(4);
        runner3.setPriority(9);

        // Iniciamos los corredores
        runner1.start();
        runner2.start();
        runner3.start();


        // Se unen
        runner1.join();
        runner2.join();
        runner3.join();

    


    }

    // Metodo de correr
    @Override
    public void run() {
        for (int i = 0; i <= 50; i++) {
            System.out.println("Metros del corredor "+getName()+": " + i);
        }
        System.out.println("Corredor "+getName()+" ha terminado la carrera.");
    }
}

