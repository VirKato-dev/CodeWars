package codewars.composite.sorted.iterator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
    private final Comparator<? super T> cmp;
    private final Iterator<T>[] all;
    private final Itr<T> EMPTY = new Itr<>(null);
    private Itr<T> min;

    /**
     * Decorator
     */
    static class Itr<T> implements Iterator<T> {
        boolean uses;
        T val;
        private final Iterator<T> it;

        public Itr(Iterator<T> i) {
            it = i;
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public T next() {
            val = it.next();
            return val;
        }
    }

    @SafeVarargs
    public CompositeSortedIterator(Comparator<? super T> cmp, Iterator<T>... iterators) {
        this.cmp = cmp;
        this.all = iterators;
        for (int j = 0; j < iterators.length; j++)
            iterators[j] = new Itr<>(iterators[j]);
        hasNext();
    }

    @Override
    public boolean hasNext() {
        for (Iterator<T> it : all) {
            if (!((Itr<T>) it).uses && it.hasNext()) {
                it.next();
                ((Itr<T>) it).uses = true;
            }
        }
        min = (Itr<T>) Arrays.stream(all)
                .min((o1, o2) ->
                        ((Itr<T>) o1).val == null ? 1
                                : ((Itr<T>) o2).val == null ? -1
                                : cmp.compare(((Itr<T>) o1).val, ((Itr<T>) o2).val))
                .orElse(EMPTY);
        return min.val != null;
    }

    @Override
    public T next() {
        if (min.val == null) throw new NoSuchElementException();
        T v = min.val;
        min.uses = false;
        min.val = null;
        return v;
    }
}
