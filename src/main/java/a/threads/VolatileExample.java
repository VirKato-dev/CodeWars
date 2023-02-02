package a.threads;

public class VolatileExample {

    static class VolExm extends Thread {
        /*volatile*/ boolean b = true; // volatile запрещает кеширование значения в память потока
        // volatile справляется только когда один поток изменяет переменную, а остальные только читают

        @Override
        public void run() {
            long counter = 0;
            while (b) {
                counter++;
            }
            System.out.println("Loop is finished. Counter = " + counter);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        VolExm ve = new VolExm();
        ve.start(); // запустился на отдельном ядре со своей памятью
        Thread.sleep(1000);
        System.out.println("After three seconds");
        ve.b = false; // поток проигнорировал изменение значения в поле b (передача значения между потоками)
        ve.join();
        System.out.println("End of program");
    }
}
