package ru.job4j.io;

import java.io.*;

import java.util.*;
import java.util.function.Consumer;

public class CSVReader {
    public static void handle(ArgsName argsName) {
        ArrayList<Integer> orderList = new ArrayList<>();
        try (FileInputStream in = new FileInputStream(argsName.get("path"));
             Scanner csvScan = new Scanner(in);
             BufferedWriter out = new BufferedWriter(new FileWriter(argsName.get("out")))) {
            StringBuilder output = new StringBuilder();

            String delimiter = argsName.get("delimiter");
            String[] filter = argsName.get("filter").split(",");
            ArrayList<String> csvLine =
                    new ArrayList<>(Arrays.asList(csvScan.nextLine().split(delimiter)));
            for (String key : filter) {
                orderList.add(csvLine.indexOf(key));
                output.append(key).append(delimiter);
            }
            output.deleteCharAt(output.lastIndexOf(delimiter));
            output.append(System.lineSeparator());

            while (csvScan.hasNext()) {
                csvLine = new ArrayList<>(Arrays.asList(csvScan.nextLine().split(delimiter)));
                for (int key : orderList) {
                    output.append(csvLine.get(key)).append(delimiter);
                }
                output.deleteCharAt(output.lastIndexOf(delimiter));
                output.append(System.lineSeparator());
            }

            if ("stdout".equals(argsName.get("out"))) {
                System.out.println(output);
            } else {
                out.write(output.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        Consumer<String> validation = x -> {
            String[] xArray = x.split("=", 2);
            if (xArray.length != 2 || xArray[0].length() < 2
                    || xArray[0].charAt(0) != '-' || xArray[1].length() < 1) {
                throw new IllegalArgumentException();
            }
        };
        Arrays.stream(args).forEach(validation);
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}
