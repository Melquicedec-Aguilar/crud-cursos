package org.aguilar.webapp.crud.cursos.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionJdbc {

    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Mexico_City";
    private static String username = "root";
    private static String password = "Nisha#070598";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
