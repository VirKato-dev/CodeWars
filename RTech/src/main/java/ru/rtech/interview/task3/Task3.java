package ru.rtech.interview.task3;

import java.util.LinkedList;

public class Task3 {

    /**
     * Дано два потока — производитель и потребитель. Производитель генерирует некоторые данные (например — числа). Потребитель «потребляет» их.
     * Два потока разделяют общий буфер данных, размер которого ограничен.
     * Если буфер пуст, потребитель должен ждать, пока там появятся данные.
     * Если буфер заполнен полностью, производитель должен ждать, пока потребитель заберёт данные и место освободится.
     */

    public static void main(String... args) {
        LinkedList<Double> sharedQueue = new LinkedList<>();
        int size = 4;
        Thread prodThread = new Thread(new Producer(sharedQueue, size), "Producer");
        Thread consThread = new Thread(new Consumer(sharedQueue), "Consumer");
        prodThread.start();
        consThread.start();
    }
}
