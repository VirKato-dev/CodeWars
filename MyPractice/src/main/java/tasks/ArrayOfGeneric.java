package tasks;

public class ArrayOfGeneric {
    static class Counter {

    }

    public static void main(String[] args) {

    }

    static <T> void fill(T[] a, Class<T> clazz) {
        try {
            for (int i = 0; i < a.length; i++) {
                a[i] = clazz.getDeclaredConstructor().newInstance();
            }
        } catch (Exception ignored) {

        }
    }
}