package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class CmdClient implements Connection{
    private final Server server;
    private final Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private int id;

    public CmdClient(Socket socket, Server server) {
        this.server = server;
        this.socket = socket;

        try (socket){

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            this.in = new BufferedReader(new InputStreamReader(inputStream));
            this.out = new PrintWriter(outputStream);

            out.println("Hello");
            out.flush();

            id = server.getConnectionList().isEmpty() ? 1 : server.getConnectionList().getLast().getId() + 1;

            server.onConnect(this);

            while (!socket.isClosed()){
                String message = in.readLine();
                if (!Objects.isNull(message)) {
                    server.onMessage(this, message);
                    if (Objects.equals(message, "exit")){
                        break;
                    }
                }
            }
        } catch (IOException e) {
            server.onError(this, e);
        }
    }

    @Override
    public void sendMessage(String message) {
        out.println(message);
        out.flush();
    }

    @Override
    public String getName() {
        return "client-" + id;
    }

    public int getId() {
        return id;
    }

}
