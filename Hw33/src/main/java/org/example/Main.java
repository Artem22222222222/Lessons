package org.example;

public class Main {
    public static void main(String[] args) {
        try (Server server = new Server(8000)){
            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}