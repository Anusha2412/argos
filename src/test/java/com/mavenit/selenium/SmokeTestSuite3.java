package com.mavenit.selenium;

import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class SmokeTestSuite3 extends Hooks {


    @Test
    public void searchTest() {

        // Search
        driver.findElement(By.id("searchTerm")).sendKeys("adidas");
        driver.findElement(By.id("searchTerm")).sendKeys(Keys.ENTER);
        //String url = driver.getCurrentUrl();

        //enterProductName();
        //clickSearchButton();


        List<WebElement> productWebElements = driver.findElements(By.cssSelector("a[data-test='component-product-card-title']"));
        Random random = new Random();
        int randomNumber = random.nextInt(productWebElements.size() - 1);

        //Identifying the product
        WebElement selectedElement1 = productWebElements.get(randomNumber);
        String selectedProductName = selectedElement1.getText();
        selectedElement1.click();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        //Add to cart
        driver.findElement(By.cssSelector("button[data-test='component-att-button']")).click();

        //Go to cart
        driver.findElement(By.cssSelector("a[data-test='component-att-button-basket']")).click();

        //Total price
        String price = driver.findElement(By.cssSelector("div.Summary__subTotalLabel__2GphY")).getText();

        //driver.navigate().back();
        //driver.navigate().back();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        // Search
        driver.findElement(By.id("searchTerm")).sendKeys("adidas");
        driver.findElement(By.id("searchTerm")).sendKeys(Keys.ENTER);
        //String url = driver.getCurrentUrl();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        List<WebElement> productsWebElements = driver.findElements(By.cssSelector("a[data-test='component-product-card-title']"));
        Random random1 = new Random();
        int random1Number = random1.nextInt(productsWebElements.size() - 1);

        //Identifying 2nd product
        WebElement selectedElement2 = productsWebElements.get(random1Number);
        String selectedProductName2 = selectedElement2.getText();
        selectedElement2.click();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        //Add to cart
        driver.findElement(By.cssSelector("button[data-test='component-att-button']")).click();

        //Go to cart
        driver.findElement(By.cssSelector("a[data-test='component-att-button-basket']")).click();

        //
        driver.findElement(By.cssSelector("div[data-e2e='basket-total-price']")).getText();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        //Total price
        String price2 = driver.findElement(By.cssSelector("div.Summary__subTotalLabel__2GphY")).getText();

        assertThat(price2, is(greaterThan(price)));

    }
}
    // @FindBy(id="searchTerm")
    // WebElement EnterText;

    // public void enterProductName(){
    // EnterText.sendKeys("adidas");


    // @FindBy(id="searchTerm")
    // WebElement SearchButton;

    // public void clickSearchButton(){
    // SearchButton.click();








