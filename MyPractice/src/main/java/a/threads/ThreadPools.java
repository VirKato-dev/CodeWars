package a.threads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ThreadPools {
    /**
     * пул потоков на 5 потоков
     */
    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    /**
     * Задача без результата
     */
    private static final Runnable task1 = () -> {
        try {
            Thread.sleep(1000);
            System.out.println("task1 is finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    };

    /**
     * Задача с результатом
     */
    private static final Callable<Integer> task2 = () -> {
        Thread.sleep(1000);
        System.out.println("task2 is finished");
        return new Random().nextInt(10);
    };


    private static final List<Future<Integer>> results = new ArrayList<>();


    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
            executorService.submit(task1);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        for (int j = 0; j < 10; j++) {
            CompletableFuture<Integer> cf = new CompletableFuture<>();
//            cf.thenAccept();
            results.add(executorService.submit(task2));
        }

        while (!results.isEmpty()) {
            Iterator<Future<Integer>> it = results.iterator();
            while (it.hasNext()) {
                Future<Integer> f = it.next();
                if (f.isDone()) {
                    try {
                        System.out.println(f.get());
                        it.remove();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        executorService.shutdown();
    }
}
