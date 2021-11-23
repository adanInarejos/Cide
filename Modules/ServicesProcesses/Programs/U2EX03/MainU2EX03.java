public class MainU2EX03 {


    public static void main(String[] args) throws InterruptedException {

        int escaladoresTotales = 80;
        Cima cima = new Cima();


        Escalador[] e = new Escalador[escaladoresTotales];
        for (int i = 0; i < escaladoresTotales; i++) {
            e[i] = new Escalador(i +1, cima);
            e[i].start();
        }

        Helicoptero helicoptero1 = new Helicoptero("helicoptro1", cima, 1);
        Helicoptero helicoptero2 = new Helicoptero("helicoptro2", cima, 3);
        Helicoptero helicoptero3 = new Helicoptero("helicoptro3", cima, 5);

        helicoptero1.start();
        helicoptero2.start();
        helicoptero3.start();

        helicoptero1.join();
        helicoptero2.join();
        helicoptero3.join();

        for (int i = 0; i < escaladoresTotales; i++) {
            e[i].join();
        }

        System.out.println("Escavadores rescatadaos");


        
    }
    
}