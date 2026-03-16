package org.prog.session16.HW;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class AlloTest {
    private WebDriver driver;
    private AlloPage alloPage;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        alloPage = new AlloPage(driver);

    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void myTest() {
        alloPage.loadPage("");
        alloPage.searchProduct("Iphone 17pro max");
        List<WebElement> cards = alloPage.getProductCards();
        for (int i = 0; i < 3; i++) {
            WebElement card = cards.get(i);
            WebElement priceBlock = card.findElement(By.cssSelector(".v-pb__cur.discount"));
            WebElement price = priceBlock.findElement(By.className("sum"));
            Assertions.assertTrue(!price.getText().isEmpty());
        }
    }
}


