package tasks;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamPeek {
    public static void main(String[] args) {
        Stream.of("yes", "no", "qwerty", "solid")
                .sorted(Comparator.comparingInt(String::length))
                .peek(s -> System.out.println("before filtering: " + s))
                .filter(s -> s.length() > 2)
                .forEach(s -> System.out.println("after filtering: " + s));
    }
}
