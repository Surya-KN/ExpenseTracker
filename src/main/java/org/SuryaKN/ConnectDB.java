package org.SuryaKN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static Connection conn = null;
    private static void startConnection() {

        try {
            String url = "jdbc:sqlite:./expense.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connected!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public static Connection connect() {
        if (conn == null) {
            startConnection();
        }
        return conn;

}}
