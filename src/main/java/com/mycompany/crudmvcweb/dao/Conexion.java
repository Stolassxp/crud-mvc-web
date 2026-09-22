package com.mycompany.crudmvcweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/crudmvcweb_db";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "25554"; // <-- CAMBIA ESTO

    public static Connection getConexion() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return conexion;
    }
}