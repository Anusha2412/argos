package com.mavenit.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SmokeTestSuite extends Hooks{

    @Test

    public void searchTest(){
        //Search
        driver.findElement((By.id("searchTerm"))).sendKeys("puma");
        driver.findElement((By.id("searchTerm"))).sendKeys(Keys.ENTER);

        //Asserts-1
        //to varify that we are looking for puma products by checking if the url has string "puma"
       String url =  driver.getCurrentUrl();
       //assertThat(url, endsWith("puma"));
       // assertThat(url, contains("Puma"));
       assertThat("Not got results of search term. ", url, endsWith("puma"));

       //Assert -2
       //collect a item to list
       //loop and verify
       //product contains strings

       List<WebElement>ProductWebElements = driver.findElements(By.cssSelector("a[data-test='component-product-card-title']"));
       for (WebElement indProduct : ProductWebElements){
           String actual = indProduct.getText();
           assertThat(actual, containsString("Puma"));
       }

       //Assert -3
       String actualTitle =driver.findElement(By.className("search-title__term")).getText();
       assertThat(actualTitle, is(equalToIgnoringCase("puma")));

    }
}
