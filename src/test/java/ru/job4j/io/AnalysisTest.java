package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.*;
import java.nio.file.Path;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AnalysisTest {

    @Test
    void secondExample(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("testserver.log").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.print("""
                    200 10:56:01
                    500 10:57:01
                    400 10:58:01
                    500 10:59:01
                    400 11:01:02
                    300 11:02:02""");
        }
        File target  = tempDir.resolve("testTarget.csv").toFile();
        Analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat("10:57:01;11:02:02;").hasToString(rsl.toString());
    }

    @Test
    void firstExample(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("testserver.log").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.print("""
                    200 10:56:01
                    500 10:57:01
                    400 10:58:01
                    300 10:59:01
                    500 11:01:02
                    200 11:02:02""");
        }
        File target  = tempDir.resolve("testTarget.csv").toFile();
        Analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat("10:57:01;10:59:01;11:01:02;11:02:02;").hasToString(rsl.toString());
    }
    @Test
    void thirdExample(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("testserver.log").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.print("""
                    200 10:56:01
                    500 10:57:01
                    400 10:58:01
                    300 10:59:01
                    500 11:01:02
                    200 11:02:02
                    400 11:05:22""");
        }
        File target  = tempDir.resolve("testTarget.csv").toFile();
        Analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat("10:57:01;10:59:01;11:01:02;11:02:02;11:05:22;").hasToString(rsl.toString());
    }
}