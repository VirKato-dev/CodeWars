package a.streams.map;

import java.util.List;

public class ChangeInStream {
    private static final List<Long> longs = List.of(10L, 20L, 30L, 40L, 50L, 60L, 70L);

    public static void main(String[] args) {
        System.out.println(
                longs.stream()
                        .map(e -> e * 2)
                        .toList()
        );
    }
}
