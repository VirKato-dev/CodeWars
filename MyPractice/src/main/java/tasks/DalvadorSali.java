package tasks;

public class DalvadorSali {

    private static int a = 0, b = 0;

    private static final Thread secondThread = new Thread(() -> {
        b = 1;
        System.out.print("a = " + a + ",");
    });

    private static final Thread firstThread = new Thread(() -> {
        a = 1;
        secondThread.start();
        System.out.print("b = " + b + ",");
    }
    );

    public static void main(String[] args) throws InterruptedException {
        System.out.print("{");
        firstThread.start();
        firstThread.join();
        secondThread.join();
        System.out.println("}");
    }
}
