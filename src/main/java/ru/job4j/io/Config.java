package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            Predicate<String> lineFilter = x -> {
                boolean goal = !(x.startsWith("#") || x.isEmpty());
                if (goal) {
                    if (!x.contains("=")) {
                        throw new IllegalArgumentException("Does not contain equal symbols");
                    }
                }
                return goal;
            };
            Consumer<String> lineAction = x -> {
                String[] s = x.split("=", 2);
                this.values.put(s[0], s[1]);
            };
            read.lines().filter(lineFilter).forEach(lineAction);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return this.values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config config = new Config("data/app.properties");
        config.load();
    }
}