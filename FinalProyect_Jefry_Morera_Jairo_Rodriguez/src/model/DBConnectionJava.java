
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionJava {
     
    static String bd = "proyectux";
    static String port = "3306";
    static String login = "root";
    static String password = "Jairo8553";
    static String url = "jdbc:mariadb://localhost:" + port + "/" + bd;

    Connection connection = null;
    // Constructor: Establishes a connection to the database when the class is instantiated.
    public DBConnectionJava() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
            System.out.println("Conexion exitosa a la base de datos");

        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar la base de datos" + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al establecer la conexion" + e.getMessage());
        }
    }
    // Gets the current connection to the database.
    public Connection getConnection() {
        return connection;
    }
    // Sets a specific connection (may be useful in certain cases).
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    // Closes the connection to the database.
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexion cerrada");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
    }
}
