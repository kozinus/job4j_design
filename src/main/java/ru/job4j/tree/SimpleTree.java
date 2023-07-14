package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private Node<E> root;

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> filter) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (filter.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    public SimpleTree(E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> parentNode = findBy(parent);
        rsl = parentNode.isPresent() && findBy(child).isEmpty();
        if (rsl) {
            parentNode.get().children.add((new Node<>(child)));
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(x -> x.equals(value));
    }

    @Override
    public boolean isBinary() {
        return findByPredicate(x -> x.children.size() < 3).isEmpty();
    }
}