package codewars.composite.sorted.iterator.v3;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

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
    private final PriorityQueue<WrappedIterator> queue;
    private final Comparator<? super T> cmp;

    @SafeVarargs
    public CompositeSortedIterator(Comparator<? super T> cmp, Iterator<T>... iterators) {
        this.cmp = cmp;
        queue = new PriorityQueue<>(100000);

        for (Iterator<T> it : iterators) {
            if (it.hasNext()) {
                T item = it.next();
                WrappedIterator wrappedIt = new WrappedIterator(it, item);
                queue.add(wrappedIt);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public T next() {
        WrappedIterator nextIt = queue.poll();
        if (nextIt == null) throw new NoSuchElementException();
        if (nextIt.iterator.hasNext()) {
            T item = nextIt.iterator.next();
            queue.add(new WrappedIterator(nextIt.iterator, item));
        }
        return nextIt.next;
    }


    private class WrappedIterator implements Comparable<WrappedIterator> {
        private final Iterator<T> iterator;
        private final T next;

        public WrappedIterator(Iterator<T> it, T item) {
            iterator = it;
            next = item;
        }

        @Override
        public int compareTo(WrappedIterator a) {
            return cmp.compare(this.next, a.next);
        }
    }
}