package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        short ram = 16;
        int age = 33;
        long year = 2023;
        byte chairs = 3;
        char string = 'w';
        float capacity = 1.51f;
        double temp = 20.2;
        boolean isTrue = true;
        LOG.debug("User info name : {}, age : {}, {}, {}, {}, {}, {}, {}, {}", name, age, ram, year, chairs, string, capacity, temp, isTrue);
    }
}