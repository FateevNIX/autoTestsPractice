package com.amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage {
    WebDriver driver;
    By labelToSelectSize = By.cssSelector("//*[@id=\"partialStateBuybox\"]/div/div[1]/span/text()");
    By addToCartButton = By.cssSelector("span > span[id*=add-to-cart]");
    By selectSizeDropdownFirstOption = By.cssSelector("//*[@class=\"a-popover a-dropdown a-dropdown-common a-declarative\"]//li[2]");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean checkIfUserNeedToChooseSizeOfProduct(WebDriver driver) {
        Boolean triger = false;
        try {
            driver.findElement(labelToSelectSize).isDisplayed();
        } catch (NoSuchElementException nsee) {
            System.out.println("There is no need in selecting 'size' ");
            triger = true;
        }
        return triger;
    }

    public void clickOnAddToCartButton(){ //наверное лучше это разбить на два метода, если надо исправлю
        WebElement addCartButton = driver.findElement(addToCartButton);
            if (checkIfUserNeedToChooseSizeOfProduct(driver)) {
                addCartButton.click(); }
            else{
                  WebElement selectSizeOfProduct = driver.findElement(selectSizeDropdownFirstOption);
                  selectSizeOfProduct.click();
                  addCartButton.click();
            }
    }
}


