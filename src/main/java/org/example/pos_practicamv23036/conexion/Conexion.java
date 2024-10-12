package org.example.pos_practicamv23036.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String url = "jdbc:postgresql://localhost:5432/dbVenta";
    private static final String USER = "postgres"; // Corrección aquí
    private static final String PASS = "MARS";

    public static Connection connection() {
        try {
            Connection conectar = DriverManager.getConnection(url, USER, PASS);
            System.out.println("Conectado a la base");
            return conectar;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



