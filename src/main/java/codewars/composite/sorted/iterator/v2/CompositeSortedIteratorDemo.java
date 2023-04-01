package codewars.composite.sorted.iterator.v2;

import java.util.*;

//todo не решено

/**
 * You are given an array of Iterator objects each sorted ascending with provided Comparator. Build a composite Iterator that yields combined content sorted same way.
 * <ul><b>Constraints</b>
 * <li>there may be at most 100000 source iterators</li>
 * <li>there may be no source iterators at all</li>
 * <li>iterators may or may not be empty</li>
 * <li>iterators may or may not be infinite</li>
 * <li>elements may repeat</li>
 * <li>source and output iterators are supposed to be read-only</li></ul>
 * <ul><b>Performance constraints</b>
 * <li>random finite tests have timeout of 1s (max 100000 elements split randomly between 100000 iterators)</li>
 * <li>infinite iterators are tested by polling considerably large amount of elements</li>
 * <li>fixed infinite tests have timeout of 0.1s (longest has 10000 iterators, ~1000 elements)</li>
 * <li>random infinite tests have timeout of 5s (max 500000 elements between 100000 iterators)</li></ul>
 */
public class CompositeSortedIteratorDemo {
    public static void main(String[] args) {
    }
}


class CompositeSortedIterator<T> implements Iterator<T> {
    private final Queue<Map.Entry<Iterator<T>, T>> queue;

    @SafeVarargs
    public CompositeSortedIterator(Comparator<? super T> cmp, Iterator<T>... iterators) {
        queue = new PriorityQueue<>(Map.Entry.comparingByValue(cmp));
        for (Iterator<T> iterator : iterators) {
            if (iterator.hasNext()) {
                queue.add(new AbstractMap.SimpleImmutableEntry<>(iterator, iterator.next()));
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Map.Entry<Iterator<T>, T> entry = queue.remove();
        Iterator<T> iterator = entry.getKey();
        if (iterator.hasNext()) {
            queue.add(new AbstractMap.SimpleImmutableEntry<>(iterator, iterator.next()));
        }
        return entry.getValue();
    }
}