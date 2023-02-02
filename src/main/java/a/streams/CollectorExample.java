package a.streams;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Предположим, что у нас есть стрим статей Stream<Article>, а в статьях есть метод getWordCount,
 * который возвращает количество слов в этой статье.
 * И нам нужен такой коллектор, который просуммирует количество слов во всех этих статьях.
 * Давайте создадим его.
 */
public class CollectorExample {

    /**
     * Класс-статья
     */
    static class Article {
        private static final Random rand = new Random();

        public int getWordCount() {
            return rand.nextInt(10);
        }

        public boolean isRussian() {
            return rand.nextBoolean();
        }
    }

    /**
     * Класс-контейнер
     */
    static class MutableInteger {
        private int value;

        public MutableInteger(int value) {
            this.value = value;
        }

        public void add(int value) {
            this.value += value;
        }

        public int getValue() {
            return this.value;
        }
    }

    /**
     * Supplier<A> supplier() — создаёт объект, в котором будет храниться результат работы коллектора (контейнер):
     */
    private static final Supplier<MutableInteger> supplier = () -> new MutableInteger(0);

    /**
     * BiConsumer<A, T> accumulator() — возвращает функцию, которая будет использоваться
     * для обновления результата в контейнере на основе элемента стрима.
     * В нашем случае — добавит количество слов в статье:
     */
    private static final BiConsumer<MutableInteger, Article> accumulator = (accumulator, article) -> accumulator.add(article.getWordCount());

    /**
     * BinaryOperator<A> combiner() — возвращает функцию, которая будет использоваться
     * при объединении нескольких контейнеров с результатами:
     */
    private static final BinaryOperator<MutableInteger> combiner = (left, right) -> {
        left.add(right.getValue());
        return left;
    };

    /**
     * Нужно выполнить преобразование над контейнером MutableInteger для получения int.
     * Для этого есть четвёртый метод в интерфейсе Collector — finisher.
     */
    private static final Function<MutableInteger, Integer> finisher = accumulator -> accumulator.getValue();


    public static void main(String[] args) {

        /*
         Коллектор - это класс, реализующий интерфейс Collector,
         поэтому для создания своего коллектора мы можем либо имплементировать данный интерфейс стандартным образом,
         либо воспользоваться методом Collector.of, который облегчает этот процесс.
        */
        Collector<Article, MutableInteger, Integer> collector = Collector.of(
                supplier, // контейнер в который собираются данные
                accumulator, // аккумулятор со следующим элементом
                combiner, // элементы из разных потоков при параллельной обработке
                finisher, // вытащить int из MutableInteger
                Collector.Characteristics.CONCURRENT // следом можно добавить ещё характеристики коллектора
        );
        // Существует 3 характеристики
        // CONCURRENT — Указывает, что контейнер с результатом может использоваться при параллельной работе.
        // UNORDERED — Указывает, результат работы коллектора не учитывает исходный порядок элементов.
        // IDENTITY_FINISH — Указывает, что функция finisher возвращает контейнер с результатом
        //                  без каких-либо преобразований, следовательно, её можно не вызывать.

        Stream<Article> articleStream = Stream.<Article>builder()
                .add(new Article())
                .add(new Article())
                .add(new Article())
                .add(new Article())
                .build();

        System.out.println(articleStream.collect(collector));
    }
}
