package a.generics;

public class Example {

    public static void main(String[] args) {
        Integer i = process(1.5f);
        System.out.println(i.toString());
    }

    static <R, T extends Number> R process(T t) {
        return (R)new MyType<>(t).get();
    }

    public static class MyType<T extends Number> {
        private final T v;

        public MyType(T value) {
            v = value;
        }

        public T get() {
            return v;
        }

        @Override
        public String toString() {
            return "MyType{" +
                    "v=" + v +
                    '}';
        }
    }
}
