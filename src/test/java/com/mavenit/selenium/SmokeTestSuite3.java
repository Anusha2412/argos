package com.mavenit.selenium;

import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SmokeTestSuite3 extends Hooks{



@Test

    public void addToBasket(){

    driver.findElement(By.id("searchTerm")).sendKeys("adidas");
driver.findElement(By.id("searchTerm")).sendKeys(Keys.ENTER);

driver.findElement(By.xpath("//a[contains(text(),'Adidas Classic 24L Backpack - Black and White')]")).click();

driver.findElement(By.className("xs-row add-to-trolley-main top-border")).click();

    }

}
