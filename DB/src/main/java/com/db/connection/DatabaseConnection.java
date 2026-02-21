package com.db.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static volatile HikariDataSource dataSource;

    private DatabaseConnection() {
        // prevent instantiation
    }

    public static HikariDataSource getDataSource() {
        if (dataSource == null) {
            synchronized (DatabaseConnection.class) {
                if (dataSource == null) {

                    HikariConfig config = new HikariConfig();
                    config.setJdbcUrl("jdbc:mysql://localhost:3306/sample");
                    config.setUsername("root");
                    config.setPassword("1234567890");

                    config.setMaximumPoolSize(10);
                    config.setMinimumIdle(2);
                    config.setConnectionTimeout(30_000);
                    config.setIdleTimeout(600_000);
                    config.setMaxLifetime(1_800_000);
                    config.setPoolName("SamplePool");

                    dataSource = new HikariDataSource(config);
                }
            }
        }
        return dataSource;
    }

    // Spring-style helper
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

//    public static void logPoolStats() {
//        var pool = DatabaseConnection.getDataSource().getHikariPoolMXBean();
//
//        System.out.println("Active connections : " + pool.getActiveConnections());
//        System.out.println("Idle connections   : " + pool.getIdleConnections());
//        System.out.println("Total connections  : " + pool.getTotalConnections());
//    }

    // ✅ IMPORTANT
    public static void shutdown() {
        if (dataSource != null) {
            dataSource.close();
        }
    }


}