public class MainU2EX03 {


    public static void main(String[] args) throws InterruptedException {

        // Se declara el numero total de escaladores y se intancia la cima
        int escaladoresTotales = 80;
        Cima cima = new Cima();


        // Se crean y se inician los escaladores
        Escalador[] e = new Escalador[escaladoresTotales];
        for (int i = 0; i < escaladoresTotales; i++) {
            e[i] = new Escalador(i +1, cima);
            e[i].start();
        }

        // Se crean los elicopteros y se establece la cantidad de personas que pueden llevar
        Helicoptero helicoptero1 = new Helicoptero("helicoptro1", cima, 1);
        Helicoptero helicoptero2 = new Helicoptero("helicoptro2", cima, 3);
        Helicoptero helicoptero3 = new Helicoptero("helicoptro3", cima, 5);

        // Se inician los helicopteros.
        helicoptero1.start();
        helicoptero2.start();
        helicoptero3.start();

        // Se bloquen los helicopteros y los escaladores
        helicoptero1.join();
        helicoptero2.join();
        helicoptero3.join();

        for (int i = 0; i < escaladoresTotales; i++) {
            e[i].join();
        }

        // Mensaje de que el programa a acabado.
        System.out.println("Escavadores rescatadaos");


        
    }
    
}