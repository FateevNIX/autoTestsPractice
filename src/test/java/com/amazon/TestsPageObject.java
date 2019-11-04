package com.amazon;

import com.amazon.Pages.HomePage;
import com.amazon.Pages.ProductDetailsPage;
import com.amazon.Pages.SearchResultsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import com.amazon.Pages.*;
import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)
public class TestsPageObject {

    public ChromeDriver driver;

    @Parameterized.Parameter
    public static String keyword;

    @Parameterized.Parameters
    public static Collection<Object> Keywords(){
        Object[] object = new Object[]{"puzzle", "sock","robe"};
        return Arrays.asList(object);
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\fateev\\IdeaProjects\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }


    @After
    public void close() {
        driver.quit();
    }

    @Test
    public void testsPageObject() {
        HomePage homePageObj = new HomePage(driver);
        SearchResultsPage searchResultsPageObj = new SearchResultsPage(driver);
        ProductDetailsPage productDetailsPageObj = new ProductDetailsPage(driver);
        PreShoppingCartPage preShoppingCartPageObj = new PreShoppingCartPage(driver);
        ShoppingCartPage shoppingCartPageObj = new ShoppingCartPage(driver);


        homePageObj.goToHomePage();
        homePageObj.selectBabyCategoryInSearchTextbox();
        homePageObj.setTextboxSearch(keyword);
        homePageObj.clickSubmitButton();
        searchResultsPageObj.checkTitle(keyword);
        searchResultsPageObj.checkThatTitlesContainsKeyword(keyword);
        String firstProductName = searchResultsPageObj.getFirstProductName(driver);
        String firstProductPrice = searchResultsPageObj.getFirstProductPrice(driver);
        searchResultsPageObj.clickOnFirstProduct();
        productDetailsPageObj.clickOnAddToCartButton();
        preShoppingCartPageObj.clickOnCartButton();
        shoppingCartPageObj.checkThatNameAndPriceAreTheSameAsOnSearchResultsPage(firstProductName,firstProductPrice);
        }

    }
