package com.amazon;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Tests {

    public ChromeDriver driver;
    String keyword = "puzzle";
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\fateev\\IdeaProjects\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void tests() {
        driver.get("https://www.amazon.com/");
        driver.findElement(By.cssSelector("#searchDropdownBox > option:nth-child(4)")).click();
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("puzzle");
        driver.findElement(By.xpath("//*[@id=\"nav-search\"]//input[1]")).click();
        String title = driver.getTitle();
        Assert.assertTrue(title.contains(keyword));

        List<String> titlesOfProducts = new ArrayList<String>();
        List<WebElement> resultList = driver.findElements(By.xpath("//*[@id=\"search\"]//h2/a/span"));
        for (WebElement resultItem : resultList) {
            String tabname = resultItem.getText();
            titlesOfProducts.add(tabname);
        }
        try {
            for (int i = 0; i < titlesOfProducts.size(); i++) {
                System.out.println(titlesOfProducts.get(i));

                Assert.assertTrue(titlesOfProducts.get(i).toLowerCase().contains(keyword));
            }

        }
        catch (AssertionError ae){
            System.out.println("There is no 'puzzle' in last product" );
        }

    }
  @After
    public void close() {
        driver.quit();
  }
    }