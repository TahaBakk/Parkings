import java.util.concurrent.Semaphore;

/**
 * Created by x3727349s on 24/11/16.
 */
public class TParking {

    private static final int MAX_AVAILABLE = 100;
    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

    public void getItem() throws InterruptedException {
        available.acquire();

    }

    public void putItem(Object x) {
            available.release();
    }
}