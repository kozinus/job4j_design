package ru.job4j.io.duplicates;

import ru.job4j.map.Map;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private Hashtable<FileProperty, List<Path>> duplicates = new Hashtable<>();

    private HashSet<FileProperty> files = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (Files.isRegularFile(file)) {
            String[] fileName = file.toString().split("\\\\");
            FileProperty fileProperty = new FileProperty(Files.size(file), fileName[fileName.length - 1]);
            if (files.contains(fileProperty)) {
                duplicates.get(fileProperty).add(file);
            } else {
                duplicates.put(fileProperty, new ArrayList<>(List.of(file)));
            }
            files.add(fileProperty);
        }
        return super.visitFile(file, attrs);
    }

    public void showDuplicates() {
        for (FileProperty file : duplicates.keySet()) {
            List<Path> filePaths =  duplicates.get(file);
            if (filePaths.size() > 1) {
                System.out.printf("%s - %x%n", file.getName(), file.getSize());
                for (Path path : filePaths) {
                    System.out.println(path.toString());
                }
            }
        }
    }
}