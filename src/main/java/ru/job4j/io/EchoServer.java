package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {

    private static final Logger ECHO_SERVER = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String str = in.readLine();
                    if (str.startsWith("GET") && str.contains("msg=")) {
                        String message = str.substring(str.indexOf("msg=") + 4, str.indexOf("HTTP") - 1);
                        if ("Hello".equals(message)) {
                            out.write("Hello, dear friend.".getBytes());
                            System.out.println("Hello, dear friend.");
                        } else if ("Bye".equals(message)) {
                            out.write("Goodbye!".getBytes());
                            System.out.println("Goodbye!");
                            server.close();
                        } else {
                            out.write("What?".getBytes());
                            System.out.println("What?");
                        }
                    }
                    out.flush();
                } catch (IOException e) {
                    ECHO_SERVER.error("I/O Error", e);
                }
            }
        }
    }
}