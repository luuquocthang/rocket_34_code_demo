package org.example.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUntil {
    private String host = "localhost";
    private String port = "3307";
    private String user = "root";
    private String pass = "123456";
    private String databaseName = "Rocket34DB";

    public String getDatabaseName() {
        return databaseName;
    }

    private Connection conn;

    public DBUntil() {
    }

    public DBUntil(String host, String port, String user, String pass, String databaseName) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
        this.databaseName = databaseName;
    }

    public Connection getConn() {
        // create connection string
        String conStr = String.format("jdbc:mysql://%s:%s/%s", this.host, this.port, this.databaseName);

        try {
            // đăng ký driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
            // tạo đối tượng Connection
            conn = DriverManager.getConnection(conStr, this.user, this.pass);
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return conn;
    }

    public static void main(String[] args) {
        DBUntil dbUntil = new DBUntil();
        Connection connection = dbUntil.getConn();
        System.out.println(connection);
    }
}
