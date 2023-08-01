package ru.job4j.serialization.json;

import ru.job4j.serialization.java.Contact;

import java.util.Arrays;

public class Person {
    public boolean sex;
    public String name;
    public int age;
    public String[] infos;
    public Contact contact;

    public Person(boolean sex, int age, String name, Contact contact, String[] infos) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.infos = infos;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Person{" + "sex=" + sex
                + ", name='" + name + '\''
                + ", age=" + age
                + ", info=" + Arrays.toString(infos)
                + ", contact=" + contact + '}';
    }
}
