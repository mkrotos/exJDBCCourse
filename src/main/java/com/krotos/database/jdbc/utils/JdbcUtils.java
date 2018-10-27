package com.krotos.database.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private final static JdbcUtils instance=new JdbcUtils();
    private Connection connection;

    private JdbcUtils(){
        String dbPassword = "student";
        String dbUser = "student";
        String connectionString = "jdbc:mysql://localhost:3306/nowa_baza_testowa";
        String connectionOptions="?serverTimezone=UTC&useSSL=false&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true";

        Properties prop = new Properties();
        prop.put("password", dbPassword);
        prop.put("user", dbUser);

        try {
            connection= DriverManager.getConnection(connectionString+connectionOptions,prop);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static JdbcUtils getInstance() {
        return instance;
    }
}
