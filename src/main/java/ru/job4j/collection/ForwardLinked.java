package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {

    private int size;
    private int modCount;
    private Node<T> head = new Node<>(null, null);


    public void add(T value) {
        Node<T> last = head;
        for (int i = 0; i < size; i++) {
            last = last.next;
        }
        last.item = value;
        last.next = new Node<>(null, null);
        modCount++;
        size++;
    }


    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> last = head;
        for (int i = 0; i < index; i++) {
            last = last.next;
        }
        return last.item;
    }

    public T deleteFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        Node<T> prev = head;
        head = head.next;
        prev.next = null;
        T prevItem = prev.item;
        prev.item = null;
        return prevItem;
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            final int expectedModCount = modCount;
            Node<T> last = head;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return last.next != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T item = last.item;
                last = last.next;
                return item;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}