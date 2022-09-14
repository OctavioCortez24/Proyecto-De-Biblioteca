package Biblioteca;

import javax.swing.*;
import java.sql.*;

public class Conexion {
    private static Conexion conexion;
    private static Connection conn;
    private static final String URL = "jdbc:mysql://localhost:3306/bibliotecas";
    private static final String user = "root";
    private static final String password = "1234";

    private Conexion() {

    }

    static Conexion getInstance() {
        if (conexion == null) {
            conexion = new Conexion();
        }
        return conexion;
    }

    public Connection crearConexion() {
        try {
            conn = DriverManager.getConnection(URL, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public void cerrarConexion () throws SQLException{
        try {
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            conn.close();
        }finally {
            conn.close();
        }

    }

}

