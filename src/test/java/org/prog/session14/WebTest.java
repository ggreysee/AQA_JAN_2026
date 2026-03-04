package org.prog.session14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WebTest {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void myTest() {
        driver.get("https://allo.ua/");
        WebElement element = driver.findElement(By.id("search-form__input"));
        element.sendKeys("Iphone 17 pro max");
        element.sendKeys(Keys.ENTER);
        System.out.println("Done!");

    }

}

