package concurrent;

public class DeadLockProblem {

    public static void main(String[] args) {
        final String resource1 = "resource1";
        final String resource2 = "resource2";
        // Поток 1 запрашивает ресурс 1, а затем ресурс 2
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: locked resource 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                synchronized (resource2) {
                    System.out.println("Thread 1: locked resource 2");
                }
            }
        });
        // Поток 2 запрашивает ресурс 2, а затем ресурс 1
        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: locked resource 2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                synchronized (resource1) {
                    System.out.println("Thread 2: locked resource 1");
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}

// кирпич = 1кг + пол кирпича

// к = 1кг + 0.5к
// к - 0.5к = 1кг
// 0.5к = 1кг
// к = 1кг / 0.5
// к = 2кг

// 1к = (2кг + 1к) / 2
// 2к = 2кг + 1к
// 1к - 1к = 2кг
// 2кг
