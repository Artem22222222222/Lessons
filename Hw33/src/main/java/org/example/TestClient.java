package org.example;

import java.io.*;
import java.net.Socket;

public class TestClient {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            try (Socket socket = new Socket("localhost", 8000)) {


                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                OutputStream outputStream = socket.getOutputStream();
                BufferedWriter out = new BufferedWriter(new PrintWriter(outputStream));
                out.write("exit");
                out.flush();

                String message = reader.readLine();
                System.out.println("Отримано від сервера: " + message);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
