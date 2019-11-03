package com.amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PreShoppingCartPage {
    WebDriver driver;
    By cartButton = By.id("hlb-view-cart-announce");

    public PreShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnCartButton(){
        driver.findElement(cartButton).click();
    }

}
