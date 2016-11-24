package ejemplosDionis;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 * Created by x3727349s on 24/11/16.
 */
public class Example2 {

 public static class parking {
        private static final int numSemaphore = 3;
        private final Semaphore plaza = new Semaphore(numSemaphore, true);

        public void entra() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce la cantidad de coches para aparcar: ");
            int cantidadCoches=sc.nextInt();
            for (int i = 0; i < cantidadCoches; i++) {
                Coche pk = new Coche();
                pk.start();
            }
        }

 public class Coche extends Thread {
            @Override
            public void run() {
                try {
                    plaza.acquire();
                    System.out.println("El coche "+ getId()+" consigue plaza");

                } catch (InterruptedException e) {
                    System.out.println("received InterruptedException");
                    return;
                }
                try {
                    sleep(1000);
                } catch (Exception e) {

                } finally {

                    // Release Lock
                    plaza.release();
                    System.out.println("El coche "+getId()+ " abandona el parking");

                }
            }
        }

 public static void main(String[] args) {
            parking pk = new parking();
            pk.entra();

        }
    }

}
