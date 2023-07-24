package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> phrases = readPhrases();
        List<String> log = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String keyWord = in.nextLine();
        boolean resume = false;
        while (!OUT.equals(keyWord)) {
            log.add(keyWord);
            resume = (CONTINUE.equals(keyWord) || resume) && !STOP.equals(keyWord);
            if (resume) {
                String message = phrases.get((int) (Math.random() * (phrases.size() + 1)));
                log.add(message);
                System.out.println(message);
            }
            keyWord = in.nextLine();
        }
        log.add(keyWord);
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers, Charset.forName("WINDOWS-1251")))) {
            br.lines().forEach(phrases::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("data/saveLog.txt", "data/botAnswers.txt");
        cc.run();
    }
}
