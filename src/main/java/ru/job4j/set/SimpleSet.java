package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;

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
            if (set.get(i) == null || set.get(i).equals(value)) {
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