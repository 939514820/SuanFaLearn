import java.util.concurrent.Semaphore;

public class Test {

    static Semaphore a1 = new Semaphore(1);
    static Semaphore b2 = new Semaphore(1);
    static Semaphore c3 = new Semaphore(1);

    public static class A extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    a1.acquire();
                    System.out.println("A");
                    b2.release();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class B extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    b2.acquire();
                    System.out.println("B");
                    c3.release();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class C extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    c3.acquire();
                    System.out.println("C");
                    a1.release();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        b2.acquire();
        c3.acquire();

        Thread.sleep(1000);
        new A().start();
        new B().start();
        new C().start();
    }
}
