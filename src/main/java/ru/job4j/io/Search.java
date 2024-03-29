package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Root folder is not correct");
        }
        validationOf2Arguments(args);
        search(Path.of(args[0]), p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static void validationOf2Arguments(String[] args) {
        if (!Files.exists(Paths.get(args[0]))) {
            throw new IllegalArgumentException(String.format("Not exist %s", args[0]));
        }
        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException(String.format("Second argument %s is not an extension", args[1]));
        }
    }
}