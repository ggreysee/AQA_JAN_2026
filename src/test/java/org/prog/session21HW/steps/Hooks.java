package org.prog.session21HW.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Hooks {
    private Connection connection;
    private WebDriver driver;

    @Before
    public void beforeSuite() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db",
                "root",
                "password"
        );
        MyDBSteps.connection = connection;

        driver = new ChromeDriver();
        MyGoogleSteps.driver = driver;
    }

    @After
    public void afterSuite() throws SQLException {
        try {
            connection.close();
        } catch (Exception e) {
        }
        try {
            driver.quit();
        } catch (Exception e) {
        }
    }
}
