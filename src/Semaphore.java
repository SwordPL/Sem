import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by student11 on 2015-03-09.
 */
public class Semaphore {
    private AtomicInteger counter = new AtomicInteger(1);

    public void swait() {
        while (!counter.compareAndSet(1, 0)) {
            Thread.yield();
        }
    }

    public void ssignal() {
        counter.getAndIncrement();
    }
}