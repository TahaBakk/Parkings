package ejemplosDionis; /**
 * Created by Dionis on 17/11/2015.
 */

import java.util.concurrent.Semaphore;


/**
 * @author Chandan Singh
 *This class demonstrates the use of java.util.concurrent.Semaphore Class
 */
public class SemaphoreDemo
{
    Semaphore semaphore = new Semaphore(8);
    int i = 0;

    public void printLock() {

            try {
                i = 0;
                semaphore.acquire();
                System.out.println("Locks acquired");
                System.out.println("Locks remaining >> " + semaphore.availablePermits());
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("Locks Released");
                System.out.println("Locks remaining >> " + semaphore.availablePermits());
            }
        }

    public static void main(String[] args)
    {
        final SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        Thread thread = new Thread(){
            @Override
            public void run()
            {
                semaphoreDemo.printLock();
            }};
        thread.start();
    }
}