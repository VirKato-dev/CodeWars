package codewars.composite.sorted.iterator;

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
    private final Iterator<T>[] iterators;
    private final Comparator<? super T> cmp;
    private final Map<String, T> values = new HashMap<>();
    private final Map<T, String> list = new HashMap<>();

    @SafeVarargs
    public CompositeSortedIterator(Comparator<? super T> cmp, Iterator<T>... iterators) {
        this.cmp = cmp;
        this.iterators = iterators;
    }

    @Override
    public boolean hasNext() {
        for (Iterator<T> it : iterators) {
            if (!values.containsKey(it.toString())) {
                if (it.hasNext()) {
                    T val = it.next();
                    values.put(it.toString(), val);
                }
            }
        }
        return !values.isEmpty();
    }

    @Override
    public T next() {
        List<T> list = new ArrayList<>(values.values().stream().filter(Objects::nonNull).toList());
        list.sort(cmp);
        if (list.size() > 0) {
            T val = list.get(0);
            Iterator<Map.Entry<String, T>> i = values.entrySet().iterator();
            while (i.hasNext()) {
                T v = i.next().getValue();
                if (v.equals(val)) {
                    i.remove();
                    break;
                }
            }
            return val;
        }
        throw new NoSuchElementException();
    }
}