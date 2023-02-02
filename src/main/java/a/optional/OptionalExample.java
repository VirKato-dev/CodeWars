package a.optional;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> oString = Optional.of("Text");
        oString = Optional.empty();
    }
}
