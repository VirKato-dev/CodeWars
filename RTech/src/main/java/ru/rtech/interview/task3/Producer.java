package ru.rtech.interview.task3;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {

    // Общая очередь
    private final Queue<Double> sharedQueue;
    // Максимальный размер
    private final int SIZE;

    // Конструктор
    public Producer(Queue<Double> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
//        throw new UnsupportedOperationException("Implemented it!");
        while (true) {
            try {
                synchronized (sharedQueue) {
                    if (sharedQueue.size() == SIZE) {
                        System.out.println("queue is full");
                        sharedQueue.wait();
                    }
                    sharedQueue.add(produce());
                    sharedQueue.notify();
                }
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private double produce() throws InterruptedException {
//        throw new UnsupportedOperationException("Implemented it!");
        return new Random().nextDouble();
    }
}
