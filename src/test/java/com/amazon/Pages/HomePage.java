package com.amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    WebDriver driver;
    By textboxSearch = By.id("twotabsearchtextbox");
    By babyCategoryInSearchTextbox = By.cssSelector("#searchDropdownBox > option:nth-child(4)");
    By submitButton = By.xpath("//*[@id=\"nav-search\"]//input[1]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void goToHomePage(){
        driver.get("https://www.amazon.com/");
    }

    public void selectBabyCategoryInSearchTextbox(){
        driver.findElement(babyCategoryInSearchTextbox).click();
    }

    public void setTextboxSearch(String text){
        driver.findElement(textboxSearch).sendKeys(text);
   }

    public void clickSubmitButton(){
        driver.findElement(submitButton).click();
    }


}
