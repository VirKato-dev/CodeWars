package codewars.composite.sorted.iterator.v0;

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
    private final Iterator<T>[] all;
    private final Map<T, Iterator<T>> last = new HashMap<>();
    private final Queue<T> queue;

    @SafeVarargs
    public CompositeSortedIterator(Comparator<? super T> cmp, Iterator<T>... iterators) {
        this.all = iterators;
        this.queue = new PriorityQueue<>(cmp);
        fillFromAll();
    }

    @Override
    public boolean hasNext() {
        return queue.size() > 0;
    }

    @Override
    public T next() {
        if (hasNext()) {
            T val = queue.poll();
            if (last.containsKey(val)) {
                if (last.get(val).hasNext()) {
                    Iterator<T> it = last.remove(val);
                    T next = it.next();
                    queue.add(next);
                    last.put(next, it);
                }
            } else {
                fillFromAll();
            }
            return val;
        }
        throw new NoSuchElementException();
    }

    private void fillFromAll() {
        for (Iterator<T> it : all) {
            if (it.hasNext()) {
                T val = it.next();
                queue.add(val);
                last.put(val, it);
            }
        }
    }
}
