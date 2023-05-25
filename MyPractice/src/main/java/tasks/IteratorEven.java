package tasks;

import java.util.*;

/**
 * Есть набор целых чисел.
 * Реализовать итератор, возвращающий только чётные (по значению) числа из него.
 * Использовать интерфейс Collection
 */

public class IteratorEven implements Iterator<Integer> {
    private final Collection<Integer> collection;
    private final Iterator<Integer> iterator;
    private Integer nextEven = null;


    public IteratorEven(Collection<Integer> collection) {
        this.collection = collection;
        this.iterator = collection.iterator();
    }


    @Override
    public boolean hasNext() {
        if (nextEven != null) return true;
        while (iterator.hasNext()) {
            nextEven = iterator.next();
            if (nextEven % 2 == 0) return true;
        }
        return false;
    }


    @Override
    public Integer next() {
        if (hasNext()) {
            Integer result = nextEven;
            nextEven = null;
            return result;
        }
        throw new NoSuchElementException();
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Iterator<Integer> iter = new IteratorEven(list);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}