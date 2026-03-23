package org.prog.session20.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    public static WebDriver getDriver() throws MalformedURLException {
        String driverType = System.getProperty("driver.type", "default");
        switch (driverType) {
            case "LOCAL_FIREFOX":
                return new FirefoxDriver();
            case "LOCAL_GRID":
                return new RemoteWebDriver(new URL("http://localhost:4444/"),
                        new ChromeOptions());
            case "JENKINS":
                return new RemoteWebDriver(new URL("http://selenium-hub:4444/"),
                        new ChromeOptions());
            default:
                return new ChromeDriver();
        }
    }
}
