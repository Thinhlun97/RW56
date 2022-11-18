package com.vti.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCutils {
    static Connection connection = null;

    public static Connection getConnect() {



        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("RW59/JDBC/src/main/resources/db.properties"));

            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String pass = properties.getProperty("pass");
            String driver = properties.getProperty("driver");

            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pass);
            if (connection != null) {
                System.out.println("Thanh cong1");
            } else {
                System.out.println("That bai");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null ){
            connection.close();
        }
    }
}
