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

    public static String getProductName(WebDriver driver) {
        String productName = driver.findElement(nameOfProductInTheCart).getText();
        return productName;
    }

    public static String getProductPrice(WebDriver driver) {
        String productPrice = driver.findElement(priceOfProductInTheCart).getText();
        return productPrice;
    }

    public void checkThatNameAndPriceAreTheSameAsOnSearchResultsPage(String firstProductName, String firstProductPrice) {
        Assert.assertEquals(getProductName(driver), firstProductName);
        Assert.assertEquals(getProductPrice(driver), firstProductPrice);
    }
}