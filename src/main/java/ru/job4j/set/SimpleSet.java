package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(0);

    @Override
    public boolean add(T value) {
        boolean goal = !contains(value);
        if (goal) {
            set.add(value);
        }
        return goal;
    }

    @Override
    public boolean contains(T value) {
        boolean goal = false;
        for (int i = 0; i < set.size(); i++) {
            if (Objects.equals(value, set.get(i))) {
                goal = true;
                break;
            }
        }
        return goal;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}