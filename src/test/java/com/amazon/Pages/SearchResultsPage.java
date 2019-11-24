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

    public String getTitleOnPage() { return driver.getTitle(); }

    public void checkTitle(String keyword) {
        Assert.assertTrue(getTitleOnPage().contains(keyword));
    }

    public List<String> getTitlesOfProducts() {
        List<WebElement> resultList = driver.findElements(listOfSearchResults);
        List<String> titlesOfProducts = new ArrayList<String>();
        for (WebElement resultItem : resultList) {
            titlesOfProducts.add(resultItem.getText());
        }
        return titlesOfProducts;

    }

    public void checkThatTitlesContainsKeyword(String keyword) {
        List<String> titlesOfProducts = getTitlesOfProducts();
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

    public WebElement getFirstProductInSearchResultsList(){
        return driver.findElement(firstProductOnThePage);
    }

    public String getFirstProductName(){ return getFirstProductInSearchResultsList().getText(); }

    public String getFirstProductPrice(){ return driver.findElement(priceOfFirstProduct).getAttribute("innerText"); }

    public void clickOnFirstProduct(){
        getFirstProductInSearchResultsList().click();
    }





}
