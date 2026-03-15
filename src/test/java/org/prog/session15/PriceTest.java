package org.prog.session15;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class PriceTest {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void priceTest() {
        driver.get("https://allo.ua/");
        WebElement element = driver.findElement(By.id("search-form__input"));
        element.sendKeys("Iphone 17pro max");
        element.sendKeys(Keys.ENTER);
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("products-layout__item")));
        List<WebElement> cards = driver.findElements(By.className("products-layout__item"));
        for (int i = 0; i < 3; i++) {
            WebElement card = cards.get(i);
            WebElement priceBlock = card.findElement(By.cssSelector(".v-pb__cur.discount"));
            WebElement price = priceBlock.findElement(By.className("sum"));
            Assertions.assertTrue(!price.getText().isEmpty());

        }
    }
}


