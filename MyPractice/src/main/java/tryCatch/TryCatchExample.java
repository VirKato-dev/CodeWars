package tryCatch;

public class TryCatchExample {

    static {
        Thread.setDefaultUncaughtExceptionHandler(
                (t, e) -> System.out.println("Exception: " + e.getClass().getSimpleName())
        );
    }


    public static void main(String[] args) {
        try {
            var result = 10 / 0;
        } finally {
            System.out.println("finally block");
            throw new Error();
        }
    }
}
