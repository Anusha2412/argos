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


    public class SmokeTestSuite2 extends Hooks {
       @Test

    public void searchTest() {
        // Search
        driver.findElement(By.id("searchTerm")).sendKeys("nike");
        driver.findElement(By.id("searchTerm")).sendKeys(Keys.ENTER);

        String url= driver.getCurrentUrl();

        // select a nike product
        List<WebElement> productWebElements = driver.findElements(By.cssSelector("a[data-test='component-product-card-title']"));

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Generate a random number from 1 to 30
        Random rand = new Random();

        int item = rand.nextInt(30);

        // Select item
        // int item = 5;

        //  String itemName =null;
        // int i;
        // for(i=0; i<productWebElements.size();i++){
        // if(item ==1){
        /driver.findElement(By.cssSelector("a[class='Buttonstyles_Button-q93iwm-2 buQekk btn-cta']")).get(i).click();

        }

        }

        // Add that product to cart
        // driver.findElement(By.xpath("//div[@class='xs-row add-to-trolley-main top-border']")).click();












