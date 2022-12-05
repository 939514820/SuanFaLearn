import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSub {
    static volatile Long a = 0L;


    public static class MyThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                a = a + 1;
            }
        }
        // 10 0-10000 10000

        public static void main(String[] args) throws InterruptedException {
            for (int i = 0; i < 10; i++) {
                Thread t = new Thread(() -> {
                    for (int j = 0; j < 10000; j++) {
                        a = a + 1;
                    }
                });
                t.start();
                t.join();
            }
            System.out.println("a=" + a);
        }
    }
//


}
