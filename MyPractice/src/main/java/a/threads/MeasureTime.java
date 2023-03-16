package a.threads;

import a.algo.sort.Bubble;

import java.util.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class MeasureTime {

    public static void main(String[] args) {
        int testLen = 1_000;
        int[] arr = new int[testLen];
        for (int i = 0; i < testLen; i++) {
            arr[i] = (int) Math.round(Math.random() * testLen);
        }

        measureTime("Сортировка пузырьком", () -> Bubble.bubbleSort(arr));
    }


    public static void measureTime(String title, Runnable action) {
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);

        new Thread(() -> {
            long begin = System.currentTimeMillis();
            action.run();
            long duration = System.currentTimeMillis() - begin;
            String message = String.format("%s:%nЗатрачено время: %dms%n", title, duration);
            handler.publish(new LogRecord(Level.ALL, message));
            handler.close();
        }).start();
    }

    public static void measureTime(String title, Runnable action, int[] arr) {
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);

        new Thread(() -> {
            long begin = System.nanoTime();

            StringBuilder sb = new StringBuilder();
            int repeat = 5;
            for (int i = 0; i < repeat; i++) {
//                sb.append(Arrays.toString(arr)).append("\n");
                action.run();
                shuffle(arr);
            }

            long duration = System.nanoTime() - begin;
            duration /= repeat;
            String message = String.format("%s:%n%sЗатрачено время: %dns%n", title, sb, duration);
            handler.publish(new LogRecord(Level.ALL, message));
            handler.close();
        }).start();
    }

    private static void shuffle(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int pos = rand.nextInt(arr.length);
            int tmp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = tmp;
        }
    }
}
