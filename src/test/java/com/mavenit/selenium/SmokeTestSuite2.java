package com.mavenit.selenium;

import net.bytebuddy.asm.Advice;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



public class SmokeTestSuite2 extends Hooks {
        @Test

        public void searchTest() {
            // Search
            driver.findElement(By.id("searchTerm")).sendKeys("nike");
            driver.findElement(By.id("searchTerm")).sendKeys(Keys.ENTER);

            String url = driver.getCurrentUrl();

            // select a nike product
            // List all nike items in the page
            List<WebElement> productWebElements = driver.findElements(By.cssSelector("a[data-test='component-product-card-title']"));

            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            // Generate a random number from 1 to 30
            Random random = new Random();
            int randomNumber = random.nextInt(productWebElements.size() - 1);

            //Identifying the random number selected
            WebElement selectedElement = productWebElements.get(randomNumber);
            String selectedProductName = selectedElement.getText();
            selectedElement.click();

            //Add product to basket
            driver.findElement(By.cssSelector("button[data-test='component-att-button']")).click();

            driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);

            //Go to basket
            driver.findElement(By.cssSelector(".xs-row a[data-test='component-att-button-basket']")).click();

            String actual = getProductInBasket();
            assertThat(actual, containsString(getProductInBasket()));

        }


    //Get product in Basket
        public String getProductInBasket() {
            return driver.findElement(By.cssSelector(".ProductCard__content__9U9b1.xsHidden.lgFlex")).getText();

        }
    }

        // Add that product to cart
        // driver.findElement(By.xpath("//div[@class='xs-row add-to-trolley-main top-border']")).click();
















