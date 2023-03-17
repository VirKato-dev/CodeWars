package codewars.composite.sorted.iterator;

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
    private final boolean[] uses;
    private final Object[] val;
    private int min = -1;


    @SafeVarargs
    public CompositeSortedIterator(Comparator<? super T> cmp, Iterator<T>... iterators) {
        this.cmp = cmp;
        this.all = iterators;
        this.val = new Object[iterators.length];
        this.uses = new boolean[iterators.length];
    }

    @Override
    public boolean hasNext() {
        min = -1;
        for (int j = 0; j < all.length; j++) {
            if (!uses[j] && all[j].hasNext()) {
                val[j] = all[j].next();
                uses[j] = true;
            }
            if (uses[j]) {
                min = min >= 0
                        ? cmp.compare((T)val[j], (T)val[min]) < 0 ? j : min
                        : j;
            }
        }
        return min >= 0;
    }

    @Override
    public T next() {
        if (min < 0) throw new NoSuchElementException();
        T v = (T) val[min];
        uses[min] = false;
        val[min] = null;
        return v;
    }
}
