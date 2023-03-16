package a.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * groupingBy - это коллектор, который работает аналогично выражению GROUP BY в SQL.
 * Чтобы использовать его, нам нужно указать по какому свойству нужно группировать элементы.
 * В результате элементы стрима будут сгруппированы по этому свойству и помещены в Map.
 */
public class GroupingByExample {

    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Пушкин", "Евгений Онегин", "Роман", 352),
                new Book("Лермонтов", "Герой нашего времени", "Роман", 224),
                new Book("Гоголь", "Мёртвые души", "Поэма", 560),
                new Book("Гоголь", "Шинель", "Повесть", 64));

        // groupingBy
        // группировка по жанру
        Map<String, List<Book>> byGenre = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre));
        // byGenre = {Поэма=['Мёртвые души'], Роман=['Евгений Онегин', 'Герой нашего времени'], Повесть=['Шинель']}

        // summingInt
        // суммарное количество страниц во всех книгах в определённом жанре
        Map<String, Integer> totalLengthByGenre = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre,
                        Collectors.summingInt(Book::getPageCount)));
        // totalLengthByGenre = {Поэма=560, Роман=576, Повесть=64}

        // summarizingInt
        // статистика о количестве страниц в книгах по жанрам:
        Map<String, IntSummaryStatistics> statisticsByGenre = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre,
                        Collectors.summarizingInt(Book::getPageCount)));
        /*
        statisticsByGenre = {
          Поэма=IntSummaryStatistics{
            count=1, sum=560, min=560, average=560.000000, max=560},
          Роман=IntSummaryStatistics{
            count=2, sum=576, min=224, average=288.000000, max=352},
          Повесть=IntSummaryStatistics{
            count=1, sum=64, min=64, average=64.000000, max=64}
        }
        */

        // maxBy
        // самая большая книга у каждого автора:
        Map<String, Optional<Book>> maxLengthByAuthor = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor,
                        Collectors.maxBy(Comparator.comparingInt(Book::getPageCount))));
        // maxLengthByAuthor = {Пушкин=Optional['Евгений Онегин'],
        //                      Гоголь=Optional['Мёртвые души'],
        //                      Лермонтов=Optional['Герой нашего времени']}

        // mapping
        // преобразовать, применив дополнительный коллектор mapping.
        // К примеру, если нужно получить все жанры, в которых работал автор:
        Map<String, Set<String>> genresByAuthor = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor,
                        Collectors.mapping(Book::getGenre, Collectors.toSet())));
        // genresByAuthor = {Пушкин=[Роман], Гоголь=[Поэма, Повесть], Лермонтов=[Роман]}

        // filtering
        // отфильтровать, применив дополнительный коллектор filtering.
        // Например, чтобы получить короткие (количество страниц < 100) книги по каждому автору:
        Map<String, Set<Book>> shortBooks = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor,
                        Collectors.filtering(b -> b.getPageCount() < 100,
                                Collectors.toSet())));
        // shortBooks = {Пушкин=[], Гоголь=['Шинель'], Лермонтов=[]}

        // flatMapping
        books.get(0).setComments(List.of("Отлично!", "Хорошо"));
        books.get(3).setComments(List.of("Нормально", "Хорошо", "Отлично!"));
        // получить все комментарии по всем книгам автора, можно использовать такой код:
        Map<String, List<List<String>>> collect = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor,
                        Collectors.mapping(Book::getComments,
                                Collectors.toList())));
        // Но в этом случае получается список списков (List<List<String>>), что не всегда удобно.
        // Если нам нужно получить все комментарии одним списком, то нужно использовать метод flatMapping,
        // который по сути объединяет несколько стримов в один:
        Map<String, List<String>> authorComments = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor,
                        Collectors.flatMapping(book -> book.getComments().stream(),
                                Collectors.toList())));
        // authorComments = {Пушкин=[Отлично!, Хорошо], Гоголь=[Нормально, Хорошо, Отлично!], Лермонтов=[]}
    }
}


class Book {
    private String author;
    private String title;
    private String genre;
    private Integer pageCount;
    private List<String> comments = new ArrayList<>();

    public Book(String author, String title, String genre, Integer pageCount) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}