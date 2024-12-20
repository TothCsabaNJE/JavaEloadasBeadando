package com.example.eloadasbeadando;

import java.sql.Connection;

public class ConnectionModel {
    Connection connection;

    public ConnectionModel() {
        connection = SqliteConnection.Connector();
        if (connection == null) {
            System.out.println("Nem sikerült kapcsolódni");
            System.exit(1);
        }
    }

    public boolean isDbConnected() {
        try {
            return !connection.isClosed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
