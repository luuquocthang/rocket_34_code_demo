package org.example.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUntil {
    private String host;
    private String port;
    private String user;
    private String pass;
    private String databaseName;

    public String getDatabaseName() {
        return databaseName;
    }

    private Connection conn;

    public DBUntil() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("./src/main/resources/database.properties"));
            this.host = properties.getProperty("host");
            this.port = properties.getProperty("port");
            this.user = properties.getProperty("user");
            this.pass = properties.getProperty("pass");
            this.databaseName = properties.getProperty("default_database");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
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
