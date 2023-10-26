package a.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ReentrantExample {
    private static final List<Future<String>> futureList = new ArrayList<>();
    private static final Lock lock = new ReentrantLock();
    private static final ExecutorService executorService = Executors.newFixedThreadPool(2);
    private static final Callable<String> callable1 = () -> {
        Thread.sleep(500);
        return "call1";
    };
    private static final Callable<String> callable2 = () -> "call2";


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            startTask(callable1);
            startTask(callable2);
        }

        executorService.shutdown();

        // ожидаем завершения всех задач
        boolean isReady = false;
        while (!isReady) {
            isReady = true;
            for (int i = 0; i < 10; i++) {
                if (!futureList.get(i).isDone()) {
                    isReady = false;
                    break;
                }
            }
        }

        futureList.forEach(t -> {
            try {
                System.out.println(t.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }


    private static void startTask(Callable<String> callable) {
        lock.lock();
        try {
            futureList.add(executorService.submit(callable));
        } finally {
            lock.unlock();
        }
    }
}
