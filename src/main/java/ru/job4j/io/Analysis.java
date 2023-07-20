package ru.job4j.io;

import java.io.*;


public class Analysis {

    public static void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            try (PrintWriter out = new PrintWriter(
                    new BufferedOutputStream(
                            new FileOutputStream(target)))) {
                boolean flag = true;
                String line;
                while ((line = in.readLine()) != null) {
                    String[] s = line.split(" ", 2);
                    boolean isUnvailable = "400".equals(s[0]) || "500".equals(s[0]);
                    if (isUnvailable == flag) {
                        flag = !flag;
                        out.printf("%s;%s", s[1], (flag ? System.lineSeparator() : ""));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Analysis.unavailable("data/server.log", "data/target.csv");
    }
}