package a.threads;

public class RaceConditionExample {
    public static void main(String[] args) {
        MyRun myRun = new MyRun();
        Thread t1 = new Thread(myRun);
        Thread t2 = new Thread(myRun);
        Thread t3 = new Thread(myRun);
        t1.start();
        t2.start();
        t3.start();
    }
    // 2 4 5 3 6 7 2 8 9 - и даже volatile не поможет. Что могло произойти?
    // 1й поток получил 0 и увеличил до 1.
    // 2й поток вклинился перед выводом 2го потока и увеличил до 2.
    // 1й поток продолжил работу и вывел прочитав 2.
    // 2й поток пропустил 5 увеличений, несколько потоков успели поработать, и вывел 2.
}

class Counter {
    /*volatile*/ static int count = 0;
}

class MyRun implements Runnable {
    // 3 проблемы
    public void increment() {
        // 1. чтение count
        // ситуация Dirty Read чтение значения, которое получил другой поток и готов изменить

        // 2. изменение count
        Counter.count++; // в этот момент может случиться Last Commit Wins из-за неатомарности операции
        // не важно, какое значение сохранил вклинившийся поток

        // 3. чтение count
        // ситуация Race Condition (или Data Race), тоже что и
        // ситуация Non Repeatable Read, когда вклинившийся поток сохранил своё значение
        System.out.print(Counter.count + " ");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            increment();
        }
    }
}
