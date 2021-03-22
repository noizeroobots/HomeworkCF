package ru.tinkoff.fintech.homework;

import java.util.*;

public class MyCollection<E> implements Collection<E>, Iterable<E> {

    private int size;
    private Object[] elementData = new Object[3];

    @Override
    public final String toString() {
        return Arrays.toString(elementData);
    }

    @Override
    public final boolean add(final E e) {
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, (int) (size * 1.5f));
//            System.out.println("new capacity: " + elementData.length);
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    public final int size() {
        return this.size;
    }

    @Override
    public final boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public final boolean contains(final Object o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean remove(final Object o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) {
//                if (i != this.size - 1) {
                if (!elementData[i].equals(size - 1)) {
                    System.arraycopy(elementData, i + 1, elementData, i, size - i - 1);
                } else {
                    elementData[i] = null;
                }
                size--;
                return true;
            }
        }
        return false;
    }


    @Override
    public final boolean removeAll(final Collection<?> c) {
        for (final Object removeItem : c) {
            for (final Object item : this) {
                if (item.equals(removeItem)) {
                    remove(item);
                    break;
                }
            }
        }
        return false;
    }

    @Override
    public final boolean containsAll(final Collection<?> c) {
        Boolean contains = false;
        for (final Object containItem : c) {
            contains = false;
            for (final Object item : this) {
                if (item.equals(containItem)) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                return contains;
            }
        }
        return contains;
    }

    @Override
    public final boolean retainAll(final Collection<?> c) {
        for (final Object arr : this) {
            if (!c.contains(arr)) {
                this.remove(arr);
            }
        }
        return true;
    }

    @Override
    public final void clear() {
        elementData = (Object[]) new Object[0];
        size = 0;
    }

    @Override
    public final Iterator<E> iterator() {
        return new MyIterator<>();
    }

    @Override
    public final boolean addAll(final Collection<? extends E> c) {
        for (final E item : c) {
            add(item);
        }
        return true;
    }


    @Override
    public final Object[] toArray() {
        return new Object[0];
    }

    @Override
    public final <T> T[] toArray(final T[] a) {
        return null;
    }


    private class MyIterator<T> implements Iterator<T> {

        private int cursor = 0;
        private T lastRet = null;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            lastRet = (T) elementData[cursor++];
            return lastRet;
        }

        @Override
        public void remove() {
            if (lastRet == null) {
                throw new IllegalStateException();
            }
            try {
                MyCollection.this.remove(lastRet);
                cursor--;
                lastRet = null;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

    }
}

