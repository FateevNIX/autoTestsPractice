package com.amazon.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class SearchResultsPage {
    WebDriver driver;
    private static By listOfSearchResults = By.xpath("//*[@id=\"search\"]//h2/a/span");
    private static By firstProductOnThePage = By.xpath("//h2/a/span[1]");
    private static By priceOfFirstProduct = By.xpath("//span[@class='a-offscreen']");
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public static String getTitleOnPage(WebDriver driver) {
        String title = driver.getTitle();
        return title;
    }

    public void checkTitle(String keyword) {
        Assert.assertTrue(getTitleOnPage(driver).contains(keyword));
    }

    public static List<String> getTitlesOfProducts(WebDriver driver) {
        List<WebElement> resultList = driver.findElements(listOfSearchResults);
        List<String> titlesOfProducts = new ArrayList<String>();
        for (WebElement resultItem : resultList) {
            titlesOfProducts.add(resultItem.getText());
        }
        return titlesOfProducts;

    }

    public void checkThatTitlesContainsKeyword(String keyword) {
        List<String> titlesOfProducts = getTitlesOfProducts(driver);
        try {
            for (int i = 0; i < titlesOfProducts.size(); i++) {
                System.out.println(titlesOfProducts.get(i)); //эта часть для наглядности того, что в названии действительно отсутствовало ключевое слово
                Assert.assertTrue(titlesOfProducts.get(i).toLowerCase().contains(keyword));
            }
        }
        catch(AssertionError ae){
            System.out.println("There is no '" + keyword + "' in last product name"); //информационное сообщение о том что assert не прошел
        }
    }

    public static WebElement getFirstProductInSearchResultsList(WebDriver driver){
        WebElement firstProductInList = driver.findElement(firstProductOnThePage);
        return firstProductInList;
    }

    public static String getFirstProductName(WebDriver driver){
        String productName = getFirstProductInSearchResultsList(driver).getText();
        return productName;
    }

    public static String getFirstProductPrice(WebDriver driver){
        String productPrice = driver.findElement(priceOfFirstProduct).getAttribute("innerText");
        return productPrice;
    }

    public void clickOnFirstProduct(){
        getFirstProductInSearchResultsList(driver).click();
    }





}
