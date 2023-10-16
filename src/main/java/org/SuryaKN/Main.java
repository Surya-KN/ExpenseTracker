package org.SuryaKN;



import com.formdev.flatlaf.intellijthemes.FlatNordIJTheme;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatNordIJTheme());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        ConnectDB.connect();
        SwingUtilities.invokeLater(() -> {
            try {
                new HomeWindow().setVisible(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                if (ConnectDB.connect() != null && !ConnectDB.connect().isClosed()) {
                    ConnectDB.connect().close();
                    System.out.println("closed!!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
    }
}