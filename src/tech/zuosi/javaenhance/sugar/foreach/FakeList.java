package tech.zuosi.javaenhance.sugar.foreach;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FakeList<E> implements Iterable<E> {
    private final int size;
    private final E VALUE;

    FakeList(E VALUE, int size) {
        this.VALUE = VALUE;
        this.size = size;
    }

    @NotNull
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            cursor++;
            return VALUE;
        }
    }
}
