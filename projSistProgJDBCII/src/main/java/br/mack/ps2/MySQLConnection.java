package br.mack.ps2;
import java.sql.*;

public class MySQLConnection {

    String url = "jdbc:mysql://localhost:32777/sys";
    String usuario = "root";
    String senha = "root";

    public Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, usuario, senha);
        } catch (final Exception ex) {
            ex.printStackTrace();
            return null;

        }

    }

}