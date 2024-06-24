package aca.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection conectar() {

        Connection conexion = null;
        String baseDatos = "estudiantes_db";
        String url = "jdbc:mysql://localhost:3306/" + baseDatos;
        String user = "root";
        String password = "Alejandro17";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }
        return conexion;
    }

    public static void main(String[] args) {

        Connection conexion = Conexion.conectar();

        if (conexion != null) {

            System.out.println("Conectado");

        } else {

            System.out.println("Conexion No Exitosa");
        }
    }
}
