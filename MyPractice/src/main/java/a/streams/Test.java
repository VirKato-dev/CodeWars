package a.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        // ленивый стрим ничего не напечатает
        Stream.of(1, 2, 3, 4)
                .filter(i -> i % 2 == 0)
                .map(i -> {
                    System.out.println("Here we are");
                    return Integer.toString(i);
                });

        // Что делает данный коллектор, если его элементы - это новостные статьи?
        Collector.<CollectorExample.Article, List<CollectorExample.Article>>of(
                ArrayList::new,
                (accumulator, next) -> {
                    if (next.isRussian()) {
                        accumulator.add(next); // накапливает только русские статьи
                    }
                },
                (left, right) -> {
                    left.addAll(right);
                    return left;
                }
        );
    }
}
