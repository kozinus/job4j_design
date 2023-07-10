package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {

    private int size;
    private int modCount;
    private Node<T> head;


    public void add(T value) {
        if (head == null) {
            head = new Node<>(value, null);
        } else {
            Node<T> last = head;
            for (int i = 1; i < size; i++) {
                last = last.next;
            }
            last.next = new Node<>(value, null);
        }
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
        size--;
        modCount++;
        return prevItem;
    }

    public void addFirst(T value) {
        head = new Node<>(value, head);
        size++;
        modCount++;
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            final int expectedModCount = modCount;
            private Node<T> last = head;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return last != null;
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