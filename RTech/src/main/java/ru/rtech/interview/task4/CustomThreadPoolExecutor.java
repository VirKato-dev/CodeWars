package ru.rtech.interview.task4;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor {
    public CustomThreadPoolExecutor(int maximumPoolSize) {
        super(0, maximumPoolSize, 0, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<>());
    }

    @Override
    public void execute(Runnable command) {
        if (command.getClass().isAnnotationPresent(Repeat.class)) {
            int repeat = command.getClass().getAnnotation(Repeat.class).value();
            for (int i = 0; i < repeat; i++) {
                super.execute(command);
            }
        }
    }
}
