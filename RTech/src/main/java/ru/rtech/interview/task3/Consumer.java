package ru.rtech.interview.task3;

import java.util.Queue;

public class Consumer implements Runnable {

    // Общая очередь
    private final Queue<Double> sharedQueue;

    public Consumer(Queue<Double> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
//        throw new UnsupportedOperationException("Implemented it!");
        while (true) {
            try {
                synchronized (sharedQueue) {
                    if (sharedQueue.isEmpty()) {
                        sharedQueue.wait();
                    }
                    System.out.println(consume());
                    sharedQueue.notify();
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Double consume() throws InterruptedException {
//        throw new UnsupportedOperationException("Implemented it!");
        return sharedQueue.poll();
    }
}
