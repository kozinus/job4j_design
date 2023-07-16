package ru.job4j.io;

import java.io.*;
import java.util.function.Consumer;


public class Analysis {
    private static boolean flag = true;

    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            PrintWriter out = new PrintWriter(
                    new BufferedOutputStream(
                            new FileOutputStream(target)
                    ));
            Consumer<String> lineAction = x -> {
                String[] s = x.split(" ", 2);
                boolean isAvailable = "400".equals(s[0]) || "500".equals(s[0]);
                if (!isAvailable && flag) {
                    flag = false;
                    out.print(s[1] + ";");
                } else if (isAvailable && !flag) {
                    flag = true;
                    out.print(s[1] + ";" + System.lineSeparator());
                }
            };
            in.lines().forEach(lineAction);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}