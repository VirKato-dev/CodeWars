package a.streams.task;

import java.util.stream.Stream;

public class FlatMapTask01 {
    public static void main(String[] args) {
        Stream<Phone> phoneStream = Stream.of(
                new Phone("iPhone 6s", 54000),
                new Phone("Motorola", 40000)
        );

        phoneStream.flatMap(p -> Stream.of(
                                String.format("name: %s regular price: %.0f", p.getName(), p.getPrice()),
                                String.format("name: %s discount price: %.2f", p.getName(), p.getPrice() - p.getPrice() * 0.1)
                        )
                )
                .forEach(System.out::println);
    }
}

class Phone {
    private final String name;
    private final double price;

    Phone(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
