package a.threads;

import java.util.Locale;

public class RaceCondition2Example {
    private static /*volatile*/ int A, B;
    private static int r1, r2;

    /**
     * Возможны 4 результата для r1,r2 = 0,0; 0,1; 1,0; 1,1
     */
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable1 = () -> {
            B = 1;
            r1 = A;
        };

        Runnable runnable2 = () -> {
            A = 1;
            r2 = B;
        };

        long min = Long.MAX_VALUE;
        long start, duration;

        long i = 0;
        while (true) {
            A = 0;
            B = 0;
            r1 = 0;
            r2 = 0;
            start = System.nanoTime();
//            System.nanoTime(); // 100ns
            Thread t1 = new Thread(runnable1);
            Thread t2 = new Thread(runnable2);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            duration = System.nanoTime() - start;
            min = Math.min(duration, min);
            if (r1 == 1 && r2 == 1) break;
            i++;
        }
        System.out.printf(Locale.getDefault(), "i=%d, r1=%d, r2=%d%n", i, r1, r2);
        System.out.println("Минимальный интервал выполнения двух потоков: " + min);
    }
}
