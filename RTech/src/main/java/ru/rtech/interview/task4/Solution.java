package ru.rtech.interview.task4;

public class Solution {
    public static void main(String[] strings) {
        CustomThreadPoolExecutor customThreadPoolExecutor = new CustomThreadPoolExecutor(10);
        customThreadPoolExecutor.execute(new MyRunnable());
    }
}
