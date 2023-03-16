package a.interf;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface Multy extends Supplier<String>, Consumer<String> {
    @Override
    default void accept(String s) {

    }

    @Override
    default String get() {
        return null;
    }
}
