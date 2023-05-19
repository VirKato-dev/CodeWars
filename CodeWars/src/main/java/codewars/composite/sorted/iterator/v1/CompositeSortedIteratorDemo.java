package codewars.composite.sorted.iterator.v1;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class CompositeSortedIteratorDemo<T> implements Iterator<T> {

    private static class Tup<T> {
        T t;
        Iterator<T> it;

        Tup(Iterator<T> it) {
            this.t = it.next();
            this.it = it;
        }
    }


    private final PriorityQueue<Tup<T>> Q;


    @SafeVarargs
    public CompositeSortedIteratorDemo(Comparator<? super T> cmp, Iterator<T>... iterators) {
        Q = new PriorityQueue<>((a, b) -> cmp.compare(a.t, b.t));
        for (var it : iterators) push(it);
    }

    @Override
    public boolean hasNext() {
        return !Q.isEmpty();
    }

    @Override
    public T next() {
        Tup<T> t = Q.poll();
        if (t == null) throw new NoSuchElementException();
        push(t.it);
        return t.t;
    }

    private void push(Iterator<T> it) {
        if (it.hasNext()) Q.add(new Tup<>(it));
    }
}