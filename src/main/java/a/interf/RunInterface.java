package a.interf;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class RunInterface {

    public static void main(String[] args) {
        Runnable r = print();
        r.run();

        print().run();

        Runnable r2 = ((Supplier<Runnable>)RunInterface::print).get();
        r2.run();

        Consumer<String> print = System.out::println;
        Stream.of("Text for test", "Second line").forEach(print);
    }

    private static Runnable print() {
        return () -> System.out.println("Test");
    }
}
