package ru.geekbgains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class webserver {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket( 8888)) {
            Socket socket = serverSocket.accept();
            System.out.println("Connected");

            BufferedReader input = new BufferedReader(
                new InputStreamReader(
                            socket.getInputStream(), StandardCharsets.UTF_8));

            while (!input.ready());

            while (input.ready()) {
                System.out.println(input.readLine());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
