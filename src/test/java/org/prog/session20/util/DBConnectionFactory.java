package org.prog.session20.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionFactory {

    public static Connection getConnection() throws SQLException {
        String driverType = System.getProperty("driver.type", "default");
        if ("JENKINS".equals(driverType)) {
            return DriverManager.getConnection(
                    "jdbc:mysql://mysql-db-1:3306/db",
                    "root",
                    "password"
            );
        } else {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db",
                    "root",
                    "password"
            );
        }

    }
}
