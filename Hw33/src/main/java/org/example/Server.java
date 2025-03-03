package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Server implements ServerHandler, AutoCloseable{
    private List<Connection> connectionList;
    private ServerSocket serverSocket;
    private static final Logger logger = LogManager.getLogger(Server.class);

    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        connectionList = Collections.synchronizedList(new ArrayList<>());
    }
    public void start(){
        while (!serverSocket.isClosed()){
            try {

                Socket clientSocket = this.serverSocket.accept();

                new Thread(() -> {
                    new CmdClient(clientSocket, this);

                }).start();
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void onConnect(Connection connection) {
        connectionList.add(connection);
        logger.debug(STR."[SERVER] \{connection.getName()} успішно підключився");
    }

    @Override
    public void onDisconnect(Connection connection) {
        connectionList.remove(connection);
        logger.debug(STR."[SERVER] \{connection.getName()} успішно відключився");
    }

    @Override
    public void onMessage(Connection connection, String message) {
        if (Objects.equals(message.toLowerCase(), "exit")) {
            onDisconnect(connection);
        }
    }

    @Override
    public void onError(Connection connection, Throwable throwable) {
        logger.error("Exception happened: " + throwable);
        connection.sendMessage("Exception happened");
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    @Override
    public void close() throws Exception {
        serverSocket.close();
    }
}
