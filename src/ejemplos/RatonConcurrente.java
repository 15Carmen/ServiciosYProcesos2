package ejemplos;

import java.io.File;

public class RatonConcurrente extends Thread{
    private String nombre;
    private int tiempoAlimentacion;

    public RatonConcurrente(String nombre, int tiempoAlimentacion) {
        super();
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }

    public void comer() {
        try {
            System.out.printf("El ratón %s ha comenzado a alimentarse%n", nombre);
            Thread.sleep(tiempoAlimentacion * 1000);
            File f = new File("recursos.txt");
            System.out.printf("El ratón %s ha terminado de alimentarse%n", nombre);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.comer();
    }

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Raton fievel = new Raton("Fievel", 4);
            fievel.getClass();
        }

        /*
        RatonConcurrente fievel = new RatonConcurrente("Fievel", 4);
        RatonConcurrente jerry = new RatonConcurrente("Jerry", 5);
        RatonConcurrente pinky = new RatonConcurrente("Pinky", 3);
        RatonConcurrente mickey = new RatonConcurrente("Mickey", 6);

        pinky.setPriority(1);
        fievel.setPriority(2);
        jerry.setPriority(3);
        mickey.setPriority(4);

        // El método start() pertenece a la clase Thread. Por dentro, llama al método run()
        fievel.start();
        jerry.start();
        pinky.start();
        mickey.start();
         */
    }
}
