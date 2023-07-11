package ru.job4j.user;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    private String name;
    private int children;
    private Calendar birthday;
    public User(String name, int children, Calendar birthday) {
        this.birthday = birthday;
        this.name = name;
        this.children = children;
    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>(16);
        Calendar birthday = Calendar.getInstance();
        User user1 = new User("Kirill", 0, birthday);
        int hashcode1 = user1.hashCode();
        int hash1 = hashcode1 ^ (hashcode1 >>> 16);
        int bucket1 = hash1 & 15;
        User user2 = new User("Kirill", 0, birthday);
        int hashcode2 = user2.hashCode();
        int hash2 = hashcode2 ^ (hashcode2 >>> 16);
        int bucket2 = hash2 & 15;
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.printf("user1 - хэшкод: %s, хэш: %s, бакет: %s",
                hashcode1, hash1, bucket1);
        System.out.println();
        System.out.printf("user2 - хэшкод: %s, хэш: %s, бакет: %s",
                hashcode2, hash2, bucket2);
        System.out.println("\nРавенство объектов: " + user1.equals(user2));
        System.out.println(map);
        /**
         * Пары попали в разные бакеты, имея разные хэшкоды.
         * Производилось, они разные
         * Производилось. Объекты не равны, поэтому совпадение их хэшкодов и бакетов очень маловероятно
         */
    }
}