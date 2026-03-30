package org.prog.session21HW.steps;

import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MyGoogleSteps {
    public static WebDriver driver;
    public static List<String> models = new ArrayList<>();
    public static List<String> prices = new ArrayList<>();

    @Given("I get 3 first iPhone models and prices from Allo")
    public void getPhones() {
        driver.get("https://allo.ua/");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("search-form__input"));
        element.sendKeys("iPhone 17pro max");
        element.sendKeys(Keys.ENTER);
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("products-layout__item")));
        List<WebElement> cards = driver.findElements(By.className("products-layout__item"));
        for (int i = 0; i < 3; i++) {
            WebElement card = cards.get(i);
            WebElement model = card.findElement(By.className("product-card__title"));
            WebElement priceBlock = card.findElement(By.cssSelector(".v-pb__cur.discount"));
            WebElement price = priceBlock.findElement(By.className("sum"));
            models.add(model.getText());
            prices.add(price.getText());
            Assertions.assertFalse(price.getText().isEmpty());

        }
    }

}
