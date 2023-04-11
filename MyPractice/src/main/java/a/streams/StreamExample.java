package a.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamExample {

    public static void main(String[] args) {
        IntStream.iterate(10, x -> x + 5).limit(5).forEach(System.out::print);
        System.out.println();
        IntStream.generate(StreamExample::gen).skip(3).limit(5).forEach(System.out::print);
        System.out.println();
        long c = IntStream.generate(StreamExample::gen).limit(100).peek(System.out::print).count();
        System.out.println("\n(" + c + ")");
        System.out.println("Сумма 1 и 2 = " + IntStream.rangeClosed(1, 2).sum());

        Stream<String> stream = Stream.of("ab", "cde", "fgh", "ijkl");
        List<String> str = stream.flatMap(s -> s.chars().mapToObj(Character::toString)).toList();
        System.out.println(str);

        System.out.println(new Random().ints().limit(10).sum());

        int x = 5;
        System.out.println(x + " -> " + sqrt().apply(x));


        List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
        System.out.println(list.stream()
                .peek(StreamExample::handleVar1)
                .filter(i -> i % 2 == 0) // нечётные числа выпадают из потока
                .peek(StreamExample::handleVar2)
                .collect(Collectors.toList()) // при count() - если убрать filter, то peek не отработают
        );

    }

    private static void handleVar1(Integer n) {
        System.out.print("1:" + n + " ");
    }

    private static void handleVar2(Integer n) {
        System.out.print("2:" + n + " ");
    }

    private static UnaryOperator<Integer> sqrt() {
        return x -> x * x; // по типу возвращаемого значения компилятор понимает, что мы ему подсовываем за лямбду
    }

    private static int x = 1;

    private static int gen() {
        x += 7;
        return x;
    }
}
