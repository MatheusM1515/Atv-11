package util;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexaoBD {
    private static final String URL = "jdbc:mysql://localhost:3306/minitok";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar: " + e.getMessage());
        }
    }
}

