package ru.job4j.user;

import java.util.Calendar;

public class User {
    private String name;
    private int children;
    private Calendar birthday;
    public User(String name, int children, Calendar birthday) {
        this.birthday = birthday;
        this.name = name;
        this.children = children;
    }
}
