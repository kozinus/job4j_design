package ru.job4j.io;

import java.io.*;


public class Analysis {

    public static void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            PrintWriter out = new PrintWriter(
                    new BufferedOutputStream(
                            new FileOutputStream(target)));
            boolean flag = true;
            String line;
            while ((line = in.readLine()) != null) {
                String[] s = line.split(" ", 2);
                boolean isUnvailable = "400".equals(s[0]) || "500".equals(s[0]);
                if (isUnvailable && flag) {
                    flag = false;
                    out.print(s[1] + ";");
                } else if (!isUnvailable && !flag) {
                    flag = true;
                    out.print(s[1] + ";" + System.lineSeparator());
                }
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Analysis.unavailable("data/server.log", "data/target.csv");
    }
}