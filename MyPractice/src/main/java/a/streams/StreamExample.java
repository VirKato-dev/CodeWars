package a.streams;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamExample {

    record Group(String name, String description) {
    }

    record User(String username, Integer age, List<StreamExample.Group> groups) {
    }

    public List<User> consume(List<User> users) {
        // Фильтруем список пользователей
        return users.stream()
                // Для каждого пользователя проверяем список групп
                .filter(user -> user.groups().stream()
                        // Если хотя бы одно имя группы начинается на "X", включаем пользователя в итоговый список
                        .anyMatch(group -> group.name().startsWith("X"))
                )
                // Собираем результат в список
                .collect(Collectors.toList());
    }


    public static final Collector<Integer, ?, List<Integer>> LIST = Collectors.toList();


    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).filter(x -> x % 2 == 0 && x % 4 != 0).forEach(System.out::println);

        String[] websites0 = new String[1000];
        Stream.generate(() -> "codewars")
                .limit(1000).toList()
                .toArray(websites0);
        System.out.println(Arrays.toString(websites0));

        String[] websites = Stream.generate(() -> "codewars")
                .limit(1000).toList()
                .toArray(String[]::new);
        System.out.println(Arrays.toString(websites));

        String[] websites2 = new String[1000];
        Arrays.fill(websites2, "codewars");
        System.out.println(Arrays.toString(websites2));

        System.out.println(Arrays.toString(Collections.nCopies(1000, "codewars").toArray(new String[0])));

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
                .collect(LIST) // при count() - если убрать filter, то peek не отработают
        );

        Optional<Long> num = Optional.of(65535L);
        String tNum = num.map(Long::toHexString).get();
        System.out.println(tNum);
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
