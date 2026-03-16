package org.prog.session16.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class AlloPage {

    private final WebDriver driver;
    private final WebDriverWait webDriverWait;


    private final static String BASE_URL = "https://allo.ua/";

    public AlloPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    public void loadPage(String path) {
        driver.get(BASE_URL + path);
    }

    public void searchProduct(String productName) {
        WebElement searchInput = driver.findElement(By.id("search-form__input"));
        searchInput.sendKeys(productName);
        searchInput.sendKeys(Keys.ENTER);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("products-layout__item")));
    }

    public List<WebElement> getProductCards() {
        return driver.findElements(By.className("products-layout__item"));
    }

}

