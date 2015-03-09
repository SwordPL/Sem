/**
 * Created by student11 on 2015-03-09.
 */
public class Main {

    public static void main(String[] args) {
        Semaphore s = new Semaphore();
        Task t1 = new Task(s, true);
        Task t2 = new Task(s, false);

        Thread t11 = new Thread(t1);
        Thread t22 = new Thread(t2);

        t11.start();
        t22.start();

        try {
            t11.join();
            t22.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(Task.getA());
        System.out.println(t1.getTime());
        System.out.println(t2.getTime());
    }
}
