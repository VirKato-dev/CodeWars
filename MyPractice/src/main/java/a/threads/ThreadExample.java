package a.threads;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " is " + Thread.currentThread().getState()), "th1");
        Thread th2 = new Thread(() -> System.out.println(Thread.currentThread().getName()), "th2");

        System.out.println(th1.getName() + ": " + th1.getState());
        th1.start();
        Thread.State state = th1.getState();
        System.out.println(th1.getName() + ": " + state);
        System.out.println(th1.getName() + ": " + th1.getState());
        th1.join();
        System.out.println(th1.getName() + ": " + th1.getState());
    }

    // Состояния потока исполнения
    // NEW - только создан
    // RUNNABLE: - после вызова start
    // - READY - ожидает своей очереди на исполнение
    // - RUNNING - приступил к выполнению
    // TERMINATED - уничтожен


    // Concurrency - согласованность/совпадение
    // петь и кушать (есть разделяемый/общий ресурс - рот)
    // чередование потоков исполнения (непредсказуемый/недетерминированный порядок)

    // Parallelism - параллелизм
    // готовить и разговаривать (нет общих ресурсов)
    // одновременное исполнение потоков


    // Asynchronous - независимое исполнение кода (параллельно или с чередованием)
    // готовить бутерброд и стирать бельё в машинке

    // Synchronous - последовательное исполнение кода (блокирующее исполнение)
    // написать 2 письма (или дождаться квитанции об оплате и потом оплатить её)
}
