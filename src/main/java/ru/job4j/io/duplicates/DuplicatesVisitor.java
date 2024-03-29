package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private final Map<FileProperty, List<Path>> duplicates = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(Files.size(file), file.getFileName().toString());
        duplicates.putIfAbsent(fileProperty, new ArrayList<>());
        duplicates.get(fileProperty).add(file);
        return super.visitFile(file, attrs);
    }

    public void showDuplicates() {
        for (FileProperty file : duplicates.keySet()) {
            List<Path> filePaths =  duplicates.get(file);
            if (filePaths.size() > 1) {
                System.out.printf("%s - %x%n", file.getName(), file.getSize());
                for (Path path : filePaths) {
                    System.out.println(path.toAbsolutePath());
                }
            }
        }
    }
}