package com.amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
    WebDriver driver;
    By labelToSelectSize = By.xpath("//span[contains(text(),'To buy, select')]");
    By addToCartButton = By.id("add-to-cart-button");
    By dropdownWithSizeOptions = By.id("dropdown_selected_size_name");
    By selectSizeDropdownFirstOption = By.xpath("//li[contains(@id,'size_name') and contains(@class,'dropdownAvailable')]");
    By inStockLabel = By.xpath("//*[@id='availability']/span");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean checkIfUserNeedToChooseSizeOfProduct(WebDriver driver) { //этот метод увеличивает шанс прохождения теста, на шаге когда надо добавить товар в корзину
        Boolean triger = false;
        try {
            driver.findElement(labelToSelectSize).isDisplayed();
        } catch (NoSuchElementException nsee) {
            System.out.println("There is no need in selecting 'size' ");
            triger = true;
        }
        return triger;
    }

    public void clickOnAddToCartButton(){
            if (checkIfUserNeedToChooseSizeOfProduct(driver)) {
                driver.findElement(addToCartButton).click(); }
            else{
                  driver.findElement(dropdownWithSizeOptions).click();
                  driver.findElement(selectSizeDropdownFirstOption).click();
                  new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(inStockLabel));
                  driver.findElement(addToCartButton).click();
            }
    }
}


