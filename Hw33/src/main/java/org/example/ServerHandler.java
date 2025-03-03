package org.example;

public interface ServerHandler {
    void onConnect(Connection connection);

    void onDisconnect(Connection connection);

    void onMessage(Connection connection, String message);

    void onError(Connection connection, Throwable throwable);

}
