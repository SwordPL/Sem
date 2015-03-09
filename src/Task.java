import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Runnable {
    private static AtomicInteger a;
    private long time;
    private Semaphore s;
    private boolean flag;

    public Task(Semaphore s, boolean incrementation) {
        a = new AtomicInteger(0);
        this.s = s;
        flag = incrementation;
    }

    public static AtomicInteger getA() {
        return a;
    }

    @Override
    public void run() {
        time = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            s.swait();
            try {
                if (flag) {
                    a.incrementAndGet();
                } else {
                    a.decrementAndGet();
                }
            } finally {
                s.ssignal();
            }
        }
        time = System.currentTimeMillis() - time;
    }

    public long getTime() {
        return time;
    }
}
