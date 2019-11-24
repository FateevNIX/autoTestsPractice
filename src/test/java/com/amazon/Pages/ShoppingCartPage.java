package com.amazon.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ShoppingCartPage {
    private static By nameOfProductInTheCart = By.xpath("//li/span/a/span");
    private static By priceOfProductInTheCart = By.xpath("//div/p/span");
    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() { return driver.findElement(nameOfProductInTheCart).getText(); }

    public String getProductPrice() { return driver.findElement(priceOfProductInTheCart).getText(); }

    public void checkThatNameAndPriceAreTheSameAsOnSearchResultsPage(String firstProductName, String firstProductPrice) {
        Assert.assertEquals(getProductName(), firstProductName);
        Assert.assertEquals(getProductPrice(), firstProductPrice);
    }
}